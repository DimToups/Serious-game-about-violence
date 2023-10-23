package fr.tyr.components.sample;

import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.sample.texts.SampleText;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;

import java.awt.*;

public class SampleTextComponent extends TextComponent {
    public SampleTextComponent(Vector2D position) {
        super(new SampleText(), position);
    }

    @Override
    public void tick(int aps) {

    }

    @Override
    public void onClick(MouseButtons button) {

    }

    @Override
    public void onHover() {
        getFrame().getParts().get(1).setFont(new Font("Roboto", Font.PLAIN, 20));
    }

    @Override
    public void onHoverLost() {
        getFrame().getParts().get(1).setFont(new Font("Roboto", Font.PLAIN, 16));
    }

    @Override
    public void onWindowResized(Vector2D size) {

    }
}
