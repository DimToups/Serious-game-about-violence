package fr.tyr.resources.images;

import fr.tyr.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

public enum Animations {
    BAR("animation/Frame %d.png", 10);

    private final String path;
    private final int frameCount;
    private List<BufferedImage> images;

    /**
     * Create an animation
     * @param path The path to the images
     * @param frameCount The number of images
     */
    Animations(String path, int frameCount){
        this.path = path;
        this.frameCount = frameCount;
    }

    /**
     * Load the images from the resources folder
     */
    private void loadImages(){
        images = new ArrayList<>();
        try {
            for(int i = 0; i < frameCount; i++){
                InputStream inputStream = getClass().getResourceAsStream("/" + path.formatted(i));
                if (Objects.isNull(inputStream))
                    throw new RuntimeException("Image not found: " + path.formatted(i));
                images.add(ImageIO.read(inputStream));
            }
        } catch (IOException e) {
            Main.getLogger().log(Level.SEVERE, e.getMessage(), e);
        }
    }

    /**
     * Return a copy of the images
     * @return A copy of the images
     */
    public List<BufferedImage> getCopy() {
        if (Objects.isNull(images))
            loadImages();
        List<BufferedImage> localImages = new ArrayList<>();
        for(BufferedImage image : images)
            localImages.add(new BufferedImage(image.getColorModel(), image.copyData(null), image.isAlphaPremultiplied(), null));
        return localImages;
    }
}
