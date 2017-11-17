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



    private Stack<Vehicle> invertStack(Stack<Vehicle> oldStack) {
        Stack<Vehicle> newStack = new Stack<Vehicle>();
        for (int i = 0; i < oldStack.size(); i++) {
            newStack.push(oldStack.pop());
        }
        return newStack;
    }
}
