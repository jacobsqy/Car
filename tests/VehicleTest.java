import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    void move() {
        Vehicle car1 = new Scania();
        double y1 = car1.getyPos();
        car1.startEngine();
        car1.move();
        double y2 = car1.getyPos();
        assertFalse(y1 == y2);
    }

    @Test
    void move1() {
        Car car = new Volvo240();
        car.move(13.2, 7.56);
        assertEquals(13.2, car.getxPos());
        assertEquals(7.56, car.getyPos());
    }

    @Test
    void turnLeft() {
        Vehicle v = new Ferry();
        Vehicle.Dir dir1 = v.getDir();
        v.turnLeft();
        Vehicle.Dir dir2 = v.getDir();
        assertFalse(dir1 == dir2);
        assertEquals(dir2, Vehicle.Dir.LEFT);
    }

    @Test
    void turnRight() {
        TransportVehicle v = new CarTransport();
        Vehicle.Dir dir1 = v.getDir();
        v.turnRight();
        v.turnRight();
        v.turnRight();
        v.turnRight();
        Vehicle.Dir dir2 = v.getDir();
        assertEquals(dir1, dir2);
    }

    @Test
    void speedFactor() {
    }

    @Test
    void gas() {
    }

    @Test
    void brake() {
    }

    @Test
    void startEngine() {
        Car car1 = new Volvo240();
        car1.startEngine();
        double output = car1.getCurrentSpeed();
        assertEquals(0.1, output);

        Vehicle truck = new Scania();
        truck.startEngine();
        double output2 = truck.getCurrentSpeed();
        assertEquals(0.1, output2);

        Vehicle ferry = new Ferry();
        ferry.startEngine();
        double output3 = ferry.getCurrentSpeed();
        assertEquals(0.1, output3);
    }

    @Test
    void stopEngine() {
        Vehicle car1 = new Saab95();
        car1.stopEngine();
        double output = car1.getCurrentSpeed();
        assertEquals(0, output);

        Vehicle truck1 = new Scania();
        truck1.stopEngine();
        double output2 = truck1.getCurrentSpeed();
        assertEquals(0, output2);

        Vehicle ferry = new Ferry();
        ferry.stopEngine();
        double output3 = ferry.getCurrentSpeed();
        assertEquals(0, output3);
    }

    @Test
    void isStill() {
        Car car1 = new Volvo240();
        car1.startEngine();
        car1.gas(0.9);
        out.println(car1.getCurrentSpeed());
        assertFalse(car1.isStill());
        car1.stopEngine();
        assertTrue(car1.isStill());
    }

    @Test
    void setLoaded() {
        Ferry f = new Ferry();
        Vehicle v = new Scania();
        boolean before = v.getLoaded();
        v.setLoaded(f);
        boolean after = v.getLoaded();
        assertFalse(after == before);
        assertTrue(f == v.getCarrier());
        v.resetLoaded();
        after = v.getLoaded();
        assertTrue(after == before);
    }

}