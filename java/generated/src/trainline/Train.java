package trainline;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Train {
    private String id;
    private Object orientation = trainline.quotes.UpQuote.getInstance();
    private Object status = trainline.quotes.StoppedQuote.getInstance();
    private Block currentBlock;

    public Train(final String idArg, final Object initialOrientation,
        final Block initialBlock) {
        cg_init_Train_1(idArg, ((Object) initialOrientation), initialBlock);
    }

    public Train() {
    }

    public void cg_init_Train_1(final String idArg,
        final Object initialOrientation, final Block initialBlock) {
        id = idArg;
        orientation = initialOrientation;
        currentBlock = initialBlock;

        return;
    }

    public void move() {
        status = trainline.quotes.MovingQuote.getInstance();
        currentBlock.trainExit(orientation);
        getNextBlock().trainEnter(orientation);
        currentBlock = getNextBlock();
    }

    public void stopAction() {
        status = trainline.quotes.StoppedQuote.getInstance();
    }

    public Boolean requestLeaveStation() {
        if (isPathClearedUntilNextStation()) {
            if (Utils.equals(getNextBlock().getNextBlock(((Object) orientation))
                                     .getSemaphore(((Object) orientation))
                                     .getColor(),
                        trainline.quotes.RedQuote.getInstance())) {
                getNextBlock()
                    .setSemaphore(trainline.quotes.YellowQuote.getInstance(),
                    orientation);
            } else {
                getNextBlock()
                    .setSemaphore(trainline.quotes.GreenQuote.getInstance(),
                    orientation);
            }

            return true;
        } else {
            return false;
        }
    }

    public Block getCurrentBlock() {
        return currentBlock;
    }

    public Block getNextBlock() {
        return currentBlock.getNextBlock(((Object) orientation));
    }

    public Block getPreviousBlock() {
        return currentBlock.getPreviousBlock(((Object) orientation));
    }

    public Object getOrientation() {
        return orientation;
    }

    public Boolean getIsStopped() {
        return Utils.equals(status, trainline.quotes.StoppedQuote.getInstance());
    }

    public String getId() {
        return id;
    }

    private Boolean isPathClearedUntilNextStation() {
        Block nextBlock = getNextBlock();
        Boolean whileCond_1 = true;

        while (whileCond_1) {
            Boolean andResult_9 = false;

            if (!(nextBlock.getModule().getIsStation())) {
                Boolean andResult_10 = false;

                if (Utils.equals(nextBlock.getSemaphore(((Object) orientation))
                                              .getSensor(),
                            trainline.quotes.FreeQuote.getInstance())) {
                    Boolean andResult_11 = false;

                    if (nextBlock.getSemaphore(((Object) orientation))
                                     .isSensorAvailable()) {
                        Boolean andResult_12 = false;

                        if (Utils.equals(nextBlock.getSemaphore(
                                        ((Object) oppositeOrientation()))
                                                      .getSensor(),
                                    trainline.quotes.FreeQuote.getInstance())) {
                            if (nextBlock.getSemaphore(
                                        ((Object) oppositeOrientation()))
                                             .isSensorAvailable()) {
                                andResult_12 = true;
                            }
                        }

                        if (andResult_12) {
                            andResult_11 = true;
                        }
                    }

                    if (andResult_11) {
                        andResult_10 = true;
                    }
                }

                if (andResult_10) {
                    andResult_9 = true;
                }
            }

            whileCond_1 = andResult_9;

            if (!(whileCond_1)) {
                break;
            }

            nextBlock = nextBlock.getNextBlock(((Object) orientation));
        }

        Boolean andResult_13 = false;

        if (nextBlock.getModule().getIsStation()) {
            Boolean andResult_14 = false;

            if (Utils.equals(nextBlock.getSemaphore(((Object) orientation))
                                          .getSensor(),
                        trainline.quotes.FreeQuote.getInstance())) {
                if (nextBlock.getSemaphore(((Object) orientation))
                                 .isSensorAvailable()) {
                    andResult_14 = true;
                }
            }

            if (andResult_14) {
                andResult_13 = true;
            }
        }

        return andResult_13;
    }

    public Object oppositeOrientation() {
        if (Utils.equals(orientation, trainline.quotes.UpQuote.getInstance())) {
            return trainline.quotes.DownQuote.getInstance();
        } else {
            return trainline.quotes.UpQuote.getInstance();
        }
    }

    public String toString() {
        return "Train{" + "id := " + Utils.toString(id) + ", orientation := " +
        Utils.toString(orientation) + ", status := " + Utils.toString(status) +
        ", currentBlock := " + Utils.toString(currentBlock) + "}";
    }
}
