package trainline;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class TrainLine {
    private VDMMap modules = MapUtil.map();
    private VDMMap trains = MapUtil.map();
    private String headModuleId = null;
    private String tailModuleId = null;
    private Boolean isLineBuilt = false;

    public TrainLine() {
    }

    public void addSimpleModule(final String id) {
        Module simpleModule = new SimpleModule(id, this);
        addModule(id, simpleModule);
    }

    public void addStationModule(final String id) {
        Module stationModule = new StationModule(id, this);
        addModule(id, stationModule);
    }

    public void closeCircularTrack() {
        ((Module) Utils.get(modules, headModuleId)).setDownModule(((Module) Utils.get(
                modules, tailModuleId)));
        ((Module) Utils.get(modules, tailModuleId)).setUpModule(((Module) Utils.get(
                modules, headModuleId)));

        for (Iterator iterator_2 = MapUtil.dom(Utils.copy(modules)).iterator();
                iterator_2.hasNext();) {
            String id = (String) iterator_2.next();
            Module module = ((Module) Utils.get(modules, id));

            if (module.getIsStation()) {
                module.getBlock(trainline.quotes.DownQuote.getInstance())
                      .setSemaphore(trainline.quotes.YellowQuote.getInstance(),
                    trainline.quotes.DownQuote.getInstance());
                module.getBlock(trainline.quotes.UpQuote.getInstance())
                      .setSemaphore(trainline.quotes.YellowQuote.getInstance(),
                    trainline.quotes.UpQuote.getInstance());
                module.getDownModule()
                      .getBlock(trainline.quotes.DownQuote.getInstance())
                      .setSemaphore(trainline.quotes.RedQuote.getInstance(),
                    trainline.quotes.DownQuote.getInstance());
                module.getUpModule()
                      .getBlock(trainline.quotes.UpQuote.getInstance())
                      .setSemaphore(trainline.quotes.RedQuote.getInstance(),
                    trainline.quotes.UpQuote.getInstance());
            }
        }

        isLineBuilt = true;
    }

    public void addTrain(final String id, final Object orientation,
        final String moduleId) {
        trains = MapUtil.override(Utils.copy(trains),
                MapUtil.map(
                    new Maplet(id,
                        new Train(id, ((Object) orientation),
                            ((Module) Utils.get(modules, moduleId)).getBlock(
                                ((Object) orientation))))));
        ((Module) Utils.get(modules, moduleId)).getBlock(((Object) orientation))
         .getPreviousBlock(((Object) orientation)).trainExit(orientation);
        ((Module) Utils.get(modules, moduleId)).getBlock(((Object) orientation))
         .trainEnter(orientation);
    }

    public void moveTrain(final String id) {
        ((Train) Utils.get(trains, id)).move();
    }

    public void stopTrain(final String id) {
        ((Train) Utils.get(trains, id)).stopAction();
    }

    public Boolean requestLeaveStation(final String id) {
        return ((Train) Utils.get(trains, id)).requestLeaveStation();
    }

    private void addModule(final String newModuleId, final Module newModule) {
        if (MapUtil.dom(Utils.copy(modules)).size() > 0L) {
            Module tailModule = ((Module) Utils.get(modules, tailModuleId));

            tailModule.setUpModule(newModule);
            newModule.setDownModule(tailModule);
            tailModuleId = newModuleId;
        } else {
            String atomicTmp_1 = newModuleId;
            String atomicTmp_2 = newModuleId;
            headModuleId = atomicTmp_1;
            tailModuleId = atomicTmp_2;
        }

        modules = MapUtil.munion(Utils.copy(modules),
                MapUtil.map(new Maplet(newModuleId, newModule)));
    }

    public Train getTrain(final String id) {
        return ((Train) Utils.get(trains, id));
    }

    public Module getModule(final String id) {
        return ((Module) Utils.get(modules, id));
    }

    public Object getBlockSemaphore(final String idArg,
        final Object orientationArg) {
        return getModule(idArg).getBlock(((Object) orientationArg))
                   .getSemaphore(((Object) orientationArg)).getColor();
    }

    public VDMMap getModules() {
        return Utils.copy(modules);
    }

    public VDMMap getTrains() {
        return Utils.copy(trains);
    }

    public String toString() {
        return "TrainLine{" + "modules := " + Utils.toString(modules) +
        ", trains := " + Utils.toString(trains) + ", headModuleId := " +
        Utils.toString(headModuleId) + ", tailModuleId := " +
        Utils.toString(tailModuleId) + ", isLineBuilt := " +
        Utils.toString(isLineBuilt) + "}";
    }
}
