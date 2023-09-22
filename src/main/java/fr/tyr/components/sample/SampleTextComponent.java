package fr.tyr.components.sample;

import fr.tyr.components.classic.TextComponent;
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
    public void onClick() {

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
    public void onResize(Vector2D size) {

    }
}
