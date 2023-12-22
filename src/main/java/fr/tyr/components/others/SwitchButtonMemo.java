package fr.tyr.components.others;

import fr.tyr.Main;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class SwitchButtonMemo extends ImageComponent {
    /**
     * Create a new image component with the given image
     * @param position the component's position
     */
    public SwitchButtonMemo(Vector2D position) {
        super(Images.SWITCH_MODE_MEMO, position);
        this.resize(0.4);
    }

    @Override
    public void onClick(MouseButtons button) {
        Main.getGameEngine().displayMemoDeck();
    }
}
