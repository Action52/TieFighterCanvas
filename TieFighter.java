/*
	Description:
					Program that generates the coordinates that represent a TieFighter.
	Authors:
					Armando Canto Garcia A01322361 Luis Alfredo Leon Villapun A01322275
	Last modification date:
					03/02/2018
*/

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.*;

public class TieFighter{
  //Global variables
  public  int[] position = {0,0};
  public  final int WIDTH = 240;
  public  final int HEIGHT = 160;
  public  int[] center = {0, 0}; //Sets center in the middle of the ship
  public  ArrayList<Pixel> linesStart = new ArrayList<Pixel>(); //Saves coordinates for the start of the lines
  public  ArrayList<Pixel> linesEnd = new ArrayList<Pixel>(); //Saves coordinates for the end of the lines
  public  ArrayList<Pixel> circles = new ArrayList<Pixel>(); //Saves the coordinates of the circles


  /*
    Constructor.
    In: no parameters.
    Out: TieFighter object
  */
  public TieFighter(){
    drawTieFighter();
  }

  /*
    Sets position.
    In: int x, int y.
    Out: void
  */
  public  void setPosition(int x, int y){
    position[0] = x;
    position[1] = y;
  }

  /*
    Draws the Tie Fighter.
    In: no parameters.
    Out: void.
  */
  public  void drawTieFighter(){

    if(!linesStart.isEmpty()){
      linesStart.clear();
    }
    if(!linesEnd.isEmpty()){
      linesEnd.clear();
    }
    if(!circles.isEmpty()){
      circles.clear();
    }

    //Circles of the ship
    setPosition(center[0] - 10, center[1] - 10);
    circles.add(new Pixel(position[0], position[1], 10));
    setPosition(center[0] - 20, center[1] - 20);
    circles.add(new Pixel(position[0], position[1], 20));
    setPosition(center[0] - 30, center[1] - 30);
    circles.add(new Pixel(position[0], position[1], 30));



    setPosition(center[0], center[1]); //Volvemos al centro

    //Ala izquierda
    setPosition(center[0], center[1] - 30);
    linesStart.add(new Pixel(position[0], position[1], 0));
    setPosition(center[0] - 70, center[1] - 10);
    linesEnd.add(new Pixel(position[0], position[1], 0));

    setPosition(center[0], center[1] + 30);
    linesStart.add(new Pixel(position[0], position[1], 0));
    setPosition(center[0] - 70, center[1] + 10);
    linesEnd.add(new Pixel(position[0], position[1], 0));

    setPosition(center[0], center[1]); //Volvemos al centro

    linesStart.add(new Pixel(position[0] - 30, position[1], 0 ));
    linesEnd.add(new Pixel(position[0] - 100, position[1], 0));

    linesStart.add(new Pixel(position[0] - 100, position[1] - 80, 0));
    linesEnd.add(new Pixel(position[0] -  100, position[1] + 80, 0));

    linesStart.add(new Pixel(position[0] - 100, position[1] - 80, 0));
    linesEnd.add(new Pixel(position[0] - 120, position[1] - 20, 0));

    linesStart.add(new Pixel(position[0] - 100, position[1] + 80, 0));
    linesEnd.add(new Pixel(position[0] - 120, position[1] + 20, 0));

    linesStart.add(new Pixel(position[0] - 120, position[1] - 20, 0));
    linesEnd.add(new Pixel(position[0] - 120, position[1] + 20, 0));

    setPosition(center[0], center[1]); //Volvemos al centro

    setPosition(center[0] - 70, center[1] - 10);
    linesStart.add(new Pixel(position[0], position[1], 0));
    setPosition(center[0] - 100, center[1] - 10);
    linesEnd.add(new Pixel(position[0], position[1], 0));

    setPosition(center[0] - 70, center[1] + 10);
    linesStart.add(new Pixel(position[0], position[1], 0));
    setPosition(center[0] - 100, center[1] + 10);
    linesEnd.add(new Pixel(position[0], position[1], 0));

    //Ala derecha
    setPosition(center[0], center[1] - 30);
    linesStart.add(new Pixel(position[0], position[1], 0));
    setPosition(center[0] + 70, center[1] - 10);
    linesEnd.add(new Pixel(position[0], position[1], 0));

    setPosition(center[0], center[1] + 30);
    linesStart.add(new Pixel(position[0], position[1], 0));
    setPosition(center[0] + 70, center[1] + 10);
    linesEnd.add(new Pixel(position[0], position[1], 0));

    setPosition(center[0], center[1]); //Volvemos al centro

    linesStart.add(new Pixel(position[0] + 30, position[1], 0 ));
    linesEnd.add(new Pixel(position[0] + 100, position[1], 0));

    linesStart.add(new Pixel(position[0] + 100, position[1] - 80, 0));
    linesEnd.add(new Pixel(position[0] +  100, position[1] + 80, 0));

    linesStart.add(new Pixel(position[0] + 100, position[1] - 80, 0));
    linesEnd.add(new Pixel(position[0] + 120, position[1] - 20, 0));

    linesStart.add(new Pixel(position[0] + 100, position[1] + 80, 0));
    linesEnd.add(new Pixel(position[0] + 120, position[1] + 20, 0));

    linesStart.add(new Pixel(position[0] + 120, position[1] - 20, 0));
    linesEnd.add(new Pixel(position[0] + 120, position[1] + 20, 0));

    setPosition(center[0], center[1]); //Volvemos al centro

    setPosition(center[0] + 70, center[1] - 10);
    linesStart.add(new Pixel(position[0], position[1], 0));
    setPosition(center[0] + 100, center[1] - 10);
    linesEnd.add(new Pixel(position[0], position[1], 0));

    setPosition(center[0] + 70, center[1] + 10);
    linesStart.add(new Pixel(position[0], position[1], 0));
    setPosition(center[0] + 100, center[1] + 10);
    linesEnd.add(new Pixel(position[0], position[1], 0));

    setPosition(center[0], center[1]); //Volvemos al centro
    //Central lines
    linesStart.add(new Pixel(position[0] - 10, position[1], 0));
    linesEnd.add(new Pixel(position[0] - 20, position[1], 0));
    linesStart.add(new Pixel(position[0] + 10, position[1], 0));
    linesEnd.add(new Pixel(position[0] + 20, position[1], 0));
    linesStart.add(new Pixel(position[0], position[1] - 10, 0));
    linesEnd.add(new Pixel(position[0], position[1] - 20, 0));
    linesStart.add(new Pixel(position[0], position[1] + 10, 0));
    linesEnd.add(new Pixel(position[0], position[1] + 20, 0));
    linesStart.add(new Pixel(position[0] - 10, position[1] - 10, 0));
    linesEnd.add(new Pixel(position[0]- 20, position[1] - 20, 0));
    linesStart.add(new Pixel(position[0] + 10, position[1] + 10, 0));
    linesEnd.add(new Pixel(position[0] + 20, position[1] + 20, 0));
    linesStart.add(new Pixel(position[0] + 10, position[1] - 10, 0));
    linesEnd.add(new Pixel(position[0] + 20, position[1] - 20, 0));
    linesStart.add(new Pixel(position[0] - 10, position[1] + 10, 0));
    linesEnd.add(new Pixel(position[0] - 20, position[1] + 20, 0));

    //Thrusters
    linesStart.add(new Pixel(position[0] - 30, position[1] + 20, 0));
    linesEnd.add(new Pixel(position[0] - 30, position[1] + 40, 0));

    linesStart.add(new Pixel(position[0] + 30, position[1] + 20, 0));
    linesEnd.add(new Pixel(position[0] + 30, position[1] + 40, 0));

    linesStart.add(new Pixel(position[0] - 30, position[1] + 40, 0));
    linesEnd.add(new Pixel(position[0] + 30, position[1] + 40, 0));

    linesStart.add(new Pixel(position[0] - 10, position[1] + 40, 0));
    linesEnd.add(new Pixel(position[0] - 10, position[1] + 50, 0));

    linesStart.add(new Pixel(position[0] + 10, position[1] + 40, 0));
    linesEnd.add(new Pixel(position[0] + 10, position[1] + 50, 0));

    linesStart.add(new Pixel(position[0] - 10, position[1] + 50, 0));
    linesEnd.add(new Pixel(position[0] + 10, position[1] + 50, 0));


  }

  /*
    Prints the actual coordinates of the tie fighter.
    In: no parameters.
    Out: void.
  */
  public void printCoordinates(){
    System.out.println("Lines: ");
    for(int i = 0; i < linesStart.size(); i++){
      Pixel act = linesStart.get(i);
      Pixel actEnd = linesEnd.get(i);
      System.out.println(act.x + " " + act.y + " to " + actEnd.x + " " + actEnd.y);
    }

    System.out.println();
    System.out.println("Circles: ");

    for(int i = 0; i < circles.size(); i++){
      Pixel act = circles.get(i);
      System.out.println(act.x + " " + act.y);
    }
  }

  /*
    Rotates the actual coordinates.
    In: degrees.
    Out: void.
  */
  public void rotate(double degrees){
    Rotationer rotationer = new Rotationer(this.linesStart, this.linesEnd, this.circles, degrees);
  }

  /*
    Translates the actual coordinates.
    In: moveInX, moveInY.
    Out: void.
  */
  public void translate(double moveInX, double moveInY){
    Translater translater = new Translater(this.linesStart, this.linesEnd, this.circles, moveInX, moveInY);
  }

  /*
    Scales the actual coordinates.
    In: scaleX, scaleY.
    Out: void.
  */
  public void scale(double scaleX, double scaleY){
    Scaler scaler = new Scaler(this.linesStart, this.linesEnd, this.circles, scaleX, scaleY);
  }

}
