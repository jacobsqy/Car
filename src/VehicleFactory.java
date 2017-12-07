import Model.*;

import java.util.Random;

public class VehicleFactory {
    public static Vehicle createSaab95(double x, double y) {
        return new Saab95(x, y);
    }

    public static Vehicle createVolvo240(double x, double y) {
        return new Volvo240(x, y);
    }

    public static Vehicle createScania(double x, double y) {
        return new Scania(x, y);
    }

    public static Vehicle createFerry(double x, double y) {
        return new Ferry(x, y);
    }

    public static Vehicle createCarTransport(double x, double y) {
        return new CarTransport(x, y);
    }

    public static Vehicle createRandom(double x, double y){
        Random random = new Random();
        int rand = random.nextInt(3);
        if(rand == 0){
            return createSaab95(x, y);
        }else if(rand == 1){
            return createVolvo240(x, y);
        }else if(rand == 2){
            return createScania(x, y);
        }else {return null;}
    }
}
