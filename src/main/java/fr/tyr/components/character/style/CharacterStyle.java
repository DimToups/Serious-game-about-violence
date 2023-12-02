package fr.tyr.components.character.style;

import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.tools.Vector2D;

public class CharacterStyle extends ComposedComponent {
    private final Eyes eyes;
    private final Hair hair;
    private final Shirt shirt;
    private final Skin skin;
    /**
     * Create the visual appearance of the character
     * @param eyes The character's eyes
     * @param hair The character's hair
     * @param shirt the character's shirt
     * @param skin the character's skin
     */
    public CharacterStyle(Eyes eyes, Hair hair, Shirt shirt, Skin skin){
        super(new Vector2D(), eyes, hair, shirt, skin);
        this.eyes = eyes;
        this.hair = hair;
        this.shirt = shirt;
        this.skin = skin;
    }

    /**
     * Send the character's Eyes
     * @return The character's Eyes
     */
    public Eyes getEyes() {
        return eyes;
    }

    /**
     * Send the character's Hair
     * @return The character's Hair
     */
    public Hair getHair() {
        return hair;
    }

    /**
     * Send the character's Shirt
     * @return The character's Shirt
     */
    public Shirt getShirt() {
        return shirt;
    }

    /**
     * Send the character's Skin
     * @return The character's Skin
     */
    public Skin getSkin() {
        return skin;
    }

    /**
     * Assemble the character's components
     */
    public void assemble(){

    }
}
