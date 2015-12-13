package trainline;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class StationModule extends Module {
    private Block upBlock;
    private Block downBlock;

    public StationModule(final String idArg, final TrainLine trainLineArg) {
        cg_init_StationModule_1(idArg, trainLineArg);
    }

    public StationModule() {
    }

    public void cg_init_StationModule_1(final String idArg,
        final TrainLine trainLineArg) {
        id = idArg;
        upBlock = new Block(this, trainLineArg);
        downBlock = new Block(this, trainLineArg);

        return;
    }

    public Boolean canEnter(final Object orientation) {
        if (Utils.equals(orientation, trainline.quotes.UpQuote.getInstance())) {
            return upBlock.canEnter(((Object) orientation));
        } else {
            return downBlock.canEnter(((Object) orientation));
        }
    }

    public Block getBlock(final Object orientation) {
        if (Utils.equals(orientation, trainline.quotes.UpQuote.getInstance())) {
            return upBlock;
        } else {
            return downBlock;
        }
    }

    public Boolean getIsStation() {
        return true;
    }

    public String toString() {
        return "StationModule{" + "upBlock := " + Utils.toString(upBlock) +
        ", downBlock := " + Utils.toString(downBlock) + "}";
    }
}
