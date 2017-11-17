import java.util.Stack;

public class Cargo {

      private Stack<Vehicle> ramp;
      private double loadingRange;
      private rampstate rampState;
      private int cargoSize;
      public enum rampstate {
          UP, DOWN
      }

      /**
       * Check if the Vehical is in loading range < 2
       * @param carrier a vecicle to compare the carriers position with
       * @param transporter the transporter that carrier compares with
       * @return
       */
      public boolean withinLoadingRange(Vehicle carrier, Vehicle transporter) {
          double dy = carrier.getyPos() - transporter.getyPos();
          double dx = carrier.getxPos() - transporter.getxPos();
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
      public void load(Car car) {
          if (withinLoadingRange(car, this) &&
                  rampState == Cargo.rampstate.DOWN && ramp.size() < cargoSize){
              ramp.push(car);
              car.setLoaded(this);
          }
      }

      /**
       * unloads the car
       */
      public void unload() {
          if (rampState == Cargo.rampstate.DOWN) {
              Vehicle vehicle = ramp.pop();
              moveUnloaded(vehicle);
              vehicle.resetLoaded();
          }
      }


      public int getCargoSize() {
          return cargoSize;
      }

      public Stack<Vehicle> getRamp() {
          return ramp;
      }

      public rampstate getRampState() {
          return rampState;
      }

      protected void moveUnloaded(Vehicle vehicle) {
      double newXPos;
      double newYPos;
      switch (getDir()) {
        case FORWARD:
          newYPos = getyPos() - 1;
          break;
        case RIGHT:
          newXPos = getxPos() - 1;
          break;
        case BACK:
          newYPos = getyPos() + 1;
          break;
        case LEFT:
          newXPos = getxPos() + 1;
          break;
      }
      vehicle.move(getxPos(), getyPos());
    }
}
