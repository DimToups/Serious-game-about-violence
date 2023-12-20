package fr.tyr.components.character.style;

import fr.tyr.components.character.style.enums.EyesEnum;
import fr.tyr.components.character.style.enums.HairEnum;
import fr.tyr.components.character.style.enums.ShirtEnum;
import fr.tyr.components.character.style.enums.SkinEnum;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.tools.Vector2D;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class CharacterStyle {
    private final ImageComponent eyes;
    private final ImageComponent hair;
    private final ImageComponent shirt;
    private final ImageComponent skin;
    private final ImageComponent additionalComponent;

    /**
     * Create the visual appearance of the character
     * @param eyes The character's eyes
     * @param hair The character's hair
     * @param shirt the character's shirt
     * @param skin the character's skin
     */
    public CharacterStyle(EyesEnum eyes, HairEnum hair, ShirtEnum shirt, SkinEnum skin){
        this.eyes = new ImageComponent(eyes.getImage());
        this.hair = new ImageComponent(hair.getImage());
        this.shirt = new ImageComponent(shirt.getImage());
        this.skin = new ImageComponent(skin.getImage());
        this.additionalComponent = null;
    }
    /**
     * Create the visual appearance of the character
     * @param eyes The character's eyes
     * @param hair The character's hair
     * @param shirt the character's shirt
     * @param skin the character's skin
     * @param additionalComponent An additional component of the character
     */
    public CharacterStyle(EyesEnum eyes, HairEnum hair, ShirtEnum shirt, SkinEnum skin, ImageComponent additionalComponent){
        this.eyes = new ImageComponent(eyes.getImage());
        this.hair = new ImageComponent(hair.getImage());
        this.shirt = new ImageComponent(shirt.getImage());
        this.skin = new ImageComponent(skin.getImage());
        this.additionalComponent = additionalComponent;
    }

    /**
     * Send the character's Eyes
     * @return The character's Eyes
     */
    public ImageComponent getEyes() {
        return eyes;
    }

    /**
     * Send the character's Hair
     * @return The character's Hair
     */
    public ImageComponent getHair() {
        return hair;
    }

    /**
     * Send the character's Shirt
     * @return The character's Shirt
     */
    public ImageComponent getShirt() {
        return shirt;
    }

    /**
     * Send the character's Skin
     * @return The character's Skin
     */
    public ImageComponent getSkin() {
        return skin;
    }

    /**
     * Send the character's additional component
     * @return The character's additional component
     */
    @Nullable
    public ImageComponent getAdditionalComponent() {
        return additionalComponent;
    }

    /**
     * Assemble the character's components
     */
    public void assemble(Vector2D position){
        if(Objects.isNull(position))
            position = new Vector2D(0, 0);
        this.skin.move(position);
        this.shirt.move(Vector2D.add(this.skin.getPosition(),
                new Vector2D((this.skin.getSize().x - this.shirt.getSize().x) / 2,  599 / this.skin.getSize().y * this.shirt.getSize().y)));
        this.eyes.move(Vector2D.add(this.skin.getPosition(),
                new Vector2D((this.skin.getSize().x - this.eyes.getSize().x) / 2,400 / this.skin.getSize().y * this.eyes.getSize().y)));
        this.hair.move(Vector2D.add(this.skin.getPosition(),
                new Vector2D((this.skin.getSize().x - this.hair.getSize().x) / 2, this.skin.getPosition().y + this.skin.getSize().y - this.hair.getSize().y + 38 / this.skin.getSize().y * this.hair.getSize().y)));
    }
}
