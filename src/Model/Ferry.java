package Model;

import java.awt.*;
import java.util.Stack;

public class Ferry extends Vehicle {
    public VehicleCargo vehicleCargo = new VehicleCargo(2.0, 10);


    public Ferry(double xPos, double yPos){
        super(2400, Color.black,"BootenAnna", xPos, yPos, null); //TODO Add image for Ferry
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

    private void load(Vehicle vehicle) {
        if (vehicleCargo.withinLoadingRange(vehicle, this) &&
                vehicleCargo.getRampState() == this.vehicleCargo.getRampState() &&
                vehicleCargo.getCargo().size() < vehicleCargo.getCargoSize() &&
                !vehicle.getClass().getName().equals(this.getClass().getName())){
            vehicleCargo.getCargo().push(vehicle);
            vehicle.setLoaded(this);
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
