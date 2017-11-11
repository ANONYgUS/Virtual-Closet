//stores the names of colors and their hsbs

public enum ColorName{


  ; //semicolon before private instance variables
  private Formality formality;
  private Hue hue;
  private int saturation;
  private int brightness;

  ColorName(Formality f, Hue h, int s, int b){
    formality = f;
    hue = h;
    saturation = s;
    brightness = b;
  }

  public Hue getHue(){
    return hue;
  }

  public int getSaturation(){
    return saturation;
  }

  public int getBrightness(){
    return brightness;
  }

  public Formality getFormality(){
    return formality;
  }

}
