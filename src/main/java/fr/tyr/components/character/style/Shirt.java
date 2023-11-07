package fr.tyr.components.character.style;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class Shirt extends ImageComponent {
    ShirtEnum shirt;
    /**
     * Create a Shirt
     * @param image
     */
    public Shirt(ShirtEnum shirt) {
        super(shirt.getImage());
        this.shirt = shirt;
    }

    /**
     * Create a Shirt
     * @param image The image of the Shirt
     * @param position The component position
     */
    public Shirt(ShirtEnum shirt, Vector2D position) {
        super(shirt.getImage(), position);
        this.shirt = shirt;
    }

    /**
     * Create a Shirt
     * @param image The image of the Shirt
     * @param position The component position
     * @param size THe component size
     * @param center Is the image centered
     */
    public Shirt(ShirtEnum shirt, Vector2D position, Vector2D size, boolean center) {
        super(shirt.getImage(), position, size, center);
        this.shirt = shirt;
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
    public String getName(){
        return shirt.getName();
    }
    public Images getImage() {
        return shirt.getImage();
    }
}