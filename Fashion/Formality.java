
/**
 * Aspects of clothing have different ranges of formality
 */
public class Formality
{

    private double min;
    private double max;
    private double impact;

    /**
     * Constructor for objects of class Formality
     */
    public Formality(double _min, double _max, double _impact)
    {
        min = _min;
        max = _max;
        impact = _impact;
    }

    /**
     *  returns the minimum formality level
     *  @return min
     */
    public double getMin(){
        return min;
    }

    /**
     *  returns the maximum formality level
     *  @return max
     */
    public double getMax(){
        return max;
    }

    public void multiplyImpact(double d){
      impact *= d;
    }
    /**
     *  returns the impact of the formality
     *  @return impact
     */
    public double getImpact(){
        return impact;
    }

    /**
     *  sets the minimum formality level
     *  @param new minimum formality
     */
    public void setMin(double m){
    }

    /**
     *  sets the maximum formality level
     *  @param new maximum formality
     */
    public void setMax(double m){
    }

    /**
     *  sets the impact of the formality
     *  @param new impact
     */
    public void setImpact(double i){
    }
}
