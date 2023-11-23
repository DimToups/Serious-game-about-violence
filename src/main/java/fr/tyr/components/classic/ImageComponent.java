package fr.tyr.components.classic;

import fr.tyr.Main;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.STimer;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public abstract class ImageComponent extends GameComponent<BufferedImage> {

    private final Images imageType;

    /**
     * Create a new image component with the given image
     * @param image The image to use
     */
    public ImageComponent(Images image){
        this(image, new Vector2D(0, 0));
    }

    /**
     * Create a new image component with the given image and position
     * @param image The image to use
     * @param position The position of the component
     */
    public ImageComponent(Images image, Vector2D position) {
        super(image.getCopy(), position);
        this.imageType = image;
        if(Objects.nonNull(getFrame()))
            setSize(new Vector2D(getFrame().getWidth(), getFrame().getHeight()));
    }

    /**
     * Create a new image component with the given image, position and size
     * @param image The image to use
     * @param position The position of the component
     * @param size The size of the component
     * @param center If true, the image will be centered in the given size
     */
    public ImageComponent(Images image, Vector2D position, Vector2D size, boolean center){
        super(image.getCopy(), position);
        this.imageType = image;
        resize(size, center);
    }

    /**
     * Resize the image to the given size
     * @param size The new size of the image
     * @param centerImage If true, the image will be centered in the new size
     */
    public void resize(Vector2D size, boolean centerImage) {
        resize(size, centerImage, false);
    }

    /**
     * Resize the image to the given size
     * @param size The new size of the image
     * @param centerImage If true, the image will be centered in the new size
     * @param centerComponent If true, the component will be centered in the new size
     */
    public void resize(Vector2D size, boolean centerImage, boolean centerComponent) {
        Vector2D baseSize = getSize();
        Thread.ofVirtual().start(() -> {
            long timerId = STimer.start();
            setFrame(imageType.getCopy(size, centerImage));
            setSize(size);
            Main.getLogger().info("%s image resized from %s to %s (%dms)".formatted(imageType.name(), getSize(), size, STimer.stop(timerId)));
            if(centerComponent){
                Vector2D tempVector = null;
                if(baseSize.x > size.x && baseSize.y > size.y)
                    tempVector = Vector2D.toPositive(Vector2D.subtract(baseSize, size)).getDivided(2);
                else if(baseSize.x < size.x && baseSize.y < size.y)
                    tempVector = Vector2D.toNegative(Vector2D.subtract(baseSize, size)).getDivided(2);
                if(Objects.isNull(tempVector)){
                    Main.getLogger().severe("Unable to center component from size %s to size %s".formatted(baseSize, size));
                    return;
                }
                getPosition().add(tempVector);
                if(isMoving())
                    moveTo(getTarget().getAdded(tempVector), getRemainingDuration());
            }
        });
    }

    /**
     * Crop the image to the given size
     * This method is currently work in progress
     * @param x The x position of the top left corner of the crop
     * @param y The y position of the top left corner of the crop
     * @param width The width of the crop
     * @param height The height of the crop
     */
    @Deprecated
    private void crop(int x, int y, int width, int height) {
        setFrame(getFrame().getSubimage(x, y, width, height));
        setSize(new Vector2D(width, height));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getFrame(), (int) getPosition().x, (int) getPosition().y, null);
    }
    public Images getImage(){
        return this.imageType;
    }
}
