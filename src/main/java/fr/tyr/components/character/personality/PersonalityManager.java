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
    public GenderPastFacts generateGenderPastFact(Gender gender) {
        //Probabilities in this method are not based on reality
        if (gender == Gender.FEMALE) {
            if (rand.nextInt(0, 15) == 0)
                return GenderPastFacts.NONE;
            else {
                List<GenderPastFacts> femalePastFacts = GenderPastFacts.getAllGenderPastFacts(Gender.FEMALE);
                return GenderPastFacts.valueOf(femalePastFacts.get(rand.nextInt(0, femalePastFacts.size())).name());
            }
        } else {
            if (rand.nextInt(0, 5) == 0)
                return GenderPastFacts.NONE;
            else {
                List<GenderPastFacts> malePastFacts = GenderPastFacts.getAllGenderPastFacts(Gender.MALE);
                return GenderPastFacts.valueOf(malePastFacts.get(rand.nextInt(0, malePastFacts.size())).name());
            }
        }
    }
    public OriginPastFacts generateOriginPastFacts(Origin origin){
        List<OriginPastFacts> values = OriginPastFacts.getAllOriginPastFacts(origin);
        return OriginPastFacts.valueOf(values.get(rand.nextInt(0, values.size())).name());
    }
    public StylePastFacts generateStylePastFact(){
        List<StylePastFacts> values = Arrays.stream(StylePastFacts.values()).toList();
        return StylePastFacts.valueOf(values.get(rand.nextInt(0, values.size())).name());
    }
    public MentalStrength generateMentalStrength(CommonPastFacts commonFact, OriginPastFacts originFact, GenderPastFacts genderFact, StylePastFacts styleFact){
        ArrayList<MentalStrength> leaningMentalStrength = new ArrayList<>(4);
        leaningMentalStrength.add(commonFact.getLeaningMentalStrength());
        leaningMentalStrength.add(originFact.getLeaningMentalStrength());
        leaningMentalStrength.add(genderFact.getLeaningMentalStrength());
        leaningMentalStrength.add(styleFact.getLeaningMentalStrength());

        float sum = 0;
        for(MentalStrength mentalStrength : leaningMentalStrength){
            switch (mentalStrength){
                case BOLD -> sum += 2;
                case NORMAL -> sum += 1;
                case null, default -> sum += 0;
            }
        }

        float mean = sum /  leaningMentalStrength.size();
        if(mean > 1)
            return MentalStrength.BOLD;
        else if (mean < 0.8)
            return MentalStrength.WEAK;
        else
            return MentalStrength.NORMAL;
    }
    public OriginPersonality generateOriginPersonality(OriginPastFacts pastFact, Origin origin){
        if(pastFact.getOverridingPersonality() != null){
            return pastFact.getOverridingPersonality();
        }

        int personnality = rand.nextInt(0,20);
        if(personnality < 7)
            return OriginPersonality.DISLIKES_ALL_COMMENTS;
        else if(personnality < 10)
            return OriginPersonality.DISLIKES_COMMENTS_ON_ITS_ORIGIN;
        else if(personnality < 15)
            return OriginPersonality.NEUTRAL;
        else
            return OriginPersonality.LIKES_ALL_COMMENTS;
    }
    public GenderPersonality generateGenderPersonality(GenderPastFacts pastFact, Gender gender){
        if(pastFact.getOverridingPersonality() != null){
            return pastFact.getOverridingPersonality();
        }

        int personality = rand.nextInt(0,20);

        if(gender == Gender.FEMALE){
            if(personality < 10)
                return GenderPersonality.DISLIKES_ALL_COMMENTS;
            else if (personality < 14)
                return GenderPersonality.MISANDRIST;
            else if(personality < 19)
                return GenderPersonality.NEUTRAL;
            else
                return GenderPersonality.MYSOGYNIST;
        }
        else if (gender == Gender.MALE){
            if(personality < 7)
                return GenderPersonality.DISLIKES_ALL_COMMENTS;
            else if (personality < 9)
                return GenderPersonality.MISANDRIST;
            else if(personality < 16)
                return GenderPersonality.NEUTRAL;
            else
                return GenderPersonality.MYSOGYNIST;
        }
        else
            return null;
    }
    public StylePersonality generateStylePersonality(StylePastFacts pastFact){
        if(pastFact.getOverridingPersonality() != null)
            return pastFact.getOverridingPersonality();

        int personality = rand.nextInt(0,20);
        if(personality < 5)
            return StylePersonality.DISLIKES_ALL_COMMENTS;
        else if (personality < 13)
            return StylePersonality.DISLIKES_COMMENTS_ON_ITS_STYLE;
        else if (personality < 17)
            return StylePersonality.NEUTRAL;
        else
            return StylePersonality.LIKES_ALL_COMMENTS;
    }
}
