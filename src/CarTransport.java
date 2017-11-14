import java.awt.*;

public class CarTransport extends Car {

    private boolean turboOn;
    private double turboPower;

    public CarTransport(){
        super(2, Color.black, 550, "cartransport");
    }


    @Override
    public double speedFactor() {
        public double speedFactor() {
            double turbo = 1;
            if(turboOn) turbo = turboPower;
            return getEnginePower() * 0.001 * turbo;
        }
    }
}
