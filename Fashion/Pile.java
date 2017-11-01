

public class Pile<T>{

  private ArrayList<T> list;

  public Pile<T>(T t){
    list = new ArrayList<T>();
    list.add(t);
  }

  public Pile<T>(T t1, T t2){
    list = new ArrayList<T>();
    list.add(t1);
    list.add(t2);
  }

  public Pile<T>(T t1, T t2, T t3){
    list = new ArrayList<T>();
    list.add(t1);
    list.add(t2);
    list.add(t3);
  }

  public ArrayList<T> getList(){
    return list;
  }
}
