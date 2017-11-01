/**
 * describes clothing factors involving the comparison between types of waists and lengths of bottoms
 * for instance shorts often look good with untucked button down shirts
 */
public interface WaistDriven
{
    /**
     * returns waist factor, either topwaist or bottomleg
     * @return topwaist or LegLength
     */
    WaistFactor getWaist();

    /**
     * returns comparison to another waist driven
     * @param w waist driven factor to be compared to
     * @return comparison
     */
    Comparison compareWaists(WaistDriven w){
    }
}
