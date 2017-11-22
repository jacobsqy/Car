import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    ArrayList<BufferedImage> carImages = new ArrayList<BufferedImage>();

    // To keep track of a single cars position
    Point volvoPoint = new Point();
    ArrayList<Point> pointList = new ArrayList<>();

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        int z = 0;
        for(int i = 0; i < pointList.size(); i++){
            if(i > 0){
                pointList.get(i).x = x;
                z += 100;
                pointList.get(i).y = z;
            }else{
                pointList.get(i).x = x;
                pointList.get(i).y = y;
            }
        }

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        pointList.add(new Point());
        pointList.add(new Point());
        pointList.add(new Point());

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            carImages.add(ImageIO.read(new File("src\\pics\\Volvo240.jpg")));
            carImages.add(ImageIO.read(new File("src\\pics\\Scania.jpg")));
            carImages.add(ImageIO.read(new File("src\\pics\\Saab95.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < pointList.size(); i++){
            g.drawImage(carImages.get(i), pointList.get(i).x, pointList.get(i).y, null); // see javadoc for more info on the parameters
        }

    }
}
