package fr.tyr.components.sample;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class SampleImageComponent extends ImageComponent {
    public SampleImageComponent(Vector2D position, Vector2D size) {
        super(Images.SWORDS, position, size, false);
    }

    @Override
    public void tick(int aps) {

    }

    @Override
    public void onClick(MouseButtons button) {
        moveTo(new Vector2D(500, 100), .5f);
    }

    @Override
    public void onHover() {
        resize(new Vector2D(100, 100), false, true);
    }

    @Override
    public void onHoverLost() {
        resize(new Vector2D(50, 50), false, true);
    }

    @Override
    public void onWindowResized(Vector2D size) {

    }
}
