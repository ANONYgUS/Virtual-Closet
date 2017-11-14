
//, scores how well colors go together throughout an outfit

public class ColorTracker{

  private ArrayList<Color> colors;

  /**
  *constructor for ColorTracker
  */
  public ColorTracker(){

  }

  /**
  * adds a color to the tracker
  * @param c color to add
  */
  public void addColor(Color c){
    colors.add(c);
  }

  /**
  * adds a color ArrayList to the tracker
  * @param c color arraylist to add
  */
  public void addColor(ArrayList<Color> aC){
    for(Color c: aC){
      colors.add(c);
    }
  }

  /**
  * returns a double representing how well all the colors of the outfit go together
  * @return score from 0-1
  */
  public double getScore(){
    return Math.max(monoChromaticScore(), brightnessScore());
  }

  /**
  * returns a double representing how monochromatic the color scheme of the outfit is
  * calculates standard deviation of weighted hues
  */
  public double monoChromaticScore(){
    int length = colors.size();
    double sumX = 0;
    double sumY = 0;
    double tImpact = 0;

    for(Color c: colors){
      double impact = c.getImpact();
      double sImpact = c.getSaturationImpact();
      double bImpact = c.getBrightnessImpact();
      tImpact += impact * sImpact * bImpact * FashionMap.MONO_COLOR_MULTIPLIER;
      sumX += c.getHue().getX() * tImpact;
      sumY += c.getHue().getY() * tImpact;
    }

    Hue meanHue = new Hue(Math.atan(sumY/sumX))
    double sum = 0;

    for(Color c: colors){
      Hue hue = c.getHue();
      double diff = Math.hypot(hue.getX()-meanHue.getX(), hue.getY()-meanHue.getY()) *
                                c.getImpact()* c.getSaturationImpact() *
                                c.getBrightnessImpact() * FashionMap.MONO_COLOR_MULTIPLIER;
      sum += Math.pow(diff, 2);

    }

    double hueDeviation = Math.sqrt(sum / (tImpact));
    return hueDeviation * FashionMap.MONO_SCORE_CONSTANT;
  }

  /**
  * calculates rough standard deviation of weighted brightnesses
  */
  public double brightnessScore(){

    double tImpact = 0;
    double sum = 0;
    for(Color c: colors){
      double added = c.getImpact() * c.getSaturationImpact() * FashionMap.BRIGHTNESS_COLOR_MULTIPLIER;
      tImpact += added;
      sum += added * c.getBrightness();
    }
    double mean = sum / tImpact;
    double sum2 = 0;

    for(Color c: colors){
      double imp = c.getImpact() * c.getSaturationImpact() * FashionMap.BRIGHTNESS_COLOR_MULTIPLIER;
      sum2 += Math.pow((c.getBrightness() - mean) * imp, 2);
    }

    return Math.sqrt(sum2 / tImpact) * FashionMap.BRIGHTNESS_SCORE_CONSTANT;
  }



}
