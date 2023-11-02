package fr.tyr.components.character.style;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class Shirt extends ImageComponent {
    /**
     * Create a Shirt
     * @param image
     */
    public Shirt(Images image) {
        super(image);
    }

    /**
     * Create a Shirt
     * @param image The image of the Shirt
     * @param position The component position
     */
    public Shirt(Images image, Vector2D position) {
        super(image, position);
    }

    /**
     * Create a Shirt
     * @param image The image of the Shirt
     * @param position The component position
     * @param size THe component size
     * @param center Is the image centered
     */
    public Shirt(Images image, Vector2D position, Vector2D size, boolean center) {
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