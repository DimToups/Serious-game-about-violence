package fr.tyr.components.mixed;

import fr.tyr.components.classic.GameComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ComposedComponent extends GameComponent<GameComponent<?>> {

    private final List<GameComponent<?>> components;

    public ComposedComponent(Vector2D position, GameComponent<?>... components) {
        super(null, position);
        this.components = new ArrayList<>(List.of(components));
    }

    @Override
    public void move(int tps){
        components.forEach(component -> component.move(tps));
    }

    @Override
    public void render(Graphics g) {
        components.forEach(component -> component.render(g));
    }

    @Override
    public void tick(int aps) {
        components.forEach(component -> component.tick(aps));
    }

    @Override
    public void onClick(MouseButtons button) {
        components.forEach(component -> component.onClick(button));
    }

    @Override
    public void onHover() {
        components.forEach(GameComponent::onHover);
    }

    @Override
    public void onHoverLost() {
        components.forEach(GameComponent::onHoverLost);
    }

    @Override
    public void onWindowResized(Vector2D size) {
        components.forEach(component -> component.onWindowResized(size));
    }
}
