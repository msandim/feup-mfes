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

	public void printBlock(String moduleId, Object orientation, Block block)
	{
		print("Block:");

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
	public void printList(List<String> list)
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

	private void print(String message)
	{
		System.out.print(message);
	}
}
