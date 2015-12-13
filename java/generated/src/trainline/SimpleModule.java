package trainline;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class SimpleModule extends Module {
    private Block block;

    public SimpleModule(final String idArg, final TrainLine trainLineArg) {
        cg_init_SimpleModule_1(idArg, trainLineArg);
    }

    public SimpleModule() {
    }

    public void cg_init_SimpleModule_1(final String idArg,
        final TrainLine trainLineArg) {
        id = idArg;
        block = new Block(this, trainLineArg);

        return;
    }

    public Boolean canEnter(final Object orientation) {
        return block.canEnter(((Object) orientation));
    }

    public Block getBlock(final Object orientation) {
        return block;
    }

    public Boolean getIsStation() {
        return false;
    }

    public String toString() {
        return "SimpleModule{" + "block := " + Utils.toString(block) + "}";
    }
}
