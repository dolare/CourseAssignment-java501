/*
Ruirui
Exercise6_20: 
SortNumbers
*/

import javax.swing.JOptionPane;
public class C6E20SortNumbers {
	  /** The main method */
  public static void main(String[] args) {
    // Initialize the list
	  boolean  bool = true;
	    double[] numbers = new double[10];
	    String[] numbersString = new String[10];
	    int i = 0;
	    String output = null;
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
	    selectionSort(numbers);  
	    output = numbers[0] + " " + numbers[1] + " " + numbers[2] + " " + numbers[3] + " " + numbers[4] + " " + numbers[5] + " " + numbers[6] + " " + numbers[7] + " " +numbers[8] + " " + numbers[9] + " " ; 
	    //display 
	    JOptionPane.showMessageDialog(null,"My list after sort is :\n " + output); 
  }

  /** The method for printing numbers */
  static void printList(double[] list) {
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + "  ");
    System.out.println();
  }

  /** The method for sorting the numbers */
  static void selectionSort(double[] list) {
    double currentMin;
    int currentMinIndex;

    for (int i = 0; i < list.length; i++) {
      // Find the smallest in the list[i..list.length-1]
      currentMin = list[i];
      currentMinIndex = i;

      for (int j = i + 1; j < list.length; j++) {
        if (currentMin > list[j]) {
          currentMin = list[j];
          currentMinIndex = j;
        }
      }

      // Swap list[i] with list[currentMinIndex] if necessary;
      if (currentMinIndex != i) {
        list[currentMinIndex] = list[i];
        list[i] = currentMin;
      }
    }
    
  }
  /** check input is a number */
  public static boolean check(String str){
	  try{
			Double.parseDouble(str);
		}catch(Exception e1){
			return false;
		}
	  return true;
  }
}
