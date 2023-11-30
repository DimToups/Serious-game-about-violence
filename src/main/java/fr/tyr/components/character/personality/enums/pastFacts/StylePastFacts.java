package fr.tyr.components.character.personality.enums.pastFacts;

import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.enums.thoughts.StyleThoughts;


public enum StylePastFacts {
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne sur son style", null, MentalStrength.NORMAL),
    RICH_KID("Enfant riche", "La personne a grandi dans une famille riche et devait bien s'habiller pour convenir à ses parents.", StyleThoughts.DISLIKES_COMMENTS_ON_ITS_STYLE, MentalStrength.NORMAL),

    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    private final StyleThoughts overridingThoughts;

    /**
     * Create an instance of StylePastFacts
     * @param title The past fact's title
     * @param description The past fact's description
     * @param overridingThoughts The overrided thoughts of the past fact
     * @param leaningMentalStrength The leaning mental strength of the character
     */
    StylePastFacts(String title, String description, StyleThoughts overridingThoughts, MentalStrength leaningMentalStrength){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
        this.overridingThoughts = overridingThoughts;
    }

    /**
     * Send the past fact's title
     * @return The past fact's title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Send the past fact's description
     * @return The past fact's title
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Send the overrided thoughts of the past fact
     * @return The overrided thoughts of the past fact
     */
    public StyleThoughts getOverridingThoughts() {
        return overridingThoughts;
    }

    /**
     * Send the leaning mental strength of the character
     * @return The leaning mental strength
     */
    public MentalStrength getLeaningMentalStrength(){
        return this.leaningMentalStrength;
    }
}
