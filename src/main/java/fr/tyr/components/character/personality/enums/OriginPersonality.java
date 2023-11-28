package fr.tyr.components.character.personality.enums;

import fr.tyr.components.character.personality.pastFacts.OriginPastFacts;

import java.util.Arrays;
import java.util.List;

public enum OriginPersonality {
    DISLIKES_ALL_COMMENTS,
    DISLIKES_COMMENTS_ON_ITS_ORIGIN,
    NEUTRAL,
    LIKES_ALL_COMMENTS;
    private final List<OriginPastFacts> overridingFacts;
    OriginPersonality(OriginPastFacts... overidingFacts){
        this.overridingFacts = Arrays.stream(overidingFacts).toList();
    }
    public List<OriginPastFacts> getOverridingFacts(){
        return this.overridingFacts;
    }
    public String cleanName(){
        String name = this.name();
        int i = 0;
        while(i < name.length() && !name.contains("_")){
            //Recherche d'un '_'
            if(name.charAt(i) == '_')
                name = name.substring(0, i) + " " + name.substring(i + 1);
        }
        return name;
    }
}
