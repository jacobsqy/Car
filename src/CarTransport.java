import java.awt.*;

public class CarTransport extends Car {

    private boolean turboOn;
    private double turboPower;
    private Stack<Car> ramp = new Stack();
    private rampstate rampState;
    private enum rampstate {
        UP, DOWN
    }

    public CarTransport(){
        super(2, Color.black, 550, "cartransport");
        rampState = rampState.DOWN;
    }



    public void load(Car car) {
      ramp.push(car);
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
