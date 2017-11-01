*stores the type of waist the top has

public class TopWaist extends WaistFactor implements FormalDriven{

  private WaistType waistType;
  private Formality formality;

  /**
  *constructor for TopWaist
  */
  public TopWaist(){

  }

  /**
  *returns the type of waist being stored
  *@return waist type
  */
  public WaistType getWaistType(){
    return waistType;
  }

  /**
  *returns the formality of waist being stored
  *@return formality
  */
  public Formality getFormality(){
    return formality;
  }

  public String factorName(){
    return "topwaist";
  }
}
