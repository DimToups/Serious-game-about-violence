package fr.tyr.components.character.style;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class Hair extends ImageComponent {
    HairEnum hair;
    /**
     * Create a Hair
     * @param image
     */
    public Hair(HairEnum hair) {
        super(hair.getImage());
        this.hair = hair;
    }
    public Hair(HairEnum hair, Vector2D position) {
        super(hair.getImage(), position);
        this.hair = hair;
    }
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
    public String getName(){
        return hair.getName();
    }
    public HairColor getColor(){
        return hair.getColor();
    }
    public Images getImage(){
        return hair.getImage();
    }
    public boolean getGender(){
        return hair.getGender();
    }
}