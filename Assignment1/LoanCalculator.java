/*Course Name: CMSC 203
  Course Number:
  Assignment1_Fall2019
  Program Description: program that calculates monthly payment for a loan.
  Due date: September 18, 2019
  Stephanie UMUTONI
 */

import java.util.Scanner;
import java.lang.Math;
//
public class LoanCalculator {

	public static void main(String[] args) {
		double loan, interest_rate, monthly_payment, numerator, denominator, sub_numerator, power;
		 
		int numberOfPayments;

		//Display of program title
		System.out.println("LOAN CALCULATOR");
		System.out.println(" ");

		//Prompts for user to enter requested values
		System.out.print("Please enter the amount of your loan: ");
		Scanner input = new Scanner(System.in);
		loan = input.nextFloat();

		System.out.print("Please enter your interest rate: ");
		interest_rate = input.nextFloat();
		
		System.out.print("How many payments will you be making (number of payments): ");
		numberOfPayments = input.nextInt();
		
		// divide the formula into 4 parts to make it easier to calculate
		numerator= (interest_rate/100)/12;
		sub_numerator= 1+ numerator;
		power=Math.pow(sub_numerator, -numberOfPayments);
		denominator=1-power;
		
		//apply above results to get monthly payment
		monthly_payment= loan*(numerator/denominator);
		System.out.println(" ");
		System.out.println("Your monthly payment for this loan will be: "+monthly_payment);

	}

}