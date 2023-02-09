import java.awt.*;

public class FlameView extends Canvas implements Runnable{
    int x;
    int y;
    Boolean animated = true;
    int delay = 12;
    Flame  flame = null;
    public FlameView(int x,int y){
        this.x = x;
        this.y = y;
        ColorPallet colorPallet = new ColorPallet(256);
        colorPallet.generateColors();
        flame = new Flame(x, y, colorPallet);

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
