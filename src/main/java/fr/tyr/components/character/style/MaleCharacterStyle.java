package fr.tyr.components.character.style;

import fr.tyr.components.character.style.enums.*;
import fr.tyr.components.classic.ImageComponent;

public class MaleCharacterStyle extends CharacterStyle{
    private final ImageComponent beard;

    /**
     * Create the visual appearance of the character
     * @param beard The character's beard
     * @param eyes The character's eyes
     * @param hair The character's hair
     * @param shirt the character's shirt
     * @param skin the character's skin
     */
    public MaleCharacterStyle(BeardEnum beard, EyesEnum eyes, HairEnum hair, ShirtEnum shirt, SkinEnum skin){
        super(eyes, hair, shirt, skin, new ImageComponent(beard.getImage()));
        this.beard = super.getAdditionalComponent();
    }

    /**
     * Send the character's Beard
     * @return The character's Beard
     */
    public ImageComponent getBeard() {
        return beard;
    }

    /**
     * Assemble the character's components
     */
    @Override
    public void assemble() {
        super.assemble();
        //Placement of the character's beard
        this.beard.move(super.getHair().getPosition());
    }
}
