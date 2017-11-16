import java.awt.*;

public class Scania extends Truck {
    private int tipAngle;
    private boolean turboOn;
    private double turboPower;



    public Scania (){
        super(2, Color.black, 550, "Scania Truck", 0);
        turboOn = false;
        turboPower = 1.5;
        tipAngle = 0;
        stopEngine();
    }

    /**
     * Increases tipAngle but only if lower then 70.
     */
    private void raiseTipper(){
        if(tipAngle < 70) tipAngle++;
    }

    /**
     * Decreases int tipAngle, but only if it higher then 0.
     */
    private void lowerTipper(){
        if(tipAngle > 0 && isStill()) tipAngle--;
    }

    /**
     * Adds currentSpeed() to the y position to make it go forward,
     * but only if tipAngle != 0.
     */
    @Override
    public void move() {
      if (tipAngle != 0) {
        super.move();
      }
    }

    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }

}
