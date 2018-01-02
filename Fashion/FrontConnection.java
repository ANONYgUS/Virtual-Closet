// stores the front connection of the top

import java.util.*;

public enum FrontConnection{

  ZIPPER(new Formality(0,7,0.2), new Pile(FrontConnectionMode.ZIPPED, FrontConnectionMode.UNZIPPED));

  private ArrayList<Object> modes; //used to be FrontConnectionMode
  private FrontConnectionMode frontConnectionMode;
  private Formality formality;
  private double impact;
  private ArrayList<Double> impacts;

  FrontConnection(Formality f, Pile pile){
    formality = f;
    modes = pile.getList();
    impacts = new ArrayList<Double>();
  }

  public void setMode(FrontConnectionMode mode){
    frontConnectionMode = mode;
  }

  public void addImpact(double d){
    impacts.add(d);
  }
  public void setImpact(){
    impact = Collections.min(impacts);
  }

  public ArrayList<Object> getModes(){ //used to be FrontConnectionMode
    return modes;
  }
  public FrontConnectionMode getMode(){
    return frontConnectionMode;
  }
  public Formality getFormality(){
    return formality;
  }
}
