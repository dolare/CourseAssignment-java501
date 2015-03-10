//Ruirui      for assignment 1    6/3/2014

import javax.swing.JOptionPane;

public class C2E4ConvertPoundsIntoKilograms {
  public static void main(String[] args) {
	  
    // Prompt the input
    String poundString = JOptionPane.showInputDialog(null,
      "Enter a number in pound:",
      "Exercise2_4 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    double pound = Double.parseDouble(poundString);
    double kilogram = pound * 0.454;

    String output="It is " + kilogram + " kilograms";
    
    System.out.println("It is " + kilogram + " kilograms");

    JOptionPane.showMessageDialog(null , output);
    		
    System.exit(0);
    
  }
}
