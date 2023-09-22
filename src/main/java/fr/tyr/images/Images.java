package fr.tyr.images;

import fr.tyr.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public enum Images {
    SWORDS("swords.png"),
    BACKGROUND("background.jpg");

    private final String path;
    private BufferedImage image;

    Images(String path){
        this.path = path;
    }

    private void loadImage(){
        try {
            InputStream inputStream = getClass().getResourceAsStream("/" + path);
            if (Objects.isNull(inputStream))
                throw new RuntimeException("Image not found: " + path);
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            Main.getLogger().severe(e.getMessage());
        }
    }

    public BufferedImage getCopy() {
        if (Objects.isNull(image))
            loadImage();
        return deepCopy(image);
    }

    private static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }


}
