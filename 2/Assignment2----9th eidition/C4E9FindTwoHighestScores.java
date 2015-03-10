/*
Ruirui
Exercise4_9: 
FindTwoHighestScores
Include:check input \ ask guest input again \ ask execute again or exit
*/

import javax.swing.JOptionPane;


public class C4E9FindTwoHighestScores {
	  int option1 = 0;
	 /** Check input */
	  public static boolean checkInput(String str){
		  try{
				Double.parseDouble(str);
			}catch(Exception e1){
				return false;
			}
		  return true;
	  }
	  
	 /** enter studentNumber */
	public static int enterStudentNumber(){
		double studentNumber = 0 ;
		String studentNumberString = JOptionPane.showInputDialog("Enter student's number ");
		while(true){
			if(checkInput(studentNumberString)){	
				studentNumber = Double.parseDouble(studentNumberString);
				break;
				   }	
			else {
				studentNumberString = JOptionPane.showInputDialog(null,"Error input , please enter a correct value  again");
		    }
		}
		return  (int)studentNumber;
	  }
	
	/** enter studentName */
	public static String enterStudentName(){
		String studentName = JOptionPane.showInputDialog("Enter this student's name (for example ruirui)");
		return studentName;
	  }
	
	/** enter studentScore */
	public static double enterStudentScore(){
		double studentScore = 0;
		String studentScoreString = JOptionPane.showInputDialog("Enter this studet's score (0 - 100)");
		while(true){
			if(checkInput(studentScoreString)){	
				studentScore = Double.parseDouble(studentScoreString);
					if(studentScore >= 0 && studentScore <= 100){
						break;
					}
					else {
						studentScoreString = JOptionPane.showInputDialog(null,"Error input , please enter a correct value (0-100) again ");
			        }
			}		
			else {
				studentScoreString = JOptionPane.showInputDialog(null,"Error input , please enter a correct value (0-100) again ");
	       }
	    }
		return studentScore;
	  }
		
	
	  
	 /** Main method */
	  public static void main(String[] args) {
		
		//initialization variable
		int option = 0;
		int studentNumber1 = 0;
		int studentNumber2 = 0;
		int studentNumber3 = 0;
		int studentNumberTemp = 0;
		double studentScore1 = 0; 
		double studentScore2 = 0; 
		double studentScore3 = 0;
		double studentScoreTemp = 0;
		String studentName1 = null;
		String studentName2 = null;
		String studentName3 = null;
		String studentNameTemp = null;
		
	
		
		String  output1 =null;
		String  output2 =null;
		
		while(true){
			//get infomations
			studentNumber1 = enterStudentNumber();
			studentName1 = enterStudentName();
			studentScore1 = enterStudentScore();
			
			studentNumber2 = enterStudentNumber();
			studentName2 = enterStudentName();
			studentScore2 = enterStudentScore();
			
			//exchange 1 and 2
			if(studentScore1 <= studentScore2){
				studentScoreTemp = studentScore2;
				studentScore2 = studentScore1;
				studentScore1 = studentScoreTemp;
				studentNameTemp = studentName2;
				studentName2 = studentName1;
				studentName1 = studentNameTemp;
				studentNumberTemp = studentNumber2;
				studentNumber2 = studentNumber1;
				studentNumber1 = studentNumberTemp;
			}
			
		        while(true){
		        	//whether input a new student's information
		        	option = JOptionPane.showConfirmDialog(null,"Do you want to enter a new student's information?");
		        	if(option == JOptionPane.YES_OPTION){
		        		studentNumber3 = enterStudentNumber();
		        		studentName3 = enterStudentName();
		        		studentScore3 = enterStudentScore();
		        		//get  highest  and second-highest scores
		        		if(studentScore3 > studentScore2 && studentScore3 < studentScore1){
		        			studentScoreTemp = studentScore2;
		        			studentScore2 = studentScore3;
		        			studentScore3 = studentScoreTemp;
		        			studentNameTemp = studentName2;
		        			studentName2 = studentName3;
		        			studentName3 = studentNameTemp;
		        			studentNumberTemp = studentNumber2;
		        			studentNumber2 = studentNumber3;
		        			studentNumber3 = studentNumberTemp;
		        		}
		        		else if(studentScore3 > studentScore1){
		        			studentScoreTemp = studentScore2;
		    				studentScore2 = studentScore1;
		    				studentScore1 = studentScoreTemp;
		    				studentNameTemp = studentName2;
		    				studentName2 = studentName1;
		    				studentName1 = studentNameTemp;
		    				studentNumberTemp = studentNumber2;
		    				studentNumber2 = studentNumber1;
		    				studentNumber1 = studentNumberTemp;
		    			
		        			studentScoreTemp = studentScore1;
		        			studentScore1 = studentScore3;
		        			studentScore3 = studentScoreTemp;
		        			studentNameTemp = studentName1;
		        			studentName1 = studentName3;
		        			studentName3 = studentNameTemp;
		        			studentNumberTemp = studentNumber1;
		        			studentNumber1 = studentNumber3;
		        			studentNumber3 = studentNumberTemp;
				        }
		        	
				    }
		        	else if(option != JOptionPane.YES_OPTION){
		        		break;
		        	}
		        }	
		        output1 = "The highest score is  " + studentScore1 + " ,student's number is  " + studentNumber1 + "  and student's name is " + studentName1 + ". \n " ;
				output2 = "The second-highest score is " + studentScore2 + " ,student's number is  " + studentNumber2 + "  and student's name is  " + studentName2;
				JOptionPane.showMessageDialog(null,output1 + output2);
				
				//  ask guest continue or exit 
				option = JOptionPane.showConfirmDialog(null,"continue and begin a new program to get highest score and second-highest score?");
	  
				// if guest say exit then exit
				if (option != JOptionPane.YES_OPTION)
					break;
		   }
	  }
}

