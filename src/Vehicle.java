public abstract class Vehicle {
  private double xPos;
  private double yPos;
  private enum Dir {
    FORWARD,
    RIGHT,
    BACK,
    LEFT
  }
  private Dir[] dirs = {Dir.FORWARD, Dir.RIGHT, Dir.BACK, Dir.LEFT};
  private int currentDirIndex = 0;
  private Dir dir;

  private void move(double x, double y) {
    switch {
      case
    }
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

}
