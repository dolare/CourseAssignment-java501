/*
Ruirui
Exercise3_22: 
CheckPointInCircle
Include:check input \ ask guest input again \ ask execute again or exit
*/

import javax.swing.JOptionPane;

public class C3E22CheckPointInCircle {
	 /** Main method */
	  public static void main(String[] args) {

		  //loop for ask guest continue or exit the computing when end of determining
	while(true){
		// definite and initialization		
		boolean index = true; //judge the input by guest is correct or error 
		double x = 0;//intermediate variable 
		double y = 0; 
		double z = 0; 
			
		String  zString = null;//intermediate variable 
		String  output1 =null;
		String  output2 =null;
		
		//input six number for a b c d e f 
	for(int i = 1 ; i<=2 ; i++){
		while(true){			
			if(index){
				switch(i){
				case 1 : zString = JOptionPane.showInputDialog("Enter  x-coordinate of the point,for example 4.0");break;
				case 2 : zString = JOptionPane.showInputDialog("Enter  y-coordinate of the point,for example 5.0");break;
				}
			}
			// ask guest enter the number again 
			else{
				zString = JOptionPane.showInputDialog(null,"Error input , please enter a correct value  again");
			}
			
			index = true;
			
			//check whether the input is a number
			try{
				Double.parseDouble(zString);
			}catch(Exception e1){
				index = false;
			}
			
			// Convert string to double
			if(index){
				
				z = Double.parseDouble(zString);
				switch (i){
				case 1 : x = z; break;
				case 2 : y = z; break;
			    }
				
				break;
	       }
	   }		
	}		
		//computing the result 
		output1 = "Point ( " + x + " , " + y + ") is in the circle";
		output2 = "Point ( " + x + " , " + y + ") is not in the circle";
	    if( Math.sqrt(x*x + y*y) <= 10){ 
	    	JOptionPane.showMessageDialog(null,output1);
	    }
	    else {	    	
	    	JOptionPane.showMessageDialog(null,output2);
	    }
	    
	  //  ask guest continue or exit 
	  int option = JOptionPane.showConfirmDialog(null,"continue and begin a new determining?");
	  
	  // if guest say exit then exit
	  if (option != JOptionPane.YES_OPTION)
		  break;
	
     }		
   }	  
}
