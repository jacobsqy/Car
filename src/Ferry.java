import java.awt.*;

public class Ferry extends TransportVehicle {


    public Ferry(){
        super(2400, Color.black,"BootenAnna",20);
    }

    @Override
    public double speedFactor() {

        return getEnginePower() * 0.0001;
    }

    private void load(Truck truck) {
        if (withinLoadingRange(truck) &&
                rampState == this.rampState.DOWN && ramp.size() < ){
            ramp.push(truck);
            Car.setLoaded(this);
        }
    }
}
