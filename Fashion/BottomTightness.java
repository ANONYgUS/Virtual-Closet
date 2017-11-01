// stores the tightness of a bottom
// for example skinny jeans, vs loose jeans

public class BottomTightness implements FormalDriven{

  private String name;
  private Formality formality;
  private BottomTightnessType bottomTightnessType;
  /**
  * constructor for BottomTightness objects
  */
  public BottomTightness(){

  }

  /**
  * returns the formality of the bottom tightness
  * @return formality
  */
  public Formality getFormality(){
    return formality;
  }

  /**
  * returns the type of bottom tightness
  * @return bottom tightness type
  */
  public BottomTightnessType getBottomTightnessType(){
    return bottomTightnessType;
  }

  /**
  * returns the name of the sleeve
  * @return name
  */
  public String getname(){
    return name;
  }
}
