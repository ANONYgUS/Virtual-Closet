
/**
 * describes factors of clothing where formality matters
 */

import java.util.*;

public interface ColorDriven
{
    /**
     * returns the color
     * @return color
     */
    ArrayList<Color> getColors();

    /**
     * returns comparison to another color driven factor
     * @param c other color driven factor
     * @return color comparison
     */
    Comparison compareColor(ColorDriven c);
}
