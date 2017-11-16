public abstract class Vehicle {
  private double xPos;
  private double yPos;
  private double currentSpeed;
  private enum Dir {
    FORWARD,
    RIGHT,
    BACK,
    LEFT
  }
  private Dir[] dirs = {Dir.FORWARD, Dir.RIGHT, Dir.BACK, Dir.LEFT};
  private int currentDirIndex = 0;
  private Dir dir;

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

  public void move(double x, double y) {
    yPos = y;
    xPos = x;
  }

  /**
   * Decrease the x position to make the car turn.
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
   * Increase the x position to make the car turn.
    */
  public void turnRight(){
    currentDirIndex = (currentDirIndex + 1) % 4;
    dir = dirs[currentDirIndex];
  }

  public double getxPos() {
      return xPos;
  }

  public double getyPos() {
      return yPos;
  }
}
