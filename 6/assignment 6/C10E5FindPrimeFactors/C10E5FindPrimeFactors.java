import javax.swing.JOptionPane;
import java.util.HashSet;
import java.util.Random; 
import java.util.Scanner;
import java.util.Set;



public class C10E5FindPrimeFactors{
	  public static void main(String args[]) {
		  	StackOfIntegers stack = new StackOfIntegers();
		    int index = 1;
		    String intString = null;
		    int number = 0;
		    while(index == 1){
		    	try{
		    		 intString = JOptionPane.showInputDialog(
		    	 "Enter a positive integer:");
		    		 number = Integer.parseInt(intString);
		    		 if(number <= 0){
		    			 Exception e = new Exception();
		    			 throw e;
		    		 }
		    		index = 0;
		       }
		    	catch(Exception e){
		    		JOptionPane.showMessageDialog(null , " error enter please enter again");
		    	}
		    	
		   }
		    String factorString = null;
		   
		    // Convert string to int
		    
		    	
		    // Find all the smallest factors of the integer
		    int[] factorInt = new int[100];
		    int j = 0;
		    int factor = 2; 
		   
		    while(factor <= number) {
		    	if (number % factor == 0) {
		    		number = number / factor;
		    		System.out.println(factor);
		    		stack.push(factor);
		    		factorInt[j] = factor;
		    		j++;		
		      }
		      else factor++;
		    } 
		   
		    int i = 0;
		  
		    String[] factors;
		    factors = new String[j];
		    String[] factors1 = new String[j];
		     for(int z = 0; z < j; z ++){
		    	factors1[z] = factorInt[z] + " ";
		    }
		    while(!stack.empty()) {
			 
			    factors[i] = stack.pop() +" " ;
			    i++;
		   }
		  
		    JOptionPane.showMessageDialog(null, "the smallest factors : " + java.util.Arrays.toString(factors1));
		    JOptionPane.showMessageDialog(null,"these smallest factors have been arranged by StackOfInteger Class :\n " + java.util.Arrays.toString(factors));
	}	
	   
}

 
	
