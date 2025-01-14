/**
 * 
 */
package edu.ilstu;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

/**
 * Game class, this class is to generate the random number of 10 questions from Question object array, and display the question to the player in play method.
 * 
 * @author Suphasit Sribuaai
 *
 */
public class Game {
	private String teamName;
	private int scoreTrack;
	private static Question[] tenQuestions = new Question[10];
	private int[] teamScore = new int[20];
	private int[] choices = new int[20];
	private final int WIN_SCORE = 200; // winning score set to 200
	private FileHelper file = new FileHelper();
	
	/**
	 * constructor
	 * 
	 * @param question - the question array 
	 * @param teamName - team name 
	 */
	public Game(Question[] question, String teamName) {
		this.teamName = teamName;
		for(int i=0; i<this.choices.length;i++) {
			choices[i] = -1; // set all element in array choices to -1
		}
		int countValid = 0;
		for(int i=0;i<question.length;i++) { // count how many valid value stored in questions array
			if(question[i]!=null)
				countValid++; // countValid = 110 
		}
		//-------------------------------Random unique number from 0-109 -------------------------------------------//
			SecureRandom sr = new SecureRandom(); // random unique number
			int[] quesRandom = new int[countValid]; // questions random to store all the question in random order
			int length = quesRandom.length;// store length of quesRandom in length
			int[] result = new int[length]; // result array to store the result of random question that will be use during the entire game
			
			for(int i=0;i<length;i++) { // loop 110 questions
				quesRandom[i] = i;
			}
			int count = length; // copy integer of length into count
			for(int i=0;i<length;i++) {
				int num = sr.nextInt(count);
				result[i] = quesRandom[num];
				quesRandom[num] = quesRandom[count-1];
				count--;
			}
		//--------------------------------------Loop ten random questions-------------------------------------------//
			for(int i=0;i<tenQuestions.length;i++) { // store 10 random questions in tenQuestions array
				tenQuestions[i] = question[result[i]]; // store the element of question array at random index in tenQuestion array index of i
				
			}
	}
	/**
	 * play method , this method is to display the current team name, and display 10 question to the first player and 10 question to second player. 
	 * record all answer and track the score. Finally announces if they win or lose and call writefile method. 
	 */
	public void play() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nGood Luck Team "+teamName+"!!");
		System.out.println("\nPlayer one will start now");
		System.out.println("\npress enter on your keyboard to start...");
		sc.nextLine();
		String answer = "";
		while(!answer.equalsIgnoreCase("no")) { // while loop keep looping if the input is not "no"
			//------------------------------------Player one------------------------------------------------//	
			int quesCount = 0;
			while(quesCount<10) 
			{ // while loop 10 questions
				System.out.println("\n"+(quesCount+1)+". "+tenQuestions[quesCount]); // use question from index 0 to 9
				System.out.print("Your answer(1-7): ");
				choices[quesCount] = sc.nextInt(); // a array variable that store user choices
				int choices1 = choices[quesCount]; // store index of the current answer, will be using to get the point of that answer
				this.teamScore[quesCount] = tenQuestions[quesCount].retrievePoint(choices1-1);// store each score in teamScore array, get point of answer index-1
				this.scoreTrack+=teamScore[quesCount]; // sum of all score
				quesCount++; // count how many questions have been answered
			}
			
			sc.nextLine();
			System.out.println("\nGood Job Player 1!!\n"
					+ "Your score was "+scoreTrack+"\n"
					+ "\n"
					+ "Player two will start now\n"
					+ "\n"
					+ "You will need "+(this.WIN_SCORE-scoreTrack)+" points to win!\n"
					+ "\n"
					+ "press Enter on your keyboard to start...\n"
					+ "");
			sc.nextLine(); // catch the enter inputs
		//------------------------------------Player two------------------------------------------------//	
			int quesCount2 = 0;
			while(quesCount2<10) 
			{ // while loop 10 questions for second player
				System.out.println((quesCount2+1)+". "+tenQuestions[quesCount2]); // use question from index 0 to 9
				System.out.print("Your answer(1-7): "); 
				
				choices[10+quesCount2] = sc.nextInt(); // store player two answer from index 10 to 19
				int choices2 = choices[10+quesCount2]; // store index of the current answer, will be using to get the point of that answer
					if(choices[quesCount2] != choices[10+quesCount2]) 
					{  // compare array at index i to index of 10+quesCount2
						this.teamScore[10+quesCount2] = tenQuestions[quesCount2].retrievePoint(choices2-1); // store each score in teamScore array, get point of answer index-1
						this.scoreTrack+=teamScore[10+quesCount2]; // sum of all score + teamScore index of 10 + the number of question player are at
						System.out.println("\nGreat Answer! You get "+this.teamScore[10+quesCount2]+" for this question\n");
						if(scoreTrack < 200) 
						{ // if total score still less than 200 display the message
							System.out.println("you need "+(this.WIN_SCORE-scoreTrack)+" to win\n");
						}
					}
					else 
					{
						System.out.println("\nToo bad! Player one answered the same answer. You get no points for this question\n"
								+ "\n"
								+ "you need "+(this.WIN_SCORE-scoreTrack)+" to win\n" // display how much score second player needed in order to win the game
								+ "");
					}
				quesCount2++; // count how many questions have been answered
				if(this.WIN_SCORE <= scoreTrack) 
				{ // if the score was reached 200, display and quit loop
					System.out.println("Congratulations!! You WON!!!!");
					quesCount2 = 10; // set quesCount to 10, quit the while loop
					answer = "no"; // set key answer to no, quit while loop
				} 
				else if(this.WIN_SCORE > scoreTrack && quesCount2 == 10) 
				{ // if the score was not over 200, display game over
					System.out.println("Game Over!\n"
							+ "Better Luck Next Time\n"
							+ "");
					quesCount2 = 10; // set quesCount2 to 10 and quit loop
					answer = "no"; // set key answer to no, quit while loop
				}
			}
		} // end of main while loop
		file.writeFile(tenQuestions, choices, teamScore, this.teamName); // calling file writer method
	}
}
