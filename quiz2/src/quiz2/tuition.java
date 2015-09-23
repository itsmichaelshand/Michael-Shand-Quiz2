//Michael Shand
//CISC181 7p.m
//9/22/2015

package quiz2;

//everything i needed to be imported for this project
import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;
import java.text.DecimalFormat;

public class tuition {

	// this is the initialization of all the variables

	// the first two were never used, but could have been so i left them in
	private int yearsInSchool = 4;
	private int monthsInYear = 12;
	private int initialTuition;
	private double tuitionIncrease;
	private double APR;
	private int term;
	
	private double fullTuition;
	private double monthlyPay;

	 

	// the main method
	public static void main(String[] args) {
		// this is used so that i can call non-static methods in a static method
		tuition str = new tuition();
		// calls the method that created all the variables
		str.allVariables();
		// calls the method that creates the monthlyPay
		str.monthly();
		// calls the method that creates the fullTuition
		str.tuitionFourYears();

	}
	
	//this is my no-args constructor
	public tuition(){
	}
	
	//this is the constructor for tuition
	 public tuition(int initialTuition, double tuitionIncrease, double APR,int term){ 
		  this.initialTuition = initialTuition; 
		  this. tuitionIncrease = tuitionIncrease; 
		  this.APR = APR; 
		  this.term = term; }


	// this is the method i created to get all the inputs from the user
	public void allVariables() {
		// creates the scanner
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your initial tuition cost?");
		this.initialTuition = scan.nextInt();
		// sets the value of that question to the variable

		System.out.println("What is your Percentage increase of tuition each year(in decimal form)?");
		this.tuitionIncrease = scan.nextDouble();
		// sets the value of that question to the variable

		System.out.println("What is your APR(Annual Percentage Rate) after graduating? as a decimal");
		this.APR = scan.nextDouble();
		// sets the value of that question to the variable

		System.out.println("How many years do you want it to take you to pay back your load?");
		this.term = scan.nextInt();
		// sets the value of that question to the variable

		// closes the scanner
		scan.close();
	}

	// this is the method to get the tuition after four years
	public double tuitionFourYears() {
		// I made four different variables to keep track of the years and the
		// interest
		// I found this easier than to instead make a loop
		double yearOne = (this.getInitialTuition()) + (this.getInitialTuition() * this.getTuitionIncrease());
		double yearTwo = (yearOne) + (yearOne * this.getTuitionIncrease() + (this.getInitialTuition()));
		double yearThree = (yearTwo) + (yearTwo * this.getTuitionIncrease() + (this.getInitialTuition()));
		double yearFour = (yearThree) + (yearThree * this.getTuitionIncrease() + (this.getInitialTuition()));
		fullTuition = yearFour;
		// rounds the number to two decimal places by making the number a string
		// rounds so that the number is readable and testable
		DecimalFormat df = new DecimalFormat("#.##");
		String s = df.format(fullTuition);
		// converts the string of s back to a double
		fullTuition = Double.parseDouble(s);
		
		//displays your total tuition
		System.out.println("Total tuition cost" + fullTuition);

		return fullTuition;
	}

	// the method that creates the monthlyPay method
	// this shows how much money you should pay back each month to pay your /n
	// full loan back in your time frame given
	public double monthly() {
		/*
		 * FinanceLib
		 * double r - rate
		 * double n - number of payments
		 * double p - present value
		 * double f - future value
		 * boolean t - type
		 */
		double r = this.getAPR() / 12;
		double n = this.getTerm() * 12;
		double p = 0;
		double f = this.getFullTuition();
		boolean t = false;

		this.monthlyPay = -1 * FinanceLib.pmt(r,  n, p, f, t);
		// rounds the number to two decimal places by making the number a string
		DecimalFormat df = new DecimalFormat("#.##");
		String s = df.format(this.monthlyPay);
		
		// converts the string of s back to a double
		this.monthlyPay = Double.parseDouble(s);
		
		//displays the monthly cost to pay back your load
		System.out.println("You should pay " + monthlyPay + " per month"); // not displaying correctly
		
		return this.monthlyPay;
	}

	//getter for the variable fullTuition
	public double getFullTuition() {
		return fullTuition;
	}

	//getter for the variable monthlyPay
	public double getMonthlyPay() {
		return monthlyPay;
	}

	// getter for the variable tuitionIncrease
	public double getTuitionIncrease() {
		return tuitionIncrease;
	}

	// getter for the variable initialTuition
	public int getInitialTuition() {
		return initialTuition;
	}

	// getter for the variable APR
	public double getAPR() {
		return APR;
	}

	// getter for the variable term
	public int getTerm() {
		return term;
	}

	
}
