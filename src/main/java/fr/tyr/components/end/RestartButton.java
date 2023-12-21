package fr.tyr.components.end;

import fr.tyr.Main;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.util.Objects;

public class RestartButton extends ImageComponent {

    private Vector2D baseSize;

    public RestartButton(Vector2D position) {
        super(Images.RESTART_BUTTON, position);
        resize(0.2);
    }

    @Override
    public void onClick(MouseButtons button) {
        Main.getGameEngine().displayGameScene();
    }

    @Override
    public void onHover() {
        super.onHover();
        baseSize = new Vector2D(getSize());
        resize(baseSize.getMultiplied(1.1));
        Vector2D difference = baseSize.getMultiplied(1.1).getSubtracted(baseSize);
        move(getPosition().getSubtracted(difference.getMultiplied(0.5)));
    }

    @Override
    public void onHoverLost() {
        super.onHoverLost();
        if(Objects.isNull(baseSize)) return;
        Vector2D difference = getSize().getSubtracted(baseSize);
        resize(baseSize);
        move(getPosition().getAdded(difference.getMultiplied(0.5)));
    }
}
