import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Shudu
{
	Generator gen=new Generator();
	static Grid g[]=new Grid[81];
	final String help="Made By Shi Xing"+'\n'+"操作方法："+'\n'+"在start中选择相应难度开始；"+'\n'+"在空格处右键弹出下拉菜单"
					+'\n'+"选择相应的数字后，在原来的空格点击左键"+'\n'+"填写完成后点击Check按钮";
	//菜单的构建
	JMenuBar jmb=new JMenuBar();
	JMenu start=new JMenu("Start");
	JMenuItem check=new JMenuItem("Check");
	JMenuItem nandu1=new JMenuItem("难度 3");
	JMenuItem nandu2=new JMenuItem("难度 4");
	JMenuItem nandu3=new JMenuItem("难度 5");
	JMenuItem mhelp=new JMenuItem("Help");
	JFrame frame=new JFrame("数独游戏");
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
				System.out.println(index);
			}
		}
		class MyListener extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				if (editable==1)
				if (e.getButton()==MouseEvent.BUTTON3)
				{
					pm.pop.setLocation(e.getXOnScreen(), e.getYOnScreen());
					pm.pop.setVisible(true);
					pm.pop.setEnabled(true);
				}
				else if (e.getButton()==MouseEvent.BUTTON1)
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
				JOptionPane.showMessageDialog(frame, "正确", "判断", JOptionPane.OK_OPTION);
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "错误", "判断", JOptionPane.OK_OPTION);
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
		}
	}
	class HelpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, help,"Help",JOptionPane.OK_OPTION);
		}
	}
	Shudu()
	{
		init();
	}
	void init()
	{
		frame.setJMenuBar(jmb);
		jmb.add(start);
		jmb.add(check);
		jmb.add(mhelp);
		HelpListener hl=new HelpListener();
		mhelp.addActionListener(hl);
		CheckListener checkl=new CheckListener();
		check.addActionListener(checkl);
		start.add(nandu1);
		start.add(nandu2);
		start.add(nandu3);
		NanduListener nl=new NanduListener();
		nandu1.addActionListener(nl);
		nandu2.addActionListener(nl);
		nandu3.addActionListener(nl);
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
	void go(int nandu)
	{
		//生成
		gen.go(nandu);
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
	public static void main(String args[])
	{
		Shudu s=new Shudu();
	}
}

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