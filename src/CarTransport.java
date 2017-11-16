import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck {

    private boolean turboOn;
    private double turboPower;

    public CarTransport(){
        super(2, Color.black, 550, "cartransport");
        ramp = new Stack<Car>();
        rampState = rampState.DOWN;
        loadingRange = 2.0;
    }

    @Override
    public void move() {
        if (rampState == rampState.UP) {
            super.move();
        }
    }

    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }
}
