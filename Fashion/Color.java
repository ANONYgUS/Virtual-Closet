//stores the color of something

public class Color{


  private String name;
  private Formality formality;
  private double impact;
  private Hue hue;
  private int saturation;
  private int brightness;

  /**
  * constructor for color objects
  */
  Color(ColorName cN){
    name = cN.toString();
    formality = cN.getFormality();
    hue = cN.getHue();
    saturation = cN.getSaturation();
    brightness = cN.getBrightness();
  }

  /**
  * returns the formality of the color
  * @return formality
  */
  public Formality getFormality(){
    return formality;
  }

  /**
  * sets the impact of the color to a double
  * @param d double to set the impact to
  */
  public void setImpact(double d){
    impact = d;
  }

  /**
  * returns the impact of the color
  * @return impact
  */
  public double getImpact(){
    return impact;
  }

  public double getSaturationImpact(){
    return saturation * FashionMap.SATURATION_IMPACT_FACTOR;
  }

  public double getBrightnessImpact(){
    return brightness * FashionMap.BRIGHTNESS_IMPACT_FACTOR;
  }
}
