package fr.tyr.components.character;

public class CharacterDirector {
    private CharacterBuilder builder;

    /**
     * Create a CharacterDirector to manage the creation of a character
     * @param builder The kind of builder depending on the gender of the wanted character
     */
    public CharacterDirector(CharacterBuilder builder){
        this.builder = builder;
    }

    /**
     * Send the CharacterDirector's Builder
     * @return The CharacterDirector's Builder
     */
    public CharacterBuilder getBuilder() {
        return builder;
    }

    /**
     * Defines the wanted Builder
     * @param builder The wanted Builder
     */
    public void setBuilder(CharacterBuilder builder) {
        this.builder = builder;
    }

    /**
     * Generate a character depending on the chosen builder
     */
    public void generateCharacter(){
        builder.generateIdentity();
        builder.generateStyle();
        builder.generatePast();
        builder.generatePersonality();
        builder.generateThoughts();
    }
}
