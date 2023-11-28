package fr.tyr.components.character.personality.pastFacts;

import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.personality.enums.MentalStrength;

import java.util.Arrays;
import java.util.List;

public enum OriginPastFacts {
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne sur son origine", MentalStrength.NORMAL),
    ORIGIN_BULLYING("Harcèlement sur l'origine", "La personne a subi du harcèlement à cause de son origine.", MentalStrength.WEAK, Origin.ASIAN, Origin.AFRICAN, Origin.ARABIC),
    ORIGIN_SUPERIORITY("Supériorité d'origine", "La personne a grandi dans un espace où son origine était prédominante, elle a une bonne estime de son origine.", MentalStrength.NORMAL, Origin.FRENCH, Origin.ARABIC, Origin.SPANISH, Origin.AFRICAN),
    ORIGIN_RISING("", "La personne a grandi lors d'une époque tumultueuse pour les gens de son origine. Au fil du temps, il a apprit à être fier de qui il est.", MentalStrength.BOLD, Origin.AFRICAN, Origin.ARABIC, Origin.ASIAN),
    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    private final List<Origin> concernedOrigins;
    OriginPastFacts(String title, String description, MentalStrength leaningMentalStrength, Origin... concernedOrigins){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
        this.concernedOrigins = Arrays.stream(concernedOrigins).toList();
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
    public List<Origin> getConcernedOrigins() {
        return this.concernedOrigins;
    }
    public static List<OriginPastFacts> getAllOriginPastFacts(Origin o){
        return (Arrays.stream(OriginPastFacts.values()).filter(f -> f.concernedOrigins.contains(o))).toList();
    }
    public static List<OriginPastFacts> getAllOriginPastFacts(Origin o, List<OriginPastFacts> originPastFacts){
        return (originPastFacts.stream().filter(f -> f.concernedOrigins.contains(o))).toList();
    }
}
