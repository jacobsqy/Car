import java.awt.*;

public class CarTransport extends Car {

    private boolean turboOn;
    private double turboPower;
    private Stack<Car> ramp = new Stack();
    private double loadingRange;
    private rampstate rampState;
    private enum rampstate {
        UP, DOWN
    }

    public CarTransport(){
        super(2, Color.black, 550, "cartransport");
        rampState = rampState.DOWN;
        loadingRange = 2.0;
    }



    public void load(Car car) {
      if (withinLoadingRange(car)) ramp.push(car);
    }

    private boolean withinLoadingRange(Car car) {
      double dy = car.getyPos() - getyPos();
      double dx = car.getxPos() - getxPos();
      double distance = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));
      return loadingRange > distance;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }
    @Override
    public void move() {
        if (rampState == rampState.UP) {
            super.move();
        }
    }
}
