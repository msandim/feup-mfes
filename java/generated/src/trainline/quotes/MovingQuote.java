package trainline.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class MovingQuote {
    private static int hc = 0;
    private static MovingQuote instance = null;

    public MovingQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static MovingQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new MovingQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof MovingQuote;
    }

    public String toString() {
        return "<Moving>";
    }
}
