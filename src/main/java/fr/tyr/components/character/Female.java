package fr.tyr.components.character;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.tools.Vector2D;

public class Female extends Character{
    /**
     * Create a Female Character
     * @param position   The position of the component
     * @param components The components to add to the composed component
     */
    public Female(Vector2D position, ImageComponent... components) {
        super(position, components);
    }
}
