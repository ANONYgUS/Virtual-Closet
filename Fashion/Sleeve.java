//stores the sleeve a top has
import java.util.*;

public class Sleeve{

  private Color color;
  private String name;
  private Formality formality;
  private SleeveType sleeveType;
  private Temperature temperature;
  private double impact;
  /**
  * constructor for sleeve objects
  */
  public Sleeve(SleeveType sT, Color c){

  }

  /**
  * returns the colors of the sleeve, which is always just going to be 1 color
  * @return color
  */
  public Color getColor(){
    return color;
  }

  public void setImpact(double d){
    impact *= d;
    color.multiplyImpact(d);
    formality.multiplyImpact(d);
  }
  /**
  * returns the formality of the sleeve
  * @return formality
  */
  public Formality getFormality(){
    return formality;
  }

  /**
  * returns the type of sleeve
  * @return sleeve type
  */
  public SleeveType getSleeveType(){
    return sleeveType;
  }

  /**
  * returns the name of the sleeve
  * @return name
  */
  public String getname(){
    return name;
  }

  /**
  * returns the temperature of the sleeve
  * @return temperature
  */
  public Temperature getTemperature(){
    return temperature;
  }
}
