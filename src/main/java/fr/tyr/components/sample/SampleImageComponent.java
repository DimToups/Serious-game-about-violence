package fr.tyr.components.sample;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.images.Images;
import fr.tyr.tools.Vector2D;

public class SampleImageComponent extends ImageComponent {
    public SampleImageComponent(Vector2D position, Vector2D size) {
        super(Images.SWORDS, position, size, false);
    }

    @Override
    public void tick(int aps) {

    }

    @Override
    public void onClick() {
        if(isHovered())
            moveTo(new Vector2D(200, 50), .1f);
        else
            moveTo(new Vector2D(205, 55), .1f);
    }

    @Override
    public void onHover() {
        resize(new Vector2D(60, 60), false);
        getPosition().subtract(new Vector2D(5, 5));
    }

    @Override
    public void onHoverLost() {
        resize(new Vector2D(50, 50), false);
        getPosition().add(new Vector2D(5, 5));
    }

    @Override
    public void onResize(Vector2D size) {

    }
}
