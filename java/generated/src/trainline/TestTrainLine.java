package trainline;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class TestTrainLine extends TestCase {
    public TestTrainLine() {
    }

    public void testSemaphoreInit() {
        TrainLine line = TrainLineBuilder.buildMap1();
        Object orientation = line.getTrain("train1").getOrientation();
        Object opOrientation = line.getTrain("train1").oppositeOrientation();
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station1", ((Object) orientation))));
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station1",
                ((Object) opOrientation))));
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module1", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module1", ((Object) opOrientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module2", ((Object) orientation))));
        super.assertEqual(trainline.quotes.GreenQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module2", ((Object) opOrientation))));
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station2", ((Object) orientation))));
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station2",
                ((Object) opOrientation))));
        super.assertEqual(trainline.quotes.GreenQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module3", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module3", ((Object) opOrientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module4", ((Object) orientation))));
        super.assertEqual(trainline.quotes.GreenQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module4", ((Object) opOrientation))));
        IO.println("Passed semaphore initialization");
    }

    public void testSimpleMovement() {
        TrainLine line = TrainLineBuilder.buildMap1();
        Object orientation = line.getTrain("train1").getOrientation();
        super.assertEqual(line.getTrain("train1").getCurrentBlock(),
            line.getModule("station1").getBlock(((Object) orientation)));
        super.assertEqual(true, line.getTrain("train1").getIsStopped());
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module1", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station1", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module2", ((Object) orientation))));
        super.assertEqual(true, line.requestLeaveStation("train1"));
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module1", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station1", ((Object) orientation))));
        super.assertEqual(trainline.quotes.GreenQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module2", ((Object) orientation))));
        super.assertEqual(true, line.getTrain("train1").getIsStopped());
        line.moveTrain("train1");
        super.assertEqual(line.getTrain("train1").getCurrentBlock(),
            line.getModule("module2").getBlock(((Object) orientation)));
        super.assertEqual(false, line.getTrain("train1").getIsStopped());
        super.assertEqual(trainline.quotes.GreenQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module1", ((Object) orientation))));
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station1", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module2", ((Object) orientation))));
        line.moveTrain("train1");
        super.assertEqual(line.getTrain("train1").getCurrentBlock(),
            line.getModule("module2.5").getBlock(((Object) orientation)));
        super.assertEqual(false, line.getTrain("train1").getIsStopped());
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station1", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module2", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module2.5", ((Object) orientation))));
        super.assertEqual(trainline.quotes.GreenQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module3", ((Object) orientation))));
        line.moveTrain("train1");
        super.assertEqual(line.getTrain("train1").getCurrentBlock(),
            line.getModule("module3").getBlock(((Object) orientation)));
        super.assertEqual(false, line.getTrain("train1").getIsStopped());
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station1", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module2", ((Object) orientation))));
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module2.5", ((Object) orientation))));
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station2", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module3", ((Object) orientation))));
        line.moveTrain("train1");
        line.stopTrain("train1");
        super.assertEqual(line.getTrain("train1").getCurrentBlock(),
            line.getModule("station2").getBlock(((Object) orientation)));
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module3", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station2", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module4", ((Object) orientation))));
        super.assertEqual(true, line.getTrain("train1").getIsStopped());
        super.assertEqual(true, line.requestLeaveStation("train1"));
        super.assertEqual(true, line.getTrain("train1").getIsStopped());
        super.assertEqual(trainline.quotes.GreenQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module4", ((Object) orientation))));
        line.moveTrain("train1");
        super.assertEqual(false, line.getTrain("train1").getIsStopped());
        super.assertEqual(trainline.quotes.YellowQuote.getInstance(),
            ((Object) line.getBlockSemaphore("station2", ((Object) orientation))));
        super.assertEqual(trainline.quotes.RedQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module4", ((Object) orientation))));
        super.assertEqual(trainline.quotes.GreenQuote.getInstance(),
            ((Object) line.getBlockSemaphore("module5", ((Object) orientation))));
        IO.println("Passed simple movement test");
    }

    public void testOnlyOneTrainBetweenTwoTracks() {
        TrainLine line = TrainLineBuilder.buildMap2();
        super.assertEqual(true, line.requestLeaveStation("train1"));
        line.moveTrain("train1");
        super.assertEqual(false, line.requestLeaveStation("train2"));
        super.assertEqual(false, line.requestLeaveStation("train3"));
        IO.println("Passed only one train between 2 tracks test");
    }

    public void testMultiTrain() {
        TrainLine line = TrainLineBuilder.buildMap2();
        super.assertEqual(true, line.requestLeaveStation("train2"));
        line.moveTrain("train2");
        super.assertEqual(true, line.requestLeaveStation("train3"));
        line.moveTrain("train3");
        line.moveTrain("train3");
        line.moveTrain("train3");
        line.stopTrain("train3");
        super.assertEqual(line.getModule("station2"),
            line.getTrain("train3").getCurrentBlock().getModule());
        super.assertEqual(false, line.requestLeaveStation("train3"));
        line.moveTrain("train2");
        line.moveTrain("train2");
        line.moveTrain("train2");
        line.stopTrain("train2");
        super.assertEqual(line.getModule("station1"),
            line.getTrain("train2").getCurrentBlock().getModule());
        super.assertEqual(true, line.requestLeaveStation("train1"));
        line.moveTrain("train1");
        line.moveTrain("train1");
        line.moveTrain("train1");
        line.moveTrain("train1");
        line.stopTrain("train1");
        super.assertEqual(line.getModule("station2"),
            line.getTrain("train1").getCurrentBlock().getModule());
        IO.println("Passed multi train test");
    }

    public void testAll() {
        testSemaphoreInit();
        testSimpleMovement();
        testMultiTrain();
        testOnlyOneTrainBetweenTwoTracks();
    }

    public String toString() {
        return "TestTrainLine{}";
    }
}
