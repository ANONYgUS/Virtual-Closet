// scores how well the outfit accomodates the temperature
// also stores the ideal temperature of the outfit
import java.util.*;
public class TemperatureTracker{

  private ArrayList<Temperature> temperatures;
  private int target;
  private int temperature;

  /**
  *constructor for TemperatureTracker
  */
  public TemperatureTracker(){

  }

  /**
  * adds a temperature to the tracker
  * @param t temperature to add
  */
  public void addTemperature(Temperature t){
    temperatures.add(t);
  }

  /**
  * returns a double representing how well the outfit accomodates the temperature
  * uses standard deviation
  * @return score from 0-1
  */
  public double getScore(){
    double sum = 0;
    double tImpact = 0;
    for(Temperature t: temperatures){
      sum += Math.pow(t.getApprox() - temperature, 2) * t.getImpact() ;
      tImpact += t.getImpact();
    }

    return Math.sqrt(sum/tImpact) * FashionMap.TEMPERATURE_SCORE_CONSTANT;
  }

  /**
  * returns a double representing the temperature of the entire outfit
  * @return outfit temperature
  */
  public double getTemperature(){

    return temperature;
  }

  public void calculateTemperature(){
    double sum = 0;
    double tImpact = 0;

    for(Temperature t: temperatures){
      sum+= t.getApprox() * t.getImpact();
      tImpact += t.getImpact();
    }

    temperature = (int)(sum / tImpact);
  }
}
