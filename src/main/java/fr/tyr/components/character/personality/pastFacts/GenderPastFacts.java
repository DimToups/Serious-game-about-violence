package fr.tyr.components.character.personality.pastFacts;

import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.personality.enums.GenderPersonality;
import fr.tyr.components.character.personality.enums.MentalStrength;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum GenderPastFacts {
    SEXUAL_HARASSMENT("Harcèlement sexuel", "", MentalStrength.WEAK, null, Gender.UNKNOWN),
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne sur son sexe", MentalStrength.NORMAL, null, Gender.UNKNOWN),
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
        return (Arrays.stream(GenderPastFacts.values()).filter(f -> f.getConcernedGenders().contains(g))).toList();
    }
    public static List<GenderPastFacts> getAllGenderPastFacts(Gender g, List<GenderPastFacts> genderPastFacts){
        List allGenderPastFacts = new ArrayList();
        for(GenderPastFacts pastFact : genderPastFacts)
            if(pastFact.concernedGenders.contains(Gender.UNKNOWN) || pastFact.concernedGenders.contains(g))
                allGenderPastFacts.add(pastFact);
        return allGenderPastFacts;
    }
}
