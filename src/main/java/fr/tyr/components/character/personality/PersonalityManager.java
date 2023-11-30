package fr.tyr.components.character.personality;

import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.personality.enums.*;
import fr.tyr.components.character.personality.enums.thoughts.GenderThoughts;
import fr.tyr.components.character.personality.enums.thoughts.OriginThoughts;
import fr.tyr.components.character.personality.enums.thoughts.StyleThoughts;
import fr.tyr.components.character.personality.enums.pastFacts.CommonPastFacts;
import fr.tyr.components.character.personality.enums.pastFacts.GenderPastFacts;
import fr.tyr.components.character.personality.enums.pastFacts.OriginPastFacts;
import fr.tyr.components.character.personality.enums.pastFacts.StylePastFacts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonalityManager {
    private static final Random rand = new Random();

    /**
     * Generate a common past fact for the character
     * @return A common past fact
     */
    public CommonPastFacts generateCommonPastFact(){
        List<CommonPastFacts> values = Arrays.stream(CommonPastFacts.values()).toList();
        return CommonPastFacts.valueOf(values.get(rand.nextInt(0, values.size())).name());
    }

    /**
     * Generate a gender based past fact for the character
     * @param gender The character gender
     * @return A gender based past fact
     */
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

    /**
     * Generate an origin based past fact for the character
     * @param origin The character's origin
     * @return An origin based past fact
     */
    public OriginPastFacts generateOriginPastFacts(Origin origin){
        List<OriginPastFacts> values = OriginPastFacts.getAllOriginPastFacts(origin);
        return OriginPastFacts.valueOf(values.get(rand.nextInt(0, values.size())).name());
    }

    /**
     * Generate a style based past fact for the character
     * @return A style based past fact
     */
    public StylePastFacts generateStylePastFact(){
        List<StylePastFacts> values = Arrays.stream(StylePastFacts.values()).toList();
        return StylePastFacts.valueOf(values.get(rand.nextInt(0, values.size())).name());
    }

    /**
     * Generate the character's mental strength depending on its past facts
     * @param commonFact The character's common past fact
     * @param originFact The character's origin based past fact
     * @param genderFact The character's gender based past fact
     * @param styleFact The character's style based past fact
     * @return The character's mental strength
     */
    public MentalStrength generateMentalStrength(CommonPastFacts commonFact, OriginPastFacts originFact, GenderPastFacts genderFact, StylePastFacts styleFact){
        ArrayList<MentalStrength> leaningMentalStrength = new ArrayList<>(4);
        leaningMentalStrength.add(commonFact.getLeaningMentalStrength());
        leaningMentalStrength.add(originFact.getLeaningMentalStrength());
        leaningMentalStrength.add(genderFact.getLeaningMentalStrength());
        leaningMentalStrength.add(styleFact.getLeaningMentalStrength());

        //Calculation of the mean of the leaning mental strength from the ArrayList leaningMentalStrength
        float sum = 0;
        for(MentalStrength mentalStrength : leaningMentalStrength){
            switch (mentalStrength){
                case BOLD -> sum += 2;
                case NORMAL -> sum += 1;
                case null, default -> sum += 0;
            }
        }

        //Decision on the character's mental strength
        float mean = sum /  leaningMentalStrength.size();
        if(mean > 1)
            return MentalStrength.BOLD;
        else if (mean < 0.8)
            return MentalStrength.WEAK;
        else
            return MentalStrength.NORMAL;
    }

    /**
     * Generate the character's thoughts on origins
     * @param pastFact An overriding past fact
     * @param origin the character's origin
     * @return The character's thoughts on origins
     */
    public OriginThoughts generateOriginThoughts(OriginPastFacts pastFact, Origin origin){
        if(pastFact.getOverridingThoughts() != null){
            return pastFact.getOverridingThoughts();
        }

        int Thoughts = rand.nextInt(0,20);
        if(Thoughts < 7)
            return OriginThoughts.DISLIKES_ALL_COMMENTS;
        else if(Thoughts < 10)
            return OriginThoughts.DISLIKES_COMMENTS_ON_ITS_ORIGIN;
        else if(Thoughts < 15)
            return OriginThoughts.NEUTRAL;
        else
            return OriginThoughts.LIKES_ALL_COMMENTS;
    }

    /**
     * Generate the character's thoughts on genders
     * @param pastFact An overriding past fact
     * @param gender The character's gender
     * @return The character's thoughts on genders
     */
    public GenderThoughts generateGenderThoughts(GenderPastFacts pastFact, Gender gender){
        if(pastFact.getOverridingThoughts() != null){
            return pastFact.getOverridingThoughts();
        }

        int Thoughts = rand.nextInt(0,20);

        if(gender == Gender.FEMALE){
            if(Thoughts < 10)
                return GenderThoughts.DISLIKES_ALL_COMMENTS;
            else if (Thoughts < 14)
                return GenderThoughts.MISANDRIST;
            else if(Thoughts < 19)
                return GenderThoughts.NEUTRAL;
            else
                return GenderThoughts.MYSOGYNIST;
        }
        else if (gender == Gender.MALE){
            if(Thoughts < 7)
                return GenderThoughts.DISLIKES_ALL_COMMENTS;
            else if (Thoughts < 9)
                return GenderThoughts.MISANDRIST;
            else if(Thoughts < 16)
                return GenderThoughts.NEUTRAL;
            else
                return GenderThoughts.MYSOGYNIST;
        }
        else
            return null;
    }

    /**
     * Generate the character's thoughts on style
     * @param pastFact An overriding past fact
     * @return The character's thoughts on style
     */
    public StyleThoughts generateStyleThoughts(StylePastFacts pastFact){
        if(pastFact.getOverridingThoughts() != null)
            return pastFact.getOverridingThoughts();

        int Thoughts = rand.nextInt(0,20);
        if(Thoughts < 5)
            return StyleThoughts.DISLIKES_ALL_COMMENTS;
        else if (Thoughts < 13)
            return StyleThoughts.DISLIKES_COMMENTS_ON_ITS_STYLE;
        else if (Thoughts < 17)
            return StyleThoughts.NEUTRAL;
        else
            return StyleThoughts.LIKES_ALL_COMMENTS;
    }
}
