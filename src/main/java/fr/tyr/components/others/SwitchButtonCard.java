package fr.tyr.components.others;

import fr.tyr.Main;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class SwitchButtonCard extends ImageComponent {
    /**
     * Create a new image component with the given image
     */
    public SwitchButtonCard() {
        super(Images.SWITCH_MODE_VIOLENCE);
    }
    public SwitchButtonCard(Vector2D position) {
        super(Images.SWITCH_MODE_VIOLENCE, position);
        this.resize(this.getSize().getMultiplied(0.5));
    }

    @Override
    public void onClick(MouseButtons button) {
        Main.getGameEngine().displayViolenceDeck();
    }
}
