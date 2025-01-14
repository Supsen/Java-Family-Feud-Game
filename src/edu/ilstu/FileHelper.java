/**
 * 
 */
package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is to read the file and store each element of that file in Question array. Write a new file by a given name of all the question and answer 
 * after the game has end.
 * 
 * @author Suphasit Sribuaai
 *
 */
public class FileHelper {
	private static Question[] question = new Question[200];
	
	public static Question[] readFile() {
		
		Scanner sc = null;
		int count = 0; // count how many element, later use to set the array length
		//Question[] question = null;
		try 
		{
			File file1 = new File("Questions.csv");
			sc = new Scanner(file1);

				int i=0;
				sc.nextLine();// skip the header line
				while(sc.hasNextLine()) {
					String[] line = sc.nextLine().split(",");
					String question1 = line[0];
					String answer1 = line[1];
					int point1 = Integer.parseInt(line[2]);
					String answer2 = line[3];
					int point2 = Integer.parseInt(line[4]);
					String answer3 = line[5];
					int point3 = Integer.parseInt(line[6]);
					String answer4 = line[7];
					int point4 = Integer.parseInt(line[8]);
					String answer5 = line[9];
					int point5 = Integer.parseInt(line[10]);
					String answer6 = line[11];
					int point6 = Integer.parseInt(line[12]);
					String answer7 = line[13];
					int point7 = Integer.parseInt(line[14]);
				
					Question value = new Question(question1, answer1, point1, answer2, point2, answer3, point3, answer4, 
						point4, answer5, point5, answer6, point6, answer7, point7);
					question[i] = value;
					i++;
				}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		} 
		catch (InputMismatchException ie)
		{
			System.out.println("Input is invalid");
		}
		
		finally 
		{
			if(sc != null)
				sc.close();
		}
		return question;
		
	}
	public static void writeFile(Question[] tenQuestions, int[] choices,int[] teamScore, String teamName) {
		PrintWriter pw = null;
		int total = 0; // temporary store score value
		int sum = 0; // sum of score
		try {
			FileWriter file = new FileWriter("redbird.txt", false); // create text file name "redbird.txt"
			pw = new PrintWriter(file);
			for(int i=0;i<choices.length;i++) { // loop array of choices and reduce the index by 1 to match the location of answer
				if(choices[i] != -1) { // only change when not equal to -1
					int tmp = choices[i];
					tmp-=1;
					choices[i] = tmp;
				}
			}
			pw.println("Team "+teamName+" results\n");
			for(int i=0;i<tenQuestions.length;i++) { // loop all ten questions
				pw.println((i+1)+". "+tenQuestions[i]);
				if(choices[i] != -1) // check array element not equal to -1
					pw.println("player1 answered: "+tenQuestions[i].retrieveAns(choices[i])+" and got "+teamScore[i]+" points");
				if(choices[10+i] != -1) // check array element not equal to -1
					pw.println("player2 answered: "+tenQuestions[i].retrieveAns(choices[i+10])+" and got "+teamScore[i+10]+" points\n");
				else
					pw.println("Game was over! Player2 did not answer this question\n");
				total = teamScore[i]+teamScore[10+i];
				sum+=total; // sum of all score
			}
			pw.println("total points for the team: "+sum);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			if(pw!=null)
				pw.close();
		}
	}
}
