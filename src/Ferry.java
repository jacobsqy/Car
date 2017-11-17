import java.awt.*;
import java.util.Stack;

public class Ferry extends TransportVehicle {


    public Ferry(){
        super(2400, Color.black,"BootenAnna",20);
    }

    @Override
    public double speedFactor() {

        return getEnginePower() * 0.0001;
    }

    private void load(Truck truck) {
        if (withinLoadingRange(truck) &&
                getRampState() == this.getRampState() && getRamp().size() < getCargoSize()){
            getRamp().push(truck);
            truck.setLoaded(this);
        }
    }
    @Override
    public void unload (){
        if (getRampState() == TransportVehicle.rampstate.DOWN) {
            invertStack(getRamp());
            Vehicle vehicle = getRamp().pop();
            moveUnloaded(vehicle);
            vehicle.resetLoaded();
        }

    }
}
