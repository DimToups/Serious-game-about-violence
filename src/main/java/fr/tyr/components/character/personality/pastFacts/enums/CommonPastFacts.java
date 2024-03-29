package fr.tyr.components.character.personality.pastFacts.enums;

import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.violence.enums.Types;

public enum CommonPastFacts {
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne.", MentalStrength.NORMAL, Types.PHYSICAL),
    LOST_FATHER("Père perdu", "La personne a perdu son père assez jeune.", MentalStrength.WEAK, Types.PHYSICAL),
    LOST_MOTHER("Mère perdu", "La personne a perdu sa mère assez jeune.", MentalStrength.WEAK, Types.PHYSICAL),
    HARASSMENT("Harcèlement", "La personne a subi du harcèlement.", MentalStrength.WEAK, Types.PHYSICAL),
    YOUNG_LONELY_ADULT("Jeune adulte seul", "La personne est partie très tôt de chez ses parents.", MentalStrength.BOLD,Types.PHYSICAL),
    KIND_FAMILY("Famille bienveillante", "La personne a grandie dans une famille bienveillante.", MentalStrength.NORMAL, Types.PHYSICAL),
    ROUGH_SCHOOL_YEARS("Années scolaires difficiles", "La personne a vécu des année scolaires difficiles.", MentalStrength.BOLD, Types.PHYSICAL),
    LOST_MONEY_AT_CASINO("A perdu son argent au casino", "La personne est pauvre à cause des jeux d'argent",MentalStrength.WEAK, Types.PHYSICAL),
    DEBTS("A des dettes","La personne doit beaucoup d'argent a son oncle.",MentalStrength.NORMAL, Types.PHYSICAL);
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    private final Types type;

    /**
     * Create an instance of CommonPastFacts
     * @param title The title of the past fact
     * @param description The description of the past fact
     * @param leaningMentalStrength The leaning mental strength of the character
     * @param type vulnerability or invulnerability to violence
     */
    CommonPastFacts(String title, String description, MentalStrength leaningMentalStrength, Types type){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
        this.type = type;
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
    /**
     * Send the past fact's leaning violence type
     * @return The past fact's leaning violence type
     */
    public Types getType(){return this.type;}
}
