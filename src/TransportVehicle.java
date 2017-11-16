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
        super(enginePower, color, modelname);
        ramp = new Stack<>();
        loadingRange = 2.0;
        rampState = rampstate.UP;
    }

<<<<<<< HEAD
    private boolean withinLoadingRange(Vehicle vehicle) {
        double dy = vehicle.getyPos() - getyPos();
        double dx = vehicle.getxPos() - getxPos();
=======
    private boolean withinLoadingRange(Car car) {
        double dy = car.getyPos() - getyPos();
        double dx = car.getxPos() - getxPos();
>>>>>>> cd876ffbca3d775c2368c8ccfa89d85c7cd7a15c
        double distance = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));
        return loadingRange > distance;
    }

    private void raiseRamp() {
        rampState = rampstate.UP;
    }
    private void lowerRamp() {
        rampState = rampstate.DOWN;
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
