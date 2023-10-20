package fr.tyr.components.animated;

import fr.tyr.resources.images.Animations;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
public abstract class AnimatedImageComponent extends AnimatedComponent<BufferedImage>{

    /**
     * Create an animated image component
     * @param position The position of the component
     * @param secondsPerImage The time between each image
     * @param animation The animation to use
     */
    public AnimatedImageComponent(Vector2D position, float secondsPerImage, Animations animation){
        super(position, animation.getCopy(), secondsPerImage);
        setSize(new Vector2D(getCurrentFrame().getWidth(), getCurrentFrame().getHeight()));
    }

    @Override
    public void nextFrame() {
        super.nextFrame();
        setSize(new Vector2D(getCurrentFrame().getWidth(), getCurrentFrame().getHeight()));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentFrame(), (int) getPosition().x, (int) getPosition().y, null);
    }
}
