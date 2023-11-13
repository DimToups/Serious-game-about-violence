package fr.tyr.components.character.style;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class Hair extends ImageComponent {
    private final HairEnum hair;

    /**
     * Create a Hair
     * @param hair The Hair's HairEnum instance
     */
    public Hair(HairEnum hair) {
        super(hair.getImage());
        this.hair = hair;
    }

    /**
     * Create a Hair
     * @param hair The Hair's HairEnum instance
     * @param position The Hair's position
     */
    public Hair(HairEnum hair, Vector2D position) {
        super(hair.getImage(), position);
        this.hair = hair;
    }

    /**
     * Create a Hair
     * @param hair The Hair's HairEnum instance
     * @param position The Hair's position
     * @param size The Hair's size
     * @param center Is the Hair centered
     */
    public Hair(HairEnum hair, Vector2D position, Vector2D size, boolean center) {
        super(hair.getImage(), position, size, center);
        this.hair = hair;
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
     * Send the Hair's name
     * @return The Hair's name
     */
    public String getName(){
        return hair.getName();
    }

    /**
     * Send the Hair's HairColor
     * @return The Hair's HairColor
     */
    public HairColor getColor(){
        return hair.getColor();
    }

    /**
     * Send the Hair's Images instance
     * @return The Hair's Images instance
     */
    public Images getImage(){
        return hair.getImage();
    }

    /**
     * Send the hair cut prefered gender (true for male, false for female)
     * @return The hair cut prefered gender
     */
    public boolean getGender(){
        return hair.getGender();
    }
}
