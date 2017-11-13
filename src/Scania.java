import java.awt.*;

public class Scania extends Car {


    public Scania (){
        super(2, Color.black, 150, "Scania Truck");
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }


}
