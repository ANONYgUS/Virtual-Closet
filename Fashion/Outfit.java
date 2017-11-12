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
  private double waistScore;

  private Tracker sleeveTracker;
  private double sleeveScore;

  private Tracker frontConnectionTracker;
  private double frontConnectionScore;

  private Tracker bottomShoeTracker;
  private double bottomShoeScore;

  /**
  * constructor for Outfit
  */
  public Outfit(TopStack ts, Bottom b, Shoe s){
    topStack = ts;
    bottom = b;
    shoe = s;

    score = FashionMap.DEFAULT_OUTFIT_SCORE;
    formality = FashionMap.NULL_FORMALITY;
    formalityScore = FashionMap.DEFAULT_OUTFIT_SCORE;;
    colorScore = FashionMap.DEFAULT_OUTFIT_SCORE;
    designScore = FashionMap.DEFAULT_OUTFIT_SCORE;
    collarScore = FashionMap.DEFAULT_OUTFIT_SCORE;
    waistScore = FashionMap.DEFAULT_OUTFIT_SCORE;
    sleeveScore = FashionMap.DEFAULT_OUTFIT_SCORE;
    frontConnectionScore = FashionMap.DEFAULT_OUTFIT_SCORE;
    bottomShoeScore = FashionMap.DEFAULT_OUTFIT_SCORE;

    formalityTracker = new FormalityTracker();
  }

  public int compareTo(Outfit o){
    double oScore = o.getScore();

    if(score>oScore) return 1;
    else if(score<oScore) return -1;
    else return 0;
  }

  public void calculateScores(){
    compareFrontConnections();
    compareCollars();
    compareSleeves();
    compareDesigns();
    compareTopWaists();
    compareBottomShoe();
    doColors();
    doFormalities();

    frontConnectionScore = frontConnectionTracker.getScore();
    collarScore = collarTracker.getScore();
    sleeveScore = sleeveTracker.getScore();
    designScore = designTracker.getScore();
    waistScore = waistTracker.getScore();
    bottomShoeScore = bottomShoeTracker.getScore();
    colorScore = colorTracker.getScore();

    formalityScore = formalityTracker.getScore();
    formality = formalityTracker.getFormality(); //object or double?

    score = collarScore * FashionMap.COLLAR_SCORE_WEIGHT+
            sleeveScore * FashionMap.SLEEVE_SCORE_WEIGHT+
            designScore * FashionMap.DESIGN_SCORE_WEIGHT+
            waistScore * FashionMap.WAIST_SCORE_WEIGHT+
            bottomShoeScore * FashionMap.BOTTOM_SHOE_SCORE_WEIGHT+
            colorScore * FashionMap.COLOR_SCORE_WEIGHT+
            formalityScore * FashionMap.FORMALITY_SCORE_WEIGHT+
            FashionMap.SCORE_CONSTANT;
  }

  public void compareFrontConnections(){
    int size = topStack.size();
    for(int i = 0; i<size-1; i++){
      for (int j = topStack.size() - 1; j>i; j--){
        FrontConnection f1 = topStack.getTop(j).getFrontConnection();

        FrontConnection f2 = topStack.getTop(j-1-i).getFrontConnection();
        Comparison c = FashionMap.compareFrontConnections(f1, f2);
        f1.setImpact(c.getUpperImpact());
        f2.setImpact(c.getLowerImpact());

        frontConnectionTracker.add(c);

      }
    }
  }

  public void compareCollars(){
    int size = topStack.size();
    for(int i = 0; i<size-1; i++){
      for (int j = topStack.size() - 1; j>i; j--){
        Collar c1 = topStack.get(j).getCollar();
        Collar c2 = topStack.get(j-1-i).getCollar();
        Comparison c = CompareMap.compareCollars(c1, c2);
        c1.setImpact(c.getUpperImpact());
        c2.setImpact(c.getLowerImpact());
        ImpactTracker.add(c);
      }
    }
  }

  public void compareSleeves(){
    int size = topStack.size();
    for(int i = 0; i<size-1; i++){
      for (int j = topStack.size() - 1; j>i; j--){
        Sleeve s1 = topStack.get(j).getSleeve();
        Sleeve s2 = topStack.get(j-1-i).getSleeve();
        Comparison c = CompareMap.compareSleeves(c1, c2);
        s1.setImpact(c.getUpperImpact());
        s2.setImpact(c.getLowerImpact());
        SleeveTracker.add(c);
      }
    }
  }

  public void compareTopWaists(){
    int size = topStack.size();
    for(int i = 0; i<size-1; i++){
      for (int j = topStack.size() - 1; j>i; j--){
        TopWaist t1 = topStack.get(j).getTopWaist();
        TopWaist t2 = topStack.get(j-1-i).getTopWaist();
        Comparison c = CompareMap.compareTopWaists(t1, t2);
        t1.setImpact(c.getUpperImpact());
        t2.setImpact(c.getLowerImpact());
        TopWaistTracker.add(c);
      }
    }
  }

  public void compareDesigns(){
    int size = topStack.size();
    for(int i = 0; i<size-1; i++){
      for (int j = topStack.size() - 1; j>i; j--){
        Design d1 = topStack.get(j).getDesign();
        Design d2 = topStack.get(j-1-i).getDesign();
        Comparison c = CompareMap.compareDesigns(d1, d2);
        d1.setImpact(c.getUpperImpact());
        d2.setImpact(c.getLowerImpact());
        DesignTracker.add(c);
      }
    }
  }

  public void compareBottomShoe(){

  }

  public void doTemperatures(){

  }

  public void doColors(){

  }

  public void doFormalities(){

    for(Top top: topStack){
      formalityTracker.addFormality(top.getMaterial.getFormality());
      // etc
    }

    formalityTracker.addFormality(bottom.getMaterial.getFormality());
    //etc
  }

  public double getScore(){
    return score;
  }
  // trackers need gets
}
