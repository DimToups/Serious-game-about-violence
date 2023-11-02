package fr.tyr.components.character;

import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public abstract class Character extends ComposedComponent{
    private Images skin;
    private Images hair;
    private Images eyes;
    private Images shirt;
    private Images special;
    public Character(Vector2D position, GameComponent<?>... components) {
        super(position, components);
    }
}
