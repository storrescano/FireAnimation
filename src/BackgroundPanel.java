import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {

    BufferedImage img;

    public BackgroundPanel() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        try {
            img = ImageIO.read(new File("background.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
}
