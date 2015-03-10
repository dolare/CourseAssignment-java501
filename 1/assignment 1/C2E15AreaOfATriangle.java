/*  Ruirui   
	for assingment1    
	6/3/2014 */

import java.util.Scanner;

public class C2E15AreaOfATriangle {
	public static void main(String [] args){
		
		//Enter three points for a triangle :
		Scanner input = new Scanner (System.in);
		
		System.out.print("Enter three points for a triangle: (for example 1.5 -3.4 4.6 5 9.5 -3.4)");
		
		//define some variables and some operation
		double points1_x = input.nextDouble();
		double points1_y = input.nextDouble();
		double points2_x = input.nextDouble();
		double points2_y = input.nextDouble();
		double points3_x = input.nextDouble();
		double points3_y = input.nextDouble();
		
		double side1 = Math.sqrt(( points1_y - points2_y)*( points1_y - points2_y)+( points1_x - points2_x)*( points1_x - points2_x));
		double side2 = Math.sqrt(( points2_y - points3_y)*( points2_y - points3_y)+( points2_x - points3_x)*( points2_x - points3_x));
		double side3 = Math.sqrt(( points1_y - points3_y)*( points1_y - points3_y)+( points1_x - points3_x)*( points1_x - points3_x));
		
		double s = ( side1 + side2 + side3 ) / 2;
		
		double area = Math.sqrt(Math.abs( s * (s - side1) * (s - side2) * (s - side3)));
		
		//rounding 
		double areaValue = Math.rint(area * 10)/10.0;
		
		//display the result
		System.out.println("The area of triangle is " + areaValue);
		
		input.close();
		System.exit(0);
		
	}
}
