import java.awt.*;
import java.util.Stack;

public class Ferry extends Vehicle {
    private VehicleCargo vehicleCargo = new VehicleCargo();


    public Ferry(){
        super(2400, Color.black,"BootenAnna");
        vehicleCargo.loadingRange = 2.0;
        vehicleCargo.cargoSize = 10;
    }

    @Override
    public void move() {
      super.move();
      vehicleCargo.moveCargo();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.0001;
    }

    private void load(Truck truck) {
        if (vehicleCargo.withinLoadingRange(truck, this) &&
                vehicleCargo.getRampState() == this.vehicleCargo.getRampState() && vehicleCargo.getCargo().size() < vehicleCargo.getCargoSize()){
            vehicleCargo.getCargo().push(truck);
            truck.setLoaded(this);
        }
    }

    public void unload (){
        if (vehicleCargo.getRampState() == VehicleCargo.rampUpDown.DOWN) {
            invertStack(vehicleCargo.getCargo());
            Vehicle vehicle = vehicleCargo.getCargo().pop();
            vehicleCargo.moveUnloaded(vehicle);
            vehicle.resetLoaded();
        }

    }



    private void invertStack(Stack<Vehicle> oldStack) {
        Stack<Vehicle> newStack = new Stack<Vehicle>();
        for (int i = 0; i < oldStack.size(); i++) {
            newStack.push(oldStack.pop());
        }
        oldStack = newStack;
    }
}
