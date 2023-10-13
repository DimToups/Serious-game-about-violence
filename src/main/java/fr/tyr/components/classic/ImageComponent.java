package fr.tyr.components.classic;

import com.google.common.annotations.Beta;
import fr.tyr.Main;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public abstract class ImageComponent extends GameComponent<BufferedImage> {

    private final Images imageType;

    public ImageComponent(Images image){
        this(image, new Vector2D(0, 0));
    }

    public ImageComponent(Images image, Vector2D position) {
        super(image.getCopy(), position);
        this.imageType = image;
        if(Objects.nonNull(getFrame()))
            setSize(new Vector2D(getFrame().getWidth(), getFrame().getHeight()));
    }

    public ImageComponent(Images image, Vector2D position, Vector2D size, boolean center){
        super(image.getCopy(), position);
        this.imageType = image;
        resize(size, center);
    }

    public void resize(Vector2D size, boolean centerImage) {
        resize(size, centerImage, false);
    }

    public void resize(Vector2D size, boolean centerImage, boolean centerComponent) {
        Vector2D baseSize = getSize();
        Thread.ofVirtual().start(() -> {
            long start = System.currentTimeMillis();
            setFrame(imageType.getCopy(size, centerImage));
            setSize(size);
            Main.getLogger().info("%s image resized from %s to %s (%dms)".formatted(imageType.name(), getSize(), size, System.currentTimeMillis() - start));

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

    @Beta
    private void crop(int x, int y, int width, int height) {
        setFrame(getFrame().getSubimage(x, y, width, height));
        setSize(new Vector2D(width, height));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getFrame(), (int) getPosition().x, (int) getPosition().y, null);
    }
}
