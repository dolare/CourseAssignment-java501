import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

public class SudokuPuzzle
{
	Generator gen=new Generator();
	static Grid g[]=new Grid[81];
	final String help="Made By Ruirui Yin"+'\n'+"operational approach:"+'\n'+"1.Firstly, Click 'start' button,select he corresponding difficulty or open txt file to load the puzzle."
			+ "；"+'\n'+"2.when the puzzle begins,click the left mouse button in a blank zone to choose a number you want,then click the right mouse button in the same blank zone to fill the number."
			+'\n'+"3.If you have filled all the blank zones you can click 'check' button to check whether you solution is correct."
			+'\n'+"4.If you cant get a right answer ,you can click 'solution1' button to see how many solutions the puzzle has and the solution sample 1."
			+'\n'+"5.If you want to see another solution,you also can click 'solution2' button to see solution sample 2 if it exists."
			+'\n'+"6.Finally,if the interface crashed,please close the interface and execute program again.";
	JMenuBar jmb=new JMenuBar();
	JMenu start=new JMenu("Start");
	JMenuItem check=new JMenuItem("Check");
	JMenuItem nandu1=new JMenuItem("Hard Level");
	JMenuItem nandu2=new JMenuItem("Normal Level");
	JMenuItem nandu3=new JMenuItem("Easy Level");
	JMenuItem nandu4=new JMenuItem("Get a puzzle from txt file");
	JMenuItem mhelp=new JMenuItem("Help");
	JMenuItem GS=new JMenuItem("solution1");
	JMenuItem NS=new JMenuItem("Solution2");
	//JMenuItem inputFile=new JMenuItem("Start from File");
	int solutionNum = 0;
	
	 static int solution1[][]=new int[9][9];
	 static int solution2[][]=new int[9][9];
	 
	 static void GetSolution(int[][] solution){
		 solution1 = solution;
	 }
	 int temp[][] = new int[9][9];
	
	JFrame frame=new JFrame("SudokuPuzzle Puzzle");
	class Grid
	{
		//有关元素
		int x;
		int y;
		PopMenu pm;
		JLabel cb;
		final String chooser[]={"   ","1","2","3","4","5","6","7","8","9"};
		int index;		//所选的东西；	
		int editable;
		//各种类定义
		class PopMenu
		{
			JPopupMenu pop;
			JRadioButtonMenuItem radio[];
			ButtonGroup bg;
			PopMenu(int a)
			{
				pop=new JPopupMenu();
				RadioListener rl=new RadioListener();
				bg=new ButtonGroup();
				radio=new JRadioButtonMenuItem[10];
				radio[0]=new JRadioButtonMenuItem(" ");
				radio[0].addActionListener(rl);
				radio[0].setMnemonic(KeyEvent.VK_0);
				radio[0].setEnabled(true);
				bg.add(radio[0]);
				pop.add(radio[0]);
				for (int i=1; i<10 ; i++)
				{
					radio[i]=new JRadioButtonMenuItem(new Integer(i).toString());
					radio[i].addActionListener(rl);
					radio[i].setMnemonic(KeyEvent.VK_0+i);
					bg.add(radio[i]);
					pop.add(radio[i]);
				}
				radio[a].setSelected(true);
			}
			
		}
		
		class RadioListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				for (int i=0; i<10 ; i++)
					if (pm.radio[i].isSelected())
					{
						index=i; break;
					}
				
			}
		}
		
		class MyListener extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				if (editable==1)
				if (e.getButton()==MouseEvent.BUTTON1)
				{
					pm.pop.setLocation(e.getXOnScreen(), e.getYOnScreen());
					pm.pop.setVisible(true);
					pm.pop.setEnabled(true);
				}
				else if (e.getButton()==MouseEvent.BUTTON3)
				{
					pm.pop.setVisible(false);
					cb.setText(chooser[index]);
					gen.ini[x][y]=index;
					
				}
			}
		}
		
		//各种方法
		Grid(int a)
		{
			editable=1;
			index=a;
			cb=new JLabel(chooser[a]);
			pm=new PopMenu(index);
			MyListener l=new MyListener();
			cb.addMouseListener(l);
			cb.setBorder(BorderFactory.createCompoundBorder( BorderFactory.createLineBorder(Color.black),BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			cb.setBounds(1, 1, 1, 1);
		}
		void set(int a)
		{
			index=a;
			cb.setText(chooser[a]);
		}
		int get()
		{
			return index;
		}
		void seteditable(int a)
		{
			editable=a;
			if (a==0)
				cb.setForeground(Color.red);
			if (a==1)
				cb.setForeground(Color.black);
		}
	}
	
	
	class CheckListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(gen.check())
			{
				JOptionPane.showMessageDialog(frame, "Congratulation,you get a Correct Solution", "check", JOptionPane.OK_OPTION);
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "Wrong,please check your answer ", "check", JOptionPane.OK_OPTION);
			}
		}
	}
	
	
	class NanduListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource()==nandu1)
				go(3);
			if (e.getSource()==nandu2)
				go(4);
			if (e.getSource()==nandu3)
				go(5);
			if (e.getSource()==nandu4)
				go(1);
		}
	}
	
	
	class HelpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, help,"Help",JOptionPane.OK_OPTION);
		}
	}
	
	class  GSListener implements ActionListener
	{
		public  void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, " The puzzle has  " + search(gen.ini,0) + "  solutions.","Number of sulutions",JOptionPane.OK_OPTION);
			search(gen.ini,1);
			
		}
	}
	class NSListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(search(gen.ini,0 ) == 1||search(gen.ini,0 ) == 0){
				JOptionPane.showMessageDialog(frame, " No more solutions " ,"Second of sulutions",JOptionPane.OK_OPTION);
			}
			if(search(gen.ini,0) > 1){
				search(gen.ini,2);
			}
		}
	}
	
	SudokuPuzzle()
	{
		init();
	}
	
	void init()
	{
		frame.setJMenuBar(jmb);
		jmb.add(start);
		jmb.add(check);
		
		jmb.add(GS);
		jmb.add(NS);
		jmb.add(mhelp);
		HelpListener hl=new HelpListener();
		mhelp.addActionListener(hl);
		CheckListener checkl=new CheckListener();
		check.addActionListener(checkl);
		GSListener GS1 = new GSListener();
		GS.addActionListener(GS1);
		NSListener NS1 = new NSListener();
		NS.addActionListener(NS1);
		start.add(nandu1);
		start.add(nandu2);
		start.add(nandu3);
		start.add(nandu4);
		NanduListener nl=new NanduListener();
		nandu1.addActionListener(nl);
		nandu2.addActionListener(nl);
		nandu3.addActionListener(nl);
		nandu4.addActionListener(nl);
		JPanel base=new JPanel(new GridLayout(3,3));
		frame.getContentPane().add(base,BorderLayout.CENTER);
		for (int i=0; i<9 ; i++)
		{
			JPanel p=new JPanel(new GridLayout(3,3));
			for (int k=0; k<3 ; k++)
			{
				g[(i%3)*3+k+27*(i/3)]=new Grid(0);
				p.add(g[(i%3)*3+k+27*(i/3)].cb);
			}
			for (int k=9; k<12 ; k++)
			{
				g[(i%3)*3+k+27*(i/3)]=new Grid(0);
				p.add(g[(i%3)*3+k+27*(i/3)].cb);
			}
			for (int k=18; k<21 ; k++)
			{
				g[(i%3)*3+k+27*(i/3)]=new Grid(0);
				p.add(g[(i%3)*3+k+27*(i/3)].cb);
			}
			p.setBorder(BorderFactory.createLineBorder(Color.red));
			base.add(p);
		}
		for (int i=0; i<9 ; i++)
			for (int j=0; j<9 ; j++)
			{
				g[i*9+j].x=i;
				g[i*9+j].y=j;
			}
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	void goSulution(int[][] sulutions){
		for (int i=0; i<9 ; i++)
			for (int j=0; j<9 ; j++)
				if (sulutions[i][j]==0)
				{
					g[i*9+j].cb.setText("  ");
					g[i*9+j].seteditable(1);
					g[i*9+j].pm.radio[0].setSelected(true);
				}
				else
				{
					g[i*9+j].cb.setText(g[0].chooser[sulutions[i][j]]);
					g[i*9+j].seteditable(0);
				}
	}
	
	void go(int nandu) 
	{
		//生成
		if(nandu == 3||nandu == 4||nandu == 5){
		gen.go(nandu);
		}
		if(nandu == 1){
			try{
				JFileChooser fileChooser = new JFileChooser();
				if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					java.io.File file = fileChooser.getSelectedFile();
				
		 
			    Scanner input = new Scanner(file);
							
			    while(input.hasNext()){
			    
			    for (int i = 0; i < 9; i++)
			      for (int j = 0; j < 9; j++)
			        gen.ini[i][j] = input.nextInt();
			    }
			    input.close();	
				}
			}
			catch(Exception e){}
		}
		
		
		for (int i=0; i<9 ; i++)
			for (int j=0; j<9 ; j++)
				if (gen.ini[i][j]==0)
				{
					g[i*9+j].cb.setText("  ");
					g[i*9+j].seteditable(1);
					g[i*9+j].pm.radio[0].setSelected(true);
				}
				else
				{
					g[i*9+j].cb.setText(g[0].chooser[gen.ini[i][j]]);
					g[i*9+j].seteditable(0);
				}
	}
//intersection
	  /** Obtain a list of free cells from the puzzle */
	  public static int[][] getFreeCellList(int[][] grid) {
	    // 81 is the maximum number of free cells
	    int[][] tempList = new int[81][2];
	    int numberOfFreeCells = 0;

	    for (int i = 0; i < 9; i++)
	      for (int j = 0; j < 9; j++)
	        if (grid[i][j] == 0) {
	          tempList[numberOfFreeCells][0] = i;
	          tempList[numberOfFreeCells][1] = j;
	          numberOfFreeCells++;
	        }

	    // Trim freeCellList
	    int[][] freeCellList = new int[numberOfFreeCells][2];
	    for (int i = 0; i < numberOfFreeCells; i++) {
	      freeCellList[i][0] = tempList[i][0];
	      freeCellList[i][1] = tempList[i][1];
	    }

	    return freeCellList;
	  }

	  /** Print the values in the grid */
	  public static void printGrid(int[][] grid) {
	    for (int i = 0; i < 9; i++) {
	      for (int j = 0; j < 9; j++)
	        System.out.print(grid[i][j] + " ");
	      System.out.println();
	    }
	  }

	  /** Search for up to 2 solutions. 
	   * This method returns the number of solutions found.
	   * Possible return values are 0, 1, 2, and 3.  */
	  public static int search(int[][] grid,int index) {
	    int[][] freeCellList = getFreeCellList(grid); // Free cells
	    int k = 0; // Start from the first free cell
	    int count = 0; // Multiple solutions: Count for 3 solutions

	    boolean done = false;

	    while (!done) {
	      int i = freeCellList[k][0];
	      int j = freeCellList[k][1];
	      if (grid[i][j] == 0)
	        grid[i][j] = 1; // Start with 1

	      if (isValid(i, j, grid)) {
	        if (k + 1 == freeCellList.length) { // No more free cells
	          // A solution is found
	          count++;
	          if (count == 1) { // Display the first two solutions
	           solution1 = grid;
	           System.out.println("Sample solution " + (count) + ":");
	           printGrid(solution1 );
	           if(index == 1){
	        	   int tempInt = 0;
	   			String tempString ;
	   			String solutionString = "";
	   			//solution1 = searchSolutions(gen.ini,1);
	   			 for (int i1 = 0; i1 < 9; i1++) {
	   			      for (int j1 = 0; j1 < 9; j1++){
	   			    	  tempInt = solution1[i1][j1];
	   			          tempString = tempInt + " ";
	   			          System.out.print(tempInt + " ");
	   			          solutionString = solutionString + tempString ;
	   			          if(j1 == 8){
	   			        	  solutionString = solutionString + " \n";
	   			          }
	   			      }
	   			          
	   			 }
	   			JOptionPane.showMessageDialog(null,"Sample solution 1: " + " \n" + solutionString);
	           }
	          //
	         
			//
	          }
	          if (count == 2) { // Display the first two solutions
		           solution2 = grid;
		           System.out.println("Sample solution " + (count) + ":");
		           printGrid(solution2 );
		           if(index == 2){
		        	   int tempInt = 0;
		   			String tempString ;
		   			String solutionString = "";
		   			//solution1 = searchSolutions(gen.ini,1);
		   			 for (int i1 = 0; i1 < 9; i1++) {
		   			      for (int j1 = 0; j1 < 9; j1++){
		   			    	  tempInt = solution1[i1][j1];
		   			          tempString = tempInt + " ";
		   			          System.out.print(tempInt + " ");
		   			          solutionString = solutionString + tempString ;
		   			          if(j1 == 8){
		   			        	  solutionString = solutionString + " \n";
		   			          }
		   			      }
		   			          
		   			 }
		   			JOptionPane.showMessageDialog(null,"Sample solution 2: " + " \n" + solutionString);
		           }
	          }
	          // Now search for the next possible solution
	          if (grid[i][j] < 9) {
	            grid[i][j] = grid[i][j] + 1; // Check the next possible value
	          } 
	          else { // grid[i][j] is 9, backtrack
	            while (grid[i][j] == 9) {
	              grid[i][j] = 0; // Reset to free cell
	              if (k == 0) {
	                done = true; // No possible value any more, done!
	                return count; 
	              }
	              k--; // Backtrack
	              i = freeCellList[k][0];
	              j = freeCellList[k][1];
	            }

	            grid[i][j] = grid[i][j] + 1; // Check the next possible value
	          }
	        } 
	        else { // Move to the next free cell
	          k++;
	        }
	      }
	      else if (grid[i][j] < 9) {
	        grid[i][j] = grid[i][j] + 1; // Check the next possible value
	      } 
	      else { // grid[i][j] is 9, backtrack
	        while (grid[i][j] == 9) {
	          grid[i][j] = 0; // Reset to free cell
	          if (k == 0) {
	            return count; // No possible value
	          }
	          k--; // Backtrack
	          i = freeCellList[k][0];
	          j = freeCellList[k][1];
	        }

	        grid[i][j] = grid[i][j] + 1; // Check the next possible value
	      }
	    }

	    return count; // A solution is found
	  }
//
	 
//
	  /** Check whether grid[i][j] is valid in the grid */
	  public static boolean isValid(int i, int j, int[][] grid) {
	    // Check whether grid[i][j] is valid at the i's row
	    for (int column = 0; column < 9; column++)
	      if (column != j && grid[i][column] == grid[i][j])
	        return false;

	    // Check whether grid[i][j] is valid at the j's column
	    for (int row = 0; row < 9; row++)
	      if (row != i && grid[row][j] == grid[i][j])
	        return false;

	    // Check whether grid[i][j] is valid in the 3 by 3 box
	    for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
	      for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
	        if (row != i && col != j && grid[row][col] == grid[i][j])
	          return false;

	    return true; // The current value at grid[i][j] is valid
	  }

	  /** Check whether the fixed cells are valid in the grid */
	  public static boolean isValid(int[][] grid) {
	    for (int i = 0; i < 9; i++)
	      for (int j = 0; j < 9; j++)
	        if (grid[i][j] < 0 || grid[i][j] > 9 ||
	           (grid[i][j] != 0 && !isValid(i, j, grid))) {
	          System.out.println("grid[i][j] = " + grid[i][j]);
	          System.out.println("i = " + i + " j " + j);
	          return false;
	        }

	    return true; // The fixed cells are valid
	  }


//intersection	
	public static void main(String args[])
	{
		SudokuPuzzle sudoku0=new SudokuPuzzle();
	}
}


//intersection





//intersection
class Generator
{
	static int ini[][]=new int[9][9];			//初始的输入；
	static int ok[][]=new int[9][9];
	static int numMask[][][]=new int[10][9][9]; //数字mask;
	static int numIni=0;						//记录已经填好的数字的个数；
	static int count=0;
	static int nandu=3;
	static Random r=new Random();
	void go(int nandu)
	{
		numIni=0;
		count=0;
		this.nandu=nandu;
		String a[]={
			"000000000",
			"000000000",
			"000000000",
			"000000000",
			"000000000",
			"000000000",
			"000000000",
			"000000000",
			"000000000",
				};
		init(a);
		
		TianChong(0);
		c2(ini,ok);
		shaixuan(9-nandu);
		
	}
	void setIni (int[][] solution){
		ini = solution;
	}
	static boolean check()
	{
		for (int i=0; i<9 ; i++)
			for (int j=0; j<9 ; j++)
				if (ok[i][j]!=ini[i][j])
					return false;
		return true;
	}
	static void shaixuan(int a)
	{
		int jishu=1;
		for (int m=0; m<3 ; m++)
			for (int n=0; n<3 ; n++)
			{
				jishu=1;
				int x,y;
				while(jishu<=a)
				{
					x=r.nextInt();
					y=r.nextInt();
					x=x>0?x:-x;
					y=y>0?y:-y;
					x=x%3;y=y%3;
					if (ini[x+3*m][y+3*n]!=0)
					{
						ini[x+3*m][y+3*n]=0;
						jishu++;
					}
				}
			}
		for (int i=0; i<9 ; i++)
			for (int j=0; j<9 ; j++)
				for (int k=0; k<9 ; k++)
					numMask[i][j][k]=0;
		numIni=0;
		for (int i=0; i<9 ; i++)
			for (int j=0; j<9 ; j++)
				if (ini[i][j]!=0)
				{
					numIni++;
					for (int m=0;m<9;m++)
						numMask[ini[i][j]][i][m]=numMask[ini[i][j]][m][j]=1;
					for (int m=0;m<3;m++)
						for (int n=0;n<3;n++)
							numMask[ini[i][j]][i/3*3+m][j/3*3+n]=1;
				}
			
		
	}
	static void TianChong(int whole)
	{
		if (numIni==81)
		{
			count++;
			//System.out.println(count+" "+ini[0][0]);
			//print(ini);
			return;
		}
		int i=whole/9;
		int j=whole%9;
				if (ini[i][j]==0  )
				{	
					int houxuan[]=new int[10];
					int l=0;
					for (int num=1; num<10 ; num++)
						if (numMask[num][i][j]==0 )
						{
							houxuan[l]=num;
							l++;
						}
					//乱续;
					int ll=l-1;
					while (ll>=1)
					{
						int biao=r.nextInt();
						biao=biao>0?biao:-biao;
						biao=biao%ll;
						int c=houxuan[biao];
						houxuan[biao]=houxuan[ll];
						houxuan[ll]=c;
						ll--;
					}
					for (int k=0;k<l;k++)
						{
							int num=houxuan[k];
							//记录回溯用值；
							int iini[][]=new int[9][9];
							int inumMask[][][]=new int[10][9][9];
							int inumIni=numIni;
							c2(ini,iini);
							c3(numMask,inumMask);
							//填写；
							ini[i][j]=num;
							numIni++;		
							updata(num,i,j);
							TianChong((whole+1)%81);
							if (count==1) return;
							//回溯；
							c2(iini,ini);
							c3(inumMask,numMask);
							numIni=inumIni;
						}
				}
				else	TianChong((whole+1)%81);
	}
	//初始化
	static void init(String a[])
	{
		for (int i=0;i<10;i++)
			for (int j=0;j<9;j++)
				for (int k=0;k<9;k++)
					numMask[i][j][k]=0;
		for (int i=0;i<9;i++)
			for (int j=0;j<9;j++)
			{
				ini[i][j]=(int)(a[i].charAt(j)-'0');
				if (ini[i][j]!=0)
				{
					numIni++;
					for (int m=0;m<9;m++)
						numMask[ini[i][j]][i][m]=numMask[ini[i][j]][m][j]=1;
					for (int m=0;m<3;m++)
						for (int n=0;n<3;n++)
							numMask[ini[i][j]][i/3*3+m][j/3*3+n]=1;
				}
			}
	
	}
	static void updata(int num,int i,int j)		//用于更新Mask和single
	{
		for (int k=0;k<9;k++)
		{
			if (numMask[num][i][k]==0)
			{
				numMask[num][i][k]=1;
				
			}
			if (numMask[num][k][j]==0)
			{
				numMask[num][k][j]=1;
			}
		}
		for (int m=0;m<3;m++)
			for (int n=0;n<3;n++)
				if (numMask[num][i/3*3+m][j/3*3+n]==0)
				{
					numMask[num][i/3*3+m][j/3*3+n]=1;
				}	
	}
	static void print (int a[][])	{
		
		for (int i=0;i<a.length;i++)
		{
			for (int j=0;j<a[0].length;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}

	static void c2(int a[][],int b[][])
	{
		for (int i=0;i<a.length;i++)
			for (int j=0;j<a[0].length;j++)
				b[i][j]=a[i][j];
	}
	static void c3(int a[][][],int b[][][])
	{
		for (int i=0;i<a.length;i++)
			for (int j=0;j<a[0].length;j++)
				for (int k=0;k<a[0][0].length;k++)
				b[i][j][k]=a[i][j][k];
	}
}