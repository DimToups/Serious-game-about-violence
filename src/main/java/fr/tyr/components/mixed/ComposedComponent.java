package fr.tyr.components.mixed;

import fr.tyr.components.classic.GameComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ComposedComponent extends GameComponent<List<GameComponent<?>>> {

    /**
     * Create a composed component
     * @param position The position of the component
     * @param components The components to add to the composed component
     */
    public ComposedComponent(Vector2D position, GameComponent<?>... components) {
        super(new ArrayList<>(List.of(components)), position);
    }

    @Override
    public void move(int tps){
        getFrame().forEach(component -> component.move(tps));
    }

    @Override
    public void render(Graphics g) {
        getFrame().forEach(component -> component.render(g));
    }

    @Override
    public void tick(int aps) {
        getFrame().forEach(component -> component.tick(aps));
    }

    @Override
    public void onClick(MouseButtons button) {
        getFrame().forEach(component -> component.onClick(button));
    }

    @Override
    public void onHover() {
        getFrame().forEach(GameComponent::onHover);
    }

    @Override
    public void onHoverLost() {
        getFrame().forEach(GameComponent::onHoverLost);
    }

    @Override
    public void onWindowResized(Vector2D size) {
        getFrame().forEach(component -> component.onWindowResized(size));
    }
}
