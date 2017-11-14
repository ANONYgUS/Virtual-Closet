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

    /**
     * all possible outfits given temperature and formality
     * @param temp temperature
     * @param f formality
     */
    public ArrayList<Outfit> getOutfits(int temp, Formality f){

      ArrayList<Outfit> returned = new ArrayList<Outfit>();
      ArrayList<TopStack> topStacks = getTopStacks();

      for (TopStack stack: topStacks){
        for (Bottom b: bottoms){
          for (Shoe s: shoes){
            returned.add(new Outfit(stack, b, s));
          }
        }
      }
      return returned;
    }

    public ArrayList<TopStack> getTopStacks(){

      ArrayList<TopStack> returned = new ArrayList<TopStack>();

      // first, each top that could be worn alone needs to be added
      for(Top top: tops){
        if (top.getLooseness() <= FashionMap.MAX_LOOSENESS_DIFF){
            Top clone = top.clone();
          for(Object mode: top.getFrontConnection().getModes()){
            mode = (FrontConnectionMode)(mode);
            clone.setFrontConnectionMode(mode);
            TopStack stack = new TopStack();
            stack.add(clone);
            returned.add(stack);
          }
        }
      }

// then, for each top that could be worn alone, all combinations of tops that could be thrown on top are added
      for(int i = 0; i<returned.size(); i++){
        TopStack stack = returned.get(i);
        for(Top t: tops){
          if(t.getLooseness() >= stack.getThickness() // makes sure a top would fit on top of the stack
          && t.getLooseness() - stack.getThickness() >= FashionMap.MAX_LOOSENESS_DIFF) // makes sure it's not too loose
          {
            Top tClone = t.clone();
            for(Object mode: t.getFrontConnection().getModes()){
              mode = (FrontConnectionMode)(mode);
              tClone.setFrontConnectionMode(mode);
              TopStack sClone = stack.clone();
              sClone.add(tClone);
              returned.add(sClone);
            }
          }
        }
      }

      return returned;
    }

    /**
     * picks some of the best outfits given possible outfits
     * @param list list of possible outfits
     * @return list of best outfits
     */
    public ArrayList<Outfit> bestOutfits(ArrayList<Outfit> list){
      TreeSet<Outfit> tree = new TreeSet<Outfit>();
      ArrayList<Outfit> returned = new ArrayList<Outfit>();

      for(Outfit o: list){
        tree.add(o);
      }

      for(int i=0; i<FashionMap.BEST_OUTFITS_SIZE; i++){
        returned.add(tree.pollLast());
      }
      return returned;
    }

    public Shoe pickShoe(){
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

    public Bottom pickBottom(Shoe shoe){

      ArrayList<Bottom> candidates = new ArrayList<Bottom>();
      ArrayList<double> scores = new ArrayList<double>();

      for(Bottom bottom: bottoms){
        double cScore = CompareMap.compareBottomShoe(bottom, shoe);
        double tScore = bottom.getTemperature.getScore(temp);

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

    public Outfit pickTopStack(Shoe shoe, Bottom bottom){
      TopStack returned = new TopStack();

      for(int i=0; i<4; i++){
        ArrayList<Outfit> candidates = new ArrayList<Outfit>();
        ArrayList<Outfit> all = new ArrayList<Outfit>();

        for(Top top: tops){
          TopStack clone = returned.clone();

          if(i==0 || top.getThickness() < returned.getBottomLayer().getLooseness()) {
            clone.addLower(top);
            Outfit outfit = new Outfit(clone, bottom, shoe);
            if(outfit.getScore() > FashionMap.OUTFIT_CUTOFF_SCORE){
              candidates.add(outfit);
            }
            all.add(outfit);
          }
        }
        if(candidates.isEmpty()){
          Outfit best = FashionMap.NULL_OUTFIT;
          for(Outfit candidate: candidates){
            if(candidate.getScore() > best.getScore()){
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
          Outfit random = candidates.get(Math.random() * size);
          TopStack randomStack = random.getTopStack();
          if(randomStack.isComplete()){
            return random;
          }
          returned.addLower(randomStack.getBottomLayer());
        }
      }

    }


}
