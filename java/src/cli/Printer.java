package cli;

import trainline.Application;
import trainline.Block;
import trainline.Semaphore;
import trainline.Train;

import java.util.List;

public class Printer
{
	private Application mApplication;

	public Printer(Application application)
	{
		mApplication = application;
	}

	public void printMoveTrainMessage(Train train)
	{
		print("Moving Train ");
		print(train.getId());
		print(" from Module ");
		print(train.getCurrentBlock().getModule().getId());
		print(" to Module ");
		print(train.getNextBlock().getModule().getId());
		print("\n");
	}
	public void printRequestLeaveStation(Train train, boolean result)
	{
		print("Train ");
		print(train.getId());
		print(" requesting to leave Station ");
		print(train.getCurrentBlock().getModule().getId());
		print("\n");

		if(result)
			print("Request accepted!");
		else
			print("Request denied!");

		print("\n");
	}
	public void printStopTrain(Train train)
	{
		print("Train ");
		print(train.getId());
		print(" stopping at Module ");
		print(train.getCurrentBlock().getModule().getId());
		print("\n");
	}

	public void printBlock(String moduleId, Object orientation)
	{
		Block block = mApplication.getBlock(moduleId, orientation);

		print("Block:\n");

		print("\tModuleId: ");
		print(moduleId);
		print("\n");

		print("\tOrientation: ");
		print(orientation.toString());
		print("\n");

		printSemaphore(block.getSemaphore(orientation));
	}
	public void printTrain(Train train)
	{
		print("Train:\n");

		print("\tModule ID: ");
		print(train.getCurrentBlock().getModule().getId());
		print("\n");

		print("\tOrientation: ");
		print(train.getOrientation().toString());
		print("\n");

		print("\tIs stopped: ");
		print(train.getIsStopped().toString());
		print("\n");
	}
	public void printTrain(String trainId)
	{
		// Get train:
		Train train = mApplication.getTrain(trainId);
		if(train == null)
		{
			Printer.println("Train doesn't exist!");
			return;
		}

		// Print info:
		printTrain(train);
	}

	public void printSemaphore(Semaphore semaphore)
	{
		print("Semaphore:\n");

		print("\tColor: ");
		print(semaphore.getColor().toString());
		print("\n");

		print("\tSensor: ");
		print(semaphore.getSensor().toString());
		print("\n");

		print("\tIs available: ");
		print(semaphore.isAvailable().toString());
		print("\n");

		print("\tIs sensor available: ");
		print(semaphore.isSensorAvailable().toString());
		print("\n");
	}
	public void printSemaphore(String moduleId, Object orientation)
	{
		// Get semaphore:
		Semaphore semaphore = mApplication.getSemaphore(moduleId, orientation);
		if(semaphore == null)
		{
			println("Semaphore doesn't exist!");
			return;
		}

		// Print info:
		printSemaphore(semaphore);
	}

	public static void printList(List<String> list)
	{
		if(list.isEmpty())
			return;

		print(list.get(0));
		for (int i = 1; i < list.size(); i++)
		{
			print(" - ");
			print(list.get(i));
		}

		print("\n");
	}
	public static void print(String message)
	{
		System.out.print(message);
	}
	public static void println(String message)
	{
		System.out.println(message);
	}
}
