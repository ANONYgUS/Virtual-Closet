// scores how well all formalities go together throughout an outfit by tracking the formalities
// also calculates the exact formality of a whole outfit from 0-1

public class FormailityTracker{

  private ArrayList<Formality> formalities;

  /**
  *constructor for FormalityTracker
  */
  public FormalityTracker(){

  }

  /**
  * adds a formality to the tracker
  * @param f formality to add
  */
  public void addFormality(Formality f){
    formalities.add(c);
  }

  /**
  * returns a double representing how well all the formalities of the outfit go together
  * @return score from 0-1
  */
  public double getScore(){
    double score = 1;
    Formality fA;
    Formality fB;
    double aImp;
    double bImp;
    double aMin;
    double aMax;
    double bMin;
    double bMax;

    for(int i = 1; i < formalities.size(); i++){ // loops through every combo of 2 formalities
      for(int j = i-1; j > -1; j--){
        fA = formalities.get(i);
        fB = formalities.get(j);
        aImp = fA.getImpact();
        bImp = fB.getImpact();
        aMin = fA.getMin();
        aMax = fA.getMax();
        bMin = fB.getMin();
        bMax = fB.getMax();

        if(aMin > bMax){
          score *= (1 - aImp * bImp) * (aMin - bMax) * FashionMap.FORMALITY_SCORE_CONSTANT;
        }
        else if(bMin > aMax){
          score *= (1 - aImp * bImp) * (bMin - aMax) * FashionMap.FORMALITY_SCORE_CONSTANT;
        }
      }
    }
    return score;
  }

  /**
  * sorts formalities in order of impact, uses insertion sort
  */
  public void sort(){

    Formality temp;
    for(int i=1, i<formalities.size(); i++){
      for(int j=i; j>0; j--){
        if(formalities.get(j).getImpact() > formalities.get(j-1).getImpact()){
          temp = formalities.get(j);
          formalities.set(j, formalities.get(j-1));
          formalities.set(j-1, temp);
        }
      }
    }
  }

  /**
  * returns a double representing the formality of the entire outfit
  * @return formality from 0-1
  */
  public double getFormality(){
    double tImpact = 0;
    double sum = 0;

    for(Formality f: formalities){
      tImpact += f.getImpact();
      sum += f.getImpact() * (f.getMax() + f.getMin()) / 2
    }

    return sum / tImpact;

  }
}
