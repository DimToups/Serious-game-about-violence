package fr.tyr.components.character.personality.pastFacts;

import fr.tyr.components.character.personality.enums.MentalStrength;

public enum CommonPastFacts {
    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    CommonPastFacts(String title, String description, MentalStrength leaningMentalStrength){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public MentalStrength getLeaningMentalStrength(){
        return this.leaningMentalStrength;
    }
}
