import java.awt.*;

public abstract class Truck extends TransportVehicle {
    private boolean loaded;
    private int nrDoors;


    public Truck(int nrDoors, Color color, double enginePower, String modelName, int cargoSeize){
        super(enginePower,color, modelName, cargoSeize );
        loaded = false;
        this.nrDoors = nrDoors;
    }
    public int getNrDoors(){
        return nrDoors;
    }

}
