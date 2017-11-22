import java.util.Stack;

public class VehicleCargo {

      private Stack<Vehicle> cargo = new Stack<>();
      private final double loadingRange;
      private RampState rampState;
      private final int cargoSize;

      public enum RampState {
        UP, DOWN
    }

      public VehicleCargo(double loadingRange, int cargoSize) {
        this.loadingRange = loadingRange;
        this.cargoSize = cargoSize;
      }

      /**
       * Check if the Vehicle is within loading range
       * @param cargo a vehicle to compare the carriers position with
       * @param transporter the transporter that carrier compares with
       * @return true if the vehicle is within the cargo loading range
       */
      public boolean withinLoadingRange(Vehicle cargo, Vehicle transporter) {
          double dy = cargo.getyPos() - transporter.getyPos();
          double dx = cargo.getxPos() - transporter.getxPos();
          double distance = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));
          return loadingRange >= distance;
      }

    /**
     * sets the cargos xpos and ypos to the same as transport vehicle
     * @param x xPos
     * @param y yPos
     */
      public void moveCargo(double x, double y) {
        Stack<Vehicle> tempS = new Stack<>();
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
       * @param vehicle the car to load
       */
      public void load(Vehicle vehicle) {
          if (rampState == RampState.DOWN &&
                  cargo.size() < cargoSize && !vehicle.getLoaded()){
              cargo.push(vehicle);
          }
      }

      /**
       * unloads the car
       */
      public void unloadFILO() {
          if (rampState == RampState.DOWN) {
              Vehicle vehicle = cargo.pop();
              moveUnloaded(vehicle);
              vehicle.resetLoaded();
          }
      }

      /**
       * Ferry unload invertStack
       */
      public void unloadFIFO() {
          if (rampState == RampState.DOWN) {
              invertStack(cargo);
              Vehicle vehicle = cargo.pop();
              moveUnloaded(vehicle);
              vehicle.resetLoaded();
              invertStack(cargo);
          }
      }

      public void moveUnloaded(Vehicle vehicle) {
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

    private void invertStack(Stack<Vehicle> oldStack) {
        Stack<Vehicle> newStack = new Stack<Vehicle>();
        for (int i = 0; i < oldStack.size(); i++) {
            newStack.push(oldStack.pop());
        }
        oldStack = newStack;
    }
    public int getCargoSize() {
        return cargoSize;
    }

    Stack<Vehicle> getCargo() {
        return cargo;
    }

    RampState getRampState() {
        return rampState;
    }
}
