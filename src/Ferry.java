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
      vehicleCargo.moveCargo(this, getxPos(), getyPos());
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
        if (vehicleCargo.getRampState() == VehicleCargo.RampState.DOWN) {
            invertStack(vehicleCargo.getCargo());
            Vehicle vehicle = vehicleCargo.getCargo().pop();
            vehicleCargo.moveUnloaded(vehicle);
            vehicle.resetLoaded();
            invertStack(vehicleCargo.getCargo());
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
