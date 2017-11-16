import java.awt.*;
public abstract class Car extends Vehicle {
  private boolean loaded;
  private int nrDoors;

  public Car(int nrDoors, Color color, double enginePower, String modelName){
      super(enginePower, color, modelName);
      loaded = false;
  }



  /*GETTERS AND SETTERS*/

    public boolean getLoaded() {
      return loaded;
    }


    public void resetLoaded() {
      loaded = false;
      carrier = null;
    }
    public int getNrDoors(){
        return nrDoors;
    }
}
