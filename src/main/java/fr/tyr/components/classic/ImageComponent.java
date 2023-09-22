package fr.tyr.components.classic;

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

    public ImageComponent(Images image, Vector2D position, Vector2D size){
        super(image.getCopy(), position);
        this.imageType = image;
        resize(size);
    }

    public void resize(Vector2D size) {
        Thread.ofVirtual().start(() -> {
            setFrame(resizeImage(size));
            setSize(size);
        });
    }

    private BufferedImage resizeImage(Vector2D size){
        BufferedImage imageCopy = imageType.getCopy();
        double originalWidth = imageCopy.getWidth();
        double originalHeight = imageCopy.getHeight();

        double scaleX = size.x / originalWidth;
        double scaleY = size.y / originalHeight;

        double scaleFactor = Math.max(scaleX, scaleY);
        int newWidth = (int) (originalWidth * scaleFactor);
        int newHeight = (int) (originalHeight * scaleFactor);

        Image tmp = imageCopy.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = newImage.createGraphics();

        // Center the image
        int xOffset = (int) ((size.x - newWidth) / 2);
        int yOffset = (int) ((size.y - newHeight) / 2);

        g2d.drawImage(tmp, xOffset, yOffset, null);
        g2d.dispose();

        return newImage;
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
