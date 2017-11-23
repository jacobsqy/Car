import java.awt.*;

public class Scania extends Truck {
    private Tipper tipper = new Tipper();

    public Scania (double xPos, double yPos){
        super(2, Color.black, 650, "Scania", xPos, yPos);
    }

    @Override
    public void move() {
        if (tipper.getTipAngle() == 0) {
            super.move();
        } else {
            stopEngine();
        }
    }

    public double speedFactor() {
        return getEnginePower() * 0.001;
    }

    public void lowerTipper() {
        if (isStill()) tipper.lowerTipper();
    }

    public void raiseTipper() {
        if (isStill()) tipper.raiseTipper();
    }

    public int getTipAngle() {
        return tipper.getTipAngle();
    }
}
