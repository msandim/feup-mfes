package trainline.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class StoppedQuote {
    private static int hc = 0;
    private static StoppedQuote instance = null;

    public StoppedQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static StoppedQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new StoppedQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof StoppedQuote;
    }

    public String toString() {
        return "<Stopped>";
    }
}
