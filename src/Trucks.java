public abstract class Trucks extends Car {

  
  @Override
  public void move() {
    if (tipAngle != 0) {
      super.move();
    }
  }
}
