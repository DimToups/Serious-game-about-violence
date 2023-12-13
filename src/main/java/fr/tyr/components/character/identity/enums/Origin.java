package fr.tyr.components.character.identity.enums;

public enum Origin {
    FRENCH,
    GERMAN,
    ARABIC,
    SPANISH,
    ASIAN,
    AMERICAN,
    RUSSIAN,
    AFRICAN;

    /**
     * Convert the Origin into a clean String
     * @return The converted Origin
     */
    public String cleanName(){
        return name().toLowerCase();
    }
}
