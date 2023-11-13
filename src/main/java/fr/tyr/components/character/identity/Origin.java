package fr.tyr.components.character.identity;

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
     * Convert the Origin into an clean String
     * @return The converted Origin
     */
    public String cleanName(){
        return this.name().toLowerCase();
    }
}
