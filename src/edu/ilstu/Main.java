/**
 * 
 */
package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class, this class is to manage the program, first display a welcome statement, the program ask user for their team name, call FileHelper class, create 
 * Question object and call play method in Game class. The program will be looping until user designed to quit by answer "no" after the game has end.
 * 
 * @author Suphasit Sribuaai
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileHelper file = new FileHelper();// create FileHelper object
		Scanner sc = new Scanner(System.in);
				System.out.println("#######################\n"
				+ "Welcome to Family Fued!\n"
				+ "#######################\n"
				+ "");
		System.out.print("please enter team name: ");
		String teamName = sc.nextLine(); // store team name in teamName variable
		Question[] questions; // Question array object
		questions = file.readFile(); // call readFile method and store the returned array value in questions array
		
		//Game newGame = new Game(questions, teamName);// created Game object, pass in questions array and team name
		String answer = "";
		
		while(!answer.equalsIgnoreCase("no")) {
			Game newGame = new Game(questions, teamName);// created new Game object, pass in questions array and team name
			newGame.play();// call play method to start the game
			System.out.print("\nWould you like to play again? (yes/no)");
			answer = sc.nextLine();
			while(!answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("yes")) { // while loop, check if input is not yes or no
				System.out.println("Please enter yes or no!!");
				System.out.print("\nWould you like to play again? (yes/no)");
				answer = sc.nextLine();
			}
		}
		System.out.println("Thanks for playing!\n"
				+ "Good bye!\n"
				+ "");
		
	}
	

}
