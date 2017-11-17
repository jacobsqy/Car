import java.awt.*;
import java.util.Stack;

public abstract class TransportVehicle extends Vehicle {


    public TransportVehicle(double enginePower, Color color, String modelname, int cargoSize){
        super(enginePower, color, modelname);
        loadingRange = 2.0;
        ramp = new Stack<Vehicle>();
        raiseRamp();
        this.cargoSize = cargoSize;
    }


}
