import javax.swing.JOptionPane;


public class C10E4TestThePoint{
  public static void main(String[] args) {
	String s1 = "";
	double x1 = 0;
	double y1 = 0;
	double x2 = 0;
	double y2 = 0;
	int x = 0;
	int y = 0;
	int z = 0;
	int o = 0;
			
	while(x == 0){
		try{
			s1 = JOptionPane.showInputDialog("Enter the x-coordinates of first point ");
			x1 = Double.parseDouble(s1);
			x = 1;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"error input,please enter again");
		}
	}
	
	while(y == 0){
		try{
			s1 = JOptionPane.showInputDialog("Enter the y-coordinates of first point ");
			y1 = Double.parseDouble(s1);
			y = 1;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"error input,please enter again");
		}
	}
	
	while(z == 0){
		try{
			s1 = JOptionPane.showInputDialog("Enter the x-coordinates of second point ");
			x2 = Double.parseDouble(s1);
			z = 1;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"error input,please enter again");
		}
	}
	while(o == 0){
		try{
			s1 = JOptionPane.showInputDialog("Enter the y-coordinates of second point ");
			y2 = Double.parseDouble(s1);
			o = 1;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"error input,please enter again");
		}
	}
	
    MyPoint p1 = new MyPoint(x1,y1);
    MyPoint p2 = new MyPoint(x2,y2);
    double output1 = Math.rint(p1.distance(p2)*100)/100.00;
    double output2 = Math.rint(MyPoint.distance(p1, p2)*100)/100.00;
    JOptionPane.showMessageDialog(null,"the distance catched by distance(MyPoint secondPoint) method is :" + output1);
    JOptionPane.showMessageDialog(null,"the distance catched by distance(MyPoint p1, MyPoint p2) method is :" + output2);
    
    System.out.println(MyPoint.distance(p1, p2));
  }
}

