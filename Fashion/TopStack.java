// stores a stack of tops and makes up a component of an outfit

import java.util.*;

public class TopStack{

  private ArrayList<Top> topList;
  private int thickness;

/**
* constructor for TopStack
*/
  public TopStack(){
    topList = new ArrayList<Top>();
    thickness = 0;
  }

  /**
  * adds a top to the TopStack
  * @param t Top to add
  */
  public void addUpper(Top t){
    topList.add(t);
    thickness += t.getThickness();
  }

  public void addLower(Top t){
    topList.add(0, t);
  }

  /**
  * returns a clone of the topStack objects
  * @return clone of TopStack
  */
  public TopStack clone(){
    TopStack returned = new TopStack();
    for(Top t: topList){
      returned.add(t);
    }
    return returned;
  }

  public Top getTop(int i){
    return topList.get(i);
  }

  public ArrayList<Top> getTops(){
    return topList;
  }

  public int size(){
    return topList.size();
  }

  public int getThickness(){
      return thickness;
  }

  public Top getBottomLayer(){
    return topList.get(0);
  }

  public boolean isComplete(){
    return getBottomLayer.getLooseness() == fashionMap.BOTTOM_LAYER_LOOSENESS;
  }
}
