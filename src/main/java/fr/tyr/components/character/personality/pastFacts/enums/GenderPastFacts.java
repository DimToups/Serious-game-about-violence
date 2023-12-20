package fr.tyr.components.character.personality.pastFacts.enums;

import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.personality.thoughts.enums.GenderThoughts;
import fr.tyr.components.character.personality.enums.MentalStrength;

import java.util.ArrayList;
import java.util.List;

public enum GenderPastFacts {
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne sur son sexe", MentalStrength.NORMAL, null, Gender.UNKNOWN),
    SEXUAL_HARASSMENT("Harcèlement sexuel", "La personne a vécu un harcèlement sexuel lors d'une partie de sa vie.", MentalStrength.WEAK, null, Gender.UNKNOWN),
    MALE_SUDDEN_DUMP("Séparation soudaine", "La personne s'est fait quitter par sa partenaire de façon assez soudaine et violente. Il exprime depuis une certaine méfiance envers les femmes", MentalStrength.NORMAL, GenderThoughts.MISOGYNIST, Gender.UNKNOWN),
    FEMALE_SUDDEN_DUMP("Séparation soudaine", "La personne s'est fait quitter par son partenaire de façon assez soudaine et violente. Elle exprime depuis une certaine méfiance envers les hommes", MentalStrength.NORMAL, GenderThoughts.MISANDRE, Gender.UNKNOWN),
    ACTIVIST("Activiste", "La personne a toujours trouvé insensé les différences faites entre les genres. Il est maintenant un activiste et défend l'égalité des genres.", MentalStrength.BOLD, GenderThoughts.DISLIKES_ALL_COMMENTS, Gender.UNKNOWN),
    EXTREM_FEMINIST("Féministe extrêmiste", "", MentalStrength.BOLD, GenderThoughts.MISANDRE, Gender.FEMALE),
    SOCIAL_OPPRESSION_ON_WOMEN("Oppression sociale sur les femmes", "La personne a grandi auprès de personnes se moquant des femmes. Blagues ou non, la personne pense de la même façon que ses pairs.", MentalStrength.NORMAL, GenderThoughts.MISOGYNIST, Gender.UNKNOWN),
    SOCIAL_OPPRESSION_ON_MEN("Oppression sociale sur les homme", "La personne a vécu auprès de personnes ayant jugé la majorité des hommes comme dégoûtants. La personne a gardé une mauvaise image des hommes.", MentalStrength.NORMAL, GenderThoughts.MISANDRE, Gender.UNKNOWN),
    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    private final GenderThoughts overridingThoughts;
    private final Gender concernedGender;

    /**
     * Create an instance of GenderPastFacts
     * @param title The past fact's title
     * @param description The past fact's description
     * @param leaningMentalStrength The leaning mental strength of the character
     * @param overridingThoughts The overrided GenderThought
     * @param concernedGender The concerned gender
     */
    GenderPastFacts(String title, String description, MentalStrength leaningMentalStrength, GenderThoughts overridingThoughts, Gender concernedGender){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
        this.overridingThoughts = overridingThoughts;
        this.concernedGender = concernedGender;
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
     * @return The past fact's description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Send the leaning mental strength
     * @return The leaning mental strength
     */
    public MentalStrength getLeaningMentalStrength(){
        return this.leaningMentalStrength;
    }

    /**
     * Send the overrided GenderThought
     * @return The overrided GenderThought
     */
    public GenderThoughts getOverridingThoughts() {
        return overridingThoughts;
    }

    /**
     * Send the concerned gender
     * @return The concerned gender
     */
    public Gender getConcernedGender(){
        return this.concernedGender;
    }

    /**
     * Send all the past facts from the enum concerning the gender g in the parameters
     * @param g The gender
     * @return The past facts corresponding to the gender
     */
    public static List<GenderPastFacts> getAllGenderPastFacts(Gender g){
        List<GenderPastFacts> facts = new ArrayList<>();

        for(GenderPastFacts fact : GenderPastFacts.values()){
            if(fact.concernedGender == Gender.UNKNOWN || fact.concernedGender == g)
                facts.add(fact);
        }
        return facts;
    }

    /**
     * Send all the past facts from the list parameter concerning the gender g in the parameters
     * @param g The gender
     * @param genderPastFacts The array of GenderPastFacts
     * @return The past facts corresponding to the gender
     */
    public static List<GenderPastFacts> getAllGenderPastFacts(Gender g, List<GenderPastFacts> genderPastFacts){
        List<GenderPastFacts> facts = new ArrayList<>();

        for(GenderPastFacts fact : genderPastFacts){
            if(fact.concernedGender == Gender.UNKNOWN || fact.concernedGender == g)
                facts.add(fact);
        }
        return facts;
    }
}
