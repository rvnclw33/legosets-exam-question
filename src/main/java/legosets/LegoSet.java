package legosets;

import java.io.Serializable;
import java.time.Year;
import java.util.Set;

/**
 * Represents a LEGO set.
 */
public record LegoSet(
        String number,
        String name,
        Year year,
        String theme,
        String subtheme,
        int numberOfPieces,
        int numberOfMinifigs,
        Set<String> tags,
        Availability availability
) implements Serializable {

    public enum Availability {
        LEGO_EXCLUSIVE,
        RETAIL,
        RETAIL_LIMITED
    }
}