import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.applet.Applet;

public class FinalGame extends Applet implements ActionListener
{
	Boolean cool=false;
	int calc=0;
	int calc2=0;
	int calc3=0;
	int calc4=0;
	int checkmate=0;
       JLabel turnpic;
       char turn ='B';
       int last =-1;
       Panel p_card;  //to hold all of the screens
       Panel card1, card2, card3, card4, card5; //the two screens
       CardLayout cdLayout = new CardLayout ();
       Border emptyBorder = BorderFactory.createEmptyBorder();
       //grid
       int row = 8;
       int col = 8;
       JButton a[] = new JButton [row * col];
       char c[][] = {{'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}, {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'}, {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'}};
       char p [][]= {{'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R'}, {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, {'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R'}};
       char ld [][]= {{'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}, {'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}, {'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}, {'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}};
       char us[][]= {{'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}};
       char ussr[][]= {{'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}};
       char ccopied[][] = {{'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}, {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'}, {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'}};
       char pcopied [][]= {{'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R'}, {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, {'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R'}};
       char ldcopied [][]= {{'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}, {'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}, {'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}, {'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}};
       char uscopied[][]= {{'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}};
       char ussrcopied[][]= {{'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}};

       public void init ()
       {
               p_card = new Panel ();
               p_card.setLayout (cdLayout);
               screen1 ();
               screen2 ();
               screen3 ();
               screen4 ();
               screen5 ();
               
               resize (560, 630);
               setLayout (new BorderLayout ());
               initMenu ();
               add ("Center", p_card);
       }
       public void initMenu ()
       {
       JMenuBar menuBar = new JMenuBar ();
       JMenu menu;
       JMenuItem menuItem;

       menu = new JMenu ("File");
       menuBar.add (menu);

       menuItem = new JMenuItem ("Close");
       menuItem.addActionListener (this);
       menuItem.setActionCommand ("Close");
       menu.add (menuItem);

       menu = new JMenu ("Navigate");
       menuBar.add (menu);

       menuItem = new JMenuItem ("Opening");
       menuItem.addActionListener (this);
       menuItem.setActionCommand ("t1");
       menu.add (menuItem);

       menuItem = new JMenuItem ("Instructions");
       menuItem.addActionListener (this);
       menuItem.setActionCommand ("t2");
       menu.add (menuItem);

       menuItem = new JMenuItem ("Play Game");
       menuItem.addActionListener (this);
       menuItem.setActionCommand ("t3");
       menu.add (menuItem);

  
       add ("North", menuBar);
       }


       public void screen1 ()
       { //screen 1 is set up.

               card1 = new Panel ();
               card1.setBackground (Color.black);
               JButton next =new JButton(createImageIcon("chesstitle.jpg"));
               next.setSize(560,610);
               next.setActionCommand ("s2");
               next.addActionListener (this);

               next.setBorder(emptyBorder);
               card1.add (next);
               p_card.add ("1", card1);

       }


       public void screen2 ()
       { //screen 2 is set up.
               card2 = new Panel ();
               card2.setBackground (Color.black);
               JButton next =new JButton(createImageIcon("instructionsf.jpg"));
               next.setSize(560,610);
               next.setActionCommand ("s3");
               next.addActionListener (this);
               next.setBorder(emptyBorder);
               card2.add (next);
               p_card.add ("2", card2);
       }


       public void screen3 ()
       { //screen 3 is set up.


           card3 = new Panel ();
           card3.setBackground (Color.black);
           JLabel title = new JLabel ("CHESS");
           title.setFont(new Font("Serif", Font.BOLD, 34)); 
           title.setForeground(Color.orange);
           
           JLabel next = new JLabel ("TURN:");
           next.setForeground(Color.orange);
           next.setFont(new Font("Serif", Font.BOLD, 23));
           turnpic =new JLabel(createImageIcon("BPDU.jpg"));

           //Set up grid
           Panel pan = new Panel (new GridLayout (row, col));
           int move = 0;
           for (int i = 0 ; i < row ; i++)
           {
                   for (int j = 0 ; j < col ; j++)
                   { 
                           a [move] = new JButton (createImageIcon (c [i] [j] +""+p [i][j]+""+ld [i][j]+""+ us[i][j]+".jpg"));
                           a [move].setPreferredSize (new Dimension (60, 60));
                           a [move].addActionListener (this);
                           a [move].setActionCommand ("" + move);
                           
                           pan.add (a [move]);
                           move++;
                   }
           }
           card3.add (title);
           card3.add (pan);
           card3.add (next);
           card3.add (turnpic);
           p_card.add ("3", card3);

       }


       public void screen4 ()
       { //screen 4 is set up.
    	   JButton next =new JButton(createImageIcon("p1winm1.jpg"));
           next.setSize(560,610);
              card4 = new Panel ();
              card4.setBackground (Color.black);
              next.setBorder(emptyBorder);
              next.setActionCommand ("s5");
             
              card4.add (next);
              p_card.add ("4", card4);

       }


       public void screen5 ()
       { //screen 5 is set up.
    		 JButton next =new JButton(createImageIcon("p2winsm2.jpg"));
             next.setSize(560,610);
                card5 = new Panel ();
                card5.setBackground (Color.black);
              
                next.setActionCommand ("s1");
                next.addActionListener (this);
                next.setBorder(emptyBorder);
  
               
                card5.add (next);
 
                p_card.add ("5", card5);

       }


       protected static ImageIcon createImageIcon (String path)
       { //change the red to your class name
               java.net.URL imgURL = FinalGame.class.getResource (path);
               if (imgURL != null)
               {
                       return new ImageIcon (imgURL);
               }
               else
               {
                       System.err.println ("Couldn't find file: " + path);
                       return null;
               }
       }


       public void redraw ()
       {
               int move = 0;
               for (int i = 0 ; i < row ; i++)
               {
                       for (int j = 0 ; j < col ; j++)
                       {
                               a [move].setIcon (createImageIcon (c [i] [j] +""+p [i][j]+""+ld [i][j]+""+ us[i][j]+".jpg"));
                               move++;
                       }
               }
       }
       public void selectPawn (int x, int y) {
               if (turn=='B') {

               if (c[x][y]=='B')
                       us [x-1][y]='S';
               if (c[x][y]=='B'&&x==6)
                       us [x-2][y]='S';
               }
               else {

                 if (c[x][y]=='W')
                         us [x+1][y]='S';
                 if (c[x][y]=='W'&&x==1)
                         us [x+2][y]='S';      

               }
       }
       public void selectPawnussr (int x, int y) {


    if (c[x][y]=='B') {

               if (c[x][y]=='B')
                       ussr [x-1][y]='S';
               if (c[x][y]=='B'&&x==6)
                       ussr [x-2][y]='S';
               }
    if (c[x][y]=='W') {

                 if (c[x][y]=='W')
                         ussr [x+1][y]='S';
                 if (c[x][y]=='W'&&x==1)
                         ussr [x+2][y]='S';      

               }
       }
       public void bishopussr (int x, int y) {

       	if (c[x][y]=='B') {
   			for(int i=1;i<row;i++) {
   				if (x-i>=0&&y+i<=7&&c[x-i][y+i]!='B') 
   					ussr[x-i][y+i]='S';
   				else 
   					i=7;
   			}
   			for(int i=1;i<row;i++) {
   				if (x-i>=0&&y-i>=0&&c[x-i][y-i]!='B') 
   					ussr[x-i][y-i]='S';
   				else 
   					i=7;
   			}
   			for(int j=1;j<row;j++) {
   				if (x+j<=7&&y-j>=0&&c[x+j][y-j]!='B') 
   					ussr[x+j][y-j]='S';
   				else 
   					j=7;
   			}
   			for(int i=1;i<row;i++) {
   				if (x+i<=7&&y+i<=7&&c[x+i][y+i]!='B') 
   					ussr[x+i][y+i]='S';
   				else 
   					i=7;
   			}
   		}

   		if (c[x][y]=='W') {
   			for(int i=1;i<row;i++) {
   				if (x-i>=0&&y+i<=7&&c[x-i][y+i]!='W') 
   					ussr[x-i][y+i]='S';
   				else 
   					i=7;
   			}
   			for(int i=1;i<row;i++) {
   				if (x-i>=0&&y-i>=0&&c[x-i][y-i]!='W') 
   					ussr[x-i][y-i]='S';
   				else 
   					i=7;
   			}
   			for(int j=1;j<row;j++) {
   				if (x+j<=7&&y-j>=0&&c[x+j][y-j]!='W') 
   					ussr[x+j][y-j]='S';
   				else 
   					j=7;
   			}
   			for(int i=1;i<row;i++) {
   				if (x+i<=7&&y+i<=7&&c[x+i][y+i]!='W') 
   					ussr[x+i][y+i]='S';
   				else 
   					i=7;
   			}
   		}
   	}
       public void selectRookussr (int x, int y) {
       	int cx1=x-1;
   		while (cx1>=0 && c[cx1][y]=='O') {
   			ussr[cx1][y]='S';
   			cx1--;
   		}
   		if (cx1>=0&&c[cx1][y]!=c[x][y]&& c[cx1][y]!='O') {
   			ussr[cx1][y]='S';	
   			}
   		
   		int cx2=x+1;
   		while (cx2<=7 && c[cx2][y]=='O') {
   			ussr[cx2][y]='S';
   			cx2++;
   		}
   		if (cx2<=7&&c[cx2][y]!=c[x][y]&& c[cx2][y]!='O') {
   			ussr[cx2][y]='S';	
   			}
   		int cy1=y+1;
   		while (cy1<=7 && c[x][cy1]=='O') {
   			ussr[x][cy1]='S';
   			cy1++;
   		}
   		if (cy1<=7&&c[x][cy1]!=c[x][y]&& c[x][cy1]!='O') {
   			ussr[x][cy1]='S';	
   			}
   		int cy2=y-1;
   		while (cy2>=0 && c[x][cy2]=='O') {
   			ussr[x][cy2]='S';
   			cy2--;
   		}
   		if (cy2>=0&&c[x][cy2]!=c[x][y]&& c[x][cy2]!='O') {
   			ussr[x][cy2]='S';	
   			}
   		
   		
   	}

       public void selectRook (int x, int y) {

       	int cx1=x-1;
   		while (cx1>=0 && c[cx1][y]=='O') {
   			us[cx1][y]='S';
   			cx1--;
   		}
   		if (cx1>=0&&c[cx1][y]!=c[x][y]&& c[cx1][y]!='O') {
   			us[cx1][y]='S';	
   			}
   		
   		int cx2=x+1;
   		while (cx2<=7 && c[cx2][y]=='O') {
   			us[cx2][y]='S';
   			cx2++;
   		}
   		if (cx2<=7&&c[cx2][y]!=c[x][y]&& c[cx2][y]!='O') {
   			us[cx2][y]='S';	
   			}
   		int cy1=y+1;
   		while (cy1<=7 && c[x][cy1]=='O') {
   			us[x][cy1]='S';
   			cy1++;
   		}
   		if (cy1<=7&&c[x][cy1]!=c[x][y]&& c[x][cy1]!='O') {
   			us[x][cy1]='S';	
   			}
   		int cy2=y-1;
   		while (cy2>=0 && c[x][cy2]=='O') {
   			us[x][cy2]='S';
   			cy2--;
   		}
   		if (cy2>=0&&c[x][cy2]!=c[x][y]&& c[x][cy2]!='O') {
   			us[x][cy2]='S';	
   			}
   		
   		
   	}

              public void bishop (int x, int y) {

            	  int cx1=x-1;
            	  int cy1=y+1;
            	  while (cx1>=0 &&cy1<=7&& c[cx1][cy1]=='O') {
            	  us[cx1][cy1]='S';
            	  cx1--;
            	  cy1++;
            	  }
            	  if (cx1>=0&&cy1<=7&&c[cx1][cy1]!=c[x][y]&& c[cx1][cy1]!='O') {
            	  us[cx1][cy1]='S';
            	  }


            	  int cx2=x-1;
            	  int cy2=y-1;
            	  while (cx2>=0 &&cy2>=0&& c[cx2][cy2]=='O') {
            	  us[cx2][cy2]='S';
            	  cx2--;
            	  cy2--;
            	  }
            	  if (cx2>=0&&cy2>=0&&c[cx2][cy2]!=c[x][y]&& c[cx2][cy2]!='O') {
            	  us[cx2][cy2]='S';
            	  }
            	  int cx3=x+1;
            	  int cy3=y+1;
            	  while (cx3<=7 &&cy3<=7&& c[cx3][cy3]=='O') {
            	  us[cx3][cy3]='S';
            	  cx3++;
            	  cy3++;
            	  }
            	  if (cx3<=7 &&cy3<=7&&c[cx3][cy3]!=c[x][y]&& c[cx3][cy3]!='O') {
            	  us[cx3][cy3]='S';
            	  }
            	  int cx4=x+1;
            	  int cy4=y-1;
            	  while (cx4<=7 &&cy4>=0&& c[cx4][cy4]=='O') {
            	  us[cx4][cy4]='S';
            	  cx4++;
            	  cy4--;
            	  }
            	  if (cx4<=7 &&cy4>=0&&c[cx4][cy4]!=c[x][y]&& c[cx4][cy4]!='O') {
            	  us[cx4][cy4]='S';
            	  }
            	  for(int i=0;i<=7;i++) {
            	  for(int j=0;j<=7;j++) {
            	  if (p[i][j]=='K') {
            	  us[i][j]='U';
            	  }
            	  }
            	  }
            	  }




       public void Queen (int x, int y) {
    		if (c[x][y]=='B') {
       	bishop (x,y);
       	selectRook(x,y);
       		}

    		else if (c[x][y]=='W') {
    			bishop (x,y);
    	       	selectRook(x,y);
       			}
       		}
       	


       public void Queenussr (int x, int y) {
      		if (c[x][y]=='B') {
      	       	bishopussr (x,y);
      	       	selectRookussr(x,y);
      	       		}

      	    		else if (c[x][y]=='W') {
      	    			bishopussr (x,y);
      	    	       	selectRookussr(x,y);
      	       			}
      	       		}



       public void horseman (int x, int y) {
       	  if (turn=='B') {
                 if (x>=2&&y>=1&&c[x-2][y-1]!='B') {
                          us [x-2][y-1]='S';


                 }
                 if (x>=2&&y<=6&&c[x-2][y+1]!='B') {
                  us [x-2][y+1]='S';


         }
                 if (x<=5&&y>=1&&c[x+2][y-1]!='B') {
                  us [x+2][y-1]='S';


         }
         if (x<=5&&y<=6&&c[x+2][y+1]!='B') {
                  us [x+2][y+1]='S';


         }
         if (x-1>=0&&y-2>=0&&c[x-1][y-2]!='B') {
                  us [x-1][y-2]='S';


         }
         if (x+1<=7&&y-2>=0&&c[x+1][y-2]!='B') {
                  us [x+1][y-2]='S';


         }
         if (x-1>=0&&y+2<=7&&c[x-1][y+2]!='B') {
                  us [x-1][y+2]='S';


         }
         if (x+1<=7&&y+2<=7&&c[x+1][y+2]!='B') {
                  us [x+1][y+2]='S';


         }


         }
         else {
                 if (x>=2&&y>=1&&c[x-2][y-1]!='W') {
                  us [x-2][y-1]='S';


         }
         if (x>=2&&y<=6&&c[x-2][y+1]!='W') {
                  us [x-2][y+1]='S';


         }
         if (x<=5&&y>=1&&c[x+2][y-1]!='W') {
                  us [x+2][y-1]='S';


         }
         if (x<=5&&y<=6&&c[x+2][y+1]!='W') {
                  us [x+2][y+1]='S';


         }
         if (x-1>=0&&y-2>=0&&c[x-1][y-2]!='W') {
                  us [x-1][y-2]='S';


         }
         if (x+1<=7&&y-2>=0&&c[x+1][y-2]!='W') {
                  us [x+1][y-2]='S';


         }
         if (x-1>=0&&y+2<=7&&c[x-1][y+2]!='W') {
                  us [x-1][y+2]='S';


         }
         if (x+1<=7&&y+2<=7&&c[x+1][y+2]!='W') {
                  us [x+1][y+2]='S';


         }

         }

 }
       public void horsemanussr (int x, int y) {
       	  if (c[x][y]=='B')  {
                 if (x>=2&&y>=1&&c[x-2][y-1]!='B') {
                          ussr [x-2][y-1]='S';


                 }
                 if (x>=2&&y<=6&&c[x-2][y+1]!='B') {
                  ussr [x-2][y+1]='S';


         }
                 if (x<=5&&y>=1&&c[x+2][y-1]!='B') {
                  ussr [x+2][y-1]='S';


         }
         if (x<=5&&y<=6&&c[x+2][y+1]!='B') {
                  ussr [x+2][y+1]='S';


         }
         if (x-1>=0&&y-2>=0&&c[x-1][y-2]!='B') {
                  ussr [x-1][y-2]='S';


         }
         if (x+1<=7&&y-2>=0&&c[x+1][y-2]!='B') {
                  ussr [x+1][y-2]='S';


         }
         if (x-1>=0&&y+2<=7&&c[x-1][y+2]!='B') {
                  ussr [x-1][y+2]='S';


         }
         if (x+1<=7&&y+2<=7&&c[x+1][y+2]!='B') {
                  ussr [x+1][y+2]='S';


         }


         }
         else {
                 if (x>=2&&y>=1&&c[x-2][y-1]!='W') {
                  ussr [x-2][y-1]='S';


         }
         if (x>=2&&y<=6&&c[x-2][y+1]!='W') {
                  ussr [x-2][y+1]='S';


         }
         if (x<=5&&y>=1&&c[x+2][y-1]!='W') {
                  ussr [x+2][y-1]='S';


         }
         if (x<=5&&y<=6&&c[x+2][y+1]!='W') {
                  ussr [x+2][y+1]='S';


         }
         if (x-1>=0&&y-2>=0&&c[x-1][y-2]!='W') {
                  ussr [x-1][y-2]='S';


         }
         if (x+1<=7&&y-2>=0&&c[x+1][y-2]!='W') {
                  ussr [x+1][y-2]='S';


         }
         if (x-1>=0&&y+2<=7&&c[x-1][y+2]!='W') {
                  ussr [x-1][y+2]='S';


         }
         if (x+1<=7&&y+2<=7&&c[x+1][y+2]!='W') {
                  ussr [x+1][y+2]='S';


         }

         }

 }
       public void king (int x, int y) {
               if (turn=='B') {
                       if (y+1<=7&&x-1>=0&&c[x-1][y+1]!='B') {
                               us [x-1][y+1]='S';

                       }
                       if (x-1>=0&&c[x-1][y]!='B') {
                               us [x-1][y]='S';
                       }
                       if (x-1>=0&&y-1>=0&&c[x-1][y-1]!='B') {
                               us [x-1][y-1]='S';
                       }
                       if (y-1>=0&&c[x][y-1]!='B') {
                               us [x][y-1]='S';
                       }
                       if (y+1<=7&&x+1<=7&&c[x+1][y+1]!='B') {
                               us [x+1][y+1]='S';
                       }
                       if (x+1<=7&&c[x+1][y]!='B') {
                               us [x+1][y]='S';
                       }
                       if (x+1<=7&&y-1>=0&&c[x+1][y-1]!='B') {
                               us [x+1][y-1]='S';
                       }
                       if (y+1<=7&&c[x][y+1]!='B') {
                               us [x][y+1]='S';
                       }
               }
               else {
                       if (y+1<=7&&x-1>=0&&c[x-1][y+1]!='W') {
                               us [x-1][y+1]='S';
                       }
                       if (x-1>=0&&c[x-1][y]!='W') {
                               us [x-1][y]='S';
                       }
                       if (x-1>=0&&y-1>=0&&c[x-1][y-1]!='W') {
                               us [x-1][y-1]='S';
                       }
                       if (y-1>=0&&c[x][y-1]!='W') {
                               us [x][y-1]='S';
                       }
                       if (y+1<=7&&x+1<=7&&c[x+1][y+1]!='W') {
                               us [x+1][y+1]='S';
                       }
                       if (x+1<=7&&c[x+1][y]!='W') {
                               us [x+1][y]='S';
                       }
                       if (x+1<=7&&y-1>=0&&c[x+1][y-1]!='W') {
                               us [x+1][y-1]='S';
                       }
                       if (y+1<=7&&c[x][y+1]!='W') {
                               us [x][y+1]='S';
                       }
               }
       }
       public void kingussr (int x, int y) {
           if (turn=='B') {
                   if (y+1<=7&&x-1>=0&&c[x-1][y+1]!='B'&&ussr[x-1][y+1]!='S') {
                           us [x-1][y+1]='S';
                           checkmate++;

                   }
                   if (x-1>=0&&c[x-1][y]!='B'&&ussr[x-1][y]!='S') {
                           us [x-1][y]='S';
                           checkmate++;

                   }
                   if (x-1>=0&&y-1>=0&&c[x-1][y-1]!='B'&&ussr[x-1][y-1]!='S') {
                           us [x-1][y-1]='S';
                           checkmate++;

                   }
                   if (y-1>=0&&c[x][y-1]!='B'&&ussr[x][y-1]!='S') {
                           us [x][y-1]='S';
                           checkmate++;

                   }
                   if (y+1<=7&&x+1<=7&&c[x+1][y+1]!='B'&&ussr[x+1][y+1]!='S') {
                           us [x+1][y+1]='S';
                           checkmate++;

                   }
                   if (x+1<=7&&c[x+1][y]!='B'&&ussr[x+1][y]!='S') {
                           us [x+1][y]='S';
                           checkmate++;

                   }
                   if (x+1<=7&&y-1>=0&&c[x+1][y-1]!='B'&&ussr[x+1][y-1]!='S') {
                           us [x+1][y-1]='S';
                           checkmate++;

                   }
                   if (y+1<=7&&c[x][y+1]!='B'&&ussr[x][y+1]!='S') {
                           us [x][y+1]='S';
                           checkmate++;

                   }
           }
           else {
                   if (y+1<=7&&x-1>=0&&c[x-1][y+1]!='W'&&ussr[x-1][y+1]!='S') {
                           us [x-1][y+1]='S';
                           checkmate++;

                   }
                   if (x-1>=0&&c[x-1][y]!='W'&&ussr[x-1][y]!='S') {
                           us [x-1][y]='S';
                           checkmate++;

                   }
                   if (x-1>=0&&y-1>=0&&c[x-1][y-1]!='W'&&ussr[x-1][y-1]!='S') {
                           us [x-1][y-1]='S';
                           checkmate++;

                   }
                   if (y-1>=0&&c[x][y-1]!='W'&&ussr[x][y-1]!='S') {
                           us [x][y-1]='S';
                           checkmate++;

                   }
                   if (y+1<=7&&x+1<=7&&c[x+1][y+1]!='W'&&ussr[x+1][y+1]!='S') {
                           us [x+1][y+1]='S';
                           checkmate++;

                   }
                   if (x+1<=7&&c[x+1][y]!='W'&&ussr[x+1][y]!='S') {
                           us [x+1][y]='S';
                           checkmate++;

                   }
                   if (x+1<=7&&y-1>=0&&c[x+1][y-1]!='W'&&ussr[x+1][y-1]!='S') {
                           us [x+1][y-1]='S';
                           checkmate++;

                   }
                   if (y+1<=7&&c[x][y+1]!='W'&&ussr[x][y+1]!='S') {
                           us [x][y+1]='S';
                           checkmate++;

                   }
           }
   }
       public void chessmate (int x, int y) {
       	

       	 for(int i=0;i<=7;i++) {
           	 for(int j=0;j<=7;j++) {
           		 if (p[i][j]=='K'&&c[i][j]=='B'){
           			 calc=i;
           		 calc2=j;
           		 }
           	 } 
           	}
       for(int i=0;i<=7;i++) {
       	 for(int j=0;j<=7;j++) {
       		 if (turn=='B'){
       		 if (p[i][j]=='P'&&c[i][j]!='B') {
       			 selectPawnussr(i,j);
       			 if (ussr[calc][calc2]=='S'&&turn=='B') {
       			
       				  if (p[x][y]=='K'){
       					  kingussr(calc,calc2);
       					
       				  }
       				  cool=true;
       			 }
       		 }
       			 if (p[i][j]=='R'&&c[i][j]!='B') {
           			 selectRookussr(i,j);
           			 if (ussr[calc][calc2]=='S'&&turn=='B') {
           			
           				 if (p[x][y]=='K'){
          					  kingussr(calc,calc2);
          					
          				  }
           				  cool=true;
           			 }
       			 }
           			 if (p[i][j]=='B'&&c[i][j]!='B') {
               			 bishopussr(i,j);
               			 if (ussr[calc][calc2]=='S'&&turn=='B') {
               			
               				 if (p[x][y]=='K'){
              					  kingussr(calc,calc2);
              					
              				  }
               				  cool=true;
               			 }
       			
       		 
       		 }
           			 if (p[i][j]=='Q'&&c[i][j]!='B') {
           				 Queenussr(i,j);
               			 if (ussr[calc][calc2]=='S'&&turn=='B') {
               				 
               				 if (p[x][y]=='K'){
              					  kingussr(calc,calc2);
              					
              				  }
               				  cool=true;
               			 }
           			 }
           			 if (p[i][j]=='N'&&c[i][j]!='B') {
           				  horsemanussr(i,j);
               			 if (ussr[calc][calc2]=='S'&&turn=='B') {

               				 if (p[x][y]=='K'){
              					  kingussr(calc,calc2);
              					
              				  }
               				  cool=true;
               			 }
           			 }
    	
       		 }
       	 }
       }
       if (checkmate==0&&ussr[calc][calc2]=='S'&&c[calc][calc2]=='B'&&p[calc][calc2]=='K') {           
    	   cdLayout.show (p_card, "5");
   		resettheboard();




       }
	 if (checkmate!=0) {
           checkmate=0;

       }
       for (int i=0;i<=7;i++){
			for (int j=0;j<=7;j++){
				ussr[i][j]='U';
			}
		}


       }
       public void chessmatew (int x, int y) {
       	

       	for(int a=0;a<=7;a++) {
				for(int b=0;b<=7;b++) {
					if (p[a][b]=='K'&&c[a][b]=='W'){
						calc3=a;
						calc4=b;
					}
				} 
			}
			for(int a=0;a<=7;a++) {
				for(int b=0;b<=7;b++) {
					if (p[a][b]=='P'&&c[a][b]!='W') {
						selectPawnussr(a,b);

						if (ussr[calc3][calc4]=='S'&&turn=='W') {
							if(p[x][y]=='K'){
								kingussr(calc3,calc4);
							}

							cool=true;
						}
					}
					if (p[a][b]=='R'&&c[a][b]!='W') {
						selectRookussr(a,b);
						if (ussr[calc3][calc4]=='S'&&turn=='W') {

							if(p[x][y]=='K'){
								kingussr(calc3,calc4);
							}
							cool=true;
						}
					}
					if (p[a][b]=='B'&&c[a][b]!='W') {
						bishopussr(a,b);
						if (ussr[calc3][calc4]=='S'&&turn=='W') {

							if(p[x][y]=='K'){
								kingussr(calc3,calc4);
							}
							cool=true;
						}


					}
					if (p[a][b]=='Q'&&c[a][b]!='W') {
						Queenussr(a,b);
						if (ussr[calc3][calc4]=='S'&&turn=='W') {

							if(p[x][y]=='K'){
								kingussr(calc3,calc4);
							}
							cool=true;
						}
					}
					if (p[a][b]=='N'&&c[a][b]!='W') {
						horsemanussr(a,b);
						if (ussr[calc3][calc4]=='S'&&turn=='W') {

							if(p[x][y]=='K'){
								kingussr(calc3,calc4);
							}
							cool=true;
						}
					}
					if (p[a][b]=='N'&&c[a][b]!='W') {
						horsemanussr(a,b);
						if (ussr[calc3][calc4]=='S'&&turn=='W') {

							if(p[x][y]=='K'){
								kingussr(calc3,calc4);
							}
							cool=true;
						}
					}

				}
			}
			 if (checkmate==0&&ussr[calc3][calc4]=='S'&&c[calc3][calc4]=='W'&&p[calc3][calc4]=='K') {
				 cdLayout.show (p_card, "4");
		resettheboard();


		        }
			 if (checkmate!=0) {
		            checkmate=0;

		        }
			for (int i=0;i<=7;i++){
				for (int j=0;j<=7;j++){
					ussr[i][j]='U';
				}
			}
			 
       }
       	
public void resettheboard() {
	checkmate=0;
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	for (int j = 0 ; j < col ; j++)
	{
	
	
	us[i][j]=uscopied[i][j];
	p[i][j]=pcopied[i][j];
	ussr[i][j]=ussrcopied[i][j];
	c[i][j]=ccopied[i][j];
	turn='B';
	a [move].setIcon (createImageIcon (c [i] [j] +""+p [i][j]+""+ld [i][j]+""+ us[i][j]+".jpg"));
	move++;
	}
	}

	}

       	
       	






       public void actionPerformed (ActionEvent e)
       { //moves between the screens
               if (e.getActionCommand ().equals ("s1"))
                       cdLayout.show (p_card, "1");
               else if (e.getActionCommand ().equals ("s2"))
                       cdLayout.show (p_card, "2");
               else if (e.getActionCommand ().equals ("s3"))
                       cdLayout.show (p_card, "3");
               else if (e.getActionCommand ().equals ("s4"))
                       cdLayout.show (p_card, "4");
               else if (e.getActionCommand ().equals ("s5"))
                       cdLayout.show (p_card, "5");
               else if (e.getActionCommand ().equals ("s6"))
                       System.exit (0);
               else if (e.getActionCommand ().equals ("t4"))
               	cdLayout.show (p_card, "4");
               	else if (e.getActionCommand ().equals ("t2"))
               	cdLayout.show (p_card, "2");
               	else if (e.getActionCommand ().equals ("t3"))
               	cdLayout.show (p_card, "3");
               	else if (e.getActionCommand ().equals ("t1"))
               	cdLayout.show (p_card, "1");
               	else if (e.getActionCommand ().equals ("Close"))
               	System.exit (0);

               else
               { //code to handle the game
               	
                       int n = Integer.parseInt (e.getActionCommand ());
                       int x = n / col;
                       int y = n % col;
                       if (turn=='B')
                           chessmate (x,y);
                      if (turn=='W')
                       chessmatew (x,y);
                      if (turn!=c[x][y]&&last==-1) {
                    	  JOptionPane.showMessageDialog (null, "Click On Appropriate Piece", "Error",
                    		        JOptionPane.ERROR_MESSAGE);
                    }

                       else if (last==-1 && turn==c[x][y]) {
                       	

                       	 if (cool==false) {
                               if(p[x][y]=='P')                         
                                       selectPawn(x,y);

                               if (p[x][y]=='R')                               
                                       selectRook(x,y);

                               if (p[x][y]=='B')
                                       bishop(x,y);

                               if (p[x][y]=='Q')
                                       Queen(x,y);
                               if (p[x][y]=='N')
                                       horseman(x,y);
                               if (p[x][y]=='K')
                               	
                                       king(x,y);

                       	 }
                       	 else if (cool==true) {            
                       		 cool=false;
                       	 }
                               //add other pieces
                               last=n;
                       }
                       else {
                               int lastx=last/col;
                               int lasty= last%col;
                               if (us[x][y]=='S') {
                                       p[x][y]=p[lastx][lasty];
                                       p[lastx][lasty]='O';
                                       c[x][y]=c[lastx][lasty];
                                       c[lastx][lasty]='O';



                                       //add more
                                       if (turn=='B'){
                                               turnpic.setIcon(createImageIcon("WPLU.jpg"));
                                               turn='W';
                                       }
                                       else{
                                               turnpic.setIcon(createImageIcon("BPDU.jpg"));
                                               turn='B';
                                       }
                               }


                               for(int i=0; i<row;i++) {
                                       for(int j=0;j<col;j++)
                                       {
                                               us[i][j]='U';
                                       }
                               }
                               last=-1;
                       }
                       redraw();

               }
       }
}