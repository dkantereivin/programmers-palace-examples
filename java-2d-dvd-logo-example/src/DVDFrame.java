import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DVDFrame extends JFrame {

    DVDGraphics graphics = new DVDGraphics();

    DVDFrame()
    {
        Dimension DimMax = new Dimension(Settings.resoulution.x,Settings.resoulution.y);
        this.getContentPane().setPreferredSize(new Dimension(Settings.resoulution.x, Settings.resoulution.y));
        this.pack();
        this.setTitle("DVD go brrrrrrrrrrr");
        try {

            this.setIconImage(ImageIO.read(Main.class.getResource(Settings.filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this.setSize(DimMax);
        //this.setMaximumSize(DimMax);
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(graphics);
        this.setVisible(true);
    }

}
