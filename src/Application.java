import Controller.CarController;
import Model.Vehicle;
import Model.VehicleFactory;
import View.CarView;
import View.Listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public static void main(String[] args) { new Application().program(); }

    void program() {
        cc.addCar(VehicleFactory.createVolvo240(0, 0));

        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0");

        frame.addListener(this);
        for (Vehicle car : cc.getVehicle()) {
            frame.getDrawPanel().addImages(car);
        }
        timer.start();
    }

    public void action(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Gas":
                cc.gas(frame.getGasAmount(), cc.getVehicle());
                break;
            case "Break":
                cc.brake(frame.getGasAmount(), cc.getVehicle());
                break;
            case "Start all cars":
                cc.startAllCars(cc.getVehicle());
                break;
            case "Stop all cars":
                cc.stopAllCars(cc.getVehicle());
                break;
            case "Saab Turbo on":
                cc.setTurboOn(cc.getVehicle());
                break;
            case "Saab Turbo off":
                cc.setTurboOff(cc.getVehicle());
                break;
            case "Scania Lift Bed":
                cc.raiseTipper(cc.getVehicle());
                break;
            case "Lower Lift Bed":
                cc.lowTipper(cc.getVehicle());
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
            for (int i = 0; i < cc.getVehicle().size(); i++) {
                cc.getVehicle().get(i).move();
                int x = (int) Math.round(cc.getVehicle().get(i).getxPos());
                int y = (int) Math.round(cc.getVehicle().get(i).getyPos());
                // repaint() calls the paintComponent method of the panel
                frame.getDrawPanel().repaint();
                cc.collision(cc.getVehicle().get(i), frame.getHeight(), frame.getWidth());
            }
        }
    }
    public void addCar() {
        cc.addCar();
        frame.addImage(cc.getVehicle().get(cc.getVehicle().size() - 1));
    }

    public void removeCar() {
        cc.removeCar();
        frame.removeImage(cc.getVehicle().get(cc.getVehicle().size() - 1));
    }
}
