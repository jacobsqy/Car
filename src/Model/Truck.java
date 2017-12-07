package Model;

import java.awt.*;

public abstract class Truck extends Vehicle {
    private int nrDoors;
    private boolean loaded;

    public Truck(int nrDoors, Color color, double enginePower, String modelName, double xPos, double yPos, String image){
        super(enginePower,color, modelName, xPos, yPos, image);
        loaded = false;
        this.nrDoors = nrDoors;
    }
    public int getNrDoors(){
        return nrDoors;
    }

}
