package fr.tyr.components.others;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.GraphicEngine;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.util.Objects;

public class BackgroundComponent extends ImageComponent {

    public BackgroundComponent(Images image) {
        super(image, new Vector2D(0, 0));
        Vector2D size = GraphicEngine.getWindowSize();
        if(Objects.nonNull(size))
            resize(size, true);
    }

    @Override
    public void onWindowResized(Vector2D size) {
        resize(size, true);
    }
}
