/*
	Description:
					Main loader class that generates the canvas to play with the Tie Fighter.
	Authors:
					Armando Canto Garcia A01322361 Luis Alfredo Leon Villapun A01322275
	Last modification date:
					05/02/2018
*/

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
  Main method.
*/
public class Main{
  public static void main(String[] args){

    final int WIDTH = 1000;
    final int HEIGHT = 600;

    Keyboard applet = new Keyboard();
    applet.init();

    final JFrame frame = new JFrame("Tie Fighter Canvas");

    frame.setContentPane(applet.getContentPane());
    frame.setJMenuBar(applet.getJMenuBar());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH, HEIGHT);
    frame.setLocation(100, 100);
    frame.setVisible(true);

    applet.start();
  }
}
