public class Main {
    public static void main(String[] args) {
        Panel panel = new Panel();
        Thread thread = new Thread(panel);
        thread.start();

    }
}
