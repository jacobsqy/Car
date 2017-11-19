import java.util.Stack;

public class VehicleCargo {

      private Stack<Vehicle> cargo;
      public double loadingRange;
      private rampstate rampState;
      public int cargoSize;
      public enum rampstate {
          UP, DOWN
      }

      /**
       * Check if the Vehicle is within the loading range
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
          rampState = rampstate.UP;
      }

      /**
       * sets rampState to down
       */
      public void lowerRamp() {
          rampState = rampstate.DOWN;
      }

      /**
       * loads a car to the ramp
       * @param car to load
       */
      public void load(Car car, Vehicle transporter) {
          if (withinLoadingRange(car, transporter) &&
                  rampState == VehicleCargo.rampstate.DOWN && cargo.size() < cargoSize){
              cargo.push(car);
              car.setLoaded(transporter);
          }
      }

      /**
       * unloads the car
       */
      public void unload() {
          if (rampState == VehicleCargo.rampstate.DOWN) {
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

      public rampstate getRampState() {
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
