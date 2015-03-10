/*  Ruirui   
	for assingment1    
	6/3/2014 */

import javax.swing.JOptionPane;

public class C2E21FCalculateFutureInvestmentValue {
	public static void main(String [] args){
		
		//Enter investment amount
		String investmentAmountString = JOptionPane.showInputDialog("Enter inverstment amount: (for example 1000)");
		
		//convert string to double
		double investmentAmount = Double.parseDouble(investmentAmountString);
		
		//Enter annual interest rate in percentage
		String annualInterestRateString = JOptionPane.showInputDialog("Enter annual interest rate in percentage : (for example 4.25)");
		
		//convert string to double
		double annualInterestRate = Double.parseDouble(annualInterestRateString);
		
		//Obtain monthly interest rate in percentage
		double monthlyInterestRate = annualInterestRate / 1200;
		
		//Enter number of year
		String numberOfYearsString = JOptionPane.showInputDialog("Enter number of year: (for example 1)");
				
		//convert string to double
		double numberOfYears = Double.parseDouble(numberOfYearsString);
		
		//calculate the future investment value
		double futureInvestmnetValue = investmentAmount *  Math.pow (1 + monthlyInterestRate, numberOfYears * 12) ;
		
		//math.rint rouding off
		double finalValue = Math.rint(   futureInvestmnetValue * 100  ) / 100.00;
		
			
				
		//convert the result and creat output
		String output = "Accumulated value is $ " + finalValue ;

		
		//display results 
		
		JOptionPane.showMessageDialog( null , output );
		
	}
}
