import java.awt.*;

public class CarTransport extends Truck {

    private boolean turboOn;
    private double turboPower;

    private VehicleCargo vehicleCargo = new VehicleCargo(2.0, 5);

    public CarTransport() {
        super(2, Color.black, 550, "cartransport");
        vehicleCargo.raiseRamp();
    }

    @Override
    public void move() {
        if (vehicleCargo.getRampState() == VehicleCargo.RampState.UP) {
            super.move();
            vehicleCargo.moveCargo(getxPos(), getyPos());
        }
    }

    public void load(Car car) {
        if (vehicleCargo.withinLoadingRange(car, this)) {
            vehicleCargo.load(car);
            car.setLoaded(this);
        }
    }

    public void unload() {
        vehicleCargo.unload();
    }

    public void lowerRamp() {
        vehicleCargo.lowerRamp();
    }

    public void raiseRamp() {
        vehicleCargo.raiseRamp();
    }

    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }
}
