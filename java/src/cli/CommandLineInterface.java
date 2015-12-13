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
		while(true)
		{
			
		}
	}

	public static void main(String[] args)
	{
		CommandLineInterface cli = new CommandLineInterface();

		cli.viewMap();
		cli.viewBlock("station1", "<Up>");
		cli.viewTrain("train1");
	}
}