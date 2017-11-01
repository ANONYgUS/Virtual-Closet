
/**
 * comparison between two factors of clothing

 */
public class Comparison
{
    // instance variables - replace the example below with your own
    private double rating;
    private double impact;
    private double colorImpactFactor;  // relevant when comparison between two factors of clothing indicates change in impact of color
    private double formalImpactFactor;
    private double sleeveImpactFactor;
    private double frontConnectionImpactFactor;
    private double collarImpactFactor;



    /**
     * Constructor for objects of class Comparison
     */
    public Comparison()
    {

    }

    /**
     * returns how good the comparison is from 0 to 1
     * @return rating
     */
    public double getRating(){
        return rating;
    }

    /**
     * returns how important the comparison is from 0 to 1
     * @return impact
     */
    public double getImpact(){
        return impact;
    }

    /**
     * returns how much color impact is going to be affected from 0 to 1
     * @return color impact factor
     */
    public double getCIF(){
        return colorImpactFactor;
    }

    /**
     * returns how much formality impact is going to be affected from 0 to 1
     * @return formal impact factor
     */
    public double getFIF(){
        return formalImpactFactor;
    }
}
