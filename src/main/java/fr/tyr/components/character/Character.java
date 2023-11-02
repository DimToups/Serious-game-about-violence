package fr.tyr.components.character;

import fr.tyr.components.character.style.*;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public abstract class Character extends ComposedComponent{
    private Skin skin;
    private Hair hair;
    private Eyes eyes;
    private Shirt shirt;
    private Images special;
    public Character(Vector2D position, GameComponent<?>... components) {
        super(position, components);

        //Attribution of the character's chosen skin in it's fields
        for(GameComponent gc : components){
            if (gc.getClass() == Skin.class)
                this.skin = (Skin)gc;
            else if (gc.getClass() == Hair.class)
                this.hair = (Hair)gc;
            else if (gc.getClass() == Eyes.class)
                this.eyes = (Eyes)gc;
            else if (gc.getClass() == Shirt.class)
                this.shirt = (Shirt)gc;
        }
    }
}
