/**
 * 
 */
package edu.ilstu;

/**
 * This Question class is to set all the elements of question object, retrieve and set each question, answer and point.Print out the question with related answer 
 * arranged order.
 * 
 * @author Suphasit Sribuaai
 *
 */
public class Question {
	private String quesText; // a variable to hold question in text
	private int number; // number of options
	String[] answer = new String[7]; // a string array of answer
	int[] point = new int[20]; // an integer array of points
	boolean index = false; // A boolean variable that will indicate if that question was selected in the game.
	
	/**
	 * Constructor
	 * 
	 * @param question - the question of the game store in String
	 * @param answer1 - first choices of the question
	 * @param point1 - point of the first answer
	 * @param answer2 - second choices of the question
	 * @param point2 - point of the second answer
	 * @param answer3 - third choices of the question
	 * @param point3 - point of the third answer
	 * @param answer4 - forth choices of the question
	 * @param point4 - point of the forth answer
	 * @param answer5 - fifth choices of the question
	 * @param point5 - point of the fifth answer
	 * @param answer6 - sixth choices of the question
	 * @param point6 - point of the sixth answer
	 * @param answer7 - seventh choices of the question
	 * @param point7 - point of the seventh answer
	 * 
	 */
	public Question(String question, String answer1, int point1, String answer2, int point2, String answer3, int point3, 
			String answer4, int point4, String answer5, int point5, String answer6, int point6, String answer7, int point7) 
	{
		this.quesText = question;
		
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
	/**
	 * retrieve method to get the question in text
	 * 
	 * @return String question
	 */
	public String retrieveQues() {
		String txtQuestion;
		return txtQuestion = this.quesText;
	}
	/**
	 * retrieve method to get answer at location index
	 * 
	 * @param index - index of the answer array
	 * 
	 * @return String answer at the location of index
	 */
	public String retrieveAns(int index) {
		String value;
		value = this.answer[index];
		return value;
	}
	/**
	 * retrieve method to get point at location index
	 * 
	 * @param index - index of the point array
	 * 
	 * @return integer point at the location of index
	 */
	public int retrievePoint(int index) {
		int value;
		value = this.point[index];
		return value;
	}
	/**
	 * retrieve method to get the value in the boolean variable
	 * 
	 * @return boolean
	 */
	public boolean retrieveValue() {
		return this.index;
	}
	/**
	 * setter method to set the answer array
	 * 
	 * @param answer
	 */
	public void setAns(String[] answer) {
		for(int i=0;i<answer.length;i++) {
			this.answer[i] = answer[i];
		}
	}
	/**
	 * setter method to set the point array
	 * 
	 * @param index - index of point
	 * @param point - the value of point
	 */
	public void setPoint(int index, int point) {
		this.point[index] = point;
	}
	/**
	 * setter method to set the boolean to true
	 */
	public void setBoolean() {
		this.index = true;
	}
	/**
	 * toString method to return string value in assigned order
	 * 
	 * @return a string containing question, and all of the answer choices related to that question.
	 */
	public String toString() {
		String value = null;

		value = retrieveQues()+"\n   1. "+retrieveAns(0)+"\n   2. "+retrieveAns(1)+"\n   3. "+retrieveAns(2)
				+"\n   4. "+retrieveAns(3)+"\n   5. "+retrieveAns(4)+"\n   6. "+retrieveAns(5)+"\n   7. "+retrieveAns(6);
		return value;
	}
	
}
