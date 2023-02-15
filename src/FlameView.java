import java.awt.*;

public class FlameView extends Canvas implements Runnable{
    int x;
    int y;
    Boolean animated = true;
    int delay = 12;

    public ColorPallet getColorPallet() {
        return colorPallet;
    }

    ColorPallet colorPallet;
    Flame  flame;
    public FlameView(int x, int y, ColorPallet colorPallet){
        this.x = x;
        this.y = y;
        this.colorPallet = colorPallet;
        this.colorPallet.generateColors();
        flame = new Flame(x, y, this.colorPallet);

    };
    public void run() {
        while (animated){
            paint();
            try {
                Thread.sleep(delay);
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void paint(){
        Graphics graphics = this.getGraphics();
        if (graphics == null)return;
        flame.sparks();
        flame.completeArray();
        final Image img = flame.processImage();
        graphics.drawImage(img,0,0,null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.x,this.y);
    }
}
