import java.awt.*;

public abstract class Truck extends Vehicle {

    public Truck(Color color, double enginePower, String modelName){
        super(enginePower);
        this.color = color;
        this.modelName = modelName;
    }

}
