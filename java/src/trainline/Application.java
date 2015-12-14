package trainline;

import trainline.quotes.UpQuote;

public class Application
{
	private TrainLine mTrainLine;

	public Application()
	{

	}

	public void initializeTrainLine()
	{
		mTrainLine = new TrainLine();
		mTrainLine.addSimpleModule("module1");
		mTrainLine.addStationModule("station1");
		mTrainLine.addSimpleModule("module2");
		mTrainLine.addSimpleModule("module3");
		mTrainLine.addStationModule("station2");
		mTrainLine.addSimpleModule("module4");
		mTrainLine.closeCircularTrack();

		mTrainLine.addTrain("train1", UpQuote.getInstance(), "station1");
	}

	public void moveTrain(Train train)
	{
		// Move train:
		train.move();
	}

	public void stopTrain(Train train)
	{
		// Stop train:
		train.stopAction();
	}

	public boolean requestLeaveStation(Train train)
	{
		// Ask for permission to leave station:
		return train.requestLeaveStation();
	}

	public TrainLine getTrainLine()
	{
		// Get train line:
		return mTrainLine;
	}
	public Train getTrain(String trainId)
	{
		// Get train line:
		TrainLine trainLine = getTrainLine();

		// Get train:
		return trainLine.getTrain(trainId);
	}
	public Module getModule(String moduleId)
	{
		// Get train line:
		TrainLine trainLine = getTrainLine();

		// Get module:
		return trainLine.getModule(moduleId);
	}
	public Block getBlock(String moduleId, Object orientation)
	{
		// Get module:
		Module module = getModule(moduleId);

		// Get block:
		return module.getBlock(orientation);
	}
	public Semaphore getSemaphore(String moduleId, Object orientation)
	{
		// Get module:
		Block block = getBlock(moduleId, orientation);

		// Get semaphore:
		return block.getSemaphore(orientation);
	}
}
