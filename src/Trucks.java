public abstract class Trucks extends Car {

  /**
   * This method adds currentSpeed() to the y position to make it go forward,
   * but only if tipAngle != 0.
   */
  @Override
  public void move() {
    if (tipAngle != 0) {
      super.move();
    }
  }
}
