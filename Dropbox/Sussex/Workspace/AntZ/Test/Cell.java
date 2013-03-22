/***
 * 
 * @author mw277
 * @version 1.0.0
 */
public class Cell {
	Ant ContainsAnt; 
	String cellType;
	int xCord;
	int yCord;
	boolean[] redMarkers =new boolean[5] ;
	boolean[] blackMarkers =new boolean[5] ; 
	int direction; 
	private int food;
	/**
	 * @param xCord 
	 * @param yCord
	 * @param cellType
	 */
	public Cell(int xCord,int yCord,String cellType){
		this.xCord = xCord;
		this.yCord = yCord;
		this.cellType = cellType; 
		this.food = 0;
	}
	/**
	 * food construcotr
	 * @param xCord
	 * @param yCord
	 * @param cellType
	 * @param f
	 */
	public Cell(int xCord,int yCord,String cellType,int f){
		this.xCord = xCord;
		this.yCord = yCord;
		this.cellType = cellType; 
		this.food = f;
	}
	/**
	 * @return 
	 * true if marker in position i 
	 * else false
	 */
	public boolean containsMarker(String colour, int i){
		if(colour.equals("red")){
			return redMarkers[i];
		}else{
			return blackMarkers[i];
		}
		
	}
	/**
	 * Clears marker in position i 
	 * @param i
	 */
	public void clearMarker(String colour, int i){
		if(colour.equals("red")){
			redMarkers[i] = false;
		}else{
			blackMarkers[i] = false;
		}
	}
	/**
	 * Sets marker in position i
	 * @param i
	 */
	public void setMarker(String colour, int i){
		if(colour.equals("red")){
			redMarkers[i] = true;
		}else{
			blackMarkers[i] = true;
		}
	}
	/**
	 * Clears all markers
	 * @param i
	 */
	public void clearAllMarkers(){
		for (boolean b:redMarkers){
			b=false;
		}
		for (boolean b:blackMarkers){
			b=false;
		}
	}
	/**
	 * 
	 * @return cellType
	 */
	public String cellType(){
		return cellType;
	}
	/**
	 * returns the Ant currently in this cell
	 * @return
	 */
	public Ant getContainsAnt() {
		return ContainsAnt;
	}
	/**
	 * Inputs ant into this cell
	 * @param containsAnt
	 */
	public void setContainsAnt(Ant containsAnt) {
		ContainsAnt = containsAnt;
	}
	/**
	 * Returns marker array of this cell
	 * @return
	 */
	public boolean[] getMarkers(String colour) {
		if(colour.equals("red")){
			return redMarkers;
		}else{
			return blackMarkers;
		}
		
	}
	public int getXCord(){
		return xCord;
	}
//	public int getYCord(){
//		return null;
//		
//	}
	public int getFood() {
		return this.getFood();
		
	}
	public void setFood(int i) {
		this.food = i;
		
	}
}
