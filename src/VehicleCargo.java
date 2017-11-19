import java.util.Stack;

public class VehicleCargo {

      private Stack<Vehicle> cargo = new Stack<Vehicle>;
      public final double loadingRange;
      private RampState rampState;
      public final int cargoSize;
      public enum RampState {
          UP, DOWN
      }

      public VehicleCargo(double loadingRange, int cargoSize) {
        this.loadingRange = loadingRange;
        this.cargoSize = cargoSize;
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
          return loadingRange >= distance;
      }

      public void moveCargo(Vehicle carrier, double x, double y) {
        Stack<Vehicle> tempS = new Stack<Vehicle>();
        Vehicle tempV;
        for (int i = 0; i < cargo.size(); i++) {
          tempV = cargo.pop();
          tempV.move(x, y);
          tempS.push(tempV);
        }
        for (int i = 0; i < cargo.size(); i++) {
          cargo.push(tempS.pop());
        }
      }

      /**
       * sets rampState to up
       */
      public void raiseRamp() {
          rampState = RampState.UP;
      }

      /**
       * sets rampState to down
       */
      public void lowerRamp() {
          rampState = RampState.DOWN;
      }

      /**
       * loads a car to the ramp
       * @param car to load
       */
      public void load(Car car, Vehicle transporter) {
          if (withinLoadingRange(car, transporter) &&
                  rampState == RampState.DOWN &&
                  cargo.size() < cargoSize && !car.getLoaded()){
              cargo.push(car);
              car.setLoaded(transporter);
          }
      }

      /**
       * unloads the car
       */
      public void unload() {
          if (rampState == RampState.DOWN) {
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

      public RampState getRampState() {
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
