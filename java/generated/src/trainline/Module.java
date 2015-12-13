package trainline;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
abstract public class Module {
    protected String id;
    protected Module upModule;
    protected Module downModule;

    public Module() {
    }

    public abstract Boolean canEnter(final Object orientation);

    public abstract Block getBlock(final Object orientation);

    public Block getNextBlock(final Object orientation) {
        if (Utils.equals(orientation, trainline.quotes.UpQuote.getInstance())) {
            return upModule.getBlock(((Object) orientation));
        } else {
            return downModule.getBlock(((Object) orientation));
        }
    }

    public Block getPreviousBlock(final Object orientation) {
        if (Utils.equals(orientation, trainline.quotes.DownQuote.getInstance())) {
            return upModule.getBlock(((Object) orientation));
        } else {
            return downModule.getBlock(((Object) orientation));
        }
    }

    public String getId() {
        return id;
    }

    public abstract Boolean getIsStation();

    public Module getUpModule() {
        return upModule;
    }

    public Module getDownModule() {
        return downModule;
    }

    public Module getNextModule(final Object orientation) {
        if (Utils.equals(orientation, trainline.quotes.UpQuote.getInstance())) {
            return upModule;
        } else {
            return downModule;
        }
    }

    public Module getPreviousModule(final Object orientation) {
        if (Utils.equals(orientation, trainline.quotes.DownQuote.getInstance())) {
            return upModule;
        } else {
            return downModule;
        }
    }

    public void setUpModule(final Module upModuleArg) {
        upModule = upModuleArg;
    }

    public void setDownModule(final Module downModuleArg) {
        downModule = downModuleArg;
    }

    public String toString() {
        return "Module{" + "id := " + Utils.toString(id) + ", upModule := " +
        Utils.toString(upModule) + ", downModule := " +
        Utils.toString(downModule) + "}";
    }
}
