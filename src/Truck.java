public abstract class Truck extends Car {

  public abstract Truck()

  public double speedFactor() {
      double turbo = 1;
      if(turboOn) turbo = turboPower;
      return getEnginePower() * 0.001 * turbo;
  }
}
