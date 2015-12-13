package trainline.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class BusyQuote {
    private static int hc = 0;
    private static BusyQuote instance = null;

    public BusyQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static BusyQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new BusyQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof BusyQuote;
    }

    public String toString() {
        return "<Busy>";
    }
}
