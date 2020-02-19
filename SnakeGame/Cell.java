package SnakeGame;

/**
 * Cell class processes the specific cell (row/column) on the Snake game board.  
 * @author Deryk Sangal
 *
 */
public class Cell {
    
    private int x, y;
    private char icon;
    

	/**
	 * getRow method gets the Cell row
	 * 
	 * @return this.x - int
	 */
	public int getRow() {
        return this.x;
    }
 
    /**
	 * getColumn method gets the Cell column
	 * 
	 * @return this.y - int
	 */
    public int getColumn() {
        return this.y;
    }
 
    /**
	 * getIcon method gets the Cell column
	 * 
	 * @return icon - char
     */
    public char getIcon() {
        return icon;
    }
 
    /**
	 * setRow method sets the Cell row
	 * 
     * @param newLocation - int
     */
    public void setRow(int newLocation) {
        this.x = newLocation;
    }
     
    /**
	 * setColumn method sets the Cell column
	 * 
     * @param newLocation - int
     */
    public void setColumn(int newLocation) {
        this.y = newLocation;
    }
     
    /**
	 * setIcon method sets the Cell icon
	 * 
     * @param newSymbol - char
     */
    public void setIcon(char newSymbol) {
        this.icon = newSymbol;
    }
}