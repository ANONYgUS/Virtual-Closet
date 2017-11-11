// stores any added on qualities to a piece, such as being distressed, or having zippered pockets

public class AddOn implements FormalDriven{

  private String name;
  private Formality formality;
  private AddOnType addOnType;

  /**
  * constructor for AddOn objects
  */
  public AddOn(){

  }

  /**
  * returns the formality of the AddOn
  * @return formality
  */
  public Formality getFormality(){
    return formality;
  }

  /**
  * returns the type of AddOn
  * @return AddOn type
  */
  public AddOnType getAddOnType(){
    return addOnType;
  }

  /**
  * returns the name of the AddOn
  * @return name
  */
  public String getname(){
    return name;
  }
}
