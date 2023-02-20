import java.awt.*;
import java.awt.image.BufferedImage;

public class Flame {
    private int width;
    private int height;
    private int[] ImgArray;
    private ColorPallet colorPallet;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getImgArray() {
        if (ImgArray == null) {
            ImgArray = new int[width * height];
        }
        return ImgArray;
    }

    public void setImgArray(int[] imgArray) {
        ImgArray = imgArray;
    }

    public ColorPallet getColorPallet() {
        return colorPallet;
    }

    public void setColorPallet(ColorPallet colorPallet) {
        this.colorPallet = colorPallet;
    }


    public Flame(int width, int height, ColorPallet colorPallet) {
        this.width = width;
        this.height = height;
        this.colorPallet = colorPallet;
    }

    public void sparks() {
        int[] ImgArray = getImgArray();
        for (int i = height - 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pos = (i * width) + j;
//                ImgArray[pos] = Math.random() > 0.55 ? 0 : 255;
                ImgArray[pos] = 0;
                int random = (int) (Math.random() * 100);
                if (random < 40) {
                    ImgArray[pos] = 255;
                }
            }
        }
    }

    public void completeArray() {
        int[] ImgArray = getImgArray();
        int[] newImg = ImgArray.clone();
        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < width - 1; j++) {
                int pos = (i * width) + j;
                int underVal = ((i + 1) * width) + j;
                int valor = ((ImgArray[pos] +
                        ImgArray[underVal] +
                        ImgArray[underVal - 1] +
                        ImgArray[underVal + 1])
                        / 4);
                if (valor < 0) {
                    newImg[pos] = 0;
                } else if (valor > 255) {
                    newImg[pos] = 255;
                }
                newImg[pos] = valor;
            }
        }
        System.arraycopy(newImg, 0, ImgArray, 0, ImgArray.length);
    }

    public Image processImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        int[] buffer = getImgArray();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (y == height - 1) continue;
                int index = y * width + x;
                Color color = colorPallet.getColor(buffer[index]);
                image.setRGB(x, y, color.getRGB());
            }
        }

        return image;
    }
}



