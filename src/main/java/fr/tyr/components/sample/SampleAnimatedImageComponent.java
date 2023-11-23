package fr.tyr.components.sample;

import fr.tyr.components.animated.AnimatedImageComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Animations;
import fr.tyr.tools.Vector2D;

public class SampleAnimatedImageComponent extends AnimatedImageComponent {

    public SampleAnimatedImageComponent(Vector2D position) {
        super(position, .05f, Animations.BAR);
    }

    @Override
    public void onClick(MouseButtons button) {

    }

    @Override
    public void onHover() {
        pause();
    }

    @Override
    public void onHoverLost() {
        resume();
    }

    @Override
    public void onWindowResized(Vector2D size) {

    }
}
