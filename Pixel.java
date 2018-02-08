/*
	Description:
					Class that represents a pixel.
	Authors:
					Armando Canto Garcia A01322361 Luis Alfredo Leon Villapun A01322275
	Last modification date:
					03/02/2018
*/
public class Pixel{
  //Global variables
  public int x;
  public int y;
  public int radius; //If it will represent a circle, it not set to 0
  public int h; //Homogeneous variable
  /*
    Constructor.
    In: int x, int y
    Out: Pixel object
  */
  public Pixel(int x, int y, int r){
    this.x = x;
    this.y = y;
    this.radius = r;
    h = 1;
  }


}
