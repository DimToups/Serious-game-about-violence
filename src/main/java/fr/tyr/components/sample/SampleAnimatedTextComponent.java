package fr.tyr.components.sample;

import fr.tyr.components.animated.AnimatedTextComponent;
import fr.tyr.tools.Vector2D;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public class SampleAnimatedTextComponent extends AnimatedTextComponent {

    public SampleAnimatedTextComponent(@NotNull Vector2D position) {
        super(position, List.of("", "H", "He", "Hel", "Hell", "Hello", "Hell", "Hel", "He", "H"), .1f, new Font("Roboto", Font.PLAIN, 18), Color.WHITE);
    }

    @Override
    public void onClick() {

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
    public void onResize(Vector2D size) {

    }
}
