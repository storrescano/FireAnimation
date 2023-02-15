import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ControlPanel extends JPanel implements ChangeListener {


    private ColorPallet colorPallet;
    JButton bPlay;
    JButton bPause;
    JSlider intensity;
    JSlider colorR;
    JSlider colorG;
    JSlider colorB;

    public ControlPanel(Container contentPane, ColorPallet colorPallet) {
        this.colorPallet = colorPallet;
        initializeComponents(contentPane);
    }

    private void initializeComponents(Container contentPane) {
        JPanel controler = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;


        Font font = new Font("Serif", Font.ITALIC, 15);

        intensity = new JSlider(0, 255, 255);
        colorR = new JSlider(0,254,254);
        colorG = new JSlider(0,254,0);
        colorB = new JSlider(0,254,0);

        colorR.setFont(font);
        colorR.setMajorTickSpacing(254);
        colorR.setMinorTickSpacing(50);
        colorR.setPaintTrack(true);
        colorR.setPaintLabels(true);
        colorR.setPaintTicks(true);

        colorG.setFont(font);
        colorG.setMajorTickSpacing(254);
        colorG.setMinorTickSpacing(50);
        colorG.setPaintTrack(true);
        colorG.setPaintLabels(true);
        colorG.setPaintTicks(true);

        colorB.setFont(font);
        colorB.setMajorTickSpacing(254);
        colorB.setMinorTickSpacing(50);
        colorB.setPaintTrack(true);
        colorB.setPaintLabels(true);
        colorB.setPaintTicks(true);

        colorR.addChangeListener(this);
        colorG.addChangeListener(this);
        colorB.addChangeListener(this);

        controler.add(colorR, c);
        c.gridy = 1;
        controler.add(colorG, c);
        c.gridy = 2;
        controler.add(colorB, c);


        bPlay = new JButton();
        bPause = new JButton();

        contentPane.add(controler);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.colorPallet.setrMax(colorR.getValue());
        this.colorPallet.setgMax(colorG.getValue());
        this.colorPallet.setbMax(colorB.getValue());
    }
}
