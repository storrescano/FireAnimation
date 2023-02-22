public class Controller {

    private Thread flameThreadView;
    private Flame flame;


    public void setSparkles(int value){
        flame.setSparksIntensity(value);
    }

    public void setFlame(Flame flame) {
        this.flame = flame;
    }

    public void stopThread() {
        flameThreadView.interrupt();
    }

    public void setFlameThread(Thread flameViewThread) {
        this.flameThreadView = flameViewThread;
    }
}
