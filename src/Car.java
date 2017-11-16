import java.awt.*;
public abstract class Car extends Vehicle implements Movable {
  private int nrDoors;
  private Color color;
  private String modelName;
  private boolean loaded;
  private Vehicle carrier;

  public Car(int nrDoors, Color color, double enginePower, String modelName){
      super(enginePower);
      this.nrDoors = nrDoors;
      this.color = color;
      this.modelName = modelName;
  }



  /*GETTERS AND SETTERS*/
    public int getNrDoors(){
      return nrDoors;
  }

    public Color getColor(){
      return color;
  }

    public void setColor(Color clr){
        color = clr;
  }

    public boolean getLoaded() {
      return loaded;
    }

    public void setLoaded(Vehicle carrier) {
      loaded = true;
      this.carrier = carrier;
    }

    public void resetLoaded() {
      loaded = false;
      carrier = null;
    }
}
