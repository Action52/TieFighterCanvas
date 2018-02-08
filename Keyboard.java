/*
	Description:
					KeyBoard class that implements the TieFighter and updates it
          on the canvas according to the keys that are pressed.
	Authors:
					Armando Canto Garcia A01322361 Luis Alfredo Leon Villapun A01322275
	Last modification date:
					05/02/2018
*/
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Keyboard extends JApplet implements KeyListener, FocusListener, MouseListener{
  //Global variables
  Color tieFighterColor;
  public static final int WIDTH = 1200;
  public static final int HEIGHT = 600;
  public double scaleX = 1;
  public double scaleY = 1;
  public double degrees = 0;
  public double moveInX = WIDTH/2; //Centers the object from the beggining
  public double moveInY = HEIGHT/2; //Center the object from the beggining

  public TieFighter tieFighter = new TieFighter(); //Tie Fighter object
  Scaler scaler = new Scaler(tieFighter.linesStart, tieFighter.linesEnd, tieFighter.circles, scaleX, scaleY); //Equal to call tieFighter.scale();
  Rotationer rotationer = new Rotationer(tieFighter.linesStart, tieFighter.linesEnd, tieFighter.circles, degrees); //Equal to call tieFighter.rotate();
  Translater translater = new Translater(tieFighter.linesStart, tieFighter.linesEnd, tieFighter.circles, moveInX, moveInY); //Equal to call tieFighter.translate();

  boolean focused = false;

  DisplayPanel canvas;

  /*
    Initiates the KeyBoard applet.
    In: no parameters.
    Out: void.
  */
  public void init(){

    setSize(WIDTH, HEIGHT);

    tieFighterColor = Color.black;

    canvas = new DisplayPanel();
    setContentPane(canvas);

    canvas.setBackground(Color.white);
    canvas.addFocusListener(this);
    canvas.addKeyListener(this);
    canvas.addMouseListener(this);

  }

  /*
    Nested class to create the canvas.
  */
  public class DisplayPanel extends JPanel{

    /*
      Method that paints the canvas.
      In: Graphics g
    */
    public void paintComponent(Graphics g){

      super.paintComponent(g);
      if(focused){
        g.setColor(Color.black);
        g.drawString("Rotate: Click 'E' or 'D'", 7, 20);
        g.drawString("Scale: Click 'R' or 'F'", 7, 35);
        g.drawString("Move: Press 'Up' key", 7, 50);

      }
      else{
        g.setColor(Color.lightGray);
      }

      int widthCanvas = getSize().width;
      int heightCanvas = getSize().height;
      g.drawRect(0,0,widthCanvas-1,heightCanvas-1);
      g.drawRect(1,1,widthCanvas-3,heightCanvas-3);
      g.drawRect(2,2,widthCanvas-5,heightCanvas-5);

      if (!focused) {
         g.setColor(Color.blue);
         g.drawString("Click to activate",7,20);
      }

      g.setColor(tieFighterColor);

      //Print the circles of the tie fighter
      for(int i = 0; i < tieFighter.circles.size(); i++){
        Pixel actual = tieFighter.circles.get(i);
        int sum = 10;
        g.drawOval(actual.x, actual.y, (int)(actual.radius*2*scaleX), (int)(actual.radius*2*scaleY));
      }
      //Print the lines of the tie fighter
      for(int i = 0; i < tieFighter.linesStart.size(); i++){
        Pixel actualStart = tieFighter.linesStart.get(i);
        Pixel actualEnd = tieFighter.linesEnd.get(i);
        g.drawLine(actualStart.x, actualStart.y, actualEnd.x, actualEnd.y);
      }

    }
  }

  /*
    Sets the focus of the canvas to true.
    In: FocusEvent evt
    Out: void.
  */
  public void focusGained(FocusEvent evt){
    focused = true;
    canvas.repaint();
  }

  /*
    Sets the focus of the canvas to false.
    In: FocusEvent evt
    Out: void.
  */
  public void focusLost(FocusEvent evt){
    focused = true;
    canvas.repaint();
  }


  /*
    Detects if a key is typed. Rotates the fighter if 'e' or 'd' are pressed.
    Scales the object if 'r' or 'f' are pressed.
    In: KeyEvent evt
    Out: void.
  */
  public void keyTyped(KeyEvent evt){
    char ch = evt.getKeyChar();

    if(ch == 'E' || ch =='e'){
      degrees+=3;
      tieFighter = new TieFighter(); //Resets tie fighter to adjust coordinates
      tieFighter.scale(scaleX, scaleY);
      tieFighter.rotate(degrees);
      tieFighter.translate(moveInX, moveInY);
      canvas.repaint();

    }

    if(ch == 'D' || ch == 'd'){
      degrees-=3;
      tieFighter = new TieFighter(); //Resets tie fighter to adjust coordinates
      tieFighter.scale(scaleX, scaleY);
      tieFighter.rotate(degrees);
      tieFighter.translate(moveInX, moveInY);
      canvas.repaint();

    }

    if(ch == 'R' || ch == 'r'){
      scaleX+=0.1;
      scaleY+=0.1;
      tieFighter = new TieFighter(); //Resets tie fighter to adjust coordinates
      tieFighter.scale(scaleX, scaleY);
      tieFighter.rotate(degrees);
      tieFighter.translate(moveInX, moveInY);
      canvas.repaint();
    }

    if(ch == 'F' || ch == 'f'){
      scaleX-=0.1;
      scaleY-=0.1;
      tieFighter = new TieFighter(); //Resets tie fighter to adjust coordinates
      tieFighter.scale(scaleX, scaleY);
      tieFighter.rotate(degrees);
      tieFighter.translate(moveInX, moveInY);
      canvas.repaint();

    }

  }


  /*
    Detects if a key is pressed. Moves forward, downward, or sideways according
    to the key that is being pressed.
    In: KeyEvent evt
    Out: void.
  */
  public void keyPressed(KeyEvent evt){
     int key = evt.getKeyCode();


    if(key == KeyEvent.VK_UP){
      moveInX += 2 * Math.cos(Math.toRadians(degrees-270));
      moveInY += 2 * Math.sin(Math.toRadians(degrees-270));
      tieFighter = new TieFighter(); //Resets tie fighter to adjust coordinates
      tieFighter.scale(scaleX, scaleY);
      tieFighter.rotate(degrees);
      tieFighter.translate(moveInX, moveInY);
      canvas.repaint();
    }


  }

  /*
    Detects if a key is released.
    In: KeyEvent evt
    Out: void.
  */
  public void keyReleased(KeyEvent evt){

  }

  /*
    Detects if the mouse is pressed.
    In: MouseEvent evt
    Out: void.
  */
  public void mousePressed(MouseEvent evt){
    canvas.requestFocus();
  }

  /*
    Empty methods requested by the implementation of interface MouseEvent.
  */
  public void mouseEntered(MouseEvent evt) { }
  public void mouseExited(MouseEvent evt) { }
  public void mouseReleased(MouseEvent evt) { }
  public void mouseClicked(MouseEvent evt) { }

}
