import java.awt.*;

public class Scania extends Truck {
    private Tipper tipper = new Tipper();

    public Scania (){
        super(2, Color.black, 650, "Scania");
    }

    @Override
    public void move() {
        if (tipper.tipAngle == 0) {
            super.move();
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

}
