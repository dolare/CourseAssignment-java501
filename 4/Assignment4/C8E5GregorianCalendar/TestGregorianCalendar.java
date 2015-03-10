import javax.swing.JOptionPane;
import java.util.GregorianCalendar;

public class TestGregorianCalendar {
	public static void main(String[] args){
		GregorianCalendar calendarCurrent = new GregorianCalendar();
		JOptionPane.showMessageDialog(null,"The current year is : " + calendarCurrent.get(GregorianCalendar.YEAR)
									  + "\n " + "The current month is : " + calendarCurrent.get(GregorianCalendar.MONTH)
										  + "\n " + "The current day is : " + calendarCurrent.get(GregorianCalendar.DAY_OF_MONTH)
										  + "\n ");
		
	
		calendarCurrent.setTimeInMillis(123456788765L);
		JOptionPane.showMessageDialog(null,"The year of SET TIME (123456788765L) is : " + calendarCurrent.get(GregorianCalendar.YEAR)
				  + "\n " + "The month of SET TIME (123456788765L) is : " + calendarCurrent.get(GregorianCalendar.MONTH)
					  + "\n " + "The day of SET TIME (123456788765L) is : " + calendarCurrent.get(GregorianCalendar.DAY_OF_MONTH)
					  + "\n ");
	}	
}
