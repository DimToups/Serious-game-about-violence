package fr.tyr.components.classic;

import fr.tyr.Main;
import fr.tyr.images.Images;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class ImageComponent extends GameComponent<BufferedImage> {

    private final Images imageType;

    public ImageComponent(Images image){
        this(image, new Vector2D(0, 0));
    }

    public ImageComponent(Images image, Vector2D position) {
        super(image.getCopy(), position);
        this.imageType = image;
        setSize(new Vector2D(getFrame().getWidth(), getFrame().getHeight()));
    }

    public ImageComponent(Images image, Vector2D position, Vector2D size, boolean center){
        super(image.getCopy(), position);
        this.imageType = image;
        resize(size, center);
    }

    public void resize(Vector2D size, boolean center) {
        Thread.ofVirtual().start(() -> {
            long start = System.currentTimeMillis();
            Main.getLogger().info("%s image resized from %s to %s ".formatted(imageType.name(), getSize(), size));
            setFrame(imageType.getCopy(size, center));
            setSize(size);
            Main.getLogger().info("%s image resized (%dms)".formatted(imageType.name(), System.currentTimeMillis() - start));
        });
    }


    private void crop(int x, int y, int width, int height) {
        setFrame(getFrame().getSubimage(x, y, width, height));
        setSize(new Vector2D(width, height));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getFrame(), (int) getPosition().x, (int) getPosition().y, null);
    }
}
