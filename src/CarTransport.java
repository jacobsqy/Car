import java.awt.*;

public class CarTransport extends Car {

    private boolean turboOn;
    private double turboPower;
    private int tipAngle;

    public CarTransport(){
        super(2, Color.black, 550, "cartransport");
        tipAngle = 0;
    }


    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }
    @Override
    public void move() {
        if (tipAngle != 0) {
            super.move();
        }
    }
}
