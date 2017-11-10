//stores the types of designs

public enum DesignType{

  ; //enum require a semicolon before declaring private instance variables
  private Formality formality;
  private double mainColorImpact;
  private double otherColorImpact;

  DesignType(Formality f, double mCI, double oCI){
    formality = f;
    mCI = mainColorImpact;
    oCI = otherColorImpact;
  }

  /**
  * returns the formality of the design being stored
  * @return formality of design
  */
  public Formality getFormality(){
    return formality;
  }

  /**
  * returns the main color impact of the design being stored
  * @return main color impact
  */
  public double getMainColorImpact(){
    return mainColorImpact;
  }

  /**
  * returns the other color impact of the design being stored
  * @return other color impact
  */
  public double getOtherColorImpact(){
    return otherColorImpact;
  }
}
