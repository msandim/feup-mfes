package trainline.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class FreeQuote {
    private static int hc = 0;
    private static FreeQuote instance = null;

    public FreeQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static FreeQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new FreeQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof FreeQuote;
    }

    public String toString() {
        return "<Free>";
    }
}
