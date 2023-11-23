package fr.tyr.components.character.style;

import fr.tyr.components.character.style.enums.BeardEnum;
import fr.tyr.components.character.style.enums.HairColor;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class Beard extends ImageComponent {
    BeardEnum beard;

    /**
     * Create a Beard
     * @param beard An instance of a beard
     */
    public Beard(BeardEnum beard) {
        super(beard.getImage());
        this.beard = beard;
    }

    /**
     * Create a Beard
     * @param beard An instance of a beard
     * @param position The component position
     */
    public Beard(BeardEnum beard, Vector2D position) {
        super(beard.getImage(), position);
        this.beard = beard;
    }

    /**
     * Create a Beard
     * @param beard An instance of a beard
     * @param position The component position
     * @param size The component size
     * @param center Is the image centered
     */
    public Beard(BeardEnum beard, Vector2D position, Vector2D size, boolean center) {
        super(beard.getImage(), position, size, center);
        this.beard = beard;
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

    /**
     * Send the Images instance of the Beard
     * @return The Images instance of the Beard
     */
    public Images getImage() {
        return this.beard.getImage();
    }

    /**
     * Send the color of the Beard
     * @return The color of the Beard
     */
    public HairColor getColor(){
        return this.beard.getColor();
    }

    /**
     * Send the name of the Beard
     * @return The name of the Beard
     */
    public String getBeardName(){
        return this.beard.getName();
    }
}
