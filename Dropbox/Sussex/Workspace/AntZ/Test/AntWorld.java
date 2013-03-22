import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AntWorld {

	private RandomGen seed;
	private Cell[][] cells;
	private Ant[] ants;
	private int round;
	private int deadAntCount;
	private int kills;
	private int foodCount;
	
	public AntWorld(String fileLoc ){	
		this.cells = new Cell[200][200];
		int col = 0;
		int row = 0;
		int lineNumber = 0;
		Scanner scanner = null;
		try { 
			File file = new File(fileLoc);
            scanner = new Scanner(file);
            int xDimension = 0;
            int yDimension = 0;
            int xCord = 0;
            int yCord = 0;
            while (scanner.hasNextLine()) {
            	lineNumber ++;
                String nextLine = scanner.nextLine();
                if(lineNumber == 1){ //get x cord length or row length
                	xDimension = Integer.parseInt(nextLine);
                }else if(lineNumber == 2){ //get y cord length or col length              	
                	yDimension = Integer.parseInt(nextLine);               	
                } else{
                	
                	this.cells = new Cell[yDimension][xDimension];
//                	System.out.print(lineNumber);
//                	System.out.println(nextLine);
                	//iterate over each char in line
                	for(int i = 0; i < nextLine.length(); i++){
                		xCord = 0; //reset xCord each row
                		char c = nextLine.charAt(i); //get next char
                		
                		if(c == ' '){ //white space
                			//ignore whitespace
                		}else{
                			if( c == '#'){//Rock
                				this.cells[xCord][yCord] = new Cell(xCord, yCord, "rock");	
                    		}else if(c == '.'){//Clear Cell
                    			this.cells[xCord][yCord] = new Cell(xCord, yCord, "clear");	
                    		}else if(c == '+'){// Red Anthill
                    			this.cells[xCord][yCord] = new Cell(xCord, yCord, "redHill");
                    			// need to create new red ant and place on cell
                    		}else if(c == '-'){// Black Anthill
                    			this.cells[xCord][yCord] = new Cell(xCord, yCord, "blackHill");  
                    			//need to create new black ant and place on cell
                    		}else if(Character.isDigit(c)){ //Food
                    			int foodAmount = Character.getNumericValue(c);
                    			this.cells[xCord][yCord] = new Cell(xCord, yCord, "food", foodAmount);
                    			
                    		}  			
                		} xCord ++; //increase row
                	} yCord ++; //increase col	
                }

            }
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
        	scanner.close();
        }
		System.out.println(this.cells.length);	
	}
	/**
	 * Returns true if given cell contains ant
	 * False if not.
	 * @param xPos
	 * @param yPos
	 * @return
	 */
	public Boolean antIsAt(int xPos, int yPos) {
		
		return this.cells[xPos][yPos].ContainsAnt != null;
		
	}
	
	/**
	 * returns ant at given coordinates
	 * @param xPos
	 * @param yPos
	 * @return
	 */
	public Ant antAt(int xPos, int yPos) {
		return this.cells[xPos][yPos].ContainsAnt;
	}
	
	/**
	 * Set ant at given coordinates
	 * @param xPos
	 * @param yPos
	 * @return
	 */
	public void setAntAt(int xPos, int yPos,Ant a) {
		this.cells[xPos][yPos].setContainsAnt(a);
	}
	
	/**
	 * kills ant with given id
	 * @param xPos
	 * @param yPos
	 * @return
	 */
	public void killAnt(int id) {
		
		this.ants[id] = null;
	}
	/**
	 * kills ant at given position
	 * @param xPos
	 * @param yPos
	 * @return
	 */
	public void killAntAt(Position pos) {
		Ant a = this.cells[pos.xPos][pos.yPos].getContainsAnt();
		if(a != null){
			int id = a.getId();
			this.ants[id] = null;
		}
	}
	
	/**
	 * returns true if ant with given id is alive
	 * @param id
	 * @return
	 */
	public Boolean antIsAlive(int id) {

		return this.ants[id] != null;
	}
	
	/**
	 * return position object of Ant
	 * @param id
	 * @return
	 */
	public Position findAnt(int id) {
		Ant a = this.ants[id];		
		return a.getPos();	
	}
	
	/**
	 * return the amount of food at given position
	 * @param pos
	 * @return
	 */
	public int foodAt(Position pos) {
		return this.cells[pos.xPos][pos.yPos].getFood();
	}
	
	/**
	 * set the amount of food at given position to i
	 * @param pos
	 * @return
	 */
	public void setFoodAt(Position pos, int i) {
		this.cells[pos.xPos][pos.yPos].setFood(i);
	}
	
	/**
	 * returns true if pos contains ant hill of given colour
	 * @param pos
	 * @param colour
	 * @return
	 */
	public Boolean anthillAt(Position pos, String colour) {
		return this.cells[pos.xPos][pos.yPos].cellType() == colour.concat("Hill");
	}
	
	/**
	 * set marker at given position
	 * @param pos
	 * @param colour
	 * @param marker
	 */
	public void setMarkerAt(Position pos, String colour, int marker) {
		this.cells[pos.xPos][pos.yPos].setMarker(colour, marker);
	}

	/**
	 * set marker at given position
	 * @param pos
	 * @param colour
	 * @param marker
	 */
	public void clearMarkerAt(Position pos, String colour, int marker) {
		this.cells[pos.xPos][pos.yPos].clearMarker(colour, marker);
	}

	
}
