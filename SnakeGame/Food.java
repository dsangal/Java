package SnakeGame;

/**
 * Food class processes the food cell (row/column) on the Snake game board.  
 * @author Deryk Sangal
 *
 */
public class Food extends Cell {
	 
    /**
	 * Food method is the constructor for Food class
	 * 
     * @param symbol - char
     */
    public Food(char symbol) {
        setIcon(symbol);
    }
 
    /**
	 * addFood method adds the snake game food to the board
	 * 
     * @param board - Board class
     * @param food - Food class
     */
    public void addFood(Board board, Food food) {
         
        int x = (int) (((Math.random()) * (board.getBoardWidth() - 1)));
        int y = (int) (((Math.random()) * (board.getBoardHeight() - 1)));
 
        if (x == 0)
        {
            x = 2;
        }
         
        if (y == 0)
        {
            y = 2;
        }
        
        board.setBoardObject(food,x,y);
        setRow(x);
        setColumn(y);
    }
}
