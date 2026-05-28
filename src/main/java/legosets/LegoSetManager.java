package legosets;

import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;
import java.time.Year;
import java.util.Set;

/**
 * Specifies methods to query information about LEGO sets.
 */
public interface LegoSetManager {

    /**
     * Loads and returns a list of {@code LegoSet} objects from a serialized file.
     *
     * @return the list of LEGO sets
     * @throws AssertionError if the serialized file cannot be found or loaded
     */
    @SuppressWarnings("unchecked")
    default List<LegoSet> getLegoSets() {
        try (ObjectInputStream in = new ObjectInputStream(LegoSetManager.class.getResourceAsStream("/legosets/legosets.ser"))) {
            return (List<LegoSet>) in.readObject();
        } catch (Exception e) {
            throw new AssertionError("Failed to load objects");
        }
    }

    /**
     * Returns the sorted list of LEGO sets.
     * * The sorting stages:
     * 1. theme (ascending)
     * 2. number of minifigures (descending)
     *
     * @return the sorted list of LEGO sets
     */
    List<LegoSet> getSetsOrderByThemeAscThenByNumberOfMinifigsDesc();

    /**
     * Returns a string that contains the lexicographically sorted sequence of distinct themes.
     * Values should be concatenated using a delimiter (e.g., a semicolon).
     *
     * @return the concatenated string of sorted themes
     */
    String getSortedAndConcatenatedThemes();

    /**
     * Prints the sorted order of all distinct tags to the standard output (one per line).
     * Each tag must be printed only once.
     */
    void printDistinctSortedTags();

    /**
     * Returns a dictionary that maps each release year to the total number of exclusive sets
     * released in that year.
     *
     * @return a map containing the years as keys and the count of exclusive sets as values
     */
    Map<Year, Long> getTotalNumberOfExclusiveSetsByYear();

    /**
     * Returns a nested dictionary that groups the sets by their release years,
     * and then by their piece counts.
     *
     * @return a map containing years as keys and another map as values,
     * which maps piece counts to sets of {@code LegoSet} objects
     */
    Map<Year, Map<Integer, Set<LegoSet>>> groupSetsByYearThenByPieces();
}