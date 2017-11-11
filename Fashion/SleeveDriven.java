
/**
 * describes clothing factors where sleeve length matters
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface SleeveDriven
{
    /**
     * returns sleeve length
     * @return sleevelength
     */
    SleeveLength getSleeve();

    /**
     * returns comparison to another sleeve driven
     * @param s sleeve driven factor to be compared to
     * @return comparison
     */
     Comparison compareSleeves(SleeveDriven s); //used to be SleeveComparison, but should be Comparison
 
}
