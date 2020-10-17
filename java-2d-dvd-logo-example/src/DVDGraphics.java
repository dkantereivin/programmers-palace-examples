import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class                DVDGraphics extends JPanel implements ActionListener {

    Point dvdPos = Settings.startingPos;
    BufferedImage dvdImage;
    {
        try {
            dvdImage = ImageIO.read(Main.class.getResource(Settings.filename));
            dvdImage = resize(dvdImage,dvdImage.getWidth()/5,dvdImage.getHeight()/5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Timer timer = new Timer(1000/Settings.FPS, this);

    DVDGraphics()
    {
        timer.start();
    }

    int x = 0;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(dvdImage,dvdPos.x,dvdPos.y,null);

        g2D.setColor(Color.GREEN);
        g2D.setStroke(new BasicStroke(3));

        //Debug Graphics
        //g2D.drawRect(dvdPos.x,dvdPos.y,10,10);
        //g2D.drawRect(dvdPos.x + dvdImage.getWidth(),dvdPos.y + dvdImage.getHeight(),10,10);
        //g2D.drawRect(Settings.resoulution.x-10,Settings.resoulution.y-10,10,10);
    }

    double xMove = 1 * Settings.SPEED * (1000/Settings.FPS);
    double yMove = 1 * Settings.SPEED * (1000/Settings.FPS);

    @Override
    public void actionPerformed(ActionEvent e){

        //Main.dvdFrame.getContentPane();
        if(Main.dvdFrame.getContentPane() == null) System.out.println("hi"); //souf
        if( dvdPos.x + dvdImage.getWidth() >= Main.dvdFrame.getContentPane().getWidth() || dvdPos.x < 0 ) {xMove = -xMove;}
        if( dvdPos.y + dvdImage.getHeight() >= Main.dvdFrame.getContentPane().getHeight() || dvdPos.y < 0 ) {yMove = -yMove;}

        dvdPos.x += xMove;
        dvdPos.y += yMove;
        //System.out.println("XPos: " + xMove + " YPos: " + yMove);
        repaint();
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
