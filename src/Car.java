import java.awt.*;
public abstract class Car extends Vehicle {
  private int nrDoors;


  public Car(int nrDoors, Color color, double enginePower, String modelName){
      super(enginePower, color, modelName);
      this.nrDoors = nrDoors;
  }



  /*GETTERS AND SETTERS*/
    public int getNrDoors(){
        return nrDoors;
    }
}
