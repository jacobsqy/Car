import java.awt.*;
import java.util.Stack;

public abstract class TransportVehicle extends Vehicle {

    private Stack<Car> ramp;
    private double loadingRange;
    private rampstate rampState;
    private enum rampstate {
        UP, DOWN
    }

    public TransportVehicle(double enginePower, Color color, String modelname){
        super(enginePower, color, modelname)
    }


    private void load(Car car) {
        if (withinLoadingRange(car) &&
                rampState == CarTransport.rampstate.DOWN && ramp.size() < 5){
            ramp.push(car);
            car.setLoaded(this);
        }
    }
    private void unload() {
        if (rampState == CarTransport.rampstate.DOWN) {
            Car car = ramp.pop();
            car.setPos(getxPos(), getyPos());
            car.resetLoaded();
        }
    }

}
