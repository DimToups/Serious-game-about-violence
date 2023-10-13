package fr.tyr.components.sample;

import fr.tyr.components.animated.AnimatedTextComponent;
import fr.tyr.components.sample.texts.SampleAnimatedText;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public class SampleAnimatedTextComponent extends AnimatedTextComponent {

    public SampleAnimatedTextComponent(@NotNull Vector2D position) {
        super(position, new SampleAnimatedText(), .1f);
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
