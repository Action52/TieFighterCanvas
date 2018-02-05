/*
	Description:
					Program that scales a given set of coordinates.
	Authors:
					Armando Canto Garcia A01322361 Luis Alfredo Leon Villapun A01322275
	Last modification date:
					03/02/2018
*/

import java.util.*;

public class Translater{
  //Global variables
  public ArrayList<Pixel> newLinesStart = new ArrayList<Pixel>();
  public ArrayList<Pixel> newLinesEnd = new ArrayList<Pixel>();
  public ArrayList<Pixel> newCircles = new ArrayList<Pixel>();

  /*
    Constructor.
    In: linesStart, linesEnd, circles, scaleInX, scaleInY
    Out: Scaler object
  */
  public Translater(ArrayList<Pixel> linesStart, ArrayList<Pixel> linesEnd, ArrayList<Pixel>circles, double moveInX, double moveInY){

    if(!linesStart.isEmpty()){
      for(int i = 0; i < linesStart.size(); i++){
        int newX = (int)Math.round((double)linesStart.get(i).x + moveInX);
        int newY = (int)Math.round((double)linesStart.get(i).y + moveInY);
        linesStart.get(i).x = newX;
        linesStart.get(i).y = newY;
      }
      newLinesStart = linesStart;
    }

    if(!linesEnd.isEmpty()){
      for(int i = 0; i < linesEnd.size(); i++){
        int newX = (int)Math.round((double)linesEnd.get(i).x + moveInX);
        int newY = (int)Math.round((double)linesEnd.get(i).y + moveInY);
        linesEnd.get(i).x = newX;
        linesEnd.get(i).y = newY;
      }
      newLinesEnd = linesEnd;
    }

    if(!circles.isEmpty()){
      for(int i = 0; i <circles.size(); i++){
        int newX = (int)Math.round((double)circles.get(i).x + moveInX);
        int newY = (int)Math.round((double)circles.get(i).y + moveInY);
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
