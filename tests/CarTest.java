import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
        @Test
        void move () {
            Car car1 = new Saab95();
            car1.startEngine();
            car1.move();
            double output = car1.getyPos();
            assertEquals(0.1, output);
        }

        @Test
        void turnLeft () {
            Car car2 = new Volvo240();
            car2.startEngine();
            car2.turnLeft();
            double output = car2.getxPos();
            System.out.println(car2.getxPos());
            assertEquals(-0.1, output);

        }

        @Test
        void turnRight () {
            Car car1 = new Saab95();
            car1.startEngine();
            car1.turnRight();
            double output = car1.getxPos();
            assertEquals(0.1, output);
        }

        @Test
        void speedFactorVolvo () {
            Car car1 = new Volvo240();
            car1.speedFactor();
            double output = car1.speedFactor();
            assertEquals(1.25, output);

        }
        @Test
        void speedFactorSaab () {
            Car car1 = new Saab95();
            car1.speedFactor();
            double output = car1.speedFactor();
            assertEquals(1.25, output);

        }


        @Test
        void gas () {

        }

        @Test
        void brake () {


        }

        @Test
        void startEngine () {

        }

        @Test
        void stopEngine () {

        }


    }