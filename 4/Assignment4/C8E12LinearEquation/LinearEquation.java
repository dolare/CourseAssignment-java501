
import javax.swing.JOptionPane;

public class LinearEquation{
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	public LinearEquation(){
		
	}
	
	public void getA(double _a){
		a = _a;
	}
	public void getB(double _b){
		b = _b;
	}
	public void getC(double _c){
		c = _c;
	}
	public void getD(double _d){
		d = _d;
	}
	public void getE(double _e){
		e = _e;
	}
	public void getF(double _f){
		f = _f;
	}
	
	
	public boolean isSolvable(){
		if((a*d - b*c) != 0){
			return true;
		}
		else 
			return false;
	}
	
	public double getX(){
		double x = (e*d - b*f)/(a*d - b *c);
		return x;
	}
	public double getY(){
		double y = (a*f - e*c)/(a*d - b *c);
		return y;
	}
	
	
	
}