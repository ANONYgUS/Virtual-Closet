// stores the temperature of the factor of clothing

public class Temperature{

  private double impact;
  private int approx;
  private double magnitude;

  /**
  * constructor for temperature objects
  */
  public Temperature(double i, int a, double m){
    impact = i;
    approx = a;
    magnitude = m;
  }

  /**
  * returns the impact of the temperature
  * @return impact
  */
  public double getImpact(){
    return impact;
  }
  public double getMagnitude(){
    return magnitude;
  }

  /**
  * returns the approximate temperature of the factor of clothing
  * @return approximate temperature
  */
  public int getApprox(){
    return approx;
  }


  public double getScore(int t){
      return impact * (Math.abs(t-approx)) * FashionMap.TEMPERATURE_SCORE_CONSTANT;
  }
}
