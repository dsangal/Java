import java.util.Scanner;

public class TicTacToe  {

	private Scanner userInput; 
	private char[][] boardGame; 
	private boolean playerXTurnFlag; 
		
	public TicTacToe() {		
	}
	
	private void displayGameMenu()  {
		if (playerXTurnFlag)
			System.out.println("Player X, it's your turn.");
		else
			System.out.println("Player O, it's your turn.");
			
		// Display menu items	
		System.out.println();
		System.out.println("1: Enter Row and Column for a move");
		System.out.println("2: Start a new game");
		System.out.println("3: Quit game");
		System.out.print("Please enter a number from the menu: ");
	}
	
	public void initBoardGame()  {		
		boardGame = new char[3][3];
			
		// Clear all board game slots
		for (int i = 0; i < 3; i++)  {			
			for (int j = 0; j < 3; j++)
				boardGame[i][j] = ' ';
		}
		
		// Player X plays first
		playerXTurnFlag = true;
		
		// Define user input
		userInput = new Scanner(System.in);
	}
	
	private void displayBoardGame()  {

		System.out.println("*****************************");
		displayGameBoardRow(0);
		System.out.println("            -----------");
		displayGameBoardRow(1);
		System.out.println("            -----------");
		displayGameBoardRow(2);
		System.out.println("    Column   " + "1" + "   " + "2" + "   " + "3");
		System.out.println("*****************************");
	}
	
	private void displayGameBoardRow(int row)  {
		int rowDisplay = row + 1;
		System.out.println("    Row " + rowDisplay + "    " + boardGame[row][0] + " | " + boardGame[row][1] + " | " + boardGame[row][2]);
	}
	
	// Process player move
	private boolean getPlayerMove()  {
		int row = 0;
		int column = 0;
		boolean invalidMove = true;
		
		while (invalidMove)  {
			System.out.println("Please enter Row number and Column number to mark - enter two numbers between 1 and 3, separated by a space");
			
			row = userInput.nextInt();
			column = userInput.nextInt();
			// Subtract 1 from row and column numbers - to use for index later
			row--;
			column--;
			
			// Check if row/column valid
			if (row >= 0 && row <= 2 && column >= 0 && column <= 2)  {
				// Check if row/column is taken
				if (boardGame[row][column] != ' ')
					System.out.println("Sorry, that slot is already taken");
				else
					invalidMove = false;
			}
			else
				System.out.println("Slot is not valid.");
		}
		
		// If valid position, mark with X or O
		if (playerXTurnFlag)
			boardGame[row][column] = 'X';
		else
			boardGame[row][column] = 'O';
		
		return checkWinner(row,column);
	}
	
	private boolean boardGameFull()  {	
		// count the number of slots that are taken to check if board game is full
		int slotsTakenCount = 0;
		
		for (int i = 0; i < 3; i++)  {			
			for (int j = 0; j < 3; j++)  {
				if (boardGame[i][j] == 'X' || boardGame[i][j] == 'O')
					slotsTakenCount++;
			}
		}
		
		return slotsTakenCount == 9;
	}
	
	private boolean checkWinner(int lastRow, int lastColumn)  {
		int foundCount = 0;
		boolean winnerFound = false; 
		char tempChar = boardGame[lastRow][lastColumn]; 
		
		// left to right checking		
		for (int l = 0; l < 3; l++)  {
			if (boardGame[lastRow][l] == tempChar)
				foundCount++;
		}
		
		if (foundCount == 3)
			winnerFound = true;
	
		// up and down checking
		foundCount = 0;
		
		for (int u = 0; u < 3; u++)  {
			if (boardGame[u][lastColumn] == tempChar)
				foundCount++;
		}
		
		if (foundCount == 3)
			winnerFound = true;

		// diagonal checking
		foundCount = 0;
		
		for (int d1 = 0; d1 < 3; d1++)  {
			if (boardGame[d1][d1] == tempChar)
				foundCount++;
		}
		
		if (foundCount == 3)
			winnerFound = true;
		
		foundCount = 0;
		
		for (int d2 = 0; d2 < 3; d2++)  {
			if (boardGame[d2][2-d2] == tempChar)
				foundCount++;
		}

		if (foundCount == 3)
			winnerFound = true;
			
		return winnerFound;
	}	
	
	public void startGame()  {
		boolean exitFlag = false;
	
		while(true)  {
		
			displayBoardGame();
			displayGameMenu();
			
			int choice = userInput.nextInt();
		
			if (choice == 1)  {
				if (getPlayerMove())  {
					displayBoardGame();	
					
					if (playerXTurnFlag)
						System.out.println("Player X won!");
					else
						System.out.println("Player O won!");

					exitFlag = true;
				}
				else if (boardGameFull())  {
					displayBoardGame(); 
					
					System.out.println("No more moves - no winner");
					exitFlag = true;
				}
				else  {
					playerXTurnFlag = !playerXTurnFlag;  
					exitFlag = false;
				}
			}
			
			else if (choice == 2) {
				initBoardGame();		
				startGame();
				exitFlag = false;
			}
			
			else if (choice == 3) {		
				exitFlag = true;
			}
			
			else
			{
				System.out.println("You entered an invalid menu item.");	
				exitFlag = false;
			}
			

			if (exitFlag) {
				System.out.println();
				System.out.println("Thanks for playing Tic Tac Toe!");
				
				System.exit(0);				
			}
		}	
	}
	
	public static void main(String[] args)  {
	
		TicTacToe game = new TicTacToe();

		System.out.println(">>>>  Tic Tac Toe Game  <<<<<");
		System.out.println();
		
		game.initBoardGame();		
		game.startGame();
		
		System.out.println("Thanks for playing Tic Tac Toe!");
	}
}