import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AntWorld {

	private RandomGen seed;
	private Cell[][] cells;
	private Ant[][] ants;
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
            while (scanner.hasNextLine()) {
            	lineNumber ++;
                String nextLine = scanner.nextLine();
                System.out.println(nextLine.length());
                nextLine.trim();
//                nextLine.replaceAll("\\s+","");
                System.out.println(nextLine.length());
                String [] tokens = nextLine.split(" ");
                for (int i = 0; i < tokens.length; i++){
                    String c = tokens[i];        
                    System.out.println(c + " ddddddddddddddddddddddd");
                    System.out.println(tokens.length + " ddddddddddddddddddddddd");
//					switch (c) {
//					  case '#': 
//						  cells[row][col] = new Cell("Rock"); 
////						  System.out.print("Rock");
//
//						  break;
//					  case '.':
////						  Cell cell = new Cell();
//						  System.out.print(" Cell ");break;
//					  case '+':
////						  Cell cell = new Cell("+ Ant Hill");
//						  System.out.print(" + Ant Hill ");break;
//					  case '-':
////						  Cell cell = new Cell("- Ant Hill");
//						  System.out.print(" - Ant Hill ");break;
////					  case ' ':
////						  System.out.print("Cell");break;
////					  default: System.out.print("Food"); break;
//					}
//					if(Character.isDigit(c)){
//						int foodNum = Character.getNumericValue(c);
//						System.out.print("Food NUM: " + foodNum);
//					}
					row ++;
					  System.out.println(row);
					  System.out.println(col);
                }
                row = 0;
                col ++;
                
                System.out.print("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
        	scanner.close();
        }
		
	}
	
	
}
