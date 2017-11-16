import java.awt.*;

public class Ferry extends Vehicle implements Movable {


    public Ferry(){
        super(2400, Color.black,"BootenAnna");
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}
