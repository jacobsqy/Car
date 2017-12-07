package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Saab95 extends Car {


    private boolean turboOn;
    private double turboPower;

    public Saab95(double xPos, double yPos) {
        super(2, Color.red, 125, "Saab95", xPos, yPos,"src\\Model\\pics\\Saab95.jpg");
        turboOn = false;
        turboPower = 1.3;
    }

    /**
     * Calculate the acceleration
     * @return the acceleration
     */
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.01 * turbo;
    }

    public void setTurboOn() { turboOn = true;}
    public void setTurboOff() {
        turboOn = false;
    }
    public boolean isTurboOn() { return turboOn;}


}
