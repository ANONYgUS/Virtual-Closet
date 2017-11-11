

public enum FrontConnectionMode{

<<<<<<< HEAD
  UNZIPPED(5, new Formality(0,7,0.3)),
  ZIPPED()
=======
  UNZIPPED(5, new Formality(0,7,0.3));
>>>>>>> 1ac9b9be8206465f19c43c3c001653dab5bbd061

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
