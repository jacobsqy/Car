import java.awt.*;

public class CarTransport extends Truck {

    private boolean turboOn;
    private double turboPower;

    private VehicleCargo vehicleCargo = new VehicleCargo();

    public CarTransport() {
        super(2, Color.black, 550, "cartransport");
        vehicleCargo.cargoSize = 5;
        vehicleCargo.loadingRange = 2.0;
    }

    @Override
    public void move() {
        if (vehicleCargo.getRampState() == VehicleCargo.rampUpDown.UP) {
            super.move();
        }
    }

    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }

}
