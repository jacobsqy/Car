import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
  /*  @Test
    void setLoaded1() {
        Model.Car car = new Model.Saab95();
        Model.Vehicle tv = new Model.CarTransport();
        car.move(1,1);
        tv.setLoaded(car);
        assertEquals(car.getxPos(), tv.getxPos());

    }

    @Test
    void move() {
        Model.Vehicle car1 = new Model.Scania();
        double y1 = car1.getyPos();
        car1.startEngine();
        car1.move();
        double y2 = car1.getyPos();
        assertFalse(y1 == y2);
    }

    @Test
    void move1() {
        Model.Car car = new Model.Volvo240();
        car.move(13.2, 7.56);
        assertEquals(13.2, car.getxPos());
        assertEquals(7.56, car.getyPos());
    }

    @Test
    void turnLeft() {
        Model.Vehicle v = new Model.Ferry();
        Model.Vehicle.Dir dir1 = v.getDir();
        v.turnLeft();
        Model.Vehicle.Dir dir2 = v.getDir();
        assertFalse(dir1 == dir2);
        assertEquals(dir2, Model.Vehicle.Dir.LEFT);
    }

    @Test
    void turnRight() {
        Model.Vehicle v = new Model.CarTransport();
        Model.Vehicle.Dir dir1 = v.getDir();
        v.turnRight();
        v.turnRight();
        v.turnRight();
        v.turnRight();
        Model.Vehicle.Dir dir2 = v.getDir();
        assertEquals(dir1, dir2);
    }

    @Test
    void speedFactor() {
        Model.Car car1 = new Model.Volvo240();
        car1.speedFactor();
        double output = car1.speedFactor();
        assertEquals(1.25, output);

        Model.Car car2 = new Model.Saab95();
        car2.speedFactor();
        double output2 = car2.speedFactor();
        assertEquals(1.25, output);

    }

    @Test
    void gas() {
        Model.Car car1 = new Model.Saab95();
        car1.gas(0.9);
        double output = car1.getCurrentSpeed();
        assertEquals(1.125, output);
    }

    @Test
    void brake() {
        Model.Car car1 = new Model.Volvo240();
        car1.startEngine();
        car1.gas(0.1);
        car1.brake(0.6);
        double output = car1.getCurrentSpeed();
        assertEquals(0, output);

        Model.Vehicle truck = new Model.CarTransport();
        truck.startEngine();
        truck.gas(0.1);
        truck.brake(0.6);
        double output2 = truck.getCurrentSpeed();
        assertEquals(0, output2);

        Model.Vehicle ferry = new Model.Ferry();
        ferry.startEngine();
        ferry.gas(0.1);
        ferry.brake(0.6);
        double output3 = ferry.getCurrentSpeed();
        assertEquals(0, output3);
    }

    @Test
    void startEngine() {
        Model.Car car1 = new Model.Volvo240();
        car1.startEngine();
        double output = car1.getCurrentSpeed();
        assertEquals(0.1, output);

        Model.Vehicle truck = new Model.Scania();
        truck.startEngine();
        double output2 = truck.getCurrentSpeed();
        assertEquals(0.1, output2);

        Model.Vehicle ferry = new Model.Ferry();
        ferry.startEngine();
        double output3 = ferry.getCurrentSpeed();
        assertEquals(0.1, output3);
    }

    @Test
    void stopEngine() {
        Model.Vehicle car1 = new Model.Saab95();
        car1.stopEngine();
        double output = car1.getCurrentSpeed();
        assertEquals(0, output);

        Model.Vehicle truck1 = new Model.Scania();
        truck1.stopEngine();
        double output2 = truck1.getCurrentSpeed();
        assertEquals(0, output2);

        Model.Vehicle ferry = new Model.Ferry();
        ferry.stopEngine();
        double output3 = ferry.getCurrentSpeed();
        assertEquals(0, output3);
    }

    @Test
    void isStill() {
        Model.Car car1 = new Model.Volvo240();
        car1.startEngine();
        car1.gas(0.9);
        out.println(car1.getCurrentSpeed());
        assertFalse(car1.isStill());
        car1.stopEngine();
        assertTrue(car1.isStill());
    }

    @Test
    void setLoaded() {
        Model.Ferry f = new Model.Ferry();
        Model.Vehicle v = new Model.Scania();
        boolean before = v.getLoaded();
        v.setLoaded(f);
        boolean after = v.getLoaded();
        assertFalse(after == before);
        assertTrue(f == v.getCarrier());
        v.resetLoaded();
        after = v.getLoaded();
        assertTrue(after == before);
    }
*/
}