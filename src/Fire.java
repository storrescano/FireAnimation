import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Fire  extends JFrame {

    public static void PrintFire() {

    BufferedImage image = new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);

    int[] data = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();


    }


}

