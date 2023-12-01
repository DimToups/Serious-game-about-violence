package fr.tyr.components.character.personality.enums.pastFact;

import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.enums.SexualOrientation;
import fr.tyr.components.character.personality.enums.thought.SexualOrientationThoughts;


public enum SexualOrientationPastFacts {
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne sur son orientation sexuelle.", null, MentalStrength.NORMAL, null),
    HOMOPHOBIC_FAMILY("Famille homophobique", "La personne a grandi dans une famille peu ouverte d'esprit. Elle ne s'est posée aucune question sur sa sexualité de peur du jugement de sa famille.", null, MentalStrength.NORMAL, SexualOrientation.STRAIGHT),
    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    private final SexualOrientationThoughts overridingThoughts;
    private final SexualOrientation overridingSexualOrientation;

    /**
     * Create an instance of StylePastFacts
     * @param title The past fact's title
     * @param description The past fact's description
     * @param overridingThoughts The overrided thoughts of the past fact
     * @param leaningMentalStrength The leaning mental strength of the character
     * @param overridingSexualOrientation The overrided sexual orientation of the character
     */
    SexualOrientationPastFacts(String title, String description, SexualOrientationThoughts overridingThoughts, MentalStrength leaningMentalStrength, SexualOrientation overridingSexualOrientation){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
        this.overridingThoughts = overridingThoughts;
        this.overridingSexualOrientation = overridingSexualOrientation;
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
    public SexualOrientationThoughts getOverridingThoughts() {
        return overridingThoughts;
    }

    /**
     * Send the leaning mental strength of the character
     * @return The leaning mental strength
     */
    public MentalStrength getLeaningMentalStrength(){
        return this.leaningMentalStrength;
    }

    /**
     * Send the overrided sexual orientation of the past fact
     * @return The overrided sexual orientation of the past fact
     */
    public SexualOrientation getOverridingSexualOrientation() {
        return overridingSexualOrientation;
    }
}
