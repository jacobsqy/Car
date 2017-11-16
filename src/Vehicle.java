public abstract class Vehicle {
  private double xPos;
  private double yPos;

  private void move(double x, double y) {
    xPos += x;
    yPos += y;
  }
}
