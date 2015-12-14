package trainline;

import org.overture.codegen.runtime.VDMMap;
import trainline.quotes.UpQuote;

public class Application
{
	private TrainLine mTrainLine;
	private Train mCurrentTrain;

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
		mTrainLine.addSimpleModule("module5");
		mTrainLine.addStationModule("station3");
		mTrainLine.addSimpleModule("module6");
		mTrainLine.closeCircularTrack();

		mTrainLine.addTrain("train1", UpQuote.getInstance(), "station1");
		mTrainLine.addTrain("train2", UpQuote.getInstance(), "station2");
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

	public Train getCurrentTrain()
	{
		return mCurrentTrain;
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

		// Get trains:
		VDMMap trains = trainLine.getTrains();

		// If trainId doesn't exist:
		if(!trains.containsKey(trainId))
			return null;

		// Get train:
		return (Train) trains.get(trainId);
	}
	public Module getModule(String moduleId)
	{
		// Get train line:
		TrainLine trainLine = getTrainLine();

		// Get modules:
		VDMMap modules = trainLine.getModules();

		// If moduleId doesn't exist:
		if(!modules.containsKey(moduleId))
			return null;

		// Get module:
		return (Module) modules.get(moduleId);
	}
	public Block getBlock(String moduleId, Object orientation)
	{
		// Get module:
		Module module = getModule(moduleId);
		if(module == null)
			return null;

		// Get block:
		return module.getBlock(orientation);
	}
	public Semaphore getSemaphore(String moduleId, Object orientation)
	{
		// Get module:
		Block block = getBlock(moduleId, orientation);
		if(block == null)
			return null;

		// Get semaphore:
		return block.getSemaphore(orientation);
	}

	public void setCurrentTrain(Train train)
	{
		mCurrentTrain = train;
	}
}
