package SnakeGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Board class processes the Snake game board.  It initializes and displays objects on the board. 
 * @author Deryk Sangal
 *
 */
/**
 * @author ched1
 *
 */
public class Board {
	 
    private char[][] boardLayout;
    private List<Cell> snakeLoc = new ArrayList<Cell>();
    private int width, height;
    private boolean foodOnboard;
	private int snakeLength = 0;    
    
    /**
     * getBoardLayout method gets the Snake game board layout
     * 
     * @return boardLayout - char[][]
     */
    public char[][] getBoardLayout() {
		return boardLayout;
	}

	/**
     * setBoardLayout method sets the Snake game board layout
     * 
	 * @param boardLayout - char[][]
	 */
	public void setBoardLayout(char[][] boardLayout) {
		this.boardLayout = boardLayout;
	}

	/**
     * getSnakeLoc method gets the Snake location list
     * 
	 * @return snakeLoc = List<Cell> 
	 */
	/**
	 * @return
	 */
	public List<Cell> getSnakeLoc() {
		return snakeLoc;
	}

	/**
     * setSnakeLoc method sets the Snake location list
     * 
	 * @param snakeLoc - List<Cell>
	 */
	public void setSnakeLoc(List<Cell> snakeLoc) {
		this.snakeLoc = snakeLoc;
	}

	/**
     * getWidth method gets the Snake board width
     * 
	 * @return width - int
	 */
	public int getWidth() {
		return width;
	}

	/**
     * setWidth method sets the Snake board width
     * 
	 * @param width - int
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
     * getHeight method gets the Snake board height
     * 
	 * @return width - int
	 */
	public int getHeight() {
		return height;
	}

	/**
     * setHeight method sets the Snake board height
     * 
	 * height width - int
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
     * getFoodOnboard method gets the Snake board food
     * 
	 * @return foodOnboard - boolean
	 */
	public boolean getFoodOnboard() {
		return foodOnboard;
	}

	/**
     * setFoodOnboard method sets the Snake board food
     * 
	 * @param foodOnboard - boolean
	 */
	public void setFoodOnboard(boolean foodOnboard) {
		this.foodOnboard = foodOnboard;
	}

	/**
     * getSnakeLength method gets the Snake board length
     * 
	 * @return snakeLength - int
	 */
	public int getSnakeLength() {
		return snakeLength;
	}

	/**
     * setSnakeLength method sets the Snake board length
     * 
	 * @param snakeLength - int
	 */
	public void setSnakeLength(int snakeLength) {
		this.snakeLength = snakeLength;
	}

	/**
	 * Board method is the constructor for class Board
	 * 
     * @param width - int
     * @param height - int
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.boardLayout = new char[this.height][this.width];
    }
     
    /**
	 * initBoard method initializes the snake game board with dots
	 * 
     */
    public void initBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.boardLayout[i][j] = '.';
            }
        }
    }
     
    /**
	 * displayBoard method displays the snake game board objects
	 * 
     * @param snake - Cell class
     */
    public void displayBoard(Cell snake) {
        for (int i = 0; i < this.height;  i++) {
            for (int j = 0; j <this.width; j++) {
            	
            	for (int k = 0; k < snakeLoc.size(); k++) {
            		
            		if (j == snakeLoc.get(k).getRow() && i == snakeLoc.get(k).getColumn()) {
            			setBoardObject(snake, snakeLoc.get(k).getRow(), snakeLoc.get(k).getColumn());
            		}
        		}
            	
                System.out.print(this.boardLayout[i][j]);
            }
            System.out.println();
        }
    }
 
    /**
	 * setBoardObject method sets the specific snake game row, column
	 * 
     * @param object - Cell class
     * @param x - int
     * @param y - int
     */
    /**
     * @param object
     * @param x
     * @param y
     */
    public void setBoardObject(Cell object, int x, int y) {
        this.boardLayout[y][x] = object.getIcon();
    }  
    
    /**
	 * resetBoardObject method sets a specific snake board row and column with a dot
	 * 
     * @param x - int
     * @param y - int
     */
    public void resetBoardObject(int x, int y) {
        this.boardLayout[y][x] = '.';        
    }
 
    /**
	 * getBoardWidth method gets the snake game board width
	 * 
     * @return this.width - int
     */
    public int getBoardWidth() {
        return this.width;
    }
 
    /**
	 * getBoardHeight method gets the snake game board height
	 * 
     * @return this.height - int
     */
    public int getBoardHeight() {
        return this.height;
    }
 
    /**
     * getBoardObject method gets a specific object from the snake game board
     * 
     * @param x - int
     * @param y - int
     * @return this.boardLayout - char
     */
    public char getBoardObject(int x, int y) {
        return this.boardLayout[y][x];
    }
}
