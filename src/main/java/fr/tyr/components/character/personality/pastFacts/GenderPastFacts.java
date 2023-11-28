package fr.tyr.components.character.personality.pastFacts;

import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.personality.enums.MentalStrength;

import java.util.Arrays;
import java.util.List;

public enum GenderPastFacts {
    SEXUAL_HARASSMENT("Harcèlement sexuel", "", MentalStrength.WEAK),

    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    private final List<Gender> concernedGenders;
    GenderPastFacts(String title, String description, MentalStrength leaningMentalStrength, Gender... concernedPastFacts){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
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
    public List<Gender> getConcernedGenders(){
        return this.concernedGenders;
    }
    public static List<GenderPastFacts> getAllGenderPastFacts(Gender g){
        return (Arrays.stream(GenderPastFacts.values()).filter(f -> f.getConcernedGenders().contains(g))).toList();
    }
    public static List<GenderPastFacts> getAllGenderPastFacts(Gender g, List<GenderPastFacts> genderPastFacts){
        return (genderPastFacts.stream().filter(f -> f.getConcernedGenders().contains(g))).toList();
    }
}
