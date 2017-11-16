import java.awt.*;

public class Ferry extends Vehicle implements Movable {


    public Ferry(){
        super(2400, Color.black,"BootenAnna");
    }

    @Override
    public double speedFactor() {

        return getEnginePower() * 0.0001;
    }
    private void load(Truck truck) {
        if (withinLoadingRange(truck) &&
                rampState == CarTransport.rampstate.DOWN && ramp.size() < 5){
            ramp.push(truck);
            car.setLoaded(this);
        }
    }
}
