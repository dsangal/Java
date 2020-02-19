package SnakeGame;

import java.util.Scanner;

/**
 * Game class is the main class the Snake game board. 
 * @author Deryk Sangal
 *
 */
public class Game {
 
    public static void main(String[] args) {
 
        final int BOARD_WIDTH = 20; 
        final int BOARD_HEIGHT = 10; 
        final int START_ROW = BOARD_WIDTH / 2;
        final int START_COLUMN = BOARD_HEIGHT / 2;
 
        Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        board.initBoard();

        Snake snake = new Snake('X', START_ROW, START_COLUMN);
        board.setBoardObject(snake, snake.getRow(), snake.getColumn());
        
        Cell snakeCell = new Cell();
        snakeCell.setRow(snake.getRow());
        snakeCell.setColumn(snake.getColumn());
        board.getSnakeLoc().add(snakeCell);
        board.setSnakeLength(board.getSnakeLength()+1);
 
        Food food = new Food('@');
        food.addFood(board, food);
        board.setFoodOnboard(true);
         
        Scanner scanner = new Scanner(System.in);
        char userInput;
        boolean gameOn = true;
 
        while (gameOn) {
            board.displayBoard(snake);
     	    System.out.print("Please make a move - type l to move to the left, r for right, u for up, d for down, or q to quit.  ");
     	   
            switch (userInput = scanner.nextLine().charAt(0)) {
            case 'l':
            	if (snake.getRow() == 0)
            	{
             	    System.out.println();
             	    System.out.println("****    Error: Border reached   ****");
             	    System.out.println();
            	}
            	else
            		snake.moveLeft(board, snake, food);
            	
                break;
            case 'r':
            	if (snake.getRow() == BOARD_WIDTH - 1)
            	{
             	    System.out.println();
             	    System.out.println("****    Error: Border reached   ****");
             	    System.out.println();
            	}
            	else
            		snake.moveRight(board, snake, food);
            	
                break;
            case 'u':
            	if (snake.getColumn() == 0)
            	{
             	    System.out.println();
             	    System.out.println("****    Error: Border reached   ****");
             	    System.out.println();
            	}
            	else
            		snake.moveUp(board, snake, food);
            	
                break;
            case 'd':
            	if (snake.getColumn() == BOARD_HEIGHT - 1)
            	{
             	    System.out.println();
             	    System.out.println("****    Error: Border reached   ****");
             	    System.out.println();
            	}
            	else
            		snake.moveDown(board, snake, food);
            	
                break;
            case 'q':
         	    System.out.println();
    			System.out.println("!!!!! Game over !!!!!");
    			gameOn = false;
            	
                break;
            default:
         	    System.out.println();
            	System.out.println("****    Error: Invalid character entered   ****");
         	    System.out.println();
            	
                break;
            }
            
           if (!board.getFoodOnboard()) {
        	   food.addFood(board, food);
        	   board.setFoodOnboard(true);
           }
        }
    }
 
}
