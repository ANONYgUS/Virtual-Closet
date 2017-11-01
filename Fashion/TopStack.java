// stores a stack of tops and makes up a component of an outfit

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
  public void add(Top t){
    topList.add(Top t);
    thickness += t.getThickness();
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

  public int size(){
    return topList.size();
  }
}
