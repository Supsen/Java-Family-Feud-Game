/**
 * 
 */
package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author suphasit sribuaai
 *
 */
public class Readfile {

	/**
	 * @param args
	 */
	private static Readfile[] read = new Readfile[200];
	private String question;
	private String[] answer = new String[7];
	private int[] point = new int[7];
	private static int[] choices = new int[20];
	
	public Readfile(String question1, String answer1, int point1, String answer2, int point2, String answer3, int point3, String answer4, 
			int point4, String answer5, int point5, String answer6, int point6, String answer7, int point7) {
		this.question = question1;
		
		this.answer[0] = answer1; 
		this.answer[1] = answer2; 
		this.answer[2] = answer3; 
		this.answer[3] = answer4; 
		this.answer[4] = answer5; 
		this.answer[5] = answer6; 
		this.answer[6] = answer7; 
		
		this.point[0] = point1;
		this.point[1] = point2;
		this.point[2] = point3;
		this.point[3] = point4;
		this.point[4] = point5;
		this.point[5] = point6;
		this.point[6] = point7;
		
		
		
	}
	public static void main(String[] args) {
	
		//Scanner sc = null;
		
		//int i = 0;
		try(Scanner sc = new Scanner(new File("Questions1.csv"))) {
			//File file1 = new File("Questions1.csv");
			//sc = new Scanner(file1);
			
			sc.nextLine();
			int i = 0;
			while(sc.hasNextLine()) {
				String[] question = sc.nextLine().split(",");
				String question1 = question[0];
				String answer1 = question[1];
				int point1 = Integer.parseInt(question[2]);
				String answer2 = question[3];
				int point2 = Integer.parseInt(question[4]);
				String answer3 = question[5];
				int point3 = Integer.parseInt(question[6]);
				String answer4 = question[7];
				int point4 = Integer.parseInt(question[8]);
				String answer5 = question[9];
				int point5 = Integer.parseInt(question[10]);
				String answer6 = question[11];
				int point6 = Integer.parseInt(question[12]);
				String answer7 = question[13];
				int point7 = Integer.parseInt(question[14]);
				
				Readfile value = new Readfile(question1, answer1, point1, answer2, point2, answer3, point3, answer4, 
						point4, answer5, point5, answer6, point6, answer7, point7);
				read[i] = value;
				
				i++;
			}
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
//		finally {
//			if(sc!=null)
//				sc.close();
//		}
//			int length = i;
//			play(sc,length);
		int count = 0;
			for(Readfile question : read) {
				if(question != null) {
					System.out.println(question);
					count++;
				}
			}
			System.out.println(count);
		

	}
	public static void play(Scanner sc, int length) {
		sc = new Scanner(System.in);
		String answer = "";
		while(!answer.equalsIgnoreCase("no")) {
			int quesCount = 0;
			while(quesCount<10) {
				Random ran = new Random();
				int ranDom = ran.nextInt(length);
				System.out.println(read[ranDom]);
				System.out.print("Your answer(1-7): ");
				choices[quesCount] = sc.nextInt();
				quesCount++;
			}
			sc.nextLine();
			System.out.println("Good Job Player 1!!\n"
					+ "Your score was 130\n"
					+ "\n"
					+ "Player two will start now\n"
					+ "\n"
					+ "You will need 70 points to win!\n"
					+ "\n"
					+ "press Enter on your keyboard to start...\n"
					+ "");
			sc.nextLine();
			
			System.out.println("Would you like to play again?");
			answer = sc.nextLine();
		}	
	}
	public String toString() {
		String value = null;
		String answer1 = null;

		value = "\n"+this.question+"\n   1. "+this.answer[0]+"\n   2. "+this.answer[1]+"\n   3. "+this.answer[2]
				+"\n   4. "+this.answer[3]+"\n   5. "+this.answer[4]+"\n   6. "+this.answer[5]+"\n   7. "+this.answer[6];
		return value;
	}
	
}
