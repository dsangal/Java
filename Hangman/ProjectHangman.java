//Deryk Sangal and Manak Ahluwalia

import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class ProjectHangman{
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int counter = 8;
		String []stringGuesses = new String[100];
		String []phraseList = new String[10];
		phraseList[0] = "Steph Curry";
		phraseList[1] = "Golden State Warriors";
		phraseList[2] = "Niner gang";
		phraseList[3] = "Good Morning";
		phraseList[4] = "Go to bed";
		phraseList[5] = "cats and dogs";
		phraseList[6] = "Klay Thompson";
		phraseList[7] = "Saturdays are for the boys";
		phraseList[8] = "I love USF";
		phraseList[9] = "CS is my major";

		Random rand = new Random();

		int rand_word = rand.nextInt(10);

		System.out.println("Welcome to Hangman! The game has chosen a random phrase for you to try to guess.");
		System.out.println("Every time you guess a letter correctly, it will be revealed within the phrase.");
		System.out.println("You have a limit of 8 incorrect guesses.");

		String game_string = "";
		if (rand_word == 1){
			game_string = phraseList[0];
		}
		else if (rand_word == 2){
			game_string = phraseList[1];
		}
		else if (rand_word == 3){
			game_string = phraseList[2];
		}
		else if (rand_word == 4){
			game_string = phraseList[3];
		}
		else if (rand_word == 5){
			game_string = phraseList[4];
		}
		else if (rand_word == 6){
			game_string = phraseList[5];
		}
		else if (rand_word == 7){
			game_string = phraseList[6];
		}
		else if (rand_word == 8){
			game_string = phraseList[7];
		}
		else if (rand_word == 9){
			game_string = phraseList[8];
		}
		else if (rand_word == 10){
			game_string = phraseList[9];
		}

		int length = game_string.length();
		StringBuilder hidden_phrase = new StringBuilder();
		String tempChar;
		for (int i = 0; i < length; i++){
			tempChar = game_string.substring(i,i+1);
			if (tempChar.equals(" ")){
				hidden_phrase.append(" ");
			}
			else {
				hidden_phrase.append("*");
			}
		}

		System.out.println(" ");
		System.out.println("Your phrase: " + hidden_phrase.toString());
		String user_guess="";
		String user_guess2="";
		boolean errorFlag = false;
		
		int arr_elem = 0;
		
		while (counter != 0){
			System.out.print("Player, guess a letter or a number: ");
			user_guess = input.nextLine();
			arr_elem++;
			errorFlag = false;
			
			// Check for duplicate answer (if not first guess)
			if (arr_elem > 1) {
				for (int j = 0; j < arr_elem; j++){
					try {
						if (stringGuesses[j].equalsIgnoreCase(user_guess)){
							System.out.println("Already used that answer.");
							System.out.println("Phrase: " + hidden_phrase.toString());
							errorFlag = true;
							break;
						}						
					}
			        catch(NullPointerException e) 
			        { 
			        	// No more to check
			            System.out.println("");
			        } 
				}
			}
			
			if (!errorFlag)
			{
				// Check for alphanumeric
				boolean userLetter = Character.isLetter(user_guess.charAt(0));
				boolean userNbr = Character.isDigit(user_guess.charAt(0));
				
				if (!userLetter && !userNbr) {
					System.out.println("Must enter an alphabet or number.");
					System.out.println("Phrase: " + hidden_phrase.toString());
					errorFlag = true;		
				}
			}
			
			// Save guesses
			stringGuesses[arr_elem] = user_guess;
			
			// Only process the rest if there is no duplicate error
			if (!errorFlag)
			{
				char c = user_guess.charAt(0);
	
				boolean guess = false;
				
				for (int i = 0; i < length; i++){
	
					if (user_guess.equalsIgnoreCase(game_string.substring(i,i+1)))
					{
						guess = true;
						hidden_phrase.setCharAt(i, c);
					}
				}
			
				if (guess){
					System.out.println("Congrats, you guessed a letter correctly!");
				}
				else if (!guess) {
					System.out.println("Incorrect guess. Try again.");	
					counter--;
	
				}
				System.out.println("You have " + counter + " incorrect guesses left.");
				
				String test = hidden_phrase.toString();
				if (test.equalsIgnoreCase(game_string)){
					System.out.println("Congrats you have guessed the word!");
					System.out.println("Phrase: " + hidden_phrase.toString());
					break;
	
				}
				else {
					System.out.println("There is still more to be solved.");
					System.out.println("");
					System.out.println("Phrase: " + hidden_phrase.toString());
	
				}
			}
		}

	}

}




