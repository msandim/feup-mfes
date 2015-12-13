package trainline.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class DownQuote {
    private static int hc = 0;
    private static DownQuote instance = null;

    public DownQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static DownQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new DownQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof DownQuote;
    }

    public String toString() {
        return "<Down>";
    }
}
