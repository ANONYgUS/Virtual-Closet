// stores the front connection of the top

public enum FrontConnection implements FormalDriven{

  ZIPPER(new Formality(0,7,0.2), new Pile<FrontConnectionMode>(FrontConnectionMode.ZIPPED, FrontConnectionMode.UNZIPPED)),

  private ArrayList<FrontConnectionMode> modes;
  private FrontConnectionMode frontConnectionMode;
  private Formality formality;

  FrontConnection(Formality f, Pile<FrontConnectionMode> pile){
    formality = f;
    modes = pile.getList();
  }

  public void setMode(FrontConnectionMode mode){
    frontConnectionMode = mode;
  }

  public ArrayList<FrontConnection> getModes(){
    return modes;
  }
}
