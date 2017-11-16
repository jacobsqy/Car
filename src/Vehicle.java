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

  private Dir[] dirs = {Dir.FORWARD, Dir.RIGHT, Dir.BACK, Dir.LEFT};
  private int currentDirIndex = 0;
  private Dir dir;
  public enum Dir {
    FORWARD,
    RIGHT,
    BACK,
    LEFT
  }

  public Vehicle(double enginePower, Color color, String modelname) {
    this.enginePower = enginePower;
    this.color = color;
    this.modelName = modelname;
    loaded = false;
  }

  /**
   * Moves the Vehicle in the current direction with the speed currentSpeed
   */
  public void move() {
    switch (dir) {
      case FORWARD:
        yPos += currentSpeed;
        break;
      case RIGHT:
        xPos += currentSpeed;
        break;
      case BACK:
        yPos -= currentSpeed;
        break;
      case LEFT:
        xPos -= currentSpeed;
        break;
    }
  }

  /**
   * Moves the Vehicle to the given position
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
    dir = dirs[currentDirIndex];
  }

  /**
   * Changes direction to the right.
    */
  public void turnRight(){
    currentDirIndex = (currentDirIndex + 1) % 4;
    dir = dirs[currentDirIndex];
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
          incrementSpeed(amount);
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
      currentSpeed = 0.1;
  }

  /**
   * Stops the engine by setting currentSpeed to 0.
   */
  public void stopEngine(){
      currentSpeed = 0;
  }


    /**
     * checks if the Car is still
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

    public void setPos(double x, double y) {
      xPos = x;
      yPos = y;
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
      return dir;
    }

    public void setLoaded(Vehicle carrier) {
      loaded = true;
      this.carrier = carrier;
    }

    public boolean getLoaded() {
      return loaded;
    }
    public void resetLoaded() {
      loaded = false;
      carrier = null;
    }
}
