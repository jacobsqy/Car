public class Tipper {
    public int tipAngle;
    public Tipper(){
        tipAngle = 0;
    }

    /**
     * Increases tipAngle but only if lower then 70.
     */
    public void raiseTipper(){
        if(tipAngle < 70) tipAngle++;
    }

    /**
     * Decreases int tipAngle, but only if it higher then 0.
     */
    public void lowerTipper(Vehicle vehicle){
        if(tipAngle > 0 && vehicle.isStill()) tipAngle--;
    }

}
