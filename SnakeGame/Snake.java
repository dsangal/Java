package SnakeGame;

/**
 * Snake class processes the user movement within the Snake game board.  
 * @author Deryk Sangal
 *
 */
public class Snake extends Cell {
	 
    public Snake(char symbol, int xStartingLocation, int yStartingLocation) {
        setIcon(symbol);
        setRow(xStartingLocation);
        setColumn(yStartingLocation);
    }
     
    /**
	 * moveLeft method moves the snake game cells one position to the left
	 * 
     * @param board - Board class
     * @param snake - Snake class
     * @param food - Food class 
     */
    public void moveLeft(Board board, Snake snake, Food food) {
		Cell snakeCell = new Cell();
		
        snake.setRow(getRow() - 1);
        board.setBoardObject(snake, snake.getRow(), snake.getColumn());
        
        checkSnakeCross(board, snake.getRow(), snake.getColumn());
        
        snakeCell.setRow(snake.getRow()); 
        snakeCell.setColumn(snake.getColumn());

        saveSnakeLocation(board, snake, snakeCell);
        
        processFoodCell(board, snake.getRow() + 1, snake.getColumn(), food);
        board.resetBoardObject(snake.getRow() + 1, snake.getColumn());
    }
     
    /**
	 * moveRight method moves the snake game cells one position to the right
	 * 
     * @param board - Board class
     * @param snake - Snake class
     * @param food - Food class 
     */
    public void moveRight(Board board, Snake snake,  Food food) {
		Cell snakeCell = new Cell();
		
        snake.setRow(getRow() + 1);
        board.setBoardObject(snake, snake.getRow(), snake.getColumn());
        
        checkSnakeCross(board, snake.getRow(), snake.getColumn());
        
        snakeCell.setRow(snake.getRow());
        snakeCell.setColumn(snake.getColumn());

        saveSnakeLocation(board, snake, snakeCell);
        
        processFoodCell(board, snake.getRow() - 1, snake.getColumn(), food);
        board.resetBoardObject(snake.getRow() - 1, snake.getColumn());
    }
     
    /**
	 * moveUp method moves the snake game cells one position up
	 * 
     * @param board - Board class
     * @param snake - Snake class
     * @param food - Food class 
     */
    public void moveUp(Board board, Snake snake,  Food food) {
		Cell snakeCell = new Cell();
		
        snake.setColumn(getColumn() - 1);
        board.setBoardObject(snake, snake.getRow(), snake.getColumn());
        
        checkSnakeCross(board, snake.getRow(), snake.getColumn());
        
        snakeCell.setRow(snake.getRow());
        snakeCell.setColumn(snake.getColumn());

        saveSnakeLocation(board, snake, snakeCell);
        
        processFoodCell(board, snake.getRow(), snake.getColumn() + 1, food);
        board.resetBoardObject(snake.getRow(), snake.getColumn() + 1);
    }
     
    /**
	 * moveDown method moves the snake game cells one position down
	 * 
     * @param board - Board class
     * @param snake - Snake class
     * @param food - Food class 
     */
    public void moveDown(Board board, Snake snake,  Food food) {
		Cell snakeCell = new Cell();
       
		snake.setColumn(getColumn() + 1);
        board.setBoardObject(snake, snake.getRow(), snake.getColumn());
        
        checkSnakeCross(board, snake.getRow(), snake.getColumn());
        
        snakeCell.setRow(snake.getRow());
        snakeCell.setColumn(snake.getColumn());

        saveSnakeLocation(board, snake, snakeCell);
        
        processFoodCell(board, snake.getRow(), snake.getColumn() - 1, food);
        board.resetBoardObject(snake.getRow(), snake.getColumn() - 1);
    }
    
    /**
	 * checkSnakeCross method checks if new cell coordinate already exists
	 * 
     * @param board - Board class
     * @param x - int
     * @param y - int
     */
    public void checkSnakeCross(Board board, int x, int y) {
    	for (int k = 0; k < board.getSnakeLoc().size(); k++) {    		
    		if (x == board.getSnakeLoc().get(k).getRow() && y == board.getSnakeLoc().get(k).getColumn()) {
    			System.out.println("!!!!! Game over !!!!!");
    			System.exit(0);
    		}
		}
    }
    
    /**
	 * processFoodCell method checks if board game position has food
	 * 
     * @param board - Board class
     * @param x - int
     * @param y - int 
     * @param food - Food class 
     */
    public void processFoodCell(Board board, int x, int y, Food food) {
    	Cell foodCell = new Cell();
    	foodCell.setRow(x);
    	foodCell.setColumn(y);
    	
    	if (foodCell.getRow() == food.getRow() && foodCell.getColumn() == food.getColumn()){
    		board.setFoodOnboard(false);
    		board.getSnakeLoc().add(foodCell);
    		board.setSnakeLength(board.getSnakeLength() + 1);
    		}
    }
    
    /**
	 * saveSnakeLocation method saves the snake cell to an array list 
	 * 
	 * @param board - Board class
	 * @param snake - Cell class
	 * @param inCell - Cell class
	 */
	public void saveSnakeLocation(Board board, Cell snake, Cell inCell) {
		Cell tempCell = new Cell();
		Cell nextTempCell = new Cell();
		
		if (board.getSnakeLoc().size() != 0) {
			
			tempCell = board.getSnakeLoc().get(0);	
			
			for (int i = 0; i < board.getSnakeLength(); i++) {
				
				board.resetBoardObject(board.getSnakeLoc().get(i).getRow(), board.getSnakeLoc().get(i).getColumn());
				if ( i== 0) {
					board.getSnakeLoc().set(i, inCell);					
				} else {	
					nextTempCell = board.getSnakeLoc().get(i);
					board.getSnakeLoc().set(i, tempCell);
					tempCell = nextTempCell;
				}
				board.setBoardObject(snake, board.getSnakeLoc().get(i).getRow(), board.getSnakeLoc().get(i).getColumn());
			}
		}
	}

}