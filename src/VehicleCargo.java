import java.util.Stack;

public class VehicleCargo {

      private Stack<Vehicle> cargo;
      public double loadingRange;
      private rampUpDown rampState;
      public int cargoSize;
      public enum rampUpDown {
          UP, DOWN
      }

      /**
       * Check if the Vehical is in loading range < 2
       * @param cargo a vecicle to compare the carriers position with
       * @param transporter the transporter that carrier compares with
       * @return
       */
      public boolean withinLoadingRange(Vehicle cargo, Vehicle transporter) {
          double dy = cargo.getyPos() - transporter.getyPos();
          double dx = cargo.getxPos() - transporter.getxPos();
          double distance = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));
          return loadingRange > distance;
      }

      /**
       * sets rampState to up
       */
      public void raiseRamp() {
          rampState = rampUpDown.UP;
      }

      /**
       * sets rampState to down
       */
      public void lowerRamp() {
          rampState = rampUpDown.DOWN;
      }

      /**
       * loads a car to the ramp
       * @param car to load
       */
      public void load(Car car, Vehicle transporter) {
          if (withinLoadingRange(car, transporter) &&
                  rampState == VehicleCargo.rampUpDown.DOWN && cargo.size() < cargoSize){
              cargo.push(car);
              car.setLoaded(transporter);
          }
      }

      /**
       * unloads the car
       */
      public void unload() {
          if (rampState == VehicleCargo.rampUpDown.DOWN) {
              Vehicle vehicle = cargo.pop();
              moveUnloaded(vehicle);
              vehicle.resetLoaded();
          }
      }


      public int getCargoSize() {
          return cargoSize;
      }

      public Stack<Vehicle> getCargo() {
          return cargo;
      }

      public rampUpDown getRampState() {
          return rampState;
      }

      protected void moveUnloaded(Vehicle vehicle) {
      double newXPos = vehicle.getxPos();
      double newYPos = vehicle.getyPos();
      switch (vehicle.getDir()) {
        case FORWARD:
          newYPos = vehicle.getyPos() - 1;
          break;
        case RIGHT:
          newXPos = vehicle.getxPos() - 1;
          break;
        case BACK:
          newYPos = vehicle.getyPos() + 1;
          break;
        case LEFT:
          newXPos = vehicle.getxPos() + 1;
          break;
      }
      vehicle.move(newXPos, newYPos);
    }
}