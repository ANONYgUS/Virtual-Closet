* scores how well a factor of clothing works throughout an outfit by tracking various comparisons of that factor

public class Tracker{

  private ArrayList<Comparison> comparisons;
  private double impact; // gets multiplied by relevant impact factors of comparisons

  /**
  *constructor for Tracker
  */
  public DesignTracker(){
    comparisons = new Arraylist<Comparison>();
    impact = 1;
  }

  /**
  * adds a comparison to the tracker
  * @param c Comparison to addComparison
  */
  public void addComparison(Comparison c){
    comparisons.add(c);
  }

  public void setImpact(double d){
    impact = d;
  }

  /**
  * returns a double representing how well a given factor of the outfit go together
  * @return score
  */
  public double getScore(){

    double sum = 0;
    double sumImpact = 0;
    for(Comparison c: comparisons){
      double impact = c.getImpact();
      sumImpact += impact;
      sum += c.getScore() * impact;
    }

      return sum / sumImpact;

  }
}
