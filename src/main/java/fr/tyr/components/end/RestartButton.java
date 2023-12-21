package fr.tyr.components.end;

import fr.tyr.Main;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class RestartButton extends ImageComponent {
    public RestartButton(Vector2D position) {
        super(Images.RESTART_BUTTON, position);
        resize(0.2);
    }

    @Override
    public void onClick(MouseButtons button) {
        Main.getGameEngine().displayGameScene();
    }
}
