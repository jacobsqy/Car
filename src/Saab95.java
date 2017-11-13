import java.awt.*;
public class Saab95 extends Car {
    private boolean turboOn;
    private double turboPower;

    public Saab95() {
        super(2, Color.red, 125, "Saab95");
        turboOn = false;
        turboPower = 1.3;
        stopEngine();
    }

    /**
     * This method calculate the acceleration
     * @return the acceleration
     */
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.01 * turbo;
    }

    public void setTurboOn() {
        turboOn = true;
    }
    public void setTurboOff() {
        turboOn = false;
    }

}
