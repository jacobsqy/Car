package Controller;

import Model.Vehicle;
import Model.World;

import java.util.List;

/**
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {

    World model = new World();

    /**
     * calls on gas() in class Model.Vehicle with double gas that is calculated with amount/100.
     * @param amount an int from the GUI between 0 and 100.
     */
    public void gas(int amount, List<Vehicle> cars) {
        model.gas(amount, cars);
    }

    /**
     * loops through all vehicles and use the startEngine() method from Model.Vehicle class.
     */
    public void startAllCars(List<Vehicle> cars) {
        model.startAllCars(cars);

    }

    /**
     * loops through all vehicles and use the stopEngine() method from Model.Vehicle class.
     */
    public void stopAllCars(List<Vehicle> cars) {
        model.stopAllCars(cars);

    }

    /**
     * Loops through all vehicles and use the brake() method from Model.Vehicle class.
     */
    public void brake(int amount, List<Vehicle> cars) {
        model.brake(amount, cars);
    }

    /**
     * Checks if the whole car is within the gamewindow, turns the car twice right if not.
     */
    public void collision(int car) {
        model.collision(car);
    }

    /**
     * loops through all vehicles and if the vehicle has the class name "saab95"
     * it calls on setTurboOn().
     */
    public void setTurboOn(List<Vehicle> cars) {
        model.setTurboOn(cars);
    }

    /**
     * loops through all vehicles and if the vehicle has the class name "saab95"
     * it calls on setTurboOff().
     */
    public void setTurboOff(List<Vehicle> cars) {
        model.setTurboOff(cars);
    }

    /**
     * loops through all vehicles and if the vehicle has the class name "scania"
     * it calls on raiseTipper().
     */
    public void raiseTipper(List<Vehicle> cars){
        model.raiseTipper(cars);
    }

    /**
     * loops through all vehicles and if the vehicle has the class name "scania"
     * it calls on lowerTipper().
     */
    public void lowTipper(List<Vehicle> cars) {
        model.lowTipper(cars);
    }

    public void moveCar(int i) {
        model.moveCar(i);
    }

    public void addCar(Vehicle car) {
        model.addCar(car);
    }

    public List<Vehicle> getVehicle() {
        return model.getVehicleList();
    }

    public void addCar() {
        model.addCar();
    }

    public void removeCar() {
        model.removeCar();
    }
}
