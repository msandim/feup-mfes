package trainline;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Block {
    private Module module;
    private TrainLine trainLine;
    private Semaphore upSemaphore = new Semaphore();
    private Semaphore downSemaphore = new Semaphore();
    private Block true_self;

    public Block(final Module moduleArg, final TrainLine trainLineArg) {
        cg_init_Block_1(moduleArg, trainLineArg);
    }

    public Block() {
    }

    public void cg_init_Block_1(final Module moduleArg,
        final TrainLine trainLineArg) {
        module = moduleArg;
        trainLine = trainLineArg;
        true_self = this;

        return;
    }

    public void trainEnter(final Object trainOrientation) {
        if (Utils.equals(trainOrientation,
                    trainline.quotes.UpQuote.getInstance())) {
            upSemaphore.setColor(trainline.quotes.RedQuote.getInstance());
            upSemaphore.setSensor(trainline.quotes.BusyQuote.getInstance());
        } else {
            downSemaphore.setColor(trainline.quotes.RedQuote.getInstance());
            downSemaphore.setSensor(trainline.quotes.BusyQuote.getInstance());
        }
    }

    public void trainExit(final Object trainOrientation) {
        Object semaphoreNextColor = null;
        Object previousSemaphoreNextColor = null;

        if (getModule().getPreviousModule(((Object) trainOrientation))
                    .getIsStation()) {
            semaphoreNextColor = trainline.quotes.RedQuote.getInstance();
        } else {
            semaphoreNextColor = trainline.quotes.YellowQuote.getInstance();
        }

        if (Utils.equals(trainOrientation,
                    trainline.quotes.UpQuote.getInstance())) {
            upSemaphore.setColor(semaphoreNextColor);
            upSemaphore.setSensor(trainline.quotes.FreeQuote.getInstance());
        } else {
            downSemaphore.setColor(semaphoreNextColor);
            downSemaphore.setSensor(trainline.quotes.FreeQuote.getInstance());
        }

        Boolean orResult_1 = false;

        if (getPreviousBlock(((Object) trainOrientation))
                    .getPreviousBlock(((Object) trainOrientation)).isInStation()) {
            orResult_1 = true;
        } else {
            orResult_1 = Utils.equals(getPreviousBlock(
                        ((Object) trainOrientation))
                                          .getSemaphore(((Object) trainOrientation))
                                          .getSensor(),
                    trainline.quotes.BusyQuote.getInstance());
        }

        if (orResult_1) {
            previousSemaphoreNextColor = trainline.quotes.RedQuote.getInstance();
        } else if (getPreviousBlock(((Object) trainOrientation)).isInStation()) {
            previousSemaphoreNextColor = trainline.quotes.YellowQuote.getInstance();
        } else {
            previousSemaphoreNextColor = trainline.quotes.GreenQuote.getInstance();
        }

        getModule().getPreviousModule(((Object) trainOrientation))
            .getBlock(((Object) trainOrientation))
            .setSemaphore(previousSemaphoreNextColor, trainOrientation);
    }

    public Boolean canEnter(final Object orientationArg) {
        if (Utils.equals(orientationArg, trainline.quotes.UpQuote.getInstance())) {
            Boolean andResult_1 = false;

            if (!(Utils.equals(upSemaphore.getColor(),
                        trainline.quotes.RedQuote.getInstance()))) {
                if (upSemaphore.isAvailable()) {
                    andResult_1 = true;
                }
            }

            return andResult_1;
        } else {
            Boolean andResult_2 = false;

            if (!(Utils.equals(downSemaphore.getColor(),
                        trainline.quotes.RedQuote.getInstance()))) {
                if (downSemaphore.isAvailable()) {
                    andResult_2 = true;
                }
            }

            return andResult_2;
        }
    }

    public Boolean canEnterNextBlock(final Object orientation) {
        return getNextBlock(((Object) orientation))
                   .canEnter(((Object) orientation));
    }

    public Boolean isInStation() {
        return module.getIsStation();
    }

    public Semaphore getSemaphore(final Object orientationArg) {
        if (Utils.equals(orientationArg, trainline.quotes.UpQuote.getInstance())) {
            return upSemaphore;
        } else {
            return downSemaphore;
        }
    }

    public Module getModule() {
        return module;
    }

    public Block getNextBlock(final Object orientation) {
        return module.getNextBlock(((Object) orientation));
    }

    public Block getPreviousBlock(final Object orientation) {
        return module.getPreviousBlock(((Object) orientation));
    }

    public void setSemaphore(final Object semaphoreArg,
        final Object orientationArg) {
        if (Utils.equals(orientationArg, trainline.quotes.UpQuote.getInstance())) {
            upSemaphore.setColor(semaphoreArg);
        } else {
            downSemaphore.setColor(semaphoreArg);
        }
    }

    public String toString() {
        return "Block{" + "module := " + Utils.toString(module) +
        ", trainLine := " + Utils.toString(trainLine) + ", upSemaphore := " +
        Utils.toString(upSemaphore) + ", downSemaphore := " +
        Utils.toString(downSemaphore) + ", true_self := " +
        Utils.toString(true_self) + "}";
    }
}
