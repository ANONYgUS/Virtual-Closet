
/**
 * Base class for wardrobe items
 *
 */
public class Piece {

    public Formality formality;
    public Temperature temperature;


    /**
     * Constructor for objects of class Piece
     */
    public Piece()
    {

    }

    /**
     * returns the formality of the piece
     * @return formality
     */
    public Formality getFormality()
    {
        return formality;
    }

    /**
     * returns the temperature of the piece
     * @return temperature
     */
    public Temperature getTemperature()
    {
        return temperature;
    }

    /**
     * returns whether or not the piece is a top
     * @return true if it's a top and false otherwise
     */
    public boolean isTop()
    {
        return false;
    }


    /**
     * returns whether or not the piece is a bottom
     * @return true if it's a bottom and false otherwise
     */
    public boolean isBottom()
    {
        return false;
    }

    /**
      *returns whether or not the piece is a shoe
      *@return true if it's a shoe and false otherwise
    */
    public boolean isShoe()
    {
        return false;
    }
}
