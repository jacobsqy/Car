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
        int rand = random.nextInt(10);
        if(rand <= 2){
            return new Saab95(x,y);
        }else if(rand <= 4){
            return new Scania(x,y);
        }else if(rand <= 6){
            return new Volvo240(x,y);
        }else if(rand <= 8){
            return new Ferry(x,y);
        }else if(rand <= 10){
            return new CarTransport(x,y);
        }else {return null;}
    }
}
