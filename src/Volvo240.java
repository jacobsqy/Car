import java.awt.*;
public class Volvo240 extends Car {
    private double trimFactor;

    public Volvo240(){
      super(4, Color.black, 100, "Volvo240");
      trimFactor = 1.25;
      stopEngine();
    }
    /**
     * Calculate the acceleration
     * @return the acceleration
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
