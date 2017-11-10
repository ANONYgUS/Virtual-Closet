//stores the material of a piece

public class Material implements FormalDriven{

  private String name;
  private Formality formality;
  private MaterialType materialType;
  private Temperature temperature;
  /**
  * constructor for sleeve objects
  */
  public Material(MaterialType mT){

  }

  /**
  * returns the formality of the material
  * @return formality
  */
  public Formality getFormality(){
    return formality;
  }

  /**
  * returns the type of material
  * @return material type
  */
  public MaterialType getMaterialType(){
    return materialType; // was sleeveType
  }

  /**
  * returns the name of the materail
  * @return name
  */
  public String getname(){
    return name;
  }

  /**
  * returns the temperature of the material
  * @return temperature
  */
  public Temperature getTemperature(){
    return temperature;
  }
}
