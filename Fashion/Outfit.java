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

  private double temperatureScore;
  private Temperature temperature;
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
    setTemperature();

    frontConnectionScore = frontConnectionTracker.getScore();
    collarScore = collarTracker.getScore();
    sleeveScore = sleeveTracker.getScore();
    designScore = designTracker.getScore();
    waistScore = waistTracker.getScore();
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
            temperatureScore * FashionMap.TEMPERATURE_SCORE_WEIGHT+
            FashionMap.SCORE_CONSTANT;
  }

  public void compareFrontConnections(){
    int size = topStack.size();
    for(int i = 0; i<size-1; i++){
      for (int j = topStack.size() - 1; j>i; j--){
        FrontConnection f1 = topStack.getTop(j).getFrontConnection();

        FrontConnection f2 = topStack.getTop(j-1-i).getFrontConnection();
        Comparison c = FashionMap.compareFrontConnections(f1, f2);
        f2.addImpact(c.getLowerImpact());

        frontConnectionTracker.add(c);

      }
    }
    for(int k = 1; k<size-1; k++){
      topStack.getTop(k).getFrontConnection().setImpact();
    }
  }

  public void compareTemperatures(){
    if(topStack.isComplete()){
      temperatureScore = temperature.getScore(temp);
    }
    else{
      temperatureScore = temperature.getScore(temp + FashionMap.BOTTOM_LAYER_THICKNESS_ADDITION
                       * (topStack.getBottomLayer.getLooseness() - FashionMap.BOTTOM_LAYER_LOOSENESS));
    }
  }

  public void compareCollars(){
    int size = topStack.size();
    for(int i = 0; i<size-1; i++){
      for (int j = topStack.size() - 1; j>i; j--){
        Collar c1 = topStack.getTop(j).getCollar();
        Collar c2 = topStack.getTop(j-1-i).getCollar();
        Comparison c = CompareMap.compareCollars(c1, c2);
        c2.setImpact(c.getLowerImpact());
        CollarTracker.add(c);
      }
    }
  }

  public void compareSleeves(){
    int size = topStack.size();
    for(int i = 0; i<size-1; i++){
      for (int j = topStack.size() - 1; j>i; j--){
        Sleeve s1 = topStack.getTop(j).getSleeve();
        Sleeve s2 = topStack.getTop(j-1-i).getSleeve();
        Comparison c = CompareMap.compareSleeves(s1, s2);
        s2.setImpact(c.getLowerImpact());
        SleeveTracker.add(c);
      }
    }
  }

  public void compareTopWaists(){
    int size = topStack.size();
    for(int i = 0; i<size-1; i++){
      for (int j = topStack.size() - 1; j>i; j--){
        TopWaist t1 = topStack.getTop(j).getTopWaist();
        TopWaist t2 = topStack.getTop(j-1-i).getTopWaist();
        Comparison c = CompareMap.compareTopWaists(t1, t2);
        TopWaistTracker.add(c);
      }
    }
  }

  public void compareDesigns(){
    int size = topStack.size();
    for(int i = 0; i<size-1; i++){
      for (int j = topStack.size() - 1; j>i; j--){
        Design d1 = topStack.getTop(j).getDesign();
        Design d2 = topStack.getTop(j-1-i).getDesign();
        Comparison c = CompareMap.compareDesigns(d1, d2);
        d2.setImpact(c.getLowerImpact());
        DesignTracker.add(c);
      }
    }
  }



<<<<<<< HEAD

=======
  public void setTemperature(){
    int tempSum = 0;
    double magSum = 0;
    double impSum = 0;
    for(Top top: tops){
      top.setTemperature();
      tempSum += top.getTemperature().getApprox();
      magSum += top.getTemperature().getMagnitude();
      impSum += top.getTemperature().getImpact();
    }
    temperature = new Temperature(tempSum, magSum/topStack.size(), impSum/topStack.size());
  }


  public void doColors(){

    for(Top top: topStack.getTops()){
      colorTracker.addColor(top.getDesign().getMainColor());
      colorTracker.addColor(top.getCollar().getColor());
      colorTracker.addColor(top.getSleeve().getColor());
      for(Color c: top.getDesign.getOtherColors()){
        colorTracker.addColor(c);
      }

    }

  }

  public void doFormalities(){

    for(Top top: topStack.getTops()){
      formalityTracker.addFormality(top.getMaterial().getFormality());
      // etc
    }

    formalityTracker.addFormality(bottom.getMaterial().getFormality());
    //etc
  }

  public double getScore(temp){

    calculateScores();
    return score;

  }
  // trackers need gets
}
