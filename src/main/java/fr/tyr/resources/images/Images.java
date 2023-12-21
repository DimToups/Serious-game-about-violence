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
    NONE("assets/none.png", false),
    // Game scene
    BACKGROUND("assets/game_scene/background.png", true),
    // End scene
    END_BACKGROUND("assets/end_scene/background.png", true),
    END_FIGURE_ICON("assets/end_scene/figure.png", true),
    END_STAR_ICON("assets/end_scene/star.png", true),
    END_TIME_ICON("assets/end_scene/time.png", true),
    RESTART_BUTTON("assets/end_scene/restart.png", true),
    // Skins
    SKIN_WHITE("assets/character/skins/white.png", true),
    SKIN_BLACK("assets/character/skins/black.png", true),
    SKIN_ASIAN("assets/character/skins/asian.png", true),
    SKIN_TANNED("assets/character/skins/tanned.png", true),
    // Shirts
    SHIRT_RED("assets/character/shirts/red.png", true),
    SHIRT_PURPLE("assets/character/shirts/purple.png", true),
    SHIRT_LIGHT_BLUE("assets/character/shirts/light_blue.png", true),
    SHIRT_GREEN("assets/character/shirts/green.png", true),
    // Eyes
    EYES_COMMON_MALE_BLUE("assets/character/eyes/male/blue.png", true),
    EYES_COMMON_MALE_LIGHT_BLUE("assets/character/eyes/male/light_blue.png", true),
    EYES_COMMON_MALE_BROWN("assets/character/eyes/male/brown.png", true),
    EYES_COMMON_MALE_GREEN("assets/character/eyes/male/green.png", true),
    EYES_COMMON_MALE_YELLOW("assets/character/eyes/male/yellow.png", true),
    EYES_ASIAN_MALE_BLUE("assets/character/eyes/male/asian_blue.png", true),
    EYES_ASIAN_MALE_LIGHT_BLUE("assets/character/eyes/male/asian_light_blue.png", true),
    EYES_ASIAN_MALE_BROWN("assets/character/eyes/male/asian_brown.png", true),
    EYES_ASIAN_MALE_GREEN("assets/character/eyes/male/asian_green.png", true),
    EYES_ASIAN_MALE_YELLOW("assets/character/eyes/male/asian_yellow.png", true),
    EYES_COMMON_FEMALE_DOUBLE_BRUSH_BLUE("assets/character/eyes/female/common_double_brush_blue.png", true),
    EYES_COMMON_FEMALE_DOUBLE_BRUSH_LIGHT_BLUE("assets/character/eyes/female/common_double_brush_light_blue.png", true),
    EYES_COMMON_FEMALE_DOUBLE_BRUSH_BROWN("assets/character/eyes/female/common_double_brush_brown.png", true),
    EYES_COMMON_FEMALE_DOUBLE_BRUSH_GREEN("assets/character/eyes/female/common_double_brush_green.png", true),
    EYES_COMMON_FEMALE_DOUBLE_BRUSH_YELLOW("assets/character/eyes/female/common_double_brush_yellow.png", true),
    // Hairs
    HAIR_MALE_DISHEVELLED("assets/character/hairs/male/dishevelled.png", true),
    HAIR_BOWL_BLACK("assets/character/hairs/male/bowl_black.png", true),
    HAIR_BOWL_DARK_BROWN("assets/character/hairs/male/bowl_dark_brown.png", true),
    HAIR_BOWL_BROWN("assets/character/hairs/male/bowl_brown.png", true),
    HAIR_BOWL_BLOND("assets/character/hairs/male/bowl_blond.png", true),
    HAIR_BOWL_WHITE("assets/character/hairs/male/bowl_white.png", true),
    HAIR_BOWL_GINGER("assets/character/hairs/male/bowl_ginger.png", true),
    HAIR_BOWL_BLUE("assets/character/hairs/male/bowl_blue.png", true),
    HAIR_BOWL_PINK("assets/character/hairs/male/bowl_pink.png", true),
    HAIR_MID_LENGTH_BLACK("assets/character/hairs/female/mid_length_black.png", true),
    HAIR_MID_LENGTH_DARK_BROWN("assets/character/hairs/female/mid_length_dark_brown.png", true),
    HAIR_MID_LENGTH_BROWN("assets/character/hairs/female/mid_length_brown.png", true),
    HAIR_MID_LENGTH_BLOND("assets/character/hairs/female/mid_length_blond.png", true),
    HAIR_MID_LENGTH_WHITE("assets/character/hairs/female/mid_length_white.png", true),
    HAIR_MID_LENGTH_GINGER("assets/character/hairs/female/mid_length_ginger.png", true),
    HAIR_MID_LENGTH_BLUE("assets/character/hairs/female/mid_length_blue.png", true),
    HAIR_MID_LENGTH_PINK("assets/character/hairs/female/mid_length_pink.png", true),
    // Beards
    BEARD_SHORT_BLACK("assets/character/beards/short_black.png", true),
    BEARD_SHORT_DARK_BROWN("assets/character/beards/short_dark_brown.png", true),
    BEARD_SHORT_BROWN("assets/character/beards/short_brown.png", true),
    BEARD_SHORT_BLOND("assets/character/beards/short_blond.png", true),
    BEARD_SHORT_WHITE("assets/character/beards/short_white.png", true),
    BEARD_SHORT_GINGER("assets/character/beards/short_ginger.png", true),
    BEARD_SHORT_BLUE("assets/character/beards/short_blue.png", true),
    BEARD_SHORT_PINK("assets/character/beards/short_pink.png", true),

    REPUTATION_GAUGE_BACKGROUND("assets/gauges/reputation/background.png", true),
    REPUTATION_GAUGE_ICON("assets/gauges/reputation/icon.png", true),
    REPUTATION_GAUGE_PROGRESS("assets/gauges/reputation/progress.png", true),
    TIME_GAUGE_BACKGROUND("assets/gauges/time/background.png", true),
    TIME_GAUGE_ICON_MORNING("assets/gauges/time/icon_morning.png", true),
    TIME_GAUGE_ICON_DAY("assets/gauges/time/icon_day.png", true),
    TIME_GAUGE_ICON_EVENING("assets/gauges/time/icon_evening.png", true),
    TIME_GAUGE_PROGRESS("assets/gauges/time/progress.png", true),
    MONEY_GAUGE_ICON("assets/gauges/money/icon.png", true),
    // violence
    // backgrounds
    BACKGROUND_PHYSICAL("assets/violenceCard/backgrounds/physical_violence.png",true),
    BACKGROUND_PSYCHOLOGICAL("assets/violenceCard/backgrounds/psychological_violence.png",true),
    BACKGROUND_ECONOMICAL("assets/violenceCard/backgrounds/economic_violence.png",true),
    BACKGROUND_VERBAL("assets/violenceCard/backgrounds/verbal_violence.png",true),
    BACKGROUND_SEXUAL("assets/violenceCard/backgrounds/sexual_violence.png",true),
    // icon
    ICON_PHYSICAL("assets/violenceCard/icons/physical_violence.png",true),
    ICON_PSYCHOLOGICAL("assets/violenceCard/icons/psychological_violence.png",true),
    ICON_ECONOMICAL("assets/violenceCard/icons/economic_violence.png",true),
    ICON_VERBAL("assets/violenceCard/icons/verbal_violence.png",true),
    ICON_SEXUAL("assets/violenceCard/icons/sexual_violence.png",true),

    // Character Sheet
    CHARACTER_SHEET_BACKGROUND("assets/character_sheet/background.png", true),

    // Memos
    MEMO_GREEN("assets/memo/green_memo.png", true),
    MEMO_YELLOW("assets/memo/yellow_memo.png", true),
    MEMO_PINK("assets/memo/pink_memo.png", true),
    ;

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
        size = new Vector2D((int) size.x, (int) size.y);
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

    /**
     * Send the Images path
     * @return The Images path
     */
    public String getPath(){
        return this.path;
    }
}
