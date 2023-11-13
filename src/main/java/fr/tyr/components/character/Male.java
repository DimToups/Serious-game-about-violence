package fr.tyr.components.character;

import fr.tyr.components.character.identity.FirstName;
import fr.tyr.components.character.identity.LastName;
import fr.tyr.components.character.style.*;
import fr.tyr.tools.Vector2D;

public class Male extends Character{
    private final Beard beard;
    /**
     * Create a Male Character
     * @param position The position of the component
     * @param skin The Character's Skin
     * @param hair The Character's Hair
     * @param eyes The Character's Eyes
     * @param beard The Character's Beard
     * @param shirt The Character's Shirt
     * @param firstName The Character's FirstName
     * @param lastName The Character's LastName
     * @param age The character's age
     */
    public Male(Vector2D position, Skin skin, Hair hair, Eyes eyes, Beard beard, Shirt shirt, FirstName firstName, LastName lastName, int age) {
        super(position, skin, hair, eyes, shirt, firstName, lastName, age);
        this.beard = beard;
    }

    /**
     * Send the Character's Beard
     * @return The Character's Beard
     */
    public Beard getBeard() {
        return beard;
    }
}
