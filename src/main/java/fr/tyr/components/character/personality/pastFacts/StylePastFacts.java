package fr.tyr.components.character.personality.pastFacts;

import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.enums.StylePersonality;


public enum StylePastFacts {
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne sur son style", null, MentalStrength.NORMAL),
    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    private final StylePersonality overridingPersonality;
    StylePastFacts(String title, String description, StylePersonality overridingPersonality,MentalStrength leaningMentalStrength){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
        this.overridingPersonality = overridingPersonality;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public StylePersonality getOverridingPersonality() {
        return overridingPersonality;
    }
    public MentalStrength getLeaningMentalStrength(){
        return this.leaningMentalStrength;
    }
}
