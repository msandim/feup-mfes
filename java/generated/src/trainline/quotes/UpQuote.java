package trainline.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class UpQuote {
    private static int hc = 0;
    private static UpQuote instance = null;

    public UpQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static UpQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new UpQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof UpQuote;
    }

    public String toString() {
        return "<Up>";
    }
}
