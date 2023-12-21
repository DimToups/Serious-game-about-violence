package fr.tyr.components.others;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class BackgroundComponent extends ImageComponent {

    public BackgroundComponent(Images image) {
        super(image, new Vector2D(0, 0));
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
        resize(size, true);
    }
}
