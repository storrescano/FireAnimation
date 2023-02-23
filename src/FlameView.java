import java.awt.*;

public class FlameView extends Canvas implements Runnable {
    private final Object lock = new Object();
    private final int x;
    private final int y;
    private Boolean animated = true;
    private final int delay = 12;



    public ColorPallet getColorPallet() {
        return colorPallet;
    }

    private final ColorPallet colorPallet;
    private Flame flame;

    private final Controller controller;

    public FlameView(int x, int y, ColorPallet colorPallet, Controller controller) {
        this.controller = controller;
        this.x = 240;
        this.y = 120;
        this.colorPallet = colorPallet;
        this.colorPallet.generateColors();
        flame = new Flame(x, y, this.colorPallet);
        setFlame(flame);

    }
    public void run() {
        while (animated) {
            paint();
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            synchronized (lock) {
                while (!animated) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void setFlame(Flame flame){
        this.controller.setFlame(flame);
    }

    public void pause() {
        animated = false;
    }

    public void resume() {
        synchronized (lock) {
            animated = true;
            lock.notify(); // Notificar a hilo
        }
    }

    public void stop(){
        flame = new Flame(x, y, this.colorPallet);
        animated = false;
    }

    public void paint() {
        Graphics graphics = this.getGraphics();

        if (graphics == null) return;
        flame.sparks();
        flame.completeArray();
        Image img = flame.processImage();
        graphics.drawImage(img, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.x, this.y);
    }
}
