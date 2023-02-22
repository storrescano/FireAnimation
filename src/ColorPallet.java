import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ColorPallet {
    private int size;
    private ArrayList<Color> colorArrayList = new ArrayList<>();
    private HashMap<Integer, Color> colorPallet = new HashMap<>();

    private int rMax = 254;
    private int gMax = 0;
    private int bMax = 0;


    private int alpha = 255;


    public int getrMax() {
        return rMax;
    }

    public int getgMax() {
        return gMax;
    }

    public int getbMax() {
        return bMax;
    }

    public void setrMax(int rMax) {
        this.rMax = rMax;
    }

    public void setgMax(int gMax) {
        this.gMax = gMax;
    }

    public void setbMax(int bMax) {
        this.bMax = bMax;
    }


    public ColorPallet(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Color> getColorArrayList() {
        return colorArrayList;
    }

    public void setColorArrayList(ArrayList<Color> colorArrayList) {
        this.colorArrayList = colorArrayList;
    }

    public HashMap<Integer, Color> getColorPallet() {
        return colorPallet;
    }

    public void refreshColor(){
        generateColors();
    }

    public void setColorPallet(HashMap<Integer, Color> colorPallet) {
        this.colorPallet = colorPallet;
    }


    public Color getColor(int index) {
        Color color = null;
        if (index < colorArrayList.size()) color = colorArrayList.get(index);
        return color;
    }

    public void generateColors() {
        float red;
        float green;
        float blue;
        float alpha;

        int r = 0;
        int g = 0;
        int b = 0;

        int gMid = 0;
        int rMid = 0;
        int bMid = 0;

        colorArrayList = new ArrayList<>();
        for (int l = 0; l < getSize(); l++) {
            if (r<=getrMax()){
                r++;
            }
            if (g<=getgMax()) {
                g++;
            }
            if (b<=getbMax()){
                b++;
            }

            colorPallet.put(l, new Color(r, g, b, getAlpha()));
            Color color = colorPallet.get(l);
            red = color.getRed();
            green = color.getGreen();
            blue = color.getBlue();
            alpha = color.getAlpha();

            colorArrayList.add(new Color((int) red, (int) green, (int) blue, (int) alpha));
        }


        /*for (int l = 40; l < 100; l++) {
            if (bMid<=getrMax()){
                bMid++;
            }
            if (rMid<=getgMax()) {
                rMid++;
            }
            if (gMid<=getbMax()){
                gMid++;
            }

            colorPallet.put(l, new Color(rMid, gMid, bMid, 255));
            Color color = colorPallet.get(l);
            red = color.getRed();
            green = color.getGreen();
            blue = color.getBlue();
            alpha = color.getAlpha();

            colorArrayList.add(new Color((int) red, (int) green, (int) blue, (int) alpha));
        }*/




        /*for (int l = 90; l < getSize(); l++) {
            if (r<=getbMax()){
                b++;
            }
            if (g<=getrMax()) {
                r++;
            }
            if (b<=getgMax()){
                g++;
            }

            colorPallet.put(l, new Color(r, g, b, 255));
            Color color = colorPallet.get(l);
            red = color.getRed();
            green = color.getGreen();
            blue = color.getBlue();
            alpha = color.getAlpha();

            colorArrayList.add(new Color((int) red, (int) green, (int) blue, (int) alpha));
        }*/

    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}
