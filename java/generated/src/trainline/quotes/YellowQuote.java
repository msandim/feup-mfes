package trainline.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class YellowQuote {
    private static int hc = 0;
    private static YellowQuote instance = null;

    public YellowQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static YellowQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new YellowQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof YellowQuote;
    }

    public String toString() {
        return "<Yellow>";
    }
}
