import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ColorPallet {
    private  int size;
    private ArrayList<Color> Colors = new ArrayList<Color>();
    private HashMap<Integer, Color> colorPallet = new HashMap<Integer, Color>();

    public ColorPallet(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Color> getColors() {
        return Colors;
    }

    public void setColors(ArrayList<Color> colors) {
        Colors = colors;
    }

    public HashMap<Integer, Color> getColorPallet() {
        return colorPallet;
    }

    public void setColorPallet(HashMap<Integer, Color> colorPallet) {
        this.colorPallet = colorPallet;
    }


    public Color getColor(int index) {
        Color color = null;
        if (index < Colors.size()) color = Colors.get(index);
        return color;
    }

    public void generateColors(){
        float red = 0;
        float green = 0;
        float blue = 0;
        float alpha = 0;


        for (int i = 0; i < getSize(); i++) {

            colorPallet.put(i,new Color(i,0,0,255));
            Color color = colorPallet.get(i);
            red = color.getRed();
            green = color.getGreen();
            blue = color.getBlue();
            alpha = color.getAlpha();
            Colors.add(new Color((int) red, (int) green, (int) blue, (int)alpha));


        }


    }
}
