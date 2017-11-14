public class Top implements FormalDriven, DesignDriven, CollarDriven, SleeveDriven, ColorDriven {

	private Material material;
	private int layer;
	private int thickness;
	private int looseness;
	private Collar collar;
	private SleeveLength sleevelength;
	private Texture texture;
	private Design design;
	private Material lining;
	private FrontConnection frontConnection;
	private ArrayList<Color> colors;
	private double frontImpact;

	//inherited from the Piece super class
	//private Temperature temperature;
	//private Formality formality;


	/**
	* Contructor for objects of class Top
	*/
	public Top(Material m, int th, int loo, Collar c, SleeveLength s, Texture t,
							Temperature temp, Formality f, Design d, FrontConnection fC, ArrayList<Color> ac){
		material = m;
		thickness = th;
		looseness = loo;
		collar = c;
		sleevelength = s;
		texture = t;
		temperature = temp;
		frontConnection = fC;
		formality = f;

		design = d;
		colors = ac;
		frontImpact = 1;
	}

	/**
	* gets the Material of the Top
	* @return material
	*/
	public Material getMaterial(){
		return material;
	}

	/**
	* gets the Formality of the Top
	* @return formality
	*/
	public Formality getFormality(){
		return formality;
	}

	/**
	* gets the Temperature of the Top
	* @return temperature
	*/
	public Temperature getTemperature(){
		return temperature;
	}

	/**
	* gets the Layer of the Top
	* @return layer
	*/
	public int getLayer(){
		return layer;
	}

	/**
	* sets the Layer of the Top
	* @param i integer to set the layer to
	*/
	public void setLayer(int i){
		layer = i;
	}

	/**
	* gets the thickness of the Top
	* @return thickness
	*/
	public int getThickness(){
		return thickness;
	}

	/**
	* gets the looseness of the Top
	* @return looseness
	*/
	public int getLooseness(){
		return looseness;
	}

	/**
	* gets the Collar of the Top
	* @return collar
	*/
	public Collar getCollar(){
		return collar;
	}

	/**
	* gets the SleeveLength of the Top
	* @return sleevelength
	*/
	public SleeveLength getSleeveLength(){
		return SleeveLength;
	}

	/**
	* gets the Texture of the Top
	* @return texture
	*/
	public Texture getTexture(){
		return texture;
	}

	/**
	* gets the design of the Top
	* @return design
	*/
	public Design getDesign(){
		return design;
	}

	/**
	* gets the Lining of the Top
	* @return lining
	*/
	public Material getLining(){
		return lining;
	}

	/**
	* gets the frontConnection of the Top
	* @return frontConnection
	*/
	public FrontConnection getFrontConnection(){
		return frontConnection;
	}

	public void setFrontConnectionMode(FrontConnectionMode mode){
		frontConnection.setFrontConnectionMode(FrontConnectionMode mode);
	}

	public void calculateTemperature(){
		// need to do this
	}

	/**
	* changes the impact of the formality of a factor of the tops
	* @param factor string representing factor of top
	* @param impact double representing new impact of the factor
	*/
	public void setFormalityImpact(String factor, double impact){

		switch(factor){
			case "material":
				material.setFormalityImpact(impact);
				break;
			case "collar":
				collar.setFormalityImpact(impact);
		}
	}

	/**
	* gets the Colors of the Top
	* @return color
	*/
	public ArrayList<Color> getColors(){
		return colors;
	}

	/**
	* returns true, because tops are tops
	*@return true
	*/
	public boolean isTop(){
		return true;
	}

	public Top clone(){
		return new Top(); // I need to write this in
	}
}
