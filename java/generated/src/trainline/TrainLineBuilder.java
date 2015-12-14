package trainline;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class TrainLineBuilder {
    public TrainLineBuilder() {
    }

    public static TrainLine buildMap1() {
        TrainLine trainLine = new TrainLine();
        trainLine.addSimpleModule("module1");
        trainLine.addStationModule("station1");
        trainLine.addSimpleModule("module2");
        trainLine.addSimpleModule("module2.5");
        trainLine.addSimpleModule("module3");
        trainLine.addStationModule("station2");
        trainLine.addSimpleModule("module4");
        trainLine.addSimpleModule("module5");
        trainLine.addStationModule("station3");
        trainLine.addSimpleModule("module6");
        trainLine.addSimpleModule("module7");
        trainLine.addStationModule("station4");
        trainLine.addSimpleModule("module8");
        trainLine.closeCircularTrack();
        trainLine.addTrain("train1", trainline.quotes.UpQuote.getInstance(),
            "station1");

        return trainLine;
    }

    public static TrainLine buildMap2() {
        TrainLine trainLine = new TrainLine();
        trainLine.addSimpleModule("module1");
        trainLine.addStationModule("station1");
        trainLine.addSimpleModule("module2");
        trainLine.addSimpleModule("module2.5");
        trainLine.addSimpleModule("module3");
        trainLine.addStationModule("station2");
        trainLine.addSimpleModule("module4");
        trainLine.addSimpleModule("module5");
        trainLine.addStationModule("station3");
        trainLine.addSimpleModule("module6");
        trainLine.addSimpleModule("module7");
        trainLine.addStationModule("station4");
        trainLine.addSimpleModule("module8");
        trainLine.closeCircularTrack();
        trainLine.addTrain("train1", trainline.quotes.UpQuote.getInstance(),
            "station1");
        trainLine.addTrain("train2", trainline.quotes.DownQuote.getInstance(),
            "station2");
        trainLine.addTrain("train3", trainline.quotes.DownQuote.getInstance(),
            "station3");

        return trainLine;
    }

    public static TrainLine buildMap3() {
        TrainLine trainLine = new TrainLine();
        trainLine.addSimpleModule("module1");
        trainLine.addStationModule("station1");
        trainLine.addSimpleModule("module2");
        trainLine.addStationModule("station2");
        trainLine.closeCircularTrack();
        trainLine.addTrain("train1", trainline.quotes.UpQuote.getInstance(),
            "station1");

        return trainLine;
    }

    public static TrainLine buildMap4() {
        TrainLine trainLine = new TrainLine();
        trainLine.addSimpleModule("module1");
        trainLine.addStationModule("station1");
        trainLine.addSimpleModule("module2");
        trainLine.addSimpleModule("module2.5");
        trainLine.addSimpleModule("module3");
        trainLine.addStationModule("station2");
        trainLine.addSimpleModule("module4");
        trainLine.addSimpleModule("module5");
        trainLine.addStationModule("station3");
        trainLine.addSimpleModule("module6");
        trainLine.addSimpleModule("module7");
        trainLine.addStationModule("station4");
        trainLine.addSimpleModule("module8");
        trainLine.closeCircularTrack();
        trainLine.addTrain("train2", trainline.quotes.DownQuote.getInstance(),
            "station2");
        trainLine.addTrain("train3", trainline.quotes.DownQuote.getInstance(),
            "station3");

        return trainLine;
    }

    public static TrainLine buildInvalidMap1() {
        TrainLine trainLine = new TrainLine();
        trainLine.addSimpleModule("module1");
        trainLine.addSimpleModule("module2");
        trainLine.addStationModule("station2");
        trainLine.addStationModule("station3");
        trainLine.closeCircularTrack();

        return trainLine;
    }

    public static TrainLine buildInvalidMap2() {
        TrainLine trainLine = new TrainLine();
        trainLine.addSimpleModule("module1");
        trainLine.addStationModule("station1");
        trainLine.addSimpleModule("module2");
        trainLine.closeCircularTrack();

        return trainLine;
    }

    public String toString() {
        return "TrainLineBuilder{}";
    }
}
