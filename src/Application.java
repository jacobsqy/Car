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
    CarView frame;

    // Instance of this class
    CarController cc = new CarController();

    List<Vehicle> vehicleList =new ArrayList<>();

    public static void main(String[] args) { new Application().program(); }

    void program() {
        vehicleList.add(VehicleFactory.createVolvo240(0, 0));
        vehicleList.add(VehicleFactory.createSaab95(0, 100));
        vehicleList.add(VehicleFactory.createScania(0, 200));
        vehicleList.add(VehicleFactory.createSaab95(0, 300));

        cc.setCars(vehicleList);

        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0");

        frame.addListener(this);
        for (Vehicle car : cc.getCars()) {
            frame.getDrawPanel().addImages(car);
        }
        timer.start();
    }

    public void action(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Gas":
                cc.gas(frame.getGasAmount());
                break;
            case "Break":
                cc.brake(frame.getGasAmount());
                break;
            case "Start all cars":
                cc.startAllCars();
                break;

        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cc.getCars().size(); i++) {
                cc.getCars().get(i).move();
                int x = (int) Math.round(cc.getCars().get(i).getxPos());
                int y = (int) Math.round(cc.getCars().get(i).getyPos());
                // repaint() calls the paintComponent method of the panel
                frame.getDrawPanel().repaint();
                cc.collision(cc.getCars().get(i));
            }
        }
    }
}
