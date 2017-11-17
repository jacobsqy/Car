import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportVehicleTest {
    @Test
    void withinLoadingRange() {
        TransportVehicle tv = new CarTransport();
        Car car = new Saab95();
        tv.move(1.0, 1.0);
        car.move(2.0,2.0);
        assertTrue(tv.withinLoadingRange(car));

        car.move(2.1,3.0);
        assertFalse(tv.withinLoadingRange(car));
    }

    @Test
    void load() {
        TransportVehicle tv = new CarTransport();
        Car car = new Volvo240();
        tv.lowerRamp();
        tv.load(car);
        assertEquals(tv.getRamp().peek(), car);
    }

    @Test
    void unload() {
        TransportVehicle tv = new CarTransport();
        Car car1 = new Volvo240();
        Car car2 = new Volvo240();
        tv.lowerRamp();
        tv.load(car1);
        tv.load(car2);
        tv.unload();
        assertEquals(tv.getRamp().peek(), car1);
    }

}