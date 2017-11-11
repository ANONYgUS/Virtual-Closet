

// public class Pile<T>{
//
//   private ArrayList<T> list;
//
//   public Pile<T>(T t){
//     list = new ArrayList<T>();
//     list.add(t);
//   }
//
//   public Pile<T>(T t1, T t2){
//     list = new ArrayList<T>();
//     list.add(t1);
//     list.add(t2);
//   }
//
//   public Pile<T>(T t1, T t2, T t3){
//     list = new ArrayList<T>();
//     list.add(t1);
//     list.add(t2);
//     list.add(t3);
//   }
//
//   public ArrayList<T> getList(){
//     return list;
//   }
// }

import java.util.*;

public class Pile{

  private ArrayList<Object> list;

  public Pile(Object o){
    list = new ArrayList<Object>();
    list.add(o);
  }

  public Pile(Object t1, Object t2){
    list = new ArrayList<Object>();
    list.add(t1);
    list.add(t2);
  }

  public Pile(Object t1, Object t2, Object t3){
    list = new ArrayList<Object>();
    list.add(t1);
    list.add(t2);
    list.add(t3);
  }

  public ArrayList<Object> getList(){
    return list;
  }
}
