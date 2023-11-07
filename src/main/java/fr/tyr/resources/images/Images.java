package fr.tyr.resources.images;

import fr.tyr.Main;
import fr.tyr.tools.Vector2D;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;

public enum Images {
    SWORDS("swords.png", true),
    BACKGROUND("background.jpg", false),
    NONE("assets/character/beards/none.png", false),
    SKIN_WHITE("assets/character/skins/white.png", false),
    SHIRT_RED("assets/character/shirts/red.png", false),
    EYES_MALE_BLUE("assets/character/eyes/male/blue.png", false),
    HAIR_MALE_DISHEVELLED("assets/character/hairs/male/dishevelled.png", false);
    private final String path;
    private final boolean sizeCache;
    private BufferedImage image;
    private Map<Vector2D, BufferedImage> sizeCacheMap;

    /**
     * Create an image
     * @param path Path to the image
     * @param sizeCache If true, the image will be resized and cached
     */
    Images(String path, boolean sizeCache){
        this.path = path;
        this.sizeCache = sizeCache;
        if(sizeCache)
            this.sizeCacheMap = new HashMap<>();
    }

    /**
     * Load the image
     */
    private void loadImage(){
        long start = System.currentTimeMillis();
        Main.getLogger().info("Loading image: %s".formatted(path));
        try {
            InputStream inputStream = getClass().getResourceAsStream("/%s".formatted(path));
            if (Objects.isNull(inputStream))
                throw new RuntimeException("Image not found: %s".formatted(path));
            image = ImageIO.read(inputStream);
            if(Objects.isNull(image))
                throw new RuntimeException("Image not found: %s".formatted(path));
            if(sizeCache)
                sizeCacheMap.put(new Vector2D(image.getWidth(), image.getHeight()), image);
            Main.getLogger().info("Image loaded %s (%d ms)".formatted(path, System.currentTimeMillis() - start));
        } catch (IOException e) {
            Main.getLogger().log(Level.SEVERE, e.getMessage(), e);
        }
    }

    /**
     * Get a copy of the image
     * @return A copy of the image
     */
    public BufferedImage getCopy() {
        if (Objects.isNull(image))
            loadImage();
        return deepCopy(image);
    }

    /**
     * Get a copy of the image resized
     * @param size Size of the image
     * @param center If true, the image will be centered
     * @return A copy of the image resized
     */
    public BufferedImage getCopy(Vector2D size, boolean center){
        if (Objects.isNull(image))
            loadImage();
        if(!sizeCache)
            return resize(image, size, center);
        if(sizeCacheMap.containsKey(size))
            return sizeCacheMap.get(size);
        BufferedImage resized = resize(image, size, center);
        sizeCacheMap.put(size, resized);
        return resized;
    }

    /**
     * Get a copy of the image resized
     * @param bi Image to resize
     * @return A copy of the image resized
     */
    private static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    /**
     * Resize an image
     * @param image Image to resize
     * @param size Size of the image
     * @param center If true, the image will be centered
     * @return The resized image
     */
    public static BufferedImage resize(BufferedImage image, Vector2D size, boolean center) {
        int targetWidth = (int) size.x;
        int targetHeight = (int) size.y;
        // Compute resize ratio
        double widthRatio = (double) targetWidth / image.getWidth();
        double heightRatio = (double) targetHeight / image.getHeight();
        double scaleFactor = Math.max(widthRatio, heightRatio);
        // Resize image with ratio
        BufferedImage resizedImage = Scalr.resize(image, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, (int) (image.getWidth() * scaleFactor), (int) (image.getHeight() * scaleFactor), Scalr.OP_ANTIALIAS);
        if (center) {
            // Compute offsets to center the image
            int xOffset = (targetWidth - resizedImage.getWidth()) / 2;
            int yOffset = (targetHeight - resizedImage.getHeight()) / 2;
            // Create the new image
            BufferedImage centeredImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = centeredImage.createGraphics();
            g2d.drawImage(resizedImage, xOffset, yOffset, null);
            g2d.dispose();
            return centeredImage;
        } else {
            return resizedImage;
        }
    }
}
