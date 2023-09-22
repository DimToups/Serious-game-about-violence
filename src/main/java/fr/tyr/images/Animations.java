package fr.tyr.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public enum Animations {
    BAR("animation/Frame %d.png", 10);

    private final String path;
    private final int frameCount;
    private List<BufferedImage> images;

    Animations(String path, int frameCount){
        this.path = path;
        this.frameCount = frameCount;
    }

    private void loadImage(){
        images = new ArrayList<>();
        try {
            for(int i = 0; i < frameCount; i++){
                InputStream inputStream = getClass().getResourceAsStream("/" + path.formatted(i));
                if (Objects.isNull(inputStream))
                    throw new RuntimeException("Image not found: " + path.formatted(i));
                images.add(ImageIO.read(inputStream));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BufferedImage> getCopy() {
        if (Objects.isNull(images))
            loadImage();
        List<BufferedImage> localImages = new ArrayList<>();
        for(BufferedImage image : images)
            localImages.add(new BufferedImage(image.getColorModel(), image.copyData(null), image.isAlphaPremultiplied(), null));
        return localImages;
    }
}
