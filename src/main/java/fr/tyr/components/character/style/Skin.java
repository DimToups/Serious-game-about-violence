package fr.tyr.components.character.style;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class Skin extends ImageComponent {
    /**
     * Create a Skin
     * @param image The image of the Skin
     */
    public Skin(Images image) {
        super(image);
    }

    /**
     * Create a Skin
     * @param image The image of the Skin
     * @param position The component position
     */
    public Skin(Images image, Vector2D position) {
        super(image, position);
    }

    /**
     * Create a Skin
     * @param image The image of the Skin
     * @param position The component position
     * @param size The component size
     * @param center Is the image centered
     */
    public Skin(Images image, Vector2D position, Vector2D size, boolean center) {
        super(image, position, size, center);
    }

    /**
     *
     * @param aps The current number of ticks per second
     */
    @Override
    public void tick(int aps) {

    }

    /**
     *
     * @param button The button that was clicked
     */
    @Override
    public void onClick(MouseButtons button) {

    }

    /**
     *
     */
    @Override
    public void onHover() {

    }

    /**
     *
     */
    @Override
    public void onHoverLost() {

    }

    /**
     *
     * @param size The new size of the window
     */
    @Override
    public void onWindowResized(Vector2D size) {

    }
}
