import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
 
/* C9E3C9E3PasswordChecking.java requires no other files. */
 
public class C9E3PasswordChecking extends JPanel
                          implements ActionListener {
    private static String OK = "ok";
    private static String HELP = "help";
 
    private JFrame controllingFrame; //needed for dialogs
    private JPasswordField passwordField;
 
    public C9E3PasswordChecking(JFrame f) {
        //Use the default FlowLayout.
        controllingFrame = f;
 
        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);
 
        JLabel label = new JLabel("Enter the password: ");
        label.setLabelFor(passwordField);
 
        JComponent buttonPane = createButtonPanel();
 
        //Lay out everything.
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.add(label);
        textPane.add(passwordField);
 
        add(textPane);
        add(buttonPane);
    }
 
    protected JComponent createButtonPanel() {
        JPanel p = new JPanel(new GridLayout(0,1));
        JButton okButton = new JButton("OK");
        JButton helpButton = new JButton("Help");
 
        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);
 
        p.add(okButton);
        p.add(helpButton);
 
        return p;
    }
 
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
 
        if (OK.equals(cmd)) { //Process the password.
            char[] input = passwordField.getPassword();
            if (isPasswordCorrect(input)) {
                JOptionPane.showMessageDialog(controllingFrame,
                    "Success! You typed the eligible password.");
            } else {
                JOptionPane.showMessageDialog(controllingFrame,
                    "Invalid password. Try again.You can see the rule click the help button .",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            }
 
            //Zero out the possible password, for security.
            Arrays.fill(input, '0');
 
            passwordField.selectAll();
            resetFocus();
        } else { //The user has asked for help.
            JOptionPane.showMessageDialog(controllingFrame,
                "The password you entered must satisfy  three conditions :\n"
              + "must have at least eight characters.\n"
              + "consists of only letters and digits.\n"
              + "must contain at least two digits.");
        }
    }
 

    
    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
       
        if (input.length < 8) { 
        	 isCorrect = false;
		} else {	
	 		char c;
			int count = 0; 
			for (int i = 0; i < input.length - 1; i++) {
				c = input[i];
				if (!Character.isLetterOrDigit(c)) {		
					 isCorrect = false;
				} else if (Character.isDigit(c)) {
					count++;
					}	
				}
			if (count < 2 )	{	
				 isCorrect = false;
                       }
		}

        return isCorrect;
    }
     
    //Must be called from the event dispatch thread.
    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("C9E3PasswordChecking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        final C9E3PasswordChecking newContentPane = new C9E3PasswordChecking(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Make sure the focus goes to the right component
        //whenever the frame is initially given the focus.
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
            }
        });
    }
}