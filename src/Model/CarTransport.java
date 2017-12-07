package Model;

import Model.Truck;
import Model.VehicleCargo;

import java.awt.*;

public class CarTransport extends Truck {

    private boolean turboOn;
    private double turboPower;

    public VehicleCargo vehicleCargo = new VehicleCargo(2.0, 5);

    public CarTransport(double xPos, double yPos) {
        super(2, Color.black, 550, "CarTransport", xPos, yPos, null); //TODO Add image for CarTransport
        vehicleCargo.raiseRamp();
    }

    @Override
    public void move() {
        if (vehicleCargo.getRampState() == VehicleCargo.RampState.UP) {
            super.move();
        }
    }

    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }

}
