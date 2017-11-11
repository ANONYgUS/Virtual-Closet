

public enum FrontConnectionMode{


  UNZIPPED(5, new Formality(0,7,0.3)),
  ZIPPED(5, new Formality(0,7,0.3)); //temp values

  private int temperature;
  private Formality formality;

  FrontConnectionMode(int t, Formality f){
    temperature = t;
    formality = f;
  }

  public Formality getFormality(){
    return formality;
  }

  public int getTemperature(){
    return temperature;
  }
}
