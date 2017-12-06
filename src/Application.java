import Controller.CarController;
import Model.Vehicle;
import View.CarView;
import View.Listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Application implements Listener {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;

    // Instance of this class
    private CarController cc = new CarController();

    private List<Vehicle> vehicleList =new ArrayList<>();

    public static void main(String[] args) { new Application().program(); }

    void program() {
        vehicleList.add(VehicleFactory.createVolvo240(0, 0));



        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0");

        frame.addListener(this);
        for (Vehicle car : vehicleList) {
            frame.getDrawPanel().addImages(car);
        }
        timer.start();
    }

    public void action(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Gas":
                cc.gas(frame.getGasAmount(), vehicleList);
                break;
            case "Break":
                cc.brake(frame.getGasAmount(), vehicleList);
                break;
            case "Start all cars":
                cc.startAllCars(vehicleList);
                break;
            case "Stop all cars":
                cc.stopAllCars(vehicleList);
                break;
            case "Saab Turbo on":
                cc.setTurboOn(vehicleList);
                break;
            case "Saab Turbo off":
                cc.setTurboOff(vehicleList);
                break;
            case "Scania Lift Bed":
                cc.raiseTipper(vehicleList);
                break;
            case "Lower Lift Bed":
                cc.lowTipper(vehicleList);
                break;
            case "Add Car":
                addCar();
                break;
            case "Remove Car":
                removeCar();
                break;
            default:
                System.err.println("NO MATCH FOR LABEL");
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < vehicleList.size(); i++) {
                vehicleList.get(i).move();
                int x = (int) Math.round(vehicleList.get(i).getxPos());
                int y = (int) Math.round(vehicleList.get(i).getyPos());
                // repaint() calls the paintComponent method of the panel
                frame.getDrawPanel().repaint();
                cc.collision(vehicleList.get(i));
            }
        }
    }
    public void addCar() {
        double y = 0;
        if (vehicleList.size() <= 9 && vehicleList.size() >= -1){
            if(vehicleList.size() == 0){ y = 0;
            }else{ y = vehicleList.get(vehicleList.size() - 1).getyPos() + 100; }
            vehicleList.add(VehicleFactory.createSaab95(0, y));
            frame.getDrawPanel().addImages(vehicleList.get(vehicleList.size() - 1));
        }
    }

    public void removeCar() {
        if (!vehicleList.isEmpty()) {
            System.out.println("i removeCar " + vehicleList.size());
            frame.getDrawPanel().removeImage(vehicleList.get(vehicleList.size() - 1));
            vehicleList.remove(vehicleList.size() - 1);
        }
    }
}
