// stores all the types of shoes

public enum ShoeType implements FormalDriven{

  private String name;
  private Formality formality;
  private int height;
  private Temperature temperature;

  /**
  * constructor for shoe types
  */
  public ShoeType(){

  }


  /**
  * returns the formality of the shoe type
  * @return formality
  */
  public Formality getFormality(){
    return formality;
  }



  /**
  * returns the name of the type of shoe
  * @return name
  */
  public String getname(){
    return name;
  }

  /**
  * returns the temperature of the type of shoe
  * @return temperature
  */
  public Temperature getTemperature(){
    return temperature;
  }
}
