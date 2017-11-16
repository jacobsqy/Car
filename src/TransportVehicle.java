import java.awt.*;
import java.util.Stack;

public abstract class TransportVehicle extends Vehicle {

    private Stack<Vehicle> ramp;
    private double loadingRange;

    private rampstate rampState;

    private int cargoSize;
    private enum rampstate {
        UP, DOWN
    }

    public TransportVehicle(double enginePower, Color color, String modelname, int cargoSize){
        super(enginePower, color, modelname);
        loadingRange = 2.0;
        ramp = new Stack<Vehicle>();
        rampState = rampstate.UP;
        this.cargoSize = cargoSize;
    }

    private boolean withinLoadingRange(Vehicle vehicle) {
        double dy = vehicle.getyPos() - getyPos();
        double dx = vehicle.getxPos() - getxPos();
        double distance = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));
        return loadingRange > distance;
    }

    public void raiseRamp() {
        rampState = rampstate.UP;
    }
    public void lowerRamp() {
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
    public int getCargoSize() {
        return cargoSize;
    }
    public Stack<Vehicle> getRamp() {
        return ramp;
    }

    public rampstate getRampState() {
        return rampState;
    }

}
