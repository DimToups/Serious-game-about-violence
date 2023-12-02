package fr.tyr.components.character.style;

public class MaleCharacterStyle extends CharacterStyle{
    private final Beard beard;

    /**
     * Create the visual appearance of the character
     * @param beard The character's beard
     * @param eyes The character's eyes
     * @param hair The character's hair
     * @param shirt the character's shirt
     * @param skin the character's skin
     */
    public MaleCharacterStyle(Beard beard, Eyes eyes, Hair hair, Shirt shirt, Skin skin){
        super(eyes, hair, shirt, skin, beard);
        this.beard = beard;
    }

    /**
     * Send the character's Beard
     * @return The character's Beard
     */
    public Beard getBeard() {
        return beard;
    }

    /**
     * Assemble the character's components
     */
    @Override
    public void assemble() {
        super.assemble();
        //Placement of the character's beard
        this.beard.moveTo(super.getHair().getPosition(), 1);
    }
}
