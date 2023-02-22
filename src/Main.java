public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        ColorPallet colorPallet = new ColorPallet(255);
        FlameView flameView = new FlameView(800, 800, colorPallet, controller);
        controller.setFlameView(flameView);
        Panel panel = new Panel(flameView, controller);

    }
}
