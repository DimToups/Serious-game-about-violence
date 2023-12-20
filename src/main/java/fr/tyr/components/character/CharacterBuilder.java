package fr.tyr.components.character;

public interface CharacterBuilder {
    /**
     * Reset the current Character
     */
    void reset();

    /**
     * Generate the Character's identity
     */
    void generateIdentity();

    /**
     * Generate the Character's personality
     */
    void generatePersonality();

    /**
     * Generate the Character's past
     */
    void generatePast();

    /**
     * Generate the Character's thoughts
     */
    void generateThoughts();

    /**
     * Generate the Character's Style
     */
    void generateStyle();

    Character getCharacter();
}
