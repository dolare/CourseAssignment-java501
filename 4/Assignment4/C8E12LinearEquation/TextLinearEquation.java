import javax.swing.JOptionPane;


public class TextLinearEquation {
	public static void main(String[] args){
		String stringA = null;
		stringA = JOptionPane.showInputDialog("Please Enter the values of x1");
		double x1 = Double.parseDouble(stringA);
		
		
		stringA = JOptionPane.showInputDialog("Please Enter the values of y1");
		double y1 = Double.parseDouble(stringA);
		
		
		stringA = JOptionPane.showInputDialog("Please Enter the values of x2");
		double x2 = Double.parseDouble(stringA);
		
		
		stringA = JOptionPane.showInputDialog("Please Enter the values of y2");
		double y2 = Double.parseDouble(stringA);
		
		
		stringA = JOptionPane.showInputDialog("Please Enter the values of x3");
		double x3 = Double.parseDouble(stringA);
		
		
		stringA = JOptionPane.showInputDialog("Please Enter the values of y3");
		double y3 = Double.parseDouble(stringA);
		
		
		stringA = JOptionPane.showInputDialog("Please Enter the values of x4");
		double x4 = Double.parseDouble(stringA);
		
		stringA = JOptionPane.showInputDialog("Please Enter the values of y4");
		double y4 = Double.parseDouble(stringA);
		
		LinearEquation linearEquation1 = new LinearEquation();
		linearEquation1.getA(y1 - y2);
		linearEquation1.getB(x2 - x1);
		linearEquation1.getC(y3 - y4);
		linearEquation1.getD(x4 - x3);
		linearEquation1.getE(-y1 * (x1 - x2) + (y1 - y2 ) * x1);
		linearEquation1.getF(-y3 * (x3 - x4) + (y3 - y4 ) * x3);
		
		linearEquation1.getX();
		linearEquation1.getY();
		
		if(linearEquation1.isSolvable()){
			JOptionPane.showMessageDialog(null, "The intersection point is : " + "("+ linearEquation1.getX() 
										+ ", " + linearEquation1.getY() + " )");
		}
		else {
			JOptionPane.showMessageDialog(null, "There is no intersection point");
		}
	}
}
