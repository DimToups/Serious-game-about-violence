package fr.tyr.components.sample;

import fr.tyr.components.classic.TextComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;

import java.awt.*;

public class SampleTextComponent extends TextComponent {
    public SampleTextComponent(Vector2D position) {
        super("Hello World!", position, new Font("Roboto", Font.PLAIN, 18), Color.WHITE);
    }

    @Override
    public void tick(int aps) {

    }

    @Override
    public void onClick(MouseButtons button) {

    }

    @Override
    public void onHover() {
        setFont(new Font("Roboto", Font.PLAIN, 24));
    }

    @Override
    public void onHoverLost() {
        setFont(new Font("Roboto", Font.PLAIN, 18));
    }

    @Override
    public void onWindowResized(Vector2D size) {

    }
}
