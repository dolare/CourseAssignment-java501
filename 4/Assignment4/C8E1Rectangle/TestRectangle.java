
import javax.swing.JOptionPane;

public class TestRectangle {
	

	public static void main(String[] args) {
		run();
    }     
	

	public static void run(){
		
		String _heightString = null;
		String _widthString = null;
		int x = 1;
		int y = 1;
		
		
		Rectangle r1 = new Rectangle();
		do{
		_widthString = JOptionPane.showInputDialog("Enter the width of rectangle (for example 4.0)");
		try{
			r1.setWidth(Double.parseDouble(_widthString));
			x++;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Invalid numeber of width : the number you enter should be > 0");
		}
		}while(x == 1);
		
		do{
			_heightString = JOptionPane.showInputDialog("Enter the height of rectangle (for example 4.0)");
			try{
				r1.setHeight(Double.parseDouble(_heightString));
				y++;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Invalid numeber of height : the number you enter should be > 0");
			}
			}while(y == 1);
				
		
		
		JOptionPane.showMessageDialog(null , "The area and perimeter of the rectangle of width " 
										+ r1.width + " and height " + r1.height + 
										"\n" + " are " + r1.getArea() + " and " + r1.getPerimeter());
		
	}
	

}
