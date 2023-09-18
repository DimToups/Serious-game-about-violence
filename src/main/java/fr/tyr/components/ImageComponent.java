package fr.tyr.components;

import fr.tyr.images.Images;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageComponent extends GameComponent {

    private final Images imageType;
    private BufferedImage image;

    public ImageComponent(Images image){
        this(new Vector2D(0, 0), image);
    }

    public ImageComponent(Vector2D position, Images image) {
        super(position);
        this.imageType = image;
        this.image = image.getCopy();
        setSize(new Vector2D(this.image.getWidth(), this.image.getHeight()));
    }

    public ImageComponent(Vector2D position, Images image, int width, int height){
        super(position);
        this.imageType = image;
        this.image = image.getCopy();
        resize(width, height);
    }

    public void resize(int width, int height){
        BufferedImage imageCopy = imageType.getCopy();
        Image tmp = imageCopy.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = newImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        image = newImage;
        setSize(new Vector2D(width, height));
    }

    private void crop(int x, int y, int width, int height) {
        image = image.getSubimage(x, y, width, height);
        setSize(new Vector2D(width, height));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) getPosition().x, (int) getPosition().y, null);
    }

    @Override
    public void onClick() {
        if(isHovered())
            moveTo(new Vector2D(205, 55), .1f);
        else
            moveTo(new Vector2D(200, 50), .1f);
    }

    @Override
    public void onHover() {
        resize(60, 60);
        getPosition().subtract(new Vector2D(5, 5));
    }

    @Override
    public void onHoverLost() {
        resize(50, 50);
        getPosition().add(new Vector2D(5, 5));
    }
}
