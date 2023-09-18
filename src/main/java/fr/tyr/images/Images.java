package fr.tyr.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public enum Images {
    SWORDS("swords.png");

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
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getCopy(){
        if(Objects.isNull(image))
            loadImage();
        return new BufferedImage(image.getColorModel(), image.copyData(null), image.isAlphaPremultiplied(), null);
    }


}
