public class Ferry extends Vehicle implements Movable {


    public Ferry(){
        super(2400,0);
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}
