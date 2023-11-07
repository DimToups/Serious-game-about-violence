package fr.tyr.components.character.style;

import fr.tyr.components.character.identity.Origin;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class Eyes extends ImageComponent {
    EyesEnum eyes;
    /**
     * Create Eyes
     * @param image The image of a single eye
     */
    public Eyes(EyesEnum eyes) {
        super(eyes.getImage());
        this.eyes = eyes;
    }

    /**
     * Create Eyes
     * @param image The image of a single eye
     * @param position The component position
     */
    public Eyes(EyesEnum eyes, Vector2D position) {
        super(eyes.getImage(), position);
        this.eyes = eyes;
    }

    /**
     * Create Eyes
     * @param image The image of a single eye
     * @param position The component position
     * @param size The component size
     * @param center Is the image centered
     */
    public Eyes(EyesEnum eyes, Vector2D position, Vector2D size, boolean center) {
        super(eyes.getImage(), position, size, center);
        this.eyes = eyes;
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
        return eyes.getName();
    }
    public EyeColor getColor(){
        return eyes.getColor();
    }
    public Images getImage(){
        return eyes.getImage();
    }
    public boolean getGender(){
        return eyes.getGender();
    }
    public Origin getOrigin(){
        return eyes.getOrigin();
    }
}