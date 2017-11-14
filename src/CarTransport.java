import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck {

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
      if (withinLoadingRange(car) && rampState == rampstate.DOWN) ramp.push(car);
    }

    public void unload() {
      if (rampState == rampstate.DOWN) {
        Car car = ramp.pop();
        car.setPos(getxPos(), getyPos());
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


    public void raiseRamp() {
      rampState = rampstate.UP;
    }
    public void lowerRamp() {
      rampState = rampstate.DOWN;
    }
}
