import org.junit.jupiter.api.Test;

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
        Vehicle v = new Scania();

    }

    @Test
    void turnRight() {
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
        Car car1 = new Saab95();
        car1.startEngine();
        assertEquals(0.1, car1.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
    }

    @Test
    void isStill() {
    }

    @Test
    void setPos() {
    }

    @Test
    void setLoaded() {
    }

}