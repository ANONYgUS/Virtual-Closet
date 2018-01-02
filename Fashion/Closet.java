import java.util.*;
/**
 * Stores all pieces and generates outfits
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Closet
{

    private ArrayList<Top> tops;
    private ArrayList<Bottom> bottoms;
    private ArrayList<Shoe> shoes;

    /**
     * Constructor for objects of class Closet
     */
    public Closet()
    {
        // initialise instance variables
        tops = new ArrayList<Top>();
        bottoms = new ArrayList<Bottom>();
        shoes = new ArrayList<Shoe>();
    }

    /**
     * add a top to the closet
     * @param t top to be added
     */
    public void addPiece(Top t)
    {

    }

    /**
     * add a shoe to the closet
     * @param s shoe to be added
     */
    public void addPiece(Shoe s){

    }

    /**
     * add a bottom to the closet
     * @param b bottom to be added
     */
    public void addPiece(Bottom b)
    {

    }

    /**
     * marks necessary pieces of outfit as dirty
     */
    public void wear(Outfit o){
    }

    /**
     * marks specific piece as dirty
     * @param p piece thats dirty
     */
    public void use(Piece p){
    }

    /**
     * makes dirty clothes clean
     */
    public void wash(){
    }






    public Shoe pickShoe(int temp){
      ArrayList<Shoe> bestShoes = new ArrayList<shoe>();
      ArrayList<double> scores = new ArrayList<double>();
      double sum = 0;
      ArrayList<double> weightedValues = new ArrayList<double>();

      for(Shoe shoe: shoes){
        double score = shoe.getTemperature.getScore(temp);
        scores.add(score);
        if(score > FahsionMap.TEMPERATURE_SCORE_CUTOFF){
          bestShoes.add(shoe,score);
          sum += score;
        }
      }

      if(bestShoes.isEmpty()){
        return shoes.get(scores.indexOf(Collections.max(scores)));
      }
      else{


        for(Shoe shoe: bestShoes){
          weightedValues.add(shoe.getTemperatue.getScore(temp) * Math.random());
        }
        return bestShoes.get(weightedValues.indexOf(Collections.max(weightedValues)));
      }
    }

    public Shoe pickShoe(Bottom bottom, int temp){
      ArrayList<Shoe> candidates = new ArrayList<Shoe>();
      ArrayList<double> scores = new ArrayList<double>();

      for(Shoe shoe: shoes){
        double cScore = CompareMap.compareBottomShoe(bottom, shoe);
        double tScore = shoe.getTemperature.getScore(temp);
        scores.add(cScore*FashionMap.C_SCORE_WEIGHT +
                   tScore*FashionMap.T_SCORE_WEIGHT);

        if(cScore > FashionMap.BOTTOM_SHOE_SCORE_CUTOFF &&
           tScore > FashionMap.TEMPERATURE_SCORE_CUTOFF){
             candidates.add(shoe);
           }
      }

      if(candidates.isEmpty()){
        return shoes.get(scores.indexOf(Collections.max(scores)));
      }
      else{
        int size = candidates.size();
        return candidates.get(Math.random() * size);
      }
    }

    public Bottom pickBottom(Shoe shoe, int temp){

      ArrayList<Bottom> candidates = new ArrayList<Bottom>();
      ArrayList<double> scores = new ArrayList<double>();

      for(Bottom bottom: bottoms){
        double cScore = CompareMap.compareBottomShoe(bottom, shoe);
        double tScore = bottom.getTemperature.getScore(temp);
        scores.add(cScore*FashionMap.C_SCORE_WEIGHT +
                   tScore*FashionMap.T_SCORE_WEIGHT);

        if(cScore > FashionMap.BOTTOM_SHOE_SCORE_CUTOFF &&
           tScore > FashionMap.TEMPERATURE_SCORE_CUTOFF){
             candidates.add(bottom);
           }
      }

      if(candidates.isEmpty()){
        return bottoms.get(scores.indexOf(Collections.max(scores)));
      }
      else{
        int size = candidates.size();
        return candidates.get(Math.random() * size);
      }


    }

    public Outfit pickTopStack(Shoe shoe, Bottom bottom, int temp){
      TopStack returned = new TopStack();

      for(int i=0; i<FashionMap.MAX_LAYERS; i++){
        ArrayList<Outfit> candidates = new ArrayList<Outfit>();
        ArrayList<Outfit> all = new ArrayList<Outfit>();

        for(Top top: tops){
          TopStack clone = returned.clone();

          if(i==0 || top.getThickness() < returned.getBottomLayer().getLooseness()) {
            clone.addLower(top);
            Outfit outfit = new Outfit(clone, bottom, shoe);
            if(outfit.getScore(temp) > FashionMap.OUTFIT_CUTOFF_SCORE){
              candidates.add(outfit);
            }
            all.add(outfit);
          }
        }
        if(candidates.isEmpty()){
          Outfit best = FashionMap.NULL_OUTFIT;
          for(Outfit candidate: candidates){
            if(candidate.getScore(temp) > best.getScore(temp)){
              best = candidate;
            }
          }
          TopStack bestStack = best.getTopStack();
          if(bestStack.isComplete()){
            return best;
          }
          returned.addLower(bestStack.getBottomLayer());
        }
        else{
          int size = candidates.size();
          Outfit random = candidates.get((int)(Math.random() * size));
          TopStack randomStack = random.getTopStack();
          if(randomStack.isComplete()){
            return random;
          }
          returned.addLower(randomStack.getBottomLayer());
        }
      }

    }

    public Outfit pickOutfit(int temp){
      Shoe shoe = pickShoe(temp);
      return pickTopStack(shoe, pickBottom(shoe, temp), temp);
    }

    public Outfit pickOutfit(int temp, Shoe shoe){
      return pickTopStack(shoe, pickBottom(shoe, temp), temp);
    }

    public Outfit pickOutfit(int temp, Bottom bottom){
      return pickTopStack(pickShoe(bottom, temp), bottom, temp);

    }


}
