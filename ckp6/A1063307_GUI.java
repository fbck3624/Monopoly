
import java.sql.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import javax.swing.*;

public class A1063307_GUI extends JFrame implements ActionListener,Runnable{
	JButton mybutton;
	JButton mybutton2;
	JButton mybutton3;
	JLabel label_display;
	JLabel dduck;
	JButton btn1;
	JLabel btn4;
	JLabel btn3;
	BufferedImage[] player;
	JLabel label[];
	JLabel btn[];	
	public static int havesave=0;
	public static int local;
	public static int howlong=1;
	public static int x1,x2,x3,x4,y1,y2,y3,y4;
	public static int line;
	public static int who3;
	public static boolean clickload=true;
	public static int howbuy;
	public static int who2=A1063307_Checkpoint6.who;
	public static int round=A1063307_Checkpoint6.round;
	public static String filename="Character.txt";
    ////TODO: GUI ////
	public static void main(String[] args) throws IOException  {
		
	}
	public A1063307_GUI() throws IOException{
		A1063307_Checkpoint6.Load(filename);
		line=A1063307_Checkpoint6.linenumber;
		JPanel panel = new JPanel(new BorderLayout());
		JPanel panell = new JPanel(new BorderLayout());
		JPanel panellin = new JPanel(new BorderLayout());
		panellin.setPreferredSize(new Dimension(45,20));
		panellin.setBackground(Color.white);
		panell.add(panellin,BorderLayout.CENTER);
		JPanel panelr = new JPanel(new BorderLayout());
		JPanel panelrin = new JPanel(new BorderLayout());
		panelrin.setPreferredSize(new Dimension(45,20));
		panelrin.setBackground(Color.white);
		panelr.add(panelrin,BorderLayout.CENTER);
		panel.setBackground(Color.white);
		JPanel panel2 = new JPanel(new FlowLayout(0,40,10));
		panel2.setBackground(Color.white);
		mybutton=new JButton("Save");
		mybutton2=new JButton("Load");
		mybutton.setFont(new java.awt.Font("Dialog", 1, 15));
		mybutton2.setFont(new java.awt.Font("Dialog", 1, 15));
		panel2.add(mybutton);
		panel2.add(mybutton2);
		mybutton.addActionListener(this);
		mybutton2.addActionListener(this);
		label=new JLabel[line];
		for(int i=1;i<line;i++) {
			label[i]=new JLabel("<html><body><p align=\'center\'>Character"+A1063307_Checkpoint6.ch[i].CHARACTER_NUMBER+"<br/>"+A1063307_Checkpoint6.ch[i].money+"</p></body></html>");
			label[i].setFont(new java.awt.Font("Dialog", 1, 10));
			panel2.add(label[i]);
		}
		btn=new JLabel[20];
		//btt=new JLabel[20];
		JPanel panel3=new JPanel(new BorderLayout());
		panel3.setBackground(Color.white);
		JPanel panel5=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		ImageIcon image5 = new ImageIcon("5.png");
		btn[5]=new JLabel(){			
			 public void paintComponent(Graphics g)
			  {
			    g.drawImage(image5.getImage(),0,0,null);
			    super.paintComponent(g); 
			  }				
			};
		btn[5].setOpaque(false);
		btn[5].setPreferredSize(new Dimension(120,120));
		btn[5].setHorizontalAlignment(label_display.CENTER);
		btn[5].setFont(new java.awt.Font("Dialog", 0, 20));
		panel5.setBackground(Color.white);
		panel5.add(btn[5]);		
		for(int i=4;i>=1;i--) {
		ImageIcon image = new ImageIcon(i+".png");
		btn[i]=new JLabel(){			
			 public void paintComponent(Graphics g)
			  {
			    g.drawImage(image.getImage(),0,0,null);
			    super.paintComponent(g); 
			  }				
			};
		btn[i].setOpaque(false);
		btn[i].setPreferredSize(new Dimension(89,120));
		panel5.setBackground(Color.white);
		panel5.add(btn[i]);	
		player = new BufferedImage[line];
		try {
		for(int x=1;x<line;x++) {
			player[x]= ImageIO.read(new File("Character_"+x+".png"));			
		}
		}catch(Exception e){
			
		}
		}
		ImageIcon image0 = new ImageIcon("0.png");
		btn[0]=new JLabel(){			
			 public void paintComponent(Graphics g)
			  {
			    g.drawImage(image0.getImage(),0,0,null);
			    super.paintComponent(g); 
			  }				
			};
		btn[0].setOpaque(false);
		btn[0].setPreferredSize(new Dimension(120,120));
		panel5.setBackground(Color.white);
		panel5.add(btn[0]);
		JPanel panel6=new JPanel(new GridLayout(4,1));
		for(int i=9;i>5;i--) {
		ImageIcon image = new ImageIcon(i+".png");
		btn[i]=new JLabel(){			
			 public void paintComponent(Graphics g)
			  {
			    g.drawImage(image.getImage(),0,0,null);
			    super.paintComponent(g); 
			  }				
			};
		btn[i].setOpaque(false);
		btn[i].setPreferredSize(new Dimension(120,89));
		panel6.setBackground(Color.white);
		panel6.add(btn[i]);
		}
		panel6.setBorder(null);
		JPanel panel7=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		ImageIcon image10 = new ImageIcon("10.png");
		btn[10]=new JLabel(){			
			 public void paintComponent(Graphics g)
			  {
			    g.drawImage(image10.getImage(),0,0,null);
			    super.paintComponent(g); 
			  }				
			};
		btn[10].setOpaque(false);
		btn[10].setPreferredSize(new Dimension(120,120));
		panel7.setBackground(Color.white);
		panel7.add(btn[10]);
		for(int i=11;i<15;i++) {
		ImageIcon image = new ImageIcon(i+".png");
		btn[i]=new JLabel(){			
			 public void paintComponent(Graphics g)
			  {
			    g.drawImage(image.getImage(),0,0,null);
			    super.paintComponent(g); 
			  }				
			};
		btn[i].setOpaque(false);
		btn[i].setPreferredSize(new Dimension(89,120));
		panel7.setBackground(Color.white);
		panel7.add(btn[i]);
		}
		ImageIcon image15 = new ImageIcon("15.png");
		btn[15]=new JLabel(){			
			 public void paintComponent(Graphics g)
			  {
			    g.drawImage(image15.getImage(),0,0,null);
			    super.paintComponent(g); 
			  }				
			};
		btn[15].setOpaque(false);
		btn[15].setPreferredSize(new Dimension(120,120));
		panel7.setBackground(Color.white);
		panel7.add(btn[15]);
		
		JPanel panel8=new JPanel(new GridLayout(4,1));
		for(int i=16;i<20;i++) {
		ImageIcon image = new ImageIcon(i+".png");
		btn[i]=new JLabel(){			
			 public void paintComponent(Graphics g)
			  {
			    g.drawImage(image.getImage(),0,0,null);
			    super.paintComponent(g); 
			  }				
			};
		btn[i].setOpaque(false);
		btn[i].setPreferredSize(new Dimension(120,89));
		panel8.setBackground(Color.white);
		panel8.add(btn[i]);
		}
		JPanel panel9=new JPanel(new BorderLayout());
		JPanel panel10=new JPanel(new BorderLayout());
		ImageIcon image = new ImageIcon("title.png");
		JLabel btn = new JLabel(image);
		btn.setFont(new Font("Serif",Font.PLAIN,12));
		panel10.add(btn,BorderLayout.WEST);
		panel10.setBackground(Color.white);
		
		JPanel panel12=new JPanel(new BorderLayout());		
		who2=A1063307_Checkpoint6.who;
		while(A1063307_Checkpoint6.ch[who2].status<=0){		
			if(who2<(line)) {
				who2++;
				}
			if(who2>=line) {
				who2=1;
				round++;
			     for(int i=1;i<line;i++) {
			    	 A1063307_Checkpoint6.ch[i].status=A1063307_Checkpoint6.ch[i].status+1;
			     }
			}
			}		
		btn4 = new JLabel("Turn Character"+A1063307_Checkpoint6.ch[who2].CHARACTER_NUMBER);
		btn4.setFont(new java.awt.Font("Dialog", 1, 32));
		panel12.add(btn4,BorderLayout.EAST);
		panel12.setBackground(Color.white);
		JPanel panel11=new JPanel(new GridLayout(1,2));		
		JPanel panel13=new JPanel(new BorderLayout());
		ImageIcon image1 = new ImageIcon("Dice.png");
		btn1 = new JButton(image1);
		btn1.setBackground(Color.white);
		btn1.setBorder(null);
		panel13.add(btn1);
		btn1.addActionListener(this);
		JPanel panel14=new JPanel(new BorderLayout());
		ImageIcon image2 = new ImageIcon("display_dicenum.png");
		label_display=new JLabel(){
		 public void paintComponent(Graphics g)
		  {
		    g.drawImage(image2.getImage(),35,55,null);
		    super.paintComponent(g);
		  }			
		};
		label_display.setOpaque(false);
		label_display.setText("0");
		label_display.setBackground(Color.white);	
		label_display.setHorizontalAlignment(label_display.CENTER);
		label_display.setFont(new java.awt.Font("Dialog", 0, 40));
		btn3 = new JLabel("ROUND  "+round);
		btn3.setFont(new java.awt.Font("Dialog", 0, 20));
		panel14.add(label_display);
		panel14.add(btn3,BorderLayout.SOUTH);
		panel11.add(panel13);
		panel11.add(panel14);
		panel14.setBackground(Color.white);
		panel13.setBackground(Color.white);
		panel9.add(panel10,BorderLayout.NORTH);
		panel9.add(panel11,BorderLayout.CENTER);
		panel9.add(panel12,BorderLayout.SOUTH);
		panel3.add(panel5,BorderLayout.SOUTH);
		panel3.add(panel6,BorderLayout.WEST);
		panel3.add(panel7,BorderLayout.NORTH);
		panel3.add(panel8,BorderLayout.EAST);
		panel3.add(panel9,BorderLayout.CENTER);
		JPanel panel4 = new JPanel(new BorderLayout());
		panel4.setBackground(Color.white);
		JPanel exit = new JPanel(new BorderLayout());
		exit.setBackground(Color.white);
		mybutton3=new JButton("Exit");
		mybutton3.addActionListener(this);
		exit.add(mybutton3,BorderLayout.EAST);		
		panel4.add(exit);
		panel.add(panel2,BorderLayout.NORTH);
		panel.add(panel3,BorderLayout.CENTER);
		panel.add(panell,BorderLayout.EAST);
		panel.add(panelr,BorderLayout.WEST);
		panel.add(panel4,BorderLayout.SOUTH);
		add(panel);
	}

	public void paint(Graphics g) {
   	    super.paint(g);
   	    if(clickload==true) {
   	    	btn3.setText("ROUND  "+A1063307_Checkpoint6.round);
   	    	for(int i=1;i<=A1063307_Checkpoint6.grid;i++) {
   	    	if(A1063307_Checkpoint6.Land[i].owner!=0) {	
   	    	int own=A1063307_Checkpoint6.Land[i].owner;
   	    	int x=A1063307_Checkpoint6.Land[i].PLACE_NUMBER;
   	    	btn[x].setHorizontalAlignment(label_display.CENTER);
			btn[x].setText(Integer.toString(own));
			btn[x].setFont(new java.awt.Font("Dialog", 1, 40));
   	    	}
   	    	}
   	    for(int i=1;i<line;i++) {
   	    	if(i==1) {
   	    		if(A1063307_Checkpoint6.ch[1].location>=0 && A1063307_Checkpoint6.ch[1].location<5) {
   	    			x1=550-A1063307_Checkpoint6.ch[1].location*95;
   	    			y1=580;
   	    		}else if(A1063307_Checkpoint6.ch[1].location>=5 && A1063307_Checkpoint6.ch[1].location<10) {
   	    			y1=580-(A1063307_Checkpoint6.ch[1].location-5)*95;
   	    			x1=75;
   	    		}else if(A1063307_Checkpoint6.ch[1].location>=10 && A1063307_Checkpoint6.ch[1].location<15) {
   	    			x1=550-(15-A1063307_Checkpoint6.ch[1].location)*95;
   	    			y1=105;
   	    		}else {
   	    			y1=580-(20-A1063307_Checkpoint6.ch[1].location)*95;
   	    			x1=550;
   	    		}
   	    	}else if(i==2) {
   	    		if(A1063307_Checkpoint6.ch[2].location>=0 && A1063307_Checkpoint6.ch[2].location<5) {
   	    			x2=590-A1063307_Checkpoint6.ch[2].location*95;
   	    			y2=580;
   	    		}else if(A1063307_Checkpoint6.ch[2].location>=5 && A1063307_Checkpoint6.ch[2].location<10) {
   	    			y2=580-(A1063307_Checkpoint6.ch[2].location-5)*95;
   	    			x2=115;
   	    		}else if(A1063307_Checkpoint6.ch[2].location>=10 && A1063307_Checkpoint6.ch[2].location<15) {
   	    			x2=590-(15-A1063307_Checkpoint6.ch[2].location)*95;
   	    			y2=105;
   	    		}else {
   	    			y2=580-(20-A1063307_Checkpoint6.ch[2].location)*95;
   	    			x2=590;
   	    		}
   	    		
   	    	}else if(i==3) {
   	    		if(A1063307_Checkpoint6.ch[3].location>=0 && A1063307_Checkpoint6.ch[3].location<5) {
   	    			x3=550-A1063307_Checkpoint6.ch[3].location*95;
   	    			y3=620;
   	    		}else if(A1063307_Checkpoint6.ch[3].location>=5 && A1063307_Checkpoint6.ch[3].location<10) {
   	    			y3=620-(A1063307_Checkpoint6.ch[3].location-5)*95;
   	    			x3=75;
   	    		}else if(A1063307_Checkpoint6.ch[3].location>=10 && A1063307_Checkpoint6.ch[3].location<15) {
   	    			x3=550-(15-A1063307_Checkpoint6.ch[3].location)*95;
   	    			y3=145;
   	    		}else {
   	    			y3=620-(20-A1063307_Checkpoint6.ch[3].location)*95;
   	    			x3=550;
   	    		}
   	    		
   	    	}else if(i==4){
   	    		if(A1063307_Checkpoint6.ch[4].location>=0 && A1063307_Checkpoint6.ch[4].location<5) {
   	    			x4=590-A1063307_Checkpoint6.ch[4].location*95;
   	    			y4=620;
   	    		}else if(A1063307_Checkpoint6.ch[4].location>=5 && A1063307_Checkpoint6.ch[4].location<10) {
   	    			y4=620-(A1063307_Checkpoint6.ch[4].location-5)*95;
   	    			x4=115;
   	    		}else if(A1063307_Checkpoint6.ch[4].location>=10 && A1063307_Checkpoint6.ch[4].location<15) {
   	    			x4=590-(15-A1063307_Checkpoint6.ch[4].location)*95;
   	    			y4=145;
   	    		}else {
   	    			y4=620-(20-A1063307_Checkpoint6.ch[4].location)*95;
   	    			x4=590;
   	    		}
   	    	}
   	    }
   	    }   	   
   	    g.drawImage((Image)player[1],x1,y1,null); 
   	    g.drawImage((Image)player[2],x2,y2,null);
   	    g.drawImage((Image)player[3],x3,y3,null);
   	    g.drawImage((Image)player[4],x4,y4,null);
   	    clickload=false;
   	    
    }   
   public void tt() {
    	Thread a=new Thread(this);
    	a.start();
    }
	public void run() {
		setEnabled(false);
		btn1.setEnabled(false);
		howlong=A1063307_Checkpoint6.random*95;
		if(who3==1) {
			int pass=0;
			int x=1;
			int count=1;
			if(A1063307_Checkpoint6.random>0 && A1063307_Checkpoint6.random<4) {		
				if(A1063307_Checkpoint6.ch[1].location%20>=0 && A1063307_Checkpoint6.ch[1].location/20>=1) {
					pass++;
				}
					while(x<=howlong) {					
					if(x1>75 && y1==580) {
					x=x+1;
					x1=x1-1;
					}else if(y1>105 && x1==75){
					x=x+1;
					y1=y1-1;
					}
					else if(y1==105 && x1>=75 && x1<=549) {
					x=x+1;
					x1=x1+1;
					}else if(y1>=105 && x1==550){
						x=x+1;
						y1=y1+1;
					}
					if(pass>0) {
						if(x1==550 && y1==580) {
							A1063307_Checkpoint6.ch[1].money=A1063307_Checkpoint6.ch[1].money+2000;							
							label[1].setText("<html><body><p align=\'center\'>Character"+A1063307_Checkpoint6.ch[1].CHARACTER_NUMBER+"<br/>"+A1063307_Checkpoint6.ch[1].money+"</p></body></html>");
						}
					}
					repaint();
					count=(2000/(howlong));					
					try {          	        	
		                Thread.sleep(count);
		             } catch (InterruptedException e) {
		                e.printStackTrace();
		             }  					
					}		
			}else {					
				if(A1063307_Checkpoint6.ch[1].location%20>=0 && A1063307_Checkpoint6.ch[1].location/20>=1) {
					pass++;
				}
					while(x<=howlong) {	
						
						if(x1>75 && y1==580) {
							x=x+1;
							x1=x1-1;
							}else if(y1>105 && x1==75){
							x=x+1;
							y1=y1-1;
							}
							else if(y1==105 && x1>=75 && x1<=549) {
							x=x+1;
							x1=x1+1;
							}else if(y1>=105 && x1==550){
								x1=550;
								x=x+1;
								y1=y1+1;
							}
						if(pass>0) {
							if(x1==550 && y1==580) {
								A1063307_Checkpoint6.ch[1].money=A1063307_Checkpoint6.ch[1].money+2000;
								label[1].setText("<html><body><p align=\'center\'>Character"+A1063307_Checkpoint6.ch[1].CHARACTER_NUMBER+"<br/>"+A1063307_Checkpoint6.ch[1].money+"</p></body></html>");
							}
						}
						repaint();
						count=(3000/(howlong)); 
						try {
			                Thread.sleep(count);
			             } catch (InterruptedException e) {
			                e.printStackTrace();
			            }  
				
						}
			}
					
		}else if(who3==2) {
			int pass=0;
			int x=1;
			int count=1;
			if(A1063307_Checkpoint6.random>0 && A1063307_Checkpoint6.random<4) {
				if(A1063307_Checkpoint6.ch[2].location%20>=0 && A1063307_Checkpoint6.ch[2].location/20>=1) {
					pass++;
				}
					while(x<=howlong) {
					
						if(x2>115 && y2==580) {
							x=x+1;
							x2=x2-1;
						}else if(y2>105 && x2==115){
							
							x=x+1;
							y2=y2-1;
						}else if(y2==105 && x2>=115 && x2<=589) {
							
							x=x+1;
							x2=x2+1;						
						}else if(y2>=105 && x2==590){
							
							x=x+1;
							y2=y2+1;
						}
						if(pass>0) {
							if(x2==590 && y2==580) {
								A1063307_Checkpoint6.ch[2].money=A1063307_Checkpoint6.ch[2].money+2000;
								label[2].setText("<html><body><p align=\'center\'>Character"+A1063307_Checkpoint6.ch[2].CHARACTER_NUMBER+"<br/>"+A1063307_Checkpoint6.ch[2].money+"</p></body></html>");
							}
						}
						repaint();
						count=(2000/(howlong));						
						try {            	        	
			                Thread.sleep(count);
			             } catch (InterruptedException e) {
			                e.printStackTrace();
			            }
						}
					
			}else {				
				if(A1063307_Checkpoint6.ch[2].location%20>=0 && A1063307_Checkpoint6.ch[2].location/20>=1) {
					pass++;
				}
					while(x<=howlong) {
						
						if(x2>115 && y2==580) {
							x=x+1;
							x2=x2-1;
						}else if(y2>105 && x2==115){
							
							x=x+1;
							y2=y2-1;
						}else if(y2==105 && x2>=115 && x2<=589) {
							
							x=x+1;
							x2=x2+1;						
						}else if(y2>=105 && x2==590){
							
							x=x+1;
							y2=y2+1;
						}	
						if(pass>0) {
							if(x2==590 && y2==580) {
								A1063307_Checkpoint6.ch[2].money=A1063307_Checkpoint6.ch[2].money+2000;
								label[2].setText("<html><body><p align=\'center\'>Character"+A1063307_Checkpoint6.ch[2].CHARACTER_NUMBER+"<br/>"+A1063307_Checkpoint6.ch[2].money+"</p></body></html>");
							}
						}
						repaint();
						count=(3000/(howlong));						
						try {            	        	
			                Thread.sleep(count);
			             } catch (InterruptedException e) {
			                e.printStackTrace();
			            }
						
						}
			}
		}else if(who3==3) {
			int pass=0;
			int x=1;
			int count=1;
			if(A1063307_Checkpoint6.random>0 && A1063307_Checkpoint6.random<4) {
				if(A1063307_Checkpoint6.ch[3].location%20>=0 && A1063307_Checkpoint6.ch[3].location/20>=1) {
					pass++;
				}
					while(x<=howlong) {
						
						if(x3>75 && y3==620) {
							x=x+1;
							x3=x3-1;
						}else if(y3>145 && x3==75){
							
							x=x+1;
							y3=y3-1;
						}else if(y3==145 && x3>=75 && x3<=549) {
							
							x=x+1;
							x3=x3+1;
						}else if(y3>=145 && x3==550){
							
							x=x+1;
							y3=y3+1;
						}
						if(pass>0) {
							if(x3==550 && y3==620) {
								A1063307_Checkpoint6.ch[3].money=A1063307_Checkpoint6.ch[3].money+2000;
								label[3].setText("<html><body><p align=\'center\'>Character"+A1063307_Checkpoint6.ch[3].CHARACTER_NUMBER+"<br/>"+A1063307_Checkpoint6.ch[3].money+"</p></body></html>");
							}
						}
						count=(2000/(howlong));
						repaint();
						try {            	        	
			                Thread.sleep(count);
			             } catch (InterruptedException e) {
			                e.printStackTrace();
			            }
						
						}	
			}else {
				if(A1063307_Checkpoint6.ch[3].location%20>=0 && A1063307_Checkpoint6.ch[3].location/20>=1) {
					pass++;
				}
					while(x<=howlong) {
						if(x3>75 && y3==620) {
							x=x+1;
							x3=x3-1;
						}else if(y3>145 && x3==75){
							
							x=x+1;
							y3=y3-1;
						}else if(y3==145 && x3>=75 && x3<=549) {
							
							x=x+1;
							x3=x3+1;
						}else if(y3>=145 && x3==550){
							
							x=x+1;
							y3=y3+1;
						}
						if(pass>0) {
							if(x3==550 && y3==620) {
								A1063307_Checkpoint6.ch[3].money=A1063307_Checkpoint6.ch[3].money+2000;
								label[3].setText("<html><body><p align=\'center\'>Character"+A1063307_Checkpoint6.ch[3].CHARACTER_NUMBER+"<br/>"+A1063307_Checkpoint6.ch[3].money+"</p></body></html>");
							}
						}
						count=(3000/(howlong));
						repaint();
						try {            	        	
			                Thread.sleep(count);
			             } catch (InterruptedException e) {
			                e.printStackTrace();
			            }
						
						}				
			}
		}else if(who3==4){
			int pass=0;
			int x=1;
			int count=1;
			if(A1063307_Checkpoint6.random>0 && A1063307_Checkpoint6.random<4) {
				if(A1063307_Checkpoint6.ch[4].location%20>=0 && A1063307_Checkpoint6.ch[4].location/20>=1) {
					pass++;
				}
					while(x<=howlong) {
						if(x4>115 && y4==620) {
							x=x+1;
							x4=x4-1;
							}else if(y4>145 && x4==115){
							
							x=x+1;
							y4=y4-1;
							}else if(y4==145 && x4>=115 && x4<=589) {
								
								x=x+1;
								x4=x4+1;
							}else if(y4>=145 && x4==590){
								
								x=x+1;
								y4=y4+1;
							}	
						if(pass>0) {
							if(x4==590 && y4==620) {
								A1063307_Checkpoint6.ch[4].money=A1063307_Checkpoint6.ch[4].money+2000;
								label[4].setText("<html><body><p align=\'center\'>Character"+A1063307_Checkpoint6.ch[4].CHARACTER_NUMBER+"<br/>"+A1063307_Checkpoint6.ch[4].money+"</p></body></html>");
							}
						}
						count=(2000/(howlong));
						repaint();
						try {            	        	
			                Thread.sleep(count);
			             } catch (InterruptedException e) {
			                e.printStackTrace();
			            }
					}
			}else {
				if(A1063307_Checkpoint6.ch[4].location%20>=0 && A1063307_Checkpoint6.ch[4].location/20>=1) {
					pass++;
				}
					while(x<=howlong) {
						if(x4>115 && y4==620) {
							x=x+1;
							x4=x4-1;
							}else if(y4>145 && x4==115){							
							x=x+1;
							y4=y4-1;
							}else if(y4==145 && x4>=115 && x4<=589) {
								
								x=x+1;
								x4=x4+1;
							}else if(y4>=145 && x4==590){
								
								x=x+1;
								y4=y4+1;
							}	
						if(pass>0) {
							if(x4==590 && y4==620) {
								A1063307_Checkpoint6.ch[4].money=A1063307_Checkpoint6.ch[4].money+2000;
								label[4].setText("<html><body><p align=\'center\'>Character"+A1063307_Checkpoint6.ch[4].CHARACTER_NUMBER+"<br/>"+A1063307_Checkpoint6.ch[4].money+"</p></body></html>");
							}
						}
						count=(3000/(howlong));
						repaint();
						try {            	        	
			                Thread.sleep(count);
			             } catch (InterruptedException e) {
			                e.printStackTrace();
			            }						
					}					
			}
		}
		setEnabled(true);
		for(int i=1;i<=A1063307_Checkpoint6.grid;i++) {
			//System.out.println(who3);
		A1063307_Checkpoint6.ch[who3].location=A1063307_Checkpoint6.ch[who3].location%20;
		
		if(A1063307_Checkpoint6.Land[i].PLACE_NUMBER==A1063307_Checkpoint6.ch[who3].location && A1063307_Checkpoint6.Land[i].owner==0 && A1063307_Checkpoint6.ch[who3].money>=A1063307_Checkpoint6.Land[i].LAND_PRICE) {			
				JLabel b_land = new JLabel("<html><body><p align=\'center\'>"+"Do you want to buy?"+"<br/>"+"$"+A1063307_Checkpoint6.Land[i].LAND_PRICE+"</p></body></html>",SwingConstants.CENTER);
				howbuy=JOptionPane.showConfirmDialog(A1063307_Checkpoint6.gui,b_land,"DO YOU WANT TO BUY",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
		local=A1063307_Checkpoint6.Land[i].PLACE_NUMBER;
			if(howbuy==0) {
				A1063307_Checkpoint6.Land[i].owner=who3;
				A1063307_Checkpoint6.ch[who3].money=A1063307_Checkpoint6.ch[who3].money-A1063307_Checkpoint6.Land[i].LAND_PRICE;
				int z=A1063307_Checkpoint6.ch[who3].location%20;
				btn[local].setHorizontalAlignment(label_display.CENTER);
				btn[local].setText(Integer.toString(who3));
				btn[local].setFont(new java.awt.Font("Dialog", 1, 40));
			}
		}else if(A1063307_Checkpoint6.Land[i].PLACE_NUMBER==A1063307_Checkpoint6.ch[who3].location && A1063307_Checkpoint6.Land[i].owner!=0 && A1063307_Checkpoint6.Land[i].owner!=who3) {			
				JOptionPane.showMessageDialog(A1063307_GUI.this,"The land is Character"+A1063307_Checkpoint6.Land[i].owner+" have,Character"+who3+" should pay money $"+A1063307_Checkpoint6.Land[i].TOLLS,"PAY!!!",JOptionPane.PLAIN_MESSAGE);
			A1063307_Checkpoint6.ch[who3].money=A1063307_Checkpoint6.ch[who3].money-A1063307_Checkpoint6.Land[i].TOLLS;
			int x=A1063307_Checkpoint6.Land[i].owner;
			A1063307_Checkpoint6.ch[x].money=A1063307_Checkpoint6.ch[x].money+A1063307_Checkpoint6.Land[i].TOLLS;
		}
		}
		btn1.setEnabled(true);
		for(int i=1;i<5;i++) {
		label[i].setText("<html><body><p align=\'center\'>Character"+A1063307_Checkpoint6.ch[i].CHARACTER_NUMBER+"<br/>"+A1063307_Checkpoint6.ch[i].money+"</p></body></html>");
		}
		btn4.setText("Turn Character"+A1063307_Checkpoint6.ch[who2].CHARACTER_NUMBER);
		btn3.setText("ROUND  "+round);
		repaint();
		
	}
			
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mybutton){
			try {
				A1063307_Checkpoint6.Save(filename);
				havesave++;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==mybutton2) {
			try {
				setVisible(false);		
				A1063307_Checkpoint6.Load(filename);
				A1063307_GUI gui2=new A1063307_GUI();	
				gui2.setVisible(true);
				gui2.setSize(700,700);
				gui2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gui2.setResizable(false);
				who3=0;
				clickload=true;
				repaint();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
			else if(e.getSource()==btn1){
				if(A1063307_Checkpoint6.ch[who2].status>0) {
					who3=who2;
					if(who2==(line-1)){
						A1063307_Checkpoint6.Random();
					tt();
					label_display.setText(String.valueOf(A1063307_Checkpoint6.random));
					who2=1;	
					int i;
					for(i=1;i<line;i++) {
						A1063307_Checkpoint6.ch[i].status=A1063307_Checkpoint6.ch[i].status+1;
					}	
					round++;
					while(A1063307_Checkpoint6.ch[who2].status<=0) {
						who2++;
						if(who2>=(line-1)) {
							who2=1;	
							for(int x=1;x<line;x++) {
								A1063307_Checkpoint6.ch[x].status=A1063307_Checkpoint6.ch[x].status+1;
							}
							}
					}
					}
					else {
					A1063307_Checkpoint6.Random();
					tt();
					//run();
					label_display.setText(String.valueOf(A1063307_Checkpoint6.random));
					who2++;
					if(who2<=(line-1)) {
						while(A1063307_Checkpoint6.ch[who2].status<=0) {	
							who2++;
							if(who2>(line-1)) {
								for(int x=1;x<line;x++) {
									A1063307_Checkpoint6.ch[x].status=A1063307_Checkpoint6.ch[x].status+1;
								}
								who2=1;
								round++;
								}
						}													
						}				
					}
				
				}
				else{							
					if(who2==(line-1)){
						who2=1;
						int i;					
						for(i=1;i<line;i++) {
							A1063307_Checkpoint6.ch[i].status=A1063307_Checkpoint6.ch[i].status+1;
						}	
						round++;
						if(who2<=(line-1)) {
						while(A1063307_Checkpoint6.ch[who2].status<=0) {
							who2++;		
							if(who2>(line-1)) {	
								for(int x=1;x<line;x++) {
									A1063307_Checkpoint6.ch[x].status=A1063307_Checkpoint6.ch[x].status+1;
								}
								who2=1;
							}
						}
						}					
					}
					else {
						who2++;
						while(who2<=(line-1)) {
						while(A1063307_Checkpoint6.ch[who2].status<=0) {
							who2++;
							if(who2>(line-1)) {
								for(int x=1;x<line;x++) {
									A1063307_Checkpoint6.ch[x].status=A1063307_Checkpoint6.ch[x].status+1;
								}
								who2=1;
								round++;
								}
							
						}
						}
					}	
			}
				
		}
			else if(e.getSource()==mybutton3){
				/*if(havesave==0) {
					File file = new File(filename);
					file.delete();
					String file1="C:\\Users\\USER\\eclipse-workspace\\checkpoint6\\src\\checkpoint6\\Land.txt";
		        	File file2 = new File(file1);
		        	file2.delete();
				}*/
				System.exit(0);
			}
		}
}
