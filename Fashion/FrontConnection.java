// stores the front connection of the top

import java.util.*;

public enum FrontConnection{

  ZIPPER(new Formality(0,7,0.2), new Pile(FrontConnectionMode.ZIPPED, FrontConnectionMode.UNZIPPED));

  private ArrayList<Object> modes; //used to be FrontConnectionMode
  private FrontConnectionMode frontConnectionMode;
  private Formality formality;

  FrontConnection(Formality f, Pile pile){
    formality = f;
    modes = pile.getList();
  }

  public void setMode(FrontConnectionMode mode){
    frontConnectionMode = mode;
  }

  public ArrayList<Object> getModes(){ //used to be FrontConnectionMode
    return modes;
  }

  public Formality getFormality(){
    return formality;
  }
}
