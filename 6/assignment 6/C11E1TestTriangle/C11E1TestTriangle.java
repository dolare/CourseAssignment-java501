
import javax.swing.JOptionPane;

public class C11E1TestTriangle {
	

	public static void main(String[] args) {
		
		String tempString;
		double side1 = 0;
		double side2 = 0;
		double side3 = 0;
		int y = 0;
		while(y == 0){
			
		
			int x1 = 0;
			while(x1 == 0){
				try{
					tempString = JOptionPane.showInputDialog("Enter length the first side   ");
					side1 = Double.parseDouble(tempString);
					if(side1 <= 0){
						Exception e = new Exception();
						throw e;
					}
					x1 = 1;
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, " Error input, plesae enter again ");
				}
			}
			
			int x2 = 0;
			while(x2 == 0){
				try{
					tempString = JOptionPane.showInputDialog("  Enter length the second side ");
					side2 = Double.parseDouble(tempString);
					if(side2 <= 0){
						Exception e = new Exception();
						throw e;
					}
					x2 = 1;
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, " Error input, plesae enter again ");
				}
			}
			
			int x3 = 0;
			while(x3 == 0){
				try{
					tempString = JOptionPane.showInputDialog("  Enter length the third side ");
					side3 = Double.parseDouble(tempString);
					if(side3 <= 0){
						Exception e = new Exception();
						throw e;
					}
					x3 = 1;
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, " Error input, plesae enter again ");
				}
			}
			
			if(((side1 + side2) > side3)&&((side2 + side3) > side1)&&((side1 + side3) > side2)){
				y = 1;
			}
			else JOptionPane.showMessageDialog(null,"the sum of two sides must more than the third size");
		}
		
			
	
		

		String color = null;
		color = JOptionPane.showInputDialog(" enter the color of Triangle ");
		int option;
		String filled = null;
		option = JOptionPane.showConfirmDialog(null, "Is the Triangle filled?");
		if(option == JOptionPane.YES_OPTION){
			filled = "the Triangle  is filled";
		}
		else filled = "the Triangle is not filled";

		System.out
				.println(" Is the Triangle filled? Reply with 'True' or 'False' ");


		Triangle triangle = new Triangle(side1, side2, side3);

		// set color of Triangle
		triangle.setColor(color);
		if (filled.equals("the Triangle  is filled")) {
			triangle.setFilled(true);

		} else {
			triangle.setFilled(false);

		}
		JOptionPane.showMessageDialog(null,"The Triangle Sides are \n side 1: "
				+ triangle.getSide1() + "\n Side 2: " + triangle.getSide2()
				+ "\n Side 3: " + triangle.getSide3());
		
		JOptionPane.showMessageDialog(null,"The Triangle's Area is " + triangle.getArea());
	
		JOptionPane.showMessageDialog(null,"The Triangle's Perimeter is "
				+ triangle.getPerimeter());
		

		JOptionPane.showMessageDialog(null,"The Triangle's Color is " + triangle.getColor());

		JOptionPane.showMessageDialog(null,"Is the Triangle filled? " + triangle.isFilled());


	}

}