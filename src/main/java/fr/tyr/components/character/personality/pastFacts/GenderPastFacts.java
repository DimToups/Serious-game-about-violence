package fr.tyr.components.character.personality.pastFacts;

import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.personality.enums.GenderPersonality;
import fr.tyr.components.character.personality.enums.MentalStrength;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum GenderPastFacts {
    SEXUAL_HARASSMENT("Harcèlement sexuel", "", MentalStrength.WEAK, null),
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne sur son sexe", MentalStrength.NORMAL, null),
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
