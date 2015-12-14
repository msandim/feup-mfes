package cli;

import org.overture.codegen.runtime.VDMMap;
import trainline.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class CommandLineInterface
{
	private Application mApplication;
	private Printer mPrinter;
	private Menu mMainMenu;
	private Menu mTrainMenu;
	private Scanner mScanner;

	public CommandLineInterface()
	{
		mApplication = new Application();
		mApplication.initializeTrainLine();

		mPrinter = new Printer(mApplication);
		mScanner = new Scanner(System.in);

		initializeMenus();
	}

	public void initializeMenus()
	{
		mMainMenu = new Menu("----- Train Line Application -----", "Select an option:");
		mMainMenu.addEntry(new MenuEntry("View train line", this::viewTrainLine));
		mMainMenu.addEntry(new MenuEntry("View list of trains", this::viewTrains));
		mMainMenu.addEntry(new MenuEntry("View a train state", this::viewTrain));
		mMainMenu.addEntry(new MenuEntry("View a semaphore/sensor state", this::viewSemaphore));
		mMainMenu.addEntry(new MenuEntry("View a block", this::viewBlock));
		mMainMenu.addEntry(new MenuEntry("Select a train", this::selectTrain));
		mMainMenu.addEntry(new MenuEntry("Change semaphore availability", this::changeSemaphoreAvailability));
		mMainMenu.addEntry(new MenuEntry("Change sensor availability", this::changeSensorAvailability));

		mTrainMenu = new Menu("----- Train Menu -----", "Select an option:");
		mTrainMenu.addEntry(new MenuEntry("View state", this::viewCurrentTrain));
		mTrainMenu.addEntry(new MenuEntry("Move", this::moveCurrentTrain));
		mTrainMenu.addEntry(new MenuEntry("Stop", this::stopTrain));
		mTrainMenu.addEntry(new MenuEntry("Request to leave station", this::requestLeaveStation));
	}

	public void changeSemaphoreAvailability()
	{
		String moduleId = getModuleId();
		Object orientation = getOrientation();
		if(orientation == null)
			return;
		boolean value = getAvailability();

		Semaphore semaphore = mApplication.getSemaphore(moduleId, orientation);
		if(semaphore == null)
		{
			Printer.println("Module doesn't exist!");
			return;
		}

		semaphore.setAvailability(value);
		mPrinter.printChangeSemaphoreAvailability(moduleId, orientation, value);
	}
	public void changeSensorAvailability()
	{
		String moduleId = getModuleId();
		Object orientation = getOrientation();
		if(orientation == null)
			return;
		boolean value = getAvailability();

		Semaphore semaphore = mApplication.getSemaphore(moduleId, orientation);
		if(semaphore == null)
		{
			Printer.println("Module doesn't exist!");
			return;
		}

		semaphore.setSensorAvailability(value);
		mPrinter.printChangeSensorAvailability(moduleId, orientation, value);
	}

	public void moveCurrentTrain()
	{
		// Get train:
		Train train = mApplication.getCurrentTrain();

		// Print move train message:
		mPrinter.printMoveTrainMessage(train);

		// Move the train:
		mApplication.moveTrain(train);

		// Print info:
		mPrinter.printSemaphore(train.getNextBlock().getModule().getId(), train.getOrientation(), true);
	}
	public void requestLeaveStation()
	{
		// Get train:
		Train train = mApplication.getCurrentTrain();

		// Request to leave station:
		boolean result = mApplication.requestLeaveStation(train);

		// Print request to leave station message:
		mPrinter.printRequestLeaveStation(train, result);
	}
	public void stopTrain()
	{
		// Get train:
		Train train = mApplication.getCurrentTrain();

		// Print stop train message:
		mPrinter.printStopTrain(train);

		// Stop the train:
		mApplication.stopTrain(train);
	}

	public void viewTrainLine()
	{
		TrainLine trainLine = mApplication.getTrainLine();
		VDMMap modules = trainLine.getModules();
		Set set = modules.keySet();

		List<String> moduleIds = new ArrayList<>();
		for (Object obj : set)
			moduleIds.add(obj.toString());

		Printer.printList(moduleIds);
	}
	public void viewTrains()
	{
		TrainLine trainLine = mApplication.getTrainLine();
		VDMMap trains = trainLine.getTrains();
		Set set = trains.keySet();

		List<String> trainIds = new ArrayList<>();
		for (Object obj : set)
			trainIds.add(obj.toString());

		Printer.println("List of trains:");
		Printer.printList(trainIds);
	}
	public void viewBlock()
	{
		String moduleId = getModuleId();

		Object orientation = getOrientation();
		if(orientation == null)
			return;

		mPrinter.printBlock(moduleId, orientation, false);
	}
	public void viewSemaphore()
	{
		String moduleId = getModuleId();

		Object orientation = getOrientation();
		if(orientation == null)
			return;

		// Print info:
		mPrinter.printSemaphore(moduleId, orientation, false);
	}
	public void viewTrain()
	{
		String trainId = getTrainId();

		mPrinter.printTrain(trainId);
	}
	public void viewCurrentTrain()
	{
		Train currentTrain = mApplication.getCurrentTrain();
		mPrinter.printTrain(currentTrain);
		mPrinter.printBlock(currentTrain.getCurrentBlock().getModule().getId(), currentTrain.getOrientation(), false);
		mPrinter.printBlock(currentTrain.getNextBlock().getModule().getId(), currentTrain.getOrientation(), true);
	}

	private void selectTrain()
	{
		// Print list of trains:
		viewTrains();

		String trainId = getTrainId();

		Train train = mApplication.getTrain(trainId);
		if(train == null)
		{
			Printer.println("Train doesn't exist!");
			return;
		}

		mApplication.setCurrentTrain(train);

		mTrainMenu.run();
	}

	private String getInput()
	{
		// Get input:
		String input = mScanner.next();

		// Ignore rest of the line:
		mScanner.nextLine();

		return input;
	}
	private boolean getBoolean()
	{
		while(!mScanner.hasNextBoolean())
			Printer.println("Invalid boolean! Expecting true or false!");

		return mScanner.nextBoolean();
	}
	private String getModuleId()
	{
		Printer.print("Module ID: ");
		return getInput();
	}
	private Object getOrientation()
	{
		Printer.print("Orientation (up, down): ");
		String orientationValue = getInput();
		Object orientation = Utils.parseSemaphore(orientationValue);
		if(orientation == null)
		{
			Printer.println("Invalid orientation!");
			return null;
		}

		return orientation;
	}
	private String getTrainId()
	{
		Printer.print("Train ID: ");
		return getInput();
	}
	private boolean getAvailability()
	{
		Printer.print("Is available: ");
		return getBoolean();
	}

	public void run()
	{
		mMainMenu.run();
	}

	public static void main(String[] args)
	{
		CommandLineInterface cli = new CommandLineInterface();

		cli.run();
	}
}