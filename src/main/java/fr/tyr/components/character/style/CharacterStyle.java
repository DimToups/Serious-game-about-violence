package fr.tyr.components.character.style;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.tools.Vector2D;

public class CharacterStyle extends ComposedComponent {
    private final Eyes eyes;
    private final Hair hair;
    private final Shirt shirt;
    private final Skin skin;
    private ImageComponent additionalComponent;
    /**
     * Create the visual appearance of the character
     * @param eyes The character's eyes
     * @param hair The character's hair
     * @param shirt the character's shirt
     * @param skin the character's skin
     */
    public CharacterStyle(Eyes eyes, Hair hair, Shirt shirt, Skin skin){
        super(new Vector2D(), skin, shirt, eyes, hair);
        this.eyes = eyes;
        this.hair = hair;
        this.shirt = shirt;
        this.skin = skin;
    }
    /**
     * Create the visual appearance of the character
     * @param eyes The character's eyes
     * @param hair The character's hair
     * @param shirt the character's shirt
     * @param skin the character's skin
     * @param additionalComponent An additional component of the character
     */
    public CharacterStyle(Eyes eyes, Hair hair, Shirt shirt, Skin skin, ImageComponent additionalComponent){
        super(new Vector2D(), skin, shirt, eyes, hair, additionalComponent);
        this.additionalComponent = additionalComponent;
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
     * Send the character's additional component
     * @return The character's additional component
     */
    public ImageComponent getAdditionalComponent() {
        return additionalComponent;
    }

    /**
     * Assemble the character's components
     */
    public void assemble(){
        this.skin.moveTo(this.getPosition(), 0);
        this.shirt.moveTo(Vector2D.add(this.skin.getPosition(),
                new Vector2D((this.skin.getSize().x - this.shirt.getSize().x) / 2,  599 / this.skin.getSize().y * this.shirt.getSize().y)), 1);
        this.eyes.moveTo(Vector2D.add(this.skin.getPosition(),
                new Vector2D((this.skin.getSize().x - this.eyes.getSize().x) / 2,400 / this.skin.getSize().y * this.eyes.getSize().y)), 1);
        this.hair.moveTo(Vector2D.add(this.skin.getPosition(),
                new Vector2D((this.skin.getSize().x - this.hair.getSize().x) / 2, this.skin.getPosition().y + this.skin.getSize().y - this.hair.getSize().y + 38 / this.skin.getSize().y * this.hair.getSize().y)), 1);
    }
}
