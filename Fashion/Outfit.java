// stores an entire outfit

public class Outfit implements Comparable<Outfit>{

  private TopStack topStack;
  private Bottom bottom;
  private Shoe shoe;

  private double score;

  private Formality formality;
  private FormalityTracker formalityTracker;
  private double formalityScore;

  private ColorTracker colorTracker;
  private double colorScore;

  private Tracker designTracker;
  private double designScore;

  private Tracker collarTracker;
  private double collarScore;

  private Tracker waistTracker;
  private double WaistScore;

  private Tracker sleeveTracker;
  private double SleeveScore;

  private Tracker frontConnectionTracker;
  private double frontConnectionScore;

  private Tracker bottomShoeTracker;
  private double bottomShoeScore;

  /**
  * constructor for Outfit
  */
  public Outfit(){

  }

  public int compareTo(Outfit o){
    double oScore = o.getScore();

    if(score>oScore) return 1;
    else if(score<oScore) return -1;
    else return 0;
  }

  public double calculateScore(){

    Top t1;
    Top t2;

    // compare all the factors accross all types of comparisons
    int size = topStack.size();
    for(int i = size-1; i > 0; i--){ // for each combination of tops
      t1 = topStack.getTop(i);

      for(int j = i-1; j > -1; j--){
        t2 = topStack.getTop(j);
        Comparison designC = t1.compareDesigns(t2);
        adjustTrackerImpacts();
        designTracker.addComparison(designC);

        Comparison sleeveC = t1.compareSleeves(t2);
        adjustTrackerImpacts();
        sleeveTracker.addComparison(sleeveC);

        Comparison collarC = t1.compareCollars(t2);
        adjustTrackerImpacts();
        collarTracker.addComparison(collarC);

        Comparison waistC = t1.compareWaists(t2);
        adjustTrackerImpacts();
        waistTracker.addComparison(waistC);

        Comparison frontConnectionC = t1.compareFrontConnections(t2);
        adjustTrackerImpacts();
        frontConnectionTracker.addComparison(frontConnectionC);

        Comparison colorC = t1.compareDesigns(t2);
        adjustTrackerImpacts();
        designTracker.addComparison(designC);

        Comparison designC = t1.compareDesigns(t2);
        adjustTrackerImpacts();
        designTracker.addComparison(designC);
      }
    }
    doFormalities();



  }

  public void adjustTrackerImpacts(Comparison c){
    designTracker.setImpact(c.getDesignImpactFactor()); // repeat this for the other things
  }

  public void doFormalities(){

    for(Top top: topStack){
      formalityTracker.addFormality(top.getMaterial.getFormality());
      // etc
    }

    formalityTracker.addFormality(bottom.getMaterial.getFormality());
    //etc
  }
  // trackers need gets
}
