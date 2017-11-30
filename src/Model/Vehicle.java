package Model;

import java.awt.*;

public abstract class Vehicle implements Movable {
  private double xPos;
  private double yPos;
  private double currentSpeed;
  private double enginePower;
  private Color color;
  private String modelName;
  private Vehicle carrier;
  private boolean loaded;
  private boolean engineOn;


  private Dir[] dirs = {Dir.FORWARD, Dir.RIGHT, Dir.BACK, Dir.LEFT};
  private int currentDirIndex;
  public enum Dir {
    FORWARD,
    RIGHT,
    BACK,
    LEFT
  }

  public Vehicle(double enginePower, Color color, String modelname, double xPos, double yPos) {
    this.enginePower = enginePower;
    this.color = color;
    this.modelName = modelname;
    loaded = false;
    currentDirIndex = 0;
    this.xPos = xPos;
    this.yPos = yPos;
  }

  /**
   * Moves the Model.Vehicle in the current direction with the speed currentSpeed
   */
  public void move() {
    switch (dirs[currentDirIndex]) {
      case FORWARD:
        xPos += currentSpeed;
        break;
      case RIGHT:
        yPos += currentSpeed;
        break;
      case BACK:
        xPos -= currentSpeed;
        break;
      case LEFT:
        yPos -= currentSpeed;
        break;
    }
  }

  /**
   * Moves the Model.Vehicle to the given position
   * @param x the x coordinate to move to
   * @param y the y coordinate to move to
   */
  public void move(double x, double y) {
    yPos = y;
    xPos = x;
  }

  /**
   * Changes the direction to the left
   */

  public void turnLeft() {
    if (currentDirIndex == 0) {
      currentDirIndex = 3;
    } else {
      currentDirIndex--;
    }
  }

  /**
   * Changes direction to the right.
    */
  public void turnRight(){
    currentDirIndex = (currentDirIndex + 1) % 4;
  }

  /**
   * Calculates the acceleration.
   * @return the speed change
   */
  public abstract double speedFactor();


  /**
   *  Uses incrementSpeed() to increase the speed of the car and also make sure the amount is between 0 and 1.
   * @param amount is an value between 0 and 1.
   */
  public void gas(double amount) {
      try {
          if (1.0 < amount || amount < 0.0) {
              throw new Exception("Invalid amount");
          }
          if (engineOn) incrementSpeed(amount);
      } catch(Exception e) {
          System.err.println(e.getMessage());
      }
  }


  /**
   * DecrementSpeed() to slow down the car and also make sure the amount is between 0 and 1.
   * @param amount is an value between 0 and 1.
   */
  public void brake(double amount) {
      try {
          if (1.0 < amount || amount < 0.0) {
              throw new Exception("Invalid amount");
          }
          decrementSpeed(amount);
      } catch(Exception e) {
          System.err.println(e.getMessage());
      }
  }
  /**
   * Increase the current speed.
   * @param amount is an value between 0 and 1, that affects how much the speed will increase.
   */
  private void incrementSpeed(double amount){
      currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
  }

  /**
   * Decrease the current speed.
   * @param amount is an value between 0 and 1, that affects how much the speed will decrease.
   */
  private void decrementSpeed(double amount){
      currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
  }

  /**
   * Starts the engine by setting currentSpeed to 0.1
   */

  public void startEngine(){
    if(!loaded){
      currentSpeed = 0.1;
      engineOn = true;
    }
  }

  /**
   * Stops the engine by setting currentSpeed to 0.
   */
  public void stopEngine(){
      currentSpeed = 0;
      engineOn = false;
  }

    /**
     * checks if the Model.Car is still
     * @return true if the speed is zero
     */
    public boolean isStill(){
        return getCurrentSpeed() == 0;
    }

    // GETTERS AND SETTERS

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public double getCurrentSpeed(){
      return currentSpeed;
    }

    public double getEnginePower(){
      return enginePower;
    }

    public Color getColor(){
    return color;
  }

    public void setColor(Color clr){
    color = clr;
  }

    public Dir getDir() {
      return dirs[currentDirIndex];
    }

    public String getModelName() { return modelName; }

    public void setLoaded(Vehicle carrier) {
      loaded = true;
      stopEngine();
      xPos = carrier.getxPos();
      yPos = carrier.getyPos();
      this.carrier = carrier;
    }

    public boolean getLoaded() {
      return loaded;
    }
    public void resetLoaded() {
      loaded = false;
      carrier = null;
    }

    public Vehicle getCarrier() {
      return carrier;
    }
}
