package Model;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Car extends Vehicle {
  private int nrDoors;


  public Car(int nrDoors, Color color, double enginePower, String modelName, double xPos, double yPos, String image){
      super(enginePower, color, modelName, xPos, yPos, image);
      this.nrDoors = nrDoors;
  }



  /*GETTERS AND SETTERS*/
    public int getNrDoors(){
        return nrDoors;
    }
}
