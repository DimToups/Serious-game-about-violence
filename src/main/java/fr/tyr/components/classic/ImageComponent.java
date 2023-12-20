package fr.tyr.components.classic;

import fr.tyr.Main;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.STimer;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class ImageComponent extends GameComponent<BufferedImage> {

    private Images imageType;
    private Vector2D originalSize;

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
        if(Objects.nonNull(getFrame())){
            setSize(new Vector2D(getFrame().getWidth(), getFrame().getHeight()));
            this.originalSize = getSize();
        }
        else
            throw new RuntimeException("Unable to load image: %s".formatted(image.name()));
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
     */
    public void resize(Vector2D size) {
        resize(size, false, false);
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
        long timerId = STimer.start();
        setFrame(imageType.getCopy(size, centerImage));
        setSize(size);
        Main.getLogger().info("%s image resized from %s to %s (%dms)".formatted(imageType.name(), getSize(), size, STimer.stop(timerId)));
        if(centerComponent){
            throw new RuntimeException("Centering component is not implemented yet");
//            Vector2D tempVector = null;
//            if(baseSize.x > size.x && baseSize.y > size.y)
//                tempVector = Vector2D.toPositive(Vector2D.subtract(baseSize, size)).getDivided(2);
//            else if(baseSize.x < size.x && baseSize.y < size.y)
//                tempVector = Vector2D.toNegative(Vector2D.subtract(baseSize, size)).getDivided(2);
//            if(Objects.isNull(tempVector))
//                throw new RuntimeException("Unable to center component from size %s to size %s".formatted(baseSize, size));
//            getPosition().add(tempVector);
//            if(isMoving())
//                moveTo(getTarget().getAdded(tempVector), getRemainingDuration());
        }
    }

    /**
     * Crop the image to the given size
     * This method is currently work in progress
     * @param x The x position of the top left corner of the crop
     * @param y The y position of the top left corner of the crop
     * @param width The width of the crop
     * @param height The height of the crop
     */
    public void crop(int x, int y, int width, int height) {
        setFrame(getImage().getCopy().getSubimage(x, y, width, height));
        setSize(new Vector2D(getFrame().getWidth(), getFrame().getHeight()));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getFrame(), (int) getPosition().x, (int) getPosition().y, null);
        if(Main.doesHitboxDisplay())
            displayHitbox(g, Color.RED);
    }

    public void setImage(Images image){
        this.imageType = image;
        setFrame(image.getCopy());
        setSize(new Vector2D(getFrame().getWidth(), getFrame().getHeight()));
    }

    public Images getImage(){
        return this.imageType;
    }

    public Vector2D getOriginalSize() {
        return originalSize;
    }

    @Override
    public void tick(int aps) {

    }

    @Override
    public void onClick(MouseButtons button) {

    }

    @Override
    public void onHover() {

    }

    @Override
    public void onHoverLost() {

    }

    @Override
    public void onWindowResized(Vector2D size) {

    }
}
