package Model;

import java.awt.*;
public abstract class Car extends Vehicle {
  private int nrDoors;


  public Car(int nrDoors, Color color, double enginePower, String modelName, double xPos, double yPos){
      super(enginePower, color, modelName, xPos, yPos);
      this.nrDoors = nrDoors;
  }



  /*GETTERS AND SETTERS*/
    public int getNrDoors(){
        return nrDoors;
    }
}
