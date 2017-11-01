// stores every raw comparison value in a HashMap

public class CompareMap{

  private HashMap<String, double> map;

  /**
  * constructor for CompareMap
  * adds all predetermined comparisons
  */
  public CompareMap(){
    map = new HashMap<String, Comparison>();


  }

  /**
  * returns the comparison between two factors of clothing
  * @param s1 name of first factor of clothing
  * @param s2 name of second factor of clothing
  */
  public double getComparison(String s1, String s2){

    return map.get(s1+s2);
  }
}