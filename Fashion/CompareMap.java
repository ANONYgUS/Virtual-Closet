// stores every raw comparison value in a HashMap
import java.util.*;

public class CompareMap{

  private HashMap<String, Double> map;

  /**
  * constructor for CompareMap
  * adds all predetermined comparisons
  */
  public CompareMap(){
    map = new HashMap<String, Double>(); //used to be String, Comparison


  }

  /**
  * returns the comparison between two factors of clothing
  * @param s1 name of first factor of clothing
  * @param s2 name of second factor of clothing
  */
  public double getComparison(String s1, String s2){

    return map.get(s1+s2);
  }

  public static Comparison compareCollars(Collar a, Collar b){
    return new Comparison(); //temp value
  }

  public static Comparison compareSleeves(Sleeve a, Sleeve b){
    return new Comparison(); //temp value
  }

  public static Comparison compareTopWaists(TopWaist a, TopWaist b){
    return new Comparison(); //temp value
  }

  public static Comparison compareDesigns(Design a, Design b){
    return new Comparison(); //temp value
  }

}
