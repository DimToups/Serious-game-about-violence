package fr.tyr.components.character.personality.pastFacts;

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
