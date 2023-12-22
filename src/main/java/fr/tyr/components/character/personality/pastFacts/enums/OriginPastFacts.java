package fr.tyr.components.character.personality.pastFacts.enums;

import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.thoughts.enums.OriginThoughts;
import fr.tyr.components.violence.enums.Types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum OriginPastFacts {
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne sur son origine.", MentalStrength.NORMAL, Types.ECONOMICAL, null),
    ORIGIN_BULLYING("Harcèlement sur l'origine", "La personne a subi du harcèlement à cause de son origine.", MentalStrength.WEAK, Types.ECONOMICAL,  null, Origin.ASIAN, Origin.AFRICAN, Origin.ARABIC),
    ORIGIN_SUPERIORITY("Supériorité d'origine", "La personne a grandi dans un espace où son origine était prédominante, elle a une bonne estime de son origine.", MentalStrength.NORMAL, Types.ECONOMICAL, null, Origin.FRENCH, Origin.ARABIC, Origin.SPANISH, Origin.AFRICAN),
    ORIGIN_RISING("Fier de sont origine", "La personne a grandi lors d'une époque tumultueuse pour les gens de son origine. Au fil du temps, il a apprit à être fier de qui il est.", MentalStrength.BOLD, Types.ECONOMICAL, null, Origin.AFRICAN, Origin.ARABIC, Origin.ASIAN),
    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    private final OriginThoughts overridingThoughts;
    private final Types type;
    private final List<Origin> concernedOrigins;

    /**
     * Create an instance of OriginPastFacts
     * @param title The past fact's title
     * @param description The past fact's description
     * @param leaningMentalStrength The leaning mental strength of the past fact
     * @param type vulnerability or invulnerability to violence
     * @param overridingThoughts The overrided origin thoughts
     * @param concernedOrigins The concerned origins by the past fact
     */
    OriginPastFacts(String title, String description, MentalStrength leaningMentalStrength, Types type, OriginThoughts overridingThoughts, Origin... concernedOrigins){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
        this.concernedOrigins = Arrays.stream(concernedOrigins).toList();
        this.type = type;
        this.overridingThoughts = overridingThoughts;
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
     * Send the leaning mental strength of the character
     * @return The leaning mental strength of the character
     */
    public MentalStrength getLeaningMentalStrength(){
        return this.leaningMentalStrength;
    }
    /**
     * Send the concerned violence type
     * @return The concerned violence type
     */
    public Types getType(){return this.type;}

    /**
     * Send the concerned origins by the past fact
     * @return The concerned origins by the past fact
     */
    public List<Origin> getConcernedOrigins() {
        return this.concernedOrigins;
    }

    /**
     * Send the overrrided origin thoughts
     * @return The overrrided origin thoughts
     */
    public OriginThoughts getOverridingThoughts() {
        return overridingThoughts;
    }

    /**
     * Send all the past facts from the enum concerning the origin o in the parameters
     * @param o The origin
     * @return All the corresponding past facts
     */
    public static List<OriginPastFacts> getAllOriginPastFacts(Origin o){
        List<OriginPastFacts> facts = new ArrayList<>();

        for(OriginPastFacts fact : OriginPastFacts.values()){
            if(fact.concernedOrigins.isEmpty() || fact.concernedOrigins.contains(o))
                facts.add(fact);
        }
        return facts;
    }

    /**
     * Send all the past facts from the list parameter concerning the origin o in the parameters
     * @param o The origin
     * @param originPastFacts A list of originPastFacts
     * @return All the corresponding past facts
     */
    public static List<OriginPastFacts> getAllOriginPastFacts(Origin o, List<OriginPastFacts> originPastFacts){
        List<OriginPastFacts> facts = new ArrayList<>();

        for(OriginPastFacts fact : originPastFacts){
            if(fact.concernedOrigins.isEmpty() || fact.concernedOrigins.contains(o))
                facts.add(fact);
        }
        return facts;
    }
}
