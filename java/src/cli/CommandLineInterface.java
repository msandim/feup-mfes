package cli;

import org.overture.codegen.runtime.VDMMap;
import trainline.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class CommandLineInterface
{
	private Application mApplication;
	private Printer mPrinter;

	public CommandLineInterface()
	{
		mApplication = new Application();
		mApplication.initializeTrainLine();

		mPrinter = new Printer(mApplication);
	}

	public void moveTrain(String trainId)
	{
		// Get train:
		Train train = mApplication.getTrain(trainId);

		// Print move train message:
		mPrinter.printMoveTrainMessage(train);

		// Move the train:
		mApplication.moveTrain(trainId);

		// View the semaphore:
		viewSemaphore(train.getCurrentBlock().getModule().getId(), train.getOrientation());
	}
	public void requestLeaveStation(String trainId)
	{
		// Get train:
		Train train = mApplication.getTrain(trainId);

		// Request to leave station:
		boolean result = mApplication.requestLeaveStation(train);

		// Print request to leave station message:
		mPrinter.printRequestLeaveStation(train, result);
	}

	public void viewMap()
	{
		TrainLine trainLine = mApplication.getTrainLine();
		VDMMap modules = trainLine.getModules();
		Set set = modules.keySet();

		List<String> moduleIds = new ArrayList<>();
		for (Object obj : set)
			moduleIds.add(obj.toString());

		mPrinter.printList(moduleIds);
	}
	public void viewBlock(String moduleId, Object orientation)
	{
		// Get block:
		Block block = mApplication.getBlock(moduleId, orientation);

		mPrinter.printBlock(moduleId, orientation, block);
	}
	public void viewSemaphore(String moduleId, Object orientation)
	{
		// Get semaphore:
		Semaphore semaphore = mApplication.getSemaphore(moduleId, orientation);

		// Print info:
		mPrinter.printSemaphore(semaphore);
	}
	public void viewTrain(String trainId)
	{
		// Get train:
		Train train = mApplication.getTrain(trainId);

		// Print info:
		mPrinter.printTrain(train);
	}

	public void run()
	{
		String train1 = "train1";

		viewMap();
		viewTrain(train1);

		requestLeaveStation(train1);

		moveTrain(train1);
		viewTrain(train1);

		moveTrain(train1);
		viewTrain(train1);
	}

	public static void main(String[] args)
	{
		CommandLineInterface cli = new CommandLineInterface();

		cli.run();
	}
}