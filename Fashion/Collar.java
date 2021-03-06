//stores the collar a top has

import java.util.*;

public class Collar {

  private CollarType collarType;
  private String name;
  private Color color;
  private Formality formality;
  private double impact;

  public Collar(CollarType cT){
    collarType = cT;
    name = cT.toString();
    formality = cT.getFormality();
    impact = 1;
  }

  /**
  * returns the type of collarType
  * @return collar type
  */
  public CollarType getCollarType(){
    return collarType;
  }

  public void setImpact(double d){
    impact *= d;
    color.multiplyImpact(d);
    formality.multiplyImpact(d);
  }

  /**
  * returns the formality of the collar
  * @return formality
  */
  public Formality getFormality(){
    return formality;
  }

  /**
  * returns the name of the collar
  * @return name
  */
  public String getname(){
    return name;
  }



  /**
  * set the color of the Collar to a specific color
  * @param c color to set the collar to
  */
  public void setColor(Color c){
    color = c;
  }


  /**
  * returns the colors of the collar, which is always just going to be 1 color
  * @return color
  */
  public ArrayList<Color> getColors(){
    ArrayList<Color> a = new ArrayList<Color>();
    a.add(color);
    return a;
  }

}
