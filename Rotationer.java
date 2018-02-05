/*
	Description:
					Program that rotates a given set of coordinates.
	Authors:
					Armando Canto Garcia A01322361 Luis Alfredo Leon Villapun A01322275
	Last modification date:
					03/02/2018
*/

import java.util.*;

public class Rotationer{
  //Global variables
  public ArrayList<Pixel> newLinesStart = new ArrayList<Pixel>();
  public ArrayList<Pixel> newLinesEnd = new ArrayList<Pixel>();
  public ArrayList<Pixel> newCircles = new ArrayList<Pixel>();

  /*
    Constructor.
    In: linesStart, linesEnd, circles, scaleInX, scaleInY
    Out: Rotationer object
  */
  public Rotationer(ArrayList<Pixel> linesStart, ArrayList<Pixel> linesEnd, ArrayList<Pixel>circles, double degrees){
    double degreesRadians = Math.toRadians(degrees);
    if(!linesStart.isEmpty()){
      for(int i = 0; i < linesStart.size(); i++){
        int newX = (int)Math.round((double)linesStart.get(i).x * Math.cos(degreesRadians) - linesStart.get(i).y * Math.sin(degreesRadians));
        int newY = (int)Math.round((double)linesStart.get(i).x * Math.sin(degreesRadians) + linesStart.get(i).y * Math.cos(degreesRadians));
        linesStart.get(i).x = newX;
        linesStart.get(i).y = newY;
      }
      newLinesStart = linesStart;
    }

    if(!linesEnd.isEmpty()){
      for(int i = 0; i < linesEnd.size(); i++){
        int newX = (int)Math.round((double)linesEnd.get(i).x * Math.cos(degreesRadians) - linesEnd.get(i).y * Math.sin(degreesRadians));
        int newY = (int)Math.round((double)linesEnd.get(i).x * Math.sin(degreesRadians) + linesEnd.get(i).y * Math.cos(degreesRadians));
        linesEnd.get(i).x = newX;
        linesEnd.get(i).y = newY;
      }
      newLinesEnd = linesEnd;
    }

    if(!circles.isEmpty()){
      for(int i = 0; i <circles.size(); i++){
        int newX = (int)Math.round((double)circles.get(i).x * Math.cos(degreesRadians) - circles.get(i).y * Math.sin(degreesRadians));
        int newY = (int)Math.round((double)circles.get(i).x * Math.sin(degreesRadians) + circles.get(i).y * Math.cos(degreesRadians));
        circles.get(i).x = newX;
        circles.get(i).y = newY;
      }
      newCircles = circles;
    }
  }

  public ArrayList<Pixel> getNewLinesStart(){
    return newLinesStart;
  }

  public ArrayList<Pixel> getNewLinesEnd(){
    return newLinesEnd;
  }

  public ArrayList<Pixel> getNewCircles(){
    return newCircles;
  }
}
