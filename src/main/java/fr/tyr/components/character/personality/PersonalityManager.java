package fr.tyr.components.character.personality;

import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.personality.enums.*;
import fr.tyr.components.character.personality.pastFacts.CommonPastFacts;
import fr.tyr.components.character.personality.pastFacts.GenderPastFacts;
import fr.tyr.components.character.personality.pastFacts.OriginPastFacts;
import fr.tyr.components.character.personality.pastFacts.StylePastFacts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonalityManager {
    private static final Random rand = new Random();
    public CommonPastFacts generateCommonPastFact(){
        List<CommonPastFacts> values = Arrays.stream(CommonPastFacts.values()).toList();
        return CommonPastFacts.valueOf(values.get(rand.nextInt(0, values.size())).name());
    }
    public GenderPastFacts generateGenderPastFact(Gender gender){
        return null;
    }
    public OriginPastFacts generateOriginPastFacts(Origin origin){
        return null;
    }
    public StylePastFacts generateStylePastFact(){
        List<StylePastFacts> values = Arrays.stream(StylePastFacts.values()).toList();
        return StylePastFacts.valueOf(values.get(rand.nextInt(0, values.size())).name());
    }
    public OriginPersonality generateOriginPersonality(OriginPastFacts pastFact, Origin origin){
        return null;
    }
    public GenderPersonality generateGenderPersonality(GenderPastFacts pastFact, Gender gender){
        return null;
    }
    public StylePersonality generateStylePersonality(StylePastFacts pastFact){
        return null;
    }
    public MentalStrength generateMentalStrength(ArrayList<MentalStrength> mentalStrengths){
        return null;
    }
}
