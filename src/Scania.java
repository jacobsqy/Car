import java.awt.*;

public class Scania extends Car {
    private int tipAngle;
    private boolean turboOn;
    private double turboPower;


    public Scania (){
        super(2, Color.black, 550, "Scania Truck");
        turboOn = false;
        turboPower = 1.5;
        stopEngine;
    }

    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turboPower;
    }
    public void setTurboOn() {
        turboOn = true;
    }
    public void setTurboOff() {
        turboOn = false;
    }
}
