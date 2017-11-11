/**
 * describes clothing factors where design matters
 */
public interface DesignDriven
{
    /**
     * returns design type
     * @return design
     */
    Design getDesign();

    /**
     * returns comparison to another design driven
     * @param d design driven factor to be compared to
     * @return comparison
     */
    Comparison compareDesign(DesignDriven c);
}
