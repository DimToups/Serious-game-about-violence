package fr.tyr.components.character.style;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class Skin extends ImageComponent {
    public Skin(Images image) {
        super(image);
    }
    public Skin(Images image, Vector2D position) {
        super(image, position);
    }
    public Skin(Images image, Vector2D position, Vector2D size, boolean center) {
        super(image, position, size, center);
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

    }
}
