import java.util.*;

public class Bottom extends Piece implements FormalDriven, DesignDriven, TightnessDriven, ColorDriven {

	private Material material;
	private Design design;
	private Tightness tightness;
	private int length;
	private Texture texture;
	private Material lining;
	private ArrayList<Color> colors;

	//inherited from the Piece super class
	//private Temperature temperature;
	//private Formality formality;


	/**
	* Contructor for objects of class Bottom
	*/
	public Bottom(Material m, Design d, Tightness ti, int l, Texture t, Temperature temp, Formality f, ArrayList<Color> c){
		material = m;
		design = d;
		tightness = ti;
		length = l;
		texture = t;
		temperature = temp;
		formality = f;
		colors = c;
	}

	public Comparison compareDesign(){ //must override method from DesignDriven

	}

	


	/**
	* gets the Material of the Bottom
	*/
	public Material getMaterial(){
		return material;
	}

	/**
	* gets the Formality of the Bottom
	*/
	public Formality getFormality(){
		return formality;
	}

	/**
	* gets the Temperature of the Bottom
	*/
	public Temperature getTemperature(){
		return temperature;
	}

	/**
	* gets the design of the Bottom
	*/
	public Design getDesign(){
		return design;
	}

	/**
	* gets the Lining of the bottom
	* @return lining
	*/
	public Material getLining(){
		return lining;
	}


	/**
	* gets the Tightness of the Bottom
	*/
	public Tightness getTightness(){
		return tightness;
	}

	/**
	* gets the Length of the Bottom
	*/
	public int getLength(){
		return length;
	}

	/**
	* gets the Texture of the Bottom
	*/
	public Texture getTexture(){
		return texture;
	}

	/**
	* gets the colors of the Bottom
	*/
	public ArrayList<Color> getColors(){
		return colors;
	}

	/**
	* returns true, because bottoms are bottoms
	*@return true
	*/
	public boolean isBottom(){
		return true;
	}
}
