package fr.tyr.images;

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

public enum Images {
    SWORDS("swords.png", true),
    BACKGROUND("background.jpg", false);

    private final String path;
    private final boolean sizeCache;
    private BufferedImage image;
    private Map<Vector2D, BufferedImage> sizeCacheMap;

    Images(String path, boolean sizeCache){
        this.path = path;
        this.sizeCache = sizeCache;
        if(sizeCache)
            this.sizeCacheMap = new HashMap<>();
    }

    private void loadImage(){
        long start = System.currentTimeMillis();
        Main.getLogger().info("Loading image: " + path);
        try {
            InputStream inputStream = getClass().getResourceAsStream("/" + path);
            if (Objects.isNull(inputStream))
                throw new RuntimeException("Image not found: " + path);
            image = ImageIO.read(inputStream);
            if(Objects.isNull(image))
                throw new RuntimeException("Image not found: " + path);
            if(sizeCache)
                sizeCacheMap.put(new Vector2D(image.getWidth(), image.getHeight()), image);
            Main.getLogger().info("Image loaded: " + path + " (" + (System.currentTimeMillis() - start) + "ms)");
        } catch (IOException e) {
            Main.getLogger().severe(e.getMessage());
        }
    }

    public BufferedImage getCopy() {
        if (Objects.isNull(image))
            loadImage();
        return deepCopy(image);
    }

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

    private static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public static BufferedImage resize(BufferedImage image, Vector2D size, boolean center) {
        int targetWidth = (int) size.x;
        int targetHeight = (int) size.y;

        // Calcule le ratio de redimensionnement
        double widthRatio = (double) targetWidth / image.getWidth();
        double heightRatio = (double) targetHeight / image.getHeight();
        double scaleFactor = Math.max(widthRatio, heightRatio);

        // Redimensionne l'image en conservant le ratio
        BufferedImage resizedImage = Scalr.resize(image, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, (int) (image.getWidth() * scaleFactor), (int) (image.getHeight() * scaleFactor), Scalr.OP_ANTIALIAS);

        if (center) {
            // Calcule les décalages pour centrer l'image dans la nouvelle taille
            int xOffset = (targetWidth - resizedImage.getWidth()) / 2;
            int yOffset = (targetHeight - resizedImage.getHeight()) / 2;

            // Crée une nouvelle image centrée
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
