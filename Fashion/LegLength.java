//stores the length of the leg of a bottom

public class LegLength extends WaistFactor{

  private Formality formality;
  private LegLengthType legLengthType;
  private Temperature temperature;
  /**
  * constructor for LegLength objects
  */
  public LegLength(LegLengthType lT){

  }


  /**
  * returns the formality of the LegLength
  * @return formality
  */
  public Formality getFormality(){
    return formality;
  }

  /**
  * returns the type of leg length
  * @return leg length type
  */
  public LegLengthType getLegLengthType(){
    return legLengthType;
  }


  /**
  * returns the temperature of the leg length
  * @return temperature
  */
  public Temperature getTemperature(){
    return temperature;
  }
}
