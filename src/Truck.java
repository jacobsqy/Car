import java.awt.*;

public abstract class Truck extends TransportVehicle {
    private boolean loaded;
    private int nrDoors;


    public Truck(int nrDoors, Color color, double enginePower, String modelName){
        super(enginePower,color, modelName);
        loaded = false;
        this.nrDoors = nrDoors;
    }
    public int getNrDoors(){
        return nrDoors;
    }

}
