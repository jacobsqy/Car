//import com.sun.java.util.jar.pack.Instruction;

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


    ArrayList<VehicleImagePoint> vehicleImagePoints = new ArrayList<>();


    void addImages(int x, int y, String modellName){
            try {
                switch (modellName) {
                    case "Saab95":
                        vehicleImagePoints.add(new VehicleImagePoint("src\\pics\\Saab95.jpg", new Point(x, y)));
                        break;
                    case "Volvo240":
                        vehicleImagePoints.add(new VehicleImagePoint("src\\pics\\Volvo240.jpg", new Point(x, y)));
                        break;
                    case "Scania":
                        vehicleImagePoints.add(new VehicleImagePoint("src\\pics\\Scania.jpg", new Point(x, y)));
                        break;
                    default:
                        throw new Exception("file not found");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
    }

    void moveIt(int x, int y, int i) {
        vehicleImagePoints.get(i).getPoint().x = x;
        vehicleImagePoints.get(i).getPoint().y = y;

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < vehicleImagePoints.size(); i++){
            g.drawImage(vehicleImagePoints.get(i).getImage(),
                    vehicleImagePoints.get(i).getPoint().x,
                    vehicleImagePoints.get(i).getPoint().y,
                    null);
        }

    }
}
