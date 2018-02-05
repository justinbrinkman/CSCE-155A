/*
 * Gradebook for CSCE 155A
 * This program helps users calculate what they need to get on the
 * final exam in order to reach thresholds for various grades.
 */

package Gradebook1;

import java.util.*;
import java.text.DecimalFormat;

public class Gradebook1 {
	public static void main(String[] args){
		final int TOTAL_POINTS = 2400;
		int homeworkPoints, labPoints, midtermPoints, prsPoints;
		int extraCreditPoints;
		int semesterPoints; //Sum of points earned before the final exam
		Scanner scanner = new Scanner(System.in);
		
		//Welcome
		System.out.println("Welcome to the CSCE 155A Grade Calculator!");
		System.out.println("You can calculate how many points you need"
				+ " on the final exam.");
		System.out.println();
	
		//Ask user to input points earned for each category
		System.out.print("Enter your total homework points (out of 600): ");
		homeworkPoints = scanner.nextInt();
		System.out.print("Enter your total lab points (out of 600): ");
		labPoints = scanner.nextInt();
		System.out.print("Enter your total midterm points (out of 600): ");
		midtermPoints = scanner.nextInt();
		System.out.print("Enter your total PRS exam points (out of 100): ");
		prsPoints = scanner.nextInt();
		System.out.print("Enter your total extra credit points (out of 250): ");
		extraCreditPoints = scanner.nextInt();
		semesterPoints = (homeworkPoints + labPoints + midtermPoints
				+ prsPoints + extraCreditPoints);
		System.out.println();
		
		//Declare decimal format to return 1 decimal place
		DecimalFormat df = new DecimalFormat("#.#");
		
		//Show user percentages for homework, labs, and exams
		System.out.println("Your total homework grade is "
				+ df.format(homeworkPoints / 6.0) + "%");
		System.out.println("Your total lab grade is "
				+ df.format(labPoints / 6.0) + "%");
		System.out.println("Your total exam grade is "
				+ df.format((midtermPoints + prsPoints) / 7.0) + "%");
		System.out.println();
		
		/* Calculate and print points needed to reach specific grade thresholds
		* This method of doing calculations within print statements was chosen 
		* to avoid defining new variables for each grade
		*/
		System.out.println("Points needed on final to get an A+: " 
				+ df.format(TOTAL_POINTS * 0.9667 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.9667 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get an A: " 
				+ df.format(TOTAL_POINTS * 0.9171 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.9171 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get an A-: " 
				+ df.format(TOTAL_POINTS * 0.9004 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.9004 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get a B+: " 
				+ df.format(TOTAL_POINTS * 0.8671 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.8671 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get a B: " 
				+ df.format(TOTAL_POINTS * 0.8171 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.8171 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get a B-: " 
				+ df.format(TOTAL_POINTS * 0.8004 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.8004 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get a C+: " 
				+ df.format(TOTAL_POINTS * 0.7671 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.7671 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get a C: " 
				+ df.format(TOTAL_POINTS * 0.7171 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.7171 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get a C-: " 
				+ df.format(TOTAL_POINTS * 0.7004 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.7004 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get a D+: " 
				+ df.format(TOTAL_POINTS * 0.6671 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.6671 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get a D: " 
				+ df.format(TOTAL_POINTS * 0.6171 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.6171 - semesterPoints)/4.0) + "%");
		
		System.out.println("Points needed on final to get a D-: " 
				+ df.format(TOTAL_POINTS * 0.6004 - semesterPoints) + " points, or "
				+ df.format((TOTAL_POINTS * 0.6004 - semesterPoints)/4.0) + "%");
		
		System.out.println("Anything below " + df.format(TOTAL_POINTS * 0.6004 -
				semesterPoints) + " points or " + df.format((TOTAL_POINTS * 0.6004 
						- semesterPoints)/4.0) + "% will result in an F");
		
		//Say good luck
		System.out.println();
		System.out.println("Good luck!");
		
		scanner.close();
}
}