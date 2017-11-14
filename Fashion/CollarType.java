// stores all types of collars

public enum CollarType{

// all types of collars
  T_CREWNECK(new Formality(0,7,0.25)),
  POLO(new Formality(4,7,.35));


  private Formality formality;

  /**
  * constructor for collar enum types
  */
  CollarType(Formality f){
    formality = f;
  }


  /**
  * returns the formality of the collar
  * @return formality
  */
  public Formality getFormality(){
    return formality;
  }
}
