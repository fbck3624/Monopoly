
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class A1063307_Checkpoint6 extends JFrame implements ActionListener{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String protocol = "jdbc:mysql:";
	private static final String username = "root";
	private static final String passwd ="imdb201907"; 
	private static ResultSet rs;
	JButton Start;
	JButton Load;
	JButton Exit;
	JButton Confirm;
	public static int[] p_number;
	public static int[] l_price;
	public static int[] tolls;
	public static int grid;
	public static int who;
	public static int round;
	public static int turn;
	public static int w;
	public static int random;
	public static int linenumber;
	public static String[][] land;
	public static String[][] land2;
	public static String[][] arr;
	public static String[][] arrr;
	public static Character[] ch;
	public static Character[] Ch;
	public static int tt;
	public static A1063307_GUI gui;
	public static A1063307_Checkpoint6 start;
	//public static A1063307_Checkpoint6 warming;
	public static JFrame warming;
	public static String s;
	public static Land[] Land;
	public static Land[] Land2;
	public static boolean Warming=false;
	public static String filename="Character.txt";
	public static void main(String[] args) throws IOException {
		
		//// TODO: Announce your GUI object to make the GUI ////
		//// TODO: This time we won't give you a function to realize our demands (Please look for demands on the document).
		//// TODO: So, you can makeit in anyway whatever you like. 
		 	start=new A1063307_Checkpoint6();
			start.setVisible(true);
			start.setSize(200,200);
			start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			start.setResizable(false);	
	}
	
	public A1063307_Checkpoint6() {
		setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(5,1));
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(45,20));
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(45,20));
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(45,20));
		JPanel panel4 = new JPanel();
		panel4.setPreferredSize(new Dimension(45,20));
		JLabel j1=new JLabel();
		JLabel j2=new JLabel();
		Start=new JButton("Start");
		Start.setSize(1,2);
		Start.addActionListener(this);
		Load=new JButton("Load");
		Load.addActionListener(this);
		Exit=new JButton("Exit");
		Exit.addActionListener(this);
		panel.add(Start);
		panel.add(j1);
		panel.add(Load);
		panel.add(j2);
		panel.add(Exit);
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.SOUTH);
		add(panel3,BorderLayout.EAST);
		add(panel4,BorderLayout.WEST);
		add(panel,BorderLayout.CENTER);		
	}
	public static void Load(String filename) throws IOException {
		//// TODO: You should load the variables from the file. ////
		LineNumberReader lnr = new LineNumberReader(new FileReader(filename));
		  linenumber = 0;
		  while (lnr.readLine() != null){
			  linenumber++;
		  }
        lnr.close();
    	arrr=new String[linenumber][5];
		arr=arrr;
		BufferedReader br=new BufferedReader(new FileReader(filename));
		 Scanner sc1=new Scanner(br);
		 String ss=sc1.nextLine();
		 String[] str1 = ss.split(",") ;
		 String r=str1[0];
		 String t=str1[1];
		 String[] str2 = r.split(":") ;
		 round= Integer.parseInt(str2[1]);
		 String[] str3 = t.split(":") ;
		 who=Integer.parseInt(str3[1]);
		 arr=new String[linenumber][5];
		 int num=0;
		 while(sc1.hasNextLine()) {	
			 int i=0;
			 num++;
			 String x=sc1.nextLine();
			String[] str = x.split(",") ;
			while(i<5) {
				arr[num][i]=str[i];
				i++;
			 }
		 }
		 int c=1;
	     ch=new Character[linenumber];

			while(c<(linenumber)) {
				
				ch[c]=new Character(Integer.parseInt(arr[c][0]),Integer.parseInt(arr[c][1]),Integer.parseInt(arr[c][2]),Integer.parseInt(arr[c][3]),arr[c][4]);							
				c++;
			}	
		
		 sc1.close();
		 String file="Land.txt";
			BufferedReader br2=new BufferedReader(new FileReader(file));
			land=new String[20][2];
			land2=new String[20][2];
			land=land2;
			Scanner sc2=new Scanner(br2);
			String strr=sc2.nextLine();
			num=0;
			 while(sc2.hasNextLine()) {	
				 int i=0;
				 num++;
				 String x=sc2.nextLine();			
				String[] str = x.split(",") ;
				while(i<2) {
					land[num][i]=str[i];
					i++;
				 }			
			 }
			
			 String url = "//localhost:3306/checkpoint?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
		   //  String url="//140.127.220.220/";
		   //  String dbname="CHECKPOINT";
			 Connection conn = null;
		     try{
		            conn = DriverManager.getConnection(protocol + url,username,passwd);
		            Statement s = conn.createStatement();
		            String sql = "SELECT PLACE_NUMBER,LAND_PRICE,TOLLS FROM LAND";
		            rs=s.executeQuery(sql);
		            p_number=new int[20];
		            l_price=new int[20];
		            tolls=new int[20];
		            grid=0;
		            while(rs.next()){
		            	grid++;
		            	p_number[grid]=rs.getInt("PLACE_NUMBER");
		            	l_price[grid]=rs.getInt("LAND_PRICE");
		            	tolls[grid]=rs.getInt("TOLLS");	            		            	
		             }		           		           
		            rs.close();
		            conn.close();
		        } catch(SQLException err){
		            System.err.println("SQL error.");
		            err.printStackTrace(System.err);
		            System.exit(0);
		        }
			 Land=new Land[20];
			 Land2=new Land[20];
			 Land=Land2;			 
		     	for(int i=1;i<=grid;i++) {
		     		Land[i]=new Land(p_number[i],Integer.parseInt(land[i][1]),l_price[i],tolls[i]);	     		
		     	}
			 sc2.close();
	}

	public static void Save(String filename) throws IOException {
		//// TODO: You should save the changed variables into original data (filename). ////
		FileWriter fw=new FileWriter(filename);
		round=A1063307_GUI.round;
		who=A1063307_GUI.who2;
		fw.write("Round:"+round+",Turn:"+who+"\n");
		int t2=1;
		while(t2<(linenumber)) {
			int zz=0;
			while(zz<5) {
				if(zz==0) {		
					ch[t2].location=ch[t2].location%20;
				    fw.write(Integer.toString(ch[t2].location)+",");
				}
				else if(zz==1){
				    fw.write(Integer.toString(ch[t2].CHARACTER_NUMBER)+",");
				
					}
				else if(zz==2){
					fw.write(Integer.toString(ch[t2].money)+",");
				
					}
			    else if(zz==3){
			    	fw.write(Integer.toString(ch[t2].status)+",");
			   
			    	}
				else {
					fw.write(ch[t2].IMAGE_FILENAME);				
					 }
				zz++;
			}
			fw.write("\n");
			t2++;
		}
		fw.close();
		FileWriter fw1=new FileWriter("Land.txt");
		fw1.write("LOCATION_NUMBER, owner\n");
		for(int i=1;i<17;i++) {
			fw1.write(Land[i].PLACE_NUMBER+","+Land[i].owner+"\n");
		}
		fw1.close();
	}
	
	public static void Random() {
		//// TODO: while calling the Random function, Character.location should plus the random value, and Character.status should minus one.
		//// TODO: While Character.status more than zero(not include zero), Character can move(plus the random value).
		Random ran =new Random();
		random=ran.nextInt(6)+1;
		//random=1;
		who=A1063307_GUI.who2;
		if((ch[who].status)>0) {
			ch[who].location=(ch[who].location)+random;
			ch[who].status=(ch[who].status)-1;
			
		}else {
				return;
			}		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Start){
			start.setVisible(false);
	        try {	        	
	        	round=1; 
	        	File file = new File(filename);
	        	PrintWriter  out = new PrintWriter(file);
	        	out.println("Round:1,Turn:1");
	        	out.println("0,1,2000,1,Character_1.png");
	        	out.println("0,2,2000,1,Character_2.png");
	        	out.println("0,3,2000,1,Character_3.png");
	        	out.println("0,4,2000,1,Character_4.png");
	        	out.close();
	        	String file1="Land.txt";
	        	File file2 = new File(file1);
	        	PrintWriter out2 = new PrintWriter(file2);
	        	out2.println("LOCATION_NUMBER, owner");
	        	for(int i=1;i<5;i++) {
	        		out2.println(i+",0");
	        	}
	        	for(int i=6;i<10;i++) {
	        		out2.println(i+",0");
	        	}
	        	for(int i=11;i<15;i++) {
	        		out2.println(i+",0");
	        	}
	        	for(int i=16;i<20;i++) {
	        		out2.println(i+",0");
	        	}
	        	out2.close();
				Load(filename);
				gui=new A1063307_GUI();
				gui.setVisible(true);
				gui.setSize(700,700);
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gui.setResizable(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
	       
		}
		else if(e.getSource()==Load){
			 File file = new File(filename);
			 if(file.exists()==true) {
				 start.setVisible(false);
				 try {	        	
			        	round=1; 			        	
						Load(filename);
						gui=new A1063307_GUI();
						gui.setVisible(true);
						gui.setSize(700,700);
						gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						gui.setResizable(false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
			 }else {
			//	Warming=true;
				 	int i=1;
					//warming=new A1063307_Checkpoint6(i);
				 	warming=new JFrame();					
					warming.setSize(150,100);
					//warming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					warming.setResizable(false);					
					warming.setLayout(new BorderLayout());
					JLabel jlabel=new JLabel("WITHOUT RECORD",SwingConstants.CENTER);
					Confirm=new JButton("Confirm");
					JPanel j1=new JPanel(new FlowLayout());
					JLabel jj=new JLabel();
					JLabel j2=new JLabel();
					Dimension preferredSize = new Dimension(100,20);
					Confirm.setPreferredSize(preferredSize); 
					j1.add(jj);
					j1.add(Confirm);
					j1.add(j2);
					Confirm.addActionListener(this);
					warming.add(jlabel,BorderLayout.CENTER);
					warming.add(j1,BorderLayout.SOUTH);
					warming.setVisible(true);
			 }
        }
		else if(e.getSource()==Exit){
			System.exit(0);
		}
		else if(e.getSource()==Confirm){
			warming.setVisible(false);
		}
		
	}
}
