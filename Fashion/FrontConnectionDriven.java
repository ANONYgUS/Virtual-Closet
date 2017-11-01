/**
 * describes clothing factors where Front connection matters
 */
public interface FrontConnectionDriven
{
    /**
     * returns FrontConnection type
     * @return FrontConnection
     */
    Collar getFrontConnection();

    /**
     * returns comparison to another front connection driven
     * @param f front connection driven factor to be compared to
     * @return comparison
     */
    Comparison compareFrontConnections(FrontConnectionDriven f){
    }
}
