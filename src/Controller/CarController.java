package Controller;

import Model.Saab95;
import Model.Scania;
import Model.Vehicle;
import View.Listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    

    /**
     * calls on gas() in class Model.Vehicle with double gas that is calculated with amount/100.
     * @param amount an int from the GUI between 0 and 100.
     */
    public void gas(int amount, List<Vehicle> cars) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    /**
     * loops through all vehicles and use the startEngine() method from Model.Vehicle class.
     */
    public void startAllCars(List<Vehicle> cars) {
        for(Vehicle car : cars){
        car.startEngine();
        }

    }

    /**
     * loops through all vehicles and use the stopEngine() method from Model.Vehicle class.
     */
    public void stopAllCars(List<Vehicle> cars) {
        for(Vehicle car : cars){
            car.stopEngine();
        }

    }

    /**
     * Loops through all vehicles and use the brake() method from Model.Vehicle class.
     */
    public void brake(int amount, List<Vehicle> cars) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    /**
     * Checks if the whole car is within the gamewindow, turns the car twice right if not.
     */
    public void collision(Vehicle car, int height, int width) {
        if (0 > car.getyPos() || car.getyPos() > height - 240 - 60 || 0 > car.getxPos() || car.getxPos() > width - 120) {
            car.turnRight();
            car.turnRight();
        }
    }

    /**
     * loops through all vehicles and if the vehicle has the class name "saab95"
     * it calls on setTurboOn().
     */
    public void setTurboOn(List<Vehicle> cars) {
        for (Vehicle car : cars) {
            if(car.getClass().getName().equals("Model.Saab95")) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    /**
     * loops through all vehicles and if the vehicle has the class name "saab95"
     * it calls on setTurboOff().
     */
    public void setTurboOff(List<Vehicle> cars) {
        for (Vehicle car : cars) {
            if(car.getClass().getName().equals("Model.Saab95")) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    /**
     * loops through all vehicles and if the vehicle has the class name "scania"
     * it calls on raiseTipper().
     */
    public void raiseTipper(List<Vehicle> cars){
        for(Vehicle car : cars){
            if(car.getClass().getName().equals("Model.Scania")){
                ((Scania) car).raiseTipper();
            }
        }
    }

    /**
     * loops through all vehicles and if the vehicle has the class name "scania"
     * it calls on lowerTipper().
     */
    public void lowTipper(List<Vehicle> cars) {
        for (Vehicle car : cars) {
            if (car.getClass().getName().equals("Model.Scania")) {
                ((Scania) car).lowerTipper();
            }
        }
    }
}
