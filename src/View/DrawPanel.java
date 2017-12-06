package View;
import Model.Vehicle;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{



    //ArrayList<VehicleImagePoint> vehicleImagePoints = new ArrayList<>();
    Map<Vehicle, BufferedImage> imageMap = new HashMap<>();

    public void addImages(Vehicle vehicle){
        try {
            imageMap.put(vehicle, ImageIO.read(new File("src\\View\\pics\\" + vehicle.getModelName() + ".jpg")));
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void removeImage(Vehicle vehicle){
        try {
            imageMap.remove(vehicle);
            if(imageMap.size() == 0){
                imageMap.clear();
                repaint();
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
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

        for (Vehicle key : imageMap.keySet()) {
            g.drawImage(imageMap.get(key), (int)key.getxPos(), (int)key.getyPos(), null);
        }

    }
}
