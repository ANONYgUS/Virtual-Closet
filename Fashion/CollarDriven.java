/**
 * describes clothing factors where collar matters
 */
public interface CollarDriven
{
    /**
     * returns collar type
     * @return collar
     */
    Collar getCollar();

    /**
     * returns comparison to another collar driven
     * @param c collar driven factor to be compared to
     * @return comparison
     */
    Comparison compareCollars(CollarDriven c);
}
