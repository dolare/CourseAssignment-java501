import javax.swing.JOptionPane;


public class C9E4OccurrencesOfSpecifiedCharacter {
  public static void main(String[] args) {
    // Prompt the user to enter a string
    String sampleString = null;
    String sampleString1 = null;
    char sampleChar = 0;
    int option = JOptionPane.YES_OPTION;

    while(option == JOptionPane.YES_OPTION ){
    	sampleString = JOptionPane.showInputDialog("Enter a string: ");
    	while(option == JOptionPane.YES_OPTION){
    		sampleString1 = JOptionPane.showInputDialog("Enter a character you want to search: ");
    		sampleChar = sampleString1.charAt(0);
    		JOptionPane.showMessageDialog(null, "There are  " + count(sampleString,sampleChar) + " '" +  sampleChar  + "'  in the string : " + sampleString);
    		option = JOptionPane.showConfirmDialog(null, "Do you want to search another character?");
    	}
    	option = JOptionPane.showConfirmDialog(null, "Do you want to enter a new string ?");
    }
 
  }

  public static int count(String str, char ch) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ch) {
        count++;
      }
    }
    return count;
  }
}
