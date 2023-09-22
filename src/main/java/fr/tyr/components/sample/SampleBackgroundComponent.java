package fr.tyr.components.sample;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.images.Images;
import fr.tyr.tools.Vector2D;

public class SampleBackgroundComponent extends ImageComponent {

    public SampleBackgroundComponent() {
        super(Images.BACKGROUND, new Vector2D(0, 0));
    }

    @Override
    public void tick(int aps) {

    }

    @Override
    public void onClick() {

    }

    @Override
    public void onHover() {

    }

    @Override
    public void onHoverLost() {

    }

    @Override
    public void onResize(Vector2D size) {
        resize(size);
    }
}
