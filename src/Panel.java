import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JFrame implements ActionListener, ChangeListener {


    JButton bPlay;
    JButton bPause;
    JButton bStop;
    private JSlider intensity;
    private JSlider colorR;
    private JSlider colorG;
    private JSlider colorB;
    private Thread flameViewThread;
    private final ColorPallet colorPallet;
    private final FlameView flameView;
    private final Controller controller;

    public Panel(FlameView flameView, Controller controller) {
        this.controller = controller;
        this.flameView = flameView;
        this.colorPallet = flameView.getColorPallet();
        setup();
    }

    public void setup() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 500);

        flameViewThread = new Thread(flameView);
        flameViewThread.start();

        controller.setFlameThread(flameViewThread);
        add(controlPanel(), BorderLayout.WEST);
        add(flameView, BorderLayout.EAST);


        pack();
        setVisible(true);
    }

    private JPanel controlPanel() {
        JPanel controler = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;


        Font font = new Font("Serif", Font.ITALIC, 15);

        intensity = new JSlider(JSlider.VERTICAL, 0, 100, 40);
        colorR = new JSlider(0, 254, 254);
        colorG = new JSlider(0, 254, 0);
        colorB = new JSlider(0, 254, 0);

        colorR.setFont(font);
        colorR.setMajorTickSpacing(254);
        colorR.setMinorTickSpacing(51);
        colorR.setPaintLabels(true);
        colorR.setPaintTicks(true);

        colorG.setFont(font);
        colorG.setMajorTickSpacing(254);
        colorG.setMinorTickSpacing(51);
        colorG.setPaintLabels(true);
        colorG.setPaintTicks(true);

        colorB.setFont(font);
        colorB.setMajorTickSpacing(254);
        colorB.setMinorTickSpacing(51);
        colorB.setPaintLabels(true);
        colorB.setPaintTicks(true);

        intensity.setFont(font);
        intensity.setMajorTickSpacing(100);
        intensity.setMinorTickSpacing(20);
        intensity.setPaintLabels(true);
        intensity.setPaintTicks(true);


        colorR.addChangeListener(this);
        colorG.addChangeListener(this);
        colorB.addChangeListener(this);
        intensity.addChangeListener(this);


        controler.add(colorR, c);
        c.gridy = 1;
        controler.add(colorG, c);
        c.gridy = 2;
        controler.add(colorB, c);
        c.gridy = 3;
        JPanel botones = new JPanel();

        bPlay = new JButton("Play");
        bPause = new JButton("Pause");
        bStop = new JButton("Stop");

        bPlay.setEnabled(false);

        botones.add(bPlay);
        botones.add(bPause);
        botones.add(bStop);

        controler.add(botones, c);
        c.gridy = 1;
        c.gridx = 1;
        controler.add(intensity, c);

        bPlay.addActionListener(this);
        bPause.addActionListener(this);
        bStop.addActionListener(this);


        return controler;
    }


    @Override
    public void stateChanged(ChangeEvent e) {

        if (e.getSource() == intensity){
            controller.setSparkles(intensity.getValue());
        }

        if (flameViewThread.getState() == Thread.State.WAITING) {
            this.colorPallet.setrMax(colorR.getValue());
            this.colorPallet.setgMax(colorG.getValue());
            this.colorPallet.setbMax(colorB.getValue());
            this.colorPallet.refreshColor();
        }
        flameView.paint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bPlay){
            bPlay.setEnabled(true);
            bPause.setEnabled(true);
            bStop.setEnabled(true);
            flameView.resume();
        } else if (e.getSource()== bPause) {
            bPause.setEnabled(false);
            bPlay.setEnabled(true);
            bStop.setEnabled(true);
            flameView.pause();
        } else{
            bStop.setEnabled(false);
            bPause.setEnabled(true);
            bPlay.setEnabled(true);
            flameView.stop();
        }

    }


}

