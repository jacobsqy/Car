import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleCargoTest {
    @Test
    void withinLoadingRange() {
        Vehicle tv = new CarTransport();
        VehicleCargo vc = new VehicleCargo();
        Car car = new Saab95();
        vc.loadingRange = 2;
        tv.move(1.0, 1.0);
        car.move(2.0, 2.0);
        assertTrue(vc.withinLoadingRange(car, tv));

        car.move(2.1,3.0);
        assertFalse(vc.withinLoadingRange(car, tv));
    }

    @Test
    void load() {
        Vehicle tv = new CarTransport();
        VehicleCargo vc = new VehicleCargo();
        Car car = new Saab95();
        vc.lowerRamp();
        vc.load(car, tv);
        assertEquals(vc.getCargo().peek(), car);
    }

    @Test
    void unload() {
        Vehicle tv = new CarTransport();
        VehicleCargo vc = new VehicleCargo();
        Car car1 = new Volvo240();
        Car car2 = new Volvo240();
        vc.lowerRamp();
        vc.load(car1, tv);
        vc.load(car2, tv);
        vc.unload();
        assertEquals(vc.getCargo().peek(), car1);
    }



    @Test
    void moveUnloaded() {
    }

}
