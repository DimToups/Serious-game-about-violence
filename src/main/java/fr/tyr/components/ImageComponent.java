package fr.tyr.components;

import fr.tyr.tools.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ImageComponent extends GameComponent {

    private BufferedImage image;

    public ImageComponent(String path){
        this(new Vector2D(0, 0), path);
    }

    public ImageComponent(Vector2D position, String path) {
        super(position);
        try {
            InputStream inputStream = getClass().getResourceAsStream("/" + path);
            if (Objects.isNull(inputStream))
                throw new RuntimeException("Image not found: " + path);
            this.image = ImageIO.read(inputStream);
            this.setSize(new Vector2D(this.image.getWidth(), this.image.getHeight()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ImageComponent(Vector2D position, String path, int width, int height){
        super(position);
        try {
            InputStream inputStream = getClass().getResourceAsStream("/" + path);
            if (Objects.isNull(inputStream))
                throw new RuntimeException("Image not found: " + path);
            this.image = ImageIO.read(inputStream);
            this.resize(width, height);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void resize(int width, int height){
        Image tmp = this.image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = newImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        this.image = newImage;
        this.setSize(new Vector2D(width, height));
    }

    private void crop(int x, int y, int width, int height) {
        this.image = this.image.getSubimage(x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) this.getPosition().x, (int) this.getPosition().y, null);
    }

    @Override
    public void onClick() {
        this.moveTo(new Vector2D(200, 50), 2);
    }

    @Override
    public void onHover() {
//        System.out.println("Hover on component");
    }

    @Override
    public void onHoverLost() {
//        System.out.println("Lost hover on component");
    }

}
