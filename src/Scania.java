import java.awt.*;

public class Scania extends Car {
    private int tipAngle;
    private boolean turboOn;
    private double turboPower;


    public Scania (){
        super(2, Color.black, 550, "Scania Truck");
        turboOn = false;
        turboPower = 1.5;
        tipAngle = 0;
        stopEngine();
    }

    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }

    /**
     * Increases tipAngle but only if lower then 70.
     */
    private void raiseTipper(){
        if(tipAngle < 70){tipAngle++;}
    }

    /**
     * Decreases int tipAngle, but only if it higher then 0.
     */
    private void lowerTipper(){
        if(tipAngle > 0 && isStill())tipAngle--;
    }

    public boolean isStill(){
        return this.getCurrentSpeed() == 0;
    }


    public void setTurboOn() {
        turboOn = true;
    }
    public void setTurboOff() {
        turboOn = false;
    }
}
