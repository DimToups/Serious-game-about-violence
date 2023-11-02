package fr.tyr.components.character;

import fr.tyr.components.character.style.Beard;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.game.GameEngine;
import fr.tyr.tools.Vector2D;

public class Male extends Character{
    private Beard beard;
    /**
     * Create a Male Character
     * @param position   The position of the component
     * @param components The components to add to the composed component
     */
    public Male(Vector2D position, GameComponent<?>... components) {
        super(position, components);
        for(GameComponent gc : components){
            if(gc.getClass() == Beard.class)
                this.beard = (Beard)gc;
        }
    }
}
