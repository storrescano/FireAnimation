import javax.swing.*;
import java.awt.*;

public class Panel extends JFrame implements Runnable {


    public void setup() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 500);
        ColorPallet colorPallet = new ColorPallet(256);
        FlameView flameView = new FlameView(500, 500, colorPallet);
        ControlPanel controler = new ControlPanel(this.getContentPane(), colorPallet);
        add(controler, BorderLayout.WEST);
        add(flameView, BorderLayout.EAST);
        Thread thread = new Thread(flameView);
        thread.start();

        pack();
        setVisible(true);
    }

    @Override
    public void run() {
        setup();
    }
}

