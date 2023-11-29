package fr.tyr.components.character.personality.pastFacts;

import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.personality.enums.GenderPersonality;
import fr.tyr.components.character.personality.enums.MentalStrength;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum GenderPastFacts {
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne sur son sexe", MentalStrength.NORMAL, null),
    SEXUAL_HARASSMENT("Harcèlement sexuel", "La personne a vécu un harcèlement sexuel lors d'une partie de sa vie.", MentalStrength.WEAK, null),
    MALE_SUDDEN_DUMP("Séparation soudaine", "La personne s'est fait quitter par sa partenaire de façon assez soudaine et violente. Il exprime depuis une certaine méfiance envers les femmes", MentalStrength.NORMAL, GenderPersonality.MYSOGYNIST),
    FEMALE_SUDDEN_DUMP("Séparation soudaine", "La personne s'est fait quitter par son partenaire de façon assez soudaine et violente. Elle exprime depuis une certaine méfiance envers les hommes", MentalStrength.NORMAL, GenderPersonality.MISANDRIST),
    ACTIVIST("Activiste", "La personne a toujours trouvé insensé les différences faites entre les genres. Il est maintenant un activiste et défend l'égalité des genres.", MentalStrength.BOLD, GenderPersonality.DISLIKES_ALL_COMMENTS),
    EXTREM_FEMINIST("Féministe extrêmiste", "", MentalStrength.BOLD, GenderPersonality.MISANDRIST, Gender.FEMALE),
    SOCIAL_OPPRESSION_ON_WOMEN("Oppression sociale sur les femmes", "La personne a grandi auprès de personnes se moquant des femmes. Blagues ou non, la personne pense de la même façon que ses pairs.", MentalStrength.NORMAL, GenderPersonality.MYSOGYNIST),
    SOCIAL_OPPRESSION_ON_MEN("Oppression sociale sur les femmes", "La personne a vécu auprès de personnes ayant jugé la majorité des hommes comme dégoûtants. La personne a gardé une mauvaise image des hommes.", MentalStrength.NORMAL, GenderPersonality.MISANDRIST),
    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    private final List<Gender> concernedGenders;
    private final GenderPersonality overridingPersonality;
    GenderPastFacts(String title, String description, MentalStrength leaningMentalStrength, GenderPersonality overridingPersonality, Gender... concernedPastFacts){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
        this.overridingPersonality = overridingPersonality;
        this.concernedGenders = Arrays.stream(concernedPastFacts).toList();
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
    public GenderPersonality getOverridingPersonality() {
        return overridingPersonality;
    }
    public List<Gender> getConcernedGenders(){
        return this.concernedGenders;
    }
    public static List<GenderPastFacts> getAllGenderPastFacts(Gender g){
        List<GenderPastFacts> facts = new ArrayList<>();

        for(GenderPastFacts fact : GenderPastFacts.values()){
            if(fact.concernedGenders.isEmpty() || fact.concernedGenders.contains(g))
                facts.add(fact);
        }
        return facts;
    }
    public static List<GenderPastFacts> getAllGenderPastFacts(Gender g, List<GenderPastFacts> genderPastFacts){
        List<GenderPastFacts> facts = new ArrayList<>();

        for(GenderPastFacts fact : genderPastFacts){
            if(fact.concernedGenders.isEmpty() || fact.concernedGenders.contains(g))
                facts.add(fact);
        }
        return facts;
    }
}
