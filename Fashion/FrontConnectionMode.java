

public enum FrontConnectionMode{

<<<<<<< HEAD
  UNZIPPED(5, new Formality(0,7,0.3)),
  ZIPPED()
=======
  UNZIPPED(5, new Formality(0,7,0.3));
>>>>>>> 8692c4d3f71744f351af49fe46d379a2d23869fd

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
