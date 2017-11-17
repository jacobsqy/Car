import java.awt.*;

public class CarTransport extends Truck {

    private boolean turboOn;
    private double turboPower;
    private Cargo cargo = new Cargo();

    public CarTransport(){
        super(2, Color.black, 550, "cartransport", 5);
    }

    @Override
    public void move() {
        if (cargo.getRampState() == Cargo.rampstate.UP) {
            super.move();
        }
    }

    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = turboPower;
        return getEnginePower() * 0.001 * turbo;
    }
}
