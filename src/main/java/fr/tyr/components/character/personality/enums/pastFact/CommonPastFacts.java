package fr.tyr.components.character.personality.enums.pastFact;

import fr.tyr.components.character.personality.enums.MentalStrength;

public enum CommonPastFacts {
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne", MentalStrength.NORMAL),
    LOST_FATHER("Père perdu", "La personne a perdu son père assez jeune. L'absence de figure paternelle l'a marquée à vie.", MentalStrength.WEAK),
    LOST_MOTHER("Mère perdu", "La personne a perdu sa mère assez jeune. L'absence de figure maternelle l'a marquée à vie.", MentalStrength.WEAK),
    HARASSMENT("Harcèlement", "La personne a subi du harcèlement pour une raison qui l'échappe. Elle peut avoir tendance à se replier sur elle-même.", MentalStrength.WEAK),
    YOUNG_LONELY_ADULT("Jeune adulte seul", "La personne est partie très tôt de chez ses parents. Cela l'a obligée à se débrouiller seul.", MentalStrength.BOLD),
    KIND_FAMILY("Famille bienveillante", "La personne a grandie dans une famille bienveillante. Elle a pu se développer dans de bonnes conditions.", MentalStrength.NORMAL),
    ROUGH_SCHOOL_YEARS("Années scolaires difficiles", "La personne a vécu des année scolaires difficiles, la forçant à s'affirmer et faire savoir ce qu'il ne va pas.", MentalStrength.BOLD),
    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;

    /**
     * Create an instance of CommonPastFacts
     * @param title The title of the past fact
     * @param description The description of the past fact
     * @param leaningMentalStrength The leaning mental strength of the character
     */
    CommonPastFacts(String title, String description, MentalStrength leaningMentalStrength){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
    }

    /**
     * Send the past fact's title
     * @return Send The past fact's title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Send the past fact's description
     * @return The past fact's description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Send the past fact's leaning mental strength
     * @return The past fact's leaning mental strength
     */
    public MentalStrength getLeaningMentalStrength(){
        return this.leaningMentalStrength;
    }
}
