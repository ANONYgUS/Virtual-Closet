//stores the design of something

public class Design{

  private String name;
  private Formality formality;
  private DesignType designType;
  // considering designs involve colors, design is prompted first
  // then when main and other colors are prompted, these values determine the impact of those colors
  private Color mainColor;
  private ArrayList<Color> otherColors;

  /**
  * constructor for design objects
  */
  public Design(DesignType d, Color mC, ArrayList<Color> oC){
    name = d.toString();
    formality = d.getFormality();
    mainColor = mC;
    mainColor.setImpact(d.getMainColorImpact());
    otherColors = oC;
    for(Color c; oC){
      c.setImpact(d.getOtherColorImpact());
    }
  }

  /**
  * returns the type of design being stored
  * @return design type
  */
  public DesignType getDesignType(){
    return designType;
  }

  /**
  * returns the name of design being stored
  * @return design name
  */
  public String getName(){
    return name;
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
