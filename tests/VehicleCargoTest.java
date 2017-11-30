import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleCargoTest {
/*    @Test
    void withinLoadingRange() {
        Model.Vehicle tv = new Model.CarTransport();
        Model.VehicleCargo vc = new Model.VehicleCargo(2, 0);
        Model.Car car = new Model.Saab95();
        tv.move(1.0, 1.0);
        car.move(2.0,2.0);
        assertTrue(vc.withinLoadingRange(car, tv));
        car.move(2.1,3.0);
        assertFalse(vc.withinLoadingRange(car, tv));
    }


    @Test
    void lowerRamp() {
        Model.VehicleCargo vc = new Model.VehicleCargo(0,0);
        vc.lowerRamp();
        System.out.println(vc.getRampState());

    }

    @Test
    void load() {
        Model.CarTransport tv = new Model.CarTransport();
        Model.Car car = new Model.Saab95();
        tv.move(1, 1);
        car.move(1.1, 1.1);
        tv.vehicleCargo.lowerRamp();
        tv.vehicleCargo.load(car, tv);
        assertEquals(car.getxPos(), tv.getxPos());
    }

    @Test
    void unload() {
        Model.CarTransport tv = new Model.CarTransport();
        Model.Car car1 = new Model.Volvo240();
        Model.Car car2 = new Model.Volvo240();
        tv.vehicleCargo.lowerRamp();
        tv.vehicleCargo.load(car1, tv);
        tv.vehicleCargo.load(car2, tv);
        tv.vehicleCargo.unload();
        assertEquals(tv.vehicleCargo.getCargo().peek(), car1);

    }



    @Test
    void moveUnloaded() {
        Model.Car mysbil = new Model.Volvo240();
        Model.VehicleCargo vc = new Model.VehicleCargo(2, 5);
        mysbil.move(1,1);
        vc.moveUnloaded(mysbil);
        assertEquals(1, mysbil.getxPos());
        assertEquals(0, mysbil.getyPos());
    }
*/
}
