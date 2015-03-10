import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public final class C14E13CountOfFileContext{

public static void main(String[] args) throws IOException {
    //counters
    int charsCount = 0;
    int wordsCount = 0;
    int linesCount = 0;

    Scanner fileScanner = null;
    File selectedFile = null;
    JFileChooser chooser = new JFileChooser();
    // choose file 
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        selectedFile = chooser.getSelectedFile();
        fileScanner = new Scanner(selectedFile);         
    }

    while (fileScanner.hasNextLine()) {
      linesCount++;
      String line = fileScanner.nextLine();
      Scanner lineScanner = new Scanner(line);
     
     while(lineScanner.hasNext()) {
        wordsCount++;
        String word = lineScanner.next();
        charsCount += word.length();
      } 

     
    lineScanner.close();
  }

  
  JOptionPane.showMessageDialog(null , "count of chars: " + charsCount + " \n count of words: " + wordsCount + " \n count of lines: " + linesCount);


  fileScanner.close();
 }
}