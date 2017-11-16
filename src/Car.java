import java.awt.*;
public abstract class Car implements Movable {
  private int nrDoors;
  private double enginePower;
  private double currentSpeed;
  private Color color;
  private String modelName;
  private boolean turbo;

  //MOVABLE VARS
  private double xPos;
  private double yPos;

  public Car(int nrDoors, Color color, double enginePower, String modelName){
      this.nrDoors = nrDoors;
      this.color = color;
      this.enginePower = enginePower;
      this.modelName = modelName;
  }


    //MOVABLE METHODS

    /**
     * Adds currentSpeed() to the y position to make it go forward.
     */
  public void move() {
        yPos += currentSpeed;
  }

    /**
     * Decrease the x position to make the car turn.
     */

  public void turnLeft() {
     xPos -= currentSpeed;
  }

    /**
     * Increase the x position to make the car turn.
      */
  public void turnRight(){
        xPos += currentSpeed;
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

  /*GETTERS AND SETTERS*/
    public boolean getTurbo() { return turbo; }
    public int getNrDoors(){
      return nrDoors;
  }
    public double getEnginePower(){
      return enginePower;
  }

    public double getCurrentSpeed(){
      return currentSpeed;
  }

    public Color getColor(){
      return color;
  }

    public void setColor(Color clr){
        color = clr;
  }

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
}
