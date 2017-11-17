import java.awt.*;
import java.util.Stack;

public class Ferry extends Vehicle {
    Cargo cargo = new Cargo();


    public Ferry(){
        super(2400, Color.black,"BootenAnna");
    }

    @Override
    public double speedFactor() {

        return getEnginePower() * 0.0001;
    }

    private void load(Truck truck) {
        if (cargo.withinLoadingRange(truck, this) &&
                cargo.getRampState() == this.cargo.getRampState() && cargo.getRamp().size() < cargo.getCargoSize()){
            cargo.getRamp().push(truck);
            truck.setLoaded(this);
        }
    }

    public void unload (){
        if (cargo.getRampState() == Cargo.rampstate.DOWN) {
            invertStack(cargo.getRamp());
            Vehicle vehicle = cargo.getRamp().pop();
            cargo.moveUnloaded(vehicle);
            vehicle.resetLoaded();
        }

    }



    private Stack<Vehicle> invertStack(Stack<Vehicle> oldStack) {
        Stack<Vehicle> newStack = new Stack<Vehicle>();
        for (int i = 0; i < oldStack.size(); i++) {
            newStack.push(oldStack.pop());
        }
        return newStack;
    }
}
