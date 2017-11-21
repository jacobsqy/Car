import java.awt.*;

public class Scania extends Truck {
    private boolean turboOn;
    private double turboPower;
    private Tipper tipper = new Tipper();




    public Scania (){
        super(2, Color.black, 550, "Scania Truck");
        turboOn = false;
        turboPower = 1.5;
        stopEngine();
    }


    /**
     * Adds currentSpeed() to the y position to make it go forward,
     * but only if tipAngle != 0.
     */
    @Override
    public void move() {
      if (tipper.tipAngle == 0) {
        super.move();
      }
    }

    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }

    public void lowerTipper() {
        if (isStill()) tipper.lowerTipper();
    }

    public void raiseTipper() {
        if (isStill()) tipper.raiseTipper();
    }

}
