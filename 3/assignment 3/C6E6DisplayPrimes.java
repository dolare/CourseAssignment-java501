/*
Ruirui
Exercise6_6: 
DisplayPrimes
*/

import javax.swing.JOptionPane;

import java.util.Arrays;

public class C6E6DisplayPrimes {
	  
	 /** Main method */
	  public static void main(String[] args) {
	    final int NUM_OF_PRIMES = 50;
	    // Store prime numbers
	    int[] primeNumbers = new int[NUM_OF_PRIMES];
	    String[] list = new String [100];
	    int count = 0; // Count the number of prime numbers
	    int number = 2; // A number to be tested for primeness
	    int j = 0;
	    boolean isPrime = true; // Is the current number prime?

	    System.out.println("The first 50 prime numbers are \n");

	    // Repeatedly find prime numbers
	    while (count < NUM_OF_PRIMES) {
	      // Assume the number is prime
	      isPrime = true;

	      // Exercise03_21 if number is prime
	      for (int i = 0; i < count &&
	        primeNumbers[i] <= Math.sqrt(number); i++) {
	        //If true, the number is not prime
	        if (number % primeNumbers[i] == 0) {
	          // Set isPrime to false, if the number is not prime
	          isPrime = false;
	          break; // Exit the for loop
	        }
	      }

	      // Print the prime number and increase the count
	      if (isPrime) {
	        primeNumbers[count] = number;
	        count++; // Increase the count
	       

	        if (count % 10 == 0) {
	          // Print the number and advance to the new line
	          System.out.println(number);
	          list[j] =primeNumbers[count - 10 ] + " " + primeNumbers[count - 9] + " "+ primeNumbers[count - 8] + " "+  primeNumbers[count - 7] + " "+ primeNumbers[count - 6] + " "+ primeNumbers[count - 5] + " "+ primeNumbers[count - 4] + " "+ primeNumbers[count - 3] + " "+  primeNumbers[count - 2] +" "+  primeNumbers[count - 1] + ""; 
	          j++;
	        }
	        else
	          System.out.print(number + "\t");
	      }

	      // Check if the next number is prime
	      number++;
	    }
	    JOptionPane.showMessageDialog(null , list);
	  }
}

