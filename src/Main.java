public class Main {
    public static void main(String[] args) {
        ColorPallet colorPallet = new ColorPallet(255);
        FlameView flameView = new FlameView(500, 500, colorPallet);
        Panel panel = new Panel(flameView);
    }
}
