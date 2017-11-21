import java.awt.*;
import java.util.Stack;

public class Ferry extends Vehicle {
    public VehicleCargo vehicleCargo = new VehicleCargo(2.0, 10);


    public Ferry(){
        super(2400, Color.black,"BootenAnna");
        vehicleCargo.raiseRamp();
    }

    @Override
    public void move() {
      super.move();
      vehicleCargo.moveCargo(getxPos(), getyPos());
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.0001;
    }

    public void load(Vehicle vehicle) {
        if (vehicleCargo.withinLoadingRange(vehicle, this)) {
            vehicleCargo.load(vehicle);
            vehicle.setLoaded(this);
        }
    }

    public void unload (){
        vehicleCargo.unloadFIFO();
    }
}
