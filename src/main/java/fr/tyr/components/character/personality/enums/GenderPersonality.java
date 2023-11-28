package fr.tyr.components.character.personality.enums;

import fr.tyr.components.character.personality.pastFacts.GenderPastFacts;

import java.util.Arrays;
import java.util.List;

public enum GenderPersonality {
    MYSOGYNIST,
    MISANDRIST,
    NEUTRAL,
    DISLIKES_ALL_COMMENTS;
    private final List<GenderPastFacts> overridingFacts;
    GenderPersonality(GenderPastFacts... overridingFacts){
        this.overridingFacts = Arrays.stream(overridingFacts).toList();
    }
    public List<GenderPastFacts> getOverridingFacts(){
        return this.overridingFacts;
    }
    public String cleanName(){
        String name = this.name();
        int i = 0;
        while(i < name.length() && !name.contains("_")){
            //Recherche d'un '_'
            if(name.charAt(i) == '_')
                name = name.substring(0, i) + " " + name.substring(i + 1, name.length());
        }
        return name;
    }
}
