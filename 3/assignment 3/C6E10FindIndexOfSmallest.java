/*
Ruirui
Exercise6_10: 
FindIndexOfSmallest
*/
import javax.swing.JOptionPane;

public class C6E10FindIndexOfSmallest {
  public static void main(String[] args) {
	//define values 
	boolean  bool = true;
    double[] numbers = new double[10];
    String[] numbersString = new String[10];
    int i = 0;
    int minNumbersIndex = 0;
    double minNumber = 0;
    // ask guest enter numbers 
    JOptionPane.showMessageDialog(null,"Please enter ten numbers one by one ");
    numbersString [i] = JOptionPane.showInputDialog("Please input the first number");
    bool = check(numbersString [i]);
    while(bool == false){
    	numbersString [i] = JOptionPane.showInputDialog("Error input , please enter a number again ");
    	 bool = check(numbersString [i]);
    }
  
    numbers [i] = Double.parseDouble(numbersString[i]);
    i++;
    for ( ;i<=9; i++){
    	numbersString [i] = JOptionPane.showInputDialog("Please enter the next number");
    	 bool = check(numbersString [i]);
    	    while(bool == false){
    	    	numbersString [i] = JOptionPane.showInputDialog("Error input , please enter a number again ");
    	    	 bool = check(numbersString [i]);
    	    }
    	numbers [i] = Double.parseDouble(numbersString[i]);
    }
    //display 
    minNumbersIndex = indexOfSmallestElement(numbers);
    minNumber = min(numbers);
    JOptionPane.showMessageDialog(null,"The smallest element is  " + minNumber + ". \n The index of smallest element is " + minNumbersIndex + " .");
  }
  
  
  
  //get the index of the smallest number
  public static int indexOfSmallestElement(double[] list) {
    double min = list[0];
    int minIndex = 0;

    for (int i = 1; i < list.length; i++)
      if (min > list[i]) {
        min = list[i];
        minIndex = i;
      }
    return minIndex;
  }
  
 //get the smallest number 
  public static double min(double[] list){
	  double min = list[0];
	  
	    for (int i = 1; i < list.length; i++)
	      if (min > list[i]) {
	        min = list[i];
	      }
	  return min;
  }
  
  //Check the input is a number
  public static boolean check(String str){
	  try{
			Double.parseDouble(str);
		}catch(Exception e1){
			return false;
		}
	  return true;
  }
  
}
