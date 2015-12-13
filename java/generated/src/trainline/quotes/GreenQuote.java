package trainline.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class GreenQuote {
    private static int hc = 0;
    private static GreenQuote instance = null;

    public GreenQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static GreenQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new GreenQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof GreenQuote;
    }

    public String toString() {
        return "<Green>";
    }
}
