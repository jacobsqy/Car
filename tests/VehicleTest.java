import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    void move() {
        Vehicle car1 = new Scania();
        double y1 = car1.getyPos();
        startEngine();
        move();
        double y2 = car1.getyPos();
        assertFalse(y2 == y1);
    }

    @Test
    void move1() {
    }

    @Test
    void turnLeft() {
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