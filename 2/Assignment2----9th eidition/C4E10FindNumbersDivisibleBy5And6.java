/*
Ruirui
Exercise4_10: 
FindNumbersDivisibleBy5And6 
*/

import javax.swing.JOptionPane;
import java.util.Arrays;

public class C4E10FindNumbersDivisibleBy5And6 {
	  
	 /** Main method */
	  public static void main(String[] args) {	  
		  String [ ] listDivisibleBy5And6 = new String[1000];
		  int [ ] list = new int[1000];
		  int j = 0 ;
		  int k = 0 ;
		  for(int i = 100; i <= 1000; i++ ){
			  if((i % 6 ==0) && (i % 5 == 0)){  
				  list [j] = i ;
				  	if(j == 9){
			  		listDivisibleBy5And6[k] = list [0] + " " + list [1] + " "+ list [2] + " "+  list [3] + " "+ list [4] + " "+ list [5] + " "+ list [6] + " "+ list [7] + " "+  list [8] +" "+  list [9]+ "";
			  		j = -1;
			  		k++;	
				  	}
				  j++; 			 
			  } 
		 }
		  JOptionPane.showMessageDialog(null,listDivisibleBy5And6); 
	}
}

