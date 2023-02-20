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

    private ColorPallet colorPallet;
    private final Flame flame;

    public FlameView(int x, int y, ColorPallet colorPallet) {
        this.x = x;
        this.y = y;
        this.colorPallet = colorPallet;
        this.colorPallet.generateColors();
        flame = new Flame(x, y, this.colorPallet);

    }

    ;

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

    public void stop() {
        animated = false;
    }

    public void resume() {
        synchronized (lock) {
            animated = true;
            lock.notify(); // Notificar a hilo
        }
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
