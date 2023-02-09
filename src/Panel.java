import javax.swing.*;
import java.io.IOException;

public class Panel extends JFrame {
    public Panel() {
        setup();
    }

    public static void main(String[] args) throws IOException {
        Panel panel = new Panel();
        panel.pack();
        panel.setVisible(true);

    }

    public void setup() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        FlameView flameView = new FlameView(300, 300);
        add(flameView);
        Thread thread = new Thread(flameView);
        thread.start();
    }

    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        return frame;
    }


}

