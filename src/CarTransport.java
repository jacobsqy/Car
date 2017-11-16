import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck {

    private boolean turboOn;
    private double turboPower;
    private Stack<Car> ramp;
    private double loadingRange;
    private rampstate rampState;
    private enum rampstate {
        UP, DOWN
    }

    public CarTransport(){
        super(2, Color.black, 550, "cartransport");
        ramp = new Stack<Car>();
        rampState = rampState.DOWN;
        loadingRange = 2.0;
    }



    private void load(Car car) {
      if (withinLoadingRange(car) &&
        rampState == rampstate.DOWN &&
        car.getClass().getName() != "CarTransport") {
          ramp.push(car);
          car.setLoaded(this);
        }
    }

    private void unload() {
      if (rampState == rampstate.DOWN) {
        Car car = ramp.pop();
        car.setPos(getxPos(), getyPos());
        car.resetLoaded();
      }
    }


    private boolean withinLoadingRange(Car car) {
      double dy = car.getyPos() - getyPos();
      double dx = car.getxPos() - getxPos();
      double distance = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));
      return loadingRange > distance;
    }


    @Override
    public void move() {
        if (rampState == rampState.UP) {
            super.move();
        }
    }


    private void raiseRamp() {
      rampState = rampstate.UP;
    }
    private void lowerRamp() {
      rampState = rampstate.DOWN;
    }


    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }
}
