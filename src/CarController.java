import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.cars.add(new Volvo240(0, 0));
        cc.cars.add(new Saab95(0, 100));
        cc.cars.add(new Scania(0, 200));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        for (Vehicle car : cc.cars) {
            int x = (int) Math.round(car.getxPos());
            int y = (int) Math.round(car.getyPos());
            cc.frame.drawPanel.addImages(x, y, car.getModelName());
        }

        // Start the timer
        cc.timer.start();
    }

    /** Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. It also call on the method collision.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).move();
                int x = (int) Math.round(cars.get(i).getxPos());
                int y = (int) Math.round(cars.get(i).getyPos());
                frame.drawPanel.moveIt(x, y, i);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                collision(cars.get(i));
            }
        }
    }


    /**
     * calls on gas() in class Vehicle with double gas that is calculated with amount/100.
     * @param amount an int from the GUI between 0 and 100.
     */    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    /**
     * loops through all vehicles and use the startEngine() method from Vehicle class.
     */
    void startAllCars() {
        for(Vehicle car : cars){
        car.startEngine();
        }

    }

    /**
     * loops through all vehicles and use the stopEngine() method from Vehicle class.
     */
    void stopAllCars() {
        for(Vehicle car : cars){
            car.stopEngine();
        }

    }

    /**
     * Loops through all vehicles and use the brake() method from Vehicle class.
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    /**
     * Checks if the whole car is within the gamewindow, turns the car twice right if not.
     */
    private void collision(Vehicle car) {
        if (0 > car.getyPos() || car.getyPos() > 800 - 240 - 60 || 0 > car.getxPos() || car.getxPos() > 800 - 120) {
            car.turnRight();
            car.turnRight();
        }
    }

    /**
     * loops through all vehicles and if the vehicle has the modellname "saab95"
     * it calls on setTurboOn().
     */
    public void getTurboOn() {
        for (Vehicle car : cars) {
            if(car.getModelName().toLowerCase().equalsIgnoreCase("saab95")) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    /**
     * loops through all vehicles and if the vehicle has the modellname "saab95"
     * it calls on setTurboOff().
     */
    public void getTurboOff() {
        for (Vehicle car : cars) {
            if(car.getModelName().toLowerCase().equalsIgnoreCase("saab95")) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    /**
     * loops through all vehicles and if the vehicle has the modellname "scania"
     * it calls on raiseTipper().
     */
    public void raiseTipper(){
        for(Vehicle car : cars){
            if(car.getModelName().toLowerCase().equalsIgnoreCase("scania")){
                ((Scania) car).raiseTipper();
            }
        }
    }

    /**
     * loops through all vehicles and if the vehicle has the modellname "scania"
     * it calls on lowerTipper().
     */
    public void lowTipper() {
        for (Vehicle car : cars) {
            if (car.getModelName().toLowerCase().equalsIgnoreCase("scania")) {
                ((Scania) car).lowerTipper();
            }
        }
    }
}
