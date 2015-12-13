package trainline;

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
		mTrainLine.addSimpleModule("station1");
		mTrainLine.addSimpleModule("module2");
		mTrainLine.addSimpleModule("station2");
		mTrainLine.closeCircularTrack();

		mTrainLine.addTrain("train1", "<Up>", "station1");
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
