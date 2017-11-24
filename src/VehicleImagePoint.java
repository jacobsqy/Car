import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Connects a Vehicle's image to a Vehicles Point.
 */
public class VehicleImagePoint {

    private BufferedImage image;
    private Point point;

    public VehicleImagePoint(String s, Point p) {
        try {
            image = (ImageIO.read(new File(s)));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        point = p;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint() {
        return point;
    }
}
