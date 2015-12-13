package trainline.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class RedQuote {
    private static int hc = 0;
    private static RedQuote instance = null;

    public RedQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static RedQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new RedQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof RedQuote;
    }

    public String toString() {
        return "<Red>";
    }
}
