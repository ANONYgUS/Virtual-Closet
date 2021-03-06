import java.util.*;
/**
 * represents a shoe
 */
public class Shoe extends Piece
{
    private ShoeType shoeType;
    private ArrayList<Color> colors;
    //private Color soleColor;

    /**
     * Constructor for objects of class Shoe
     */
    public Shoe()
    {
       colors = new ArrayList<Color>();
    }

    /**
     * returns the colors of the shoe
     * @return colors
     */
    public ArrayList<Color> getColors(){
        return colors;
    }

    /**
     * returns the sole color of the shoe
     * @return sole color
     */
    public Color getSoleColor(){
        return soleColor;
    }

    /**
     * returns the formality of the shoe
     * @return formality
     */
    public Formality getFormality(){
        return formality;
    }

    /**
     * returns the height of the shoe
     * @return height
     */
    public int getHeight(){
        return height;
    }

    /**
    * returns true, because shoes are shoes
    *@return true
    */
    public boolean isShoe(){
    	return true;
    }

}
