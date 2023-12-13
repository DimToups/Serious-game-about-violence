package fr.tyr.components.character.personality;

import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.personality.enums.*;
import fr.tyr.components.character.personality.enums.thought.GenderThoughts;
import fr.tyr.components.character.personality.enums.thought.OriginThoughts;
import fr.tyr.components.character.personality.enums.thought.SexualOrientationThoughts;
import fr.tyr.components.character.personality.enums.pastFact.CommonPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.GenderPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.OriginPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.SexualOrientationPastFacts;

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
    public SexualOrientationPastFacts generateSexualOrientationPastFact(){
        List<SexualOrientationPastFacts> values = Arrays.stream(SexualOrientationPastFacts.values()).toList();
        return SexualOrientationPastFacts.valueOf(values.get(rand.nextInt(0, values.size())).name());
    }

    /**
     * Generate the character's mental strength depending on its past facts
     * @param commonFact The character's common past fact
     * @param originFact The character's origin based past fact
     * @param genderFact The character's gender based past fact
     * @param styleFact The character's style based past fact
     * @return The character's mental strength
     */
    public MentalStrength generateMentalStrength(CommonPastFacts commonFact, OriginPastFacts originFact, GenderPastFacts genderFact, SexualOrientationPastFacts styleFact){
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
    public SexualOrientation generateSexualOrientation(SexualOrientationPastFacts fact, Gender gender){
        if(fact.getOverridingSexualOrientation() != null)
            return fact.getOverridingSexualOrientation();

        int orientation = rand.nextInt(0,100);
        if(gender == Gender.MALE){
            if (orientation < 89)
                return SexualOrientation.STRAIGHT;
            else if (orientation < 96)
                return SexualOrientation.GAY;
            else
                return SexualOrientation.BISEXUAL;
        }
        else if(gender == Gender.FEMALE){
            if (orientation < 93)
                return SexualOrientation.STRAIGHT;
            else if (orientation < 96)
                return SexualOrientation.GAY;
            else
                return SexualOrientation.BISEXUAL;
        }
        else
            return SexualOrientation.BISEXUAL;
    }
    /**
     * Generate the character's thoughts on origins
     * @param pastFact An overriding past fact
     * @return The character's thoughts on origins
     */
    public OriginThoughts generateOriginThoughts(OriginPastFacts pastFact){
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
                return GenderThoughts.MISANDRE;
            else if(Thoughts < 19)
                return GenderThoughts.NEUTRAL;
            else
                return GenderThoughts.MISOGYNIST;
        }
        else if (gender == Gender.MALE){
            if(Thoughts < 7)
                return GenderThoughts.DISLIKES_ALL_COMMENTS;
            else if (Thoughts < 9)
                return GenderThoughts.MISANDRE;
            else if(Thoughts < 16)
                return GenderThoughts.NEUTRAL;
            else
                return GenderThoughts.MISOGYNIST;
        }
        else
            return null;
    }

    /**
     * Generate the character's thoughts on sexual orientations
     * @param pastFact An overriding past fact
     * @return The character's thoughts on sexual orientations
     */
    public SexualOrientationThoughts generateSexualOrientationThoughts(SexualOrientationPastFacts pastFact){
        if(pastFact.getOverridingThoughts() != null)
            return pastFact.getOverridingThoughts();

        int thoughts = rand.nextInt(0,20);
        if(thoughts < 10)
            return SexualOrientationThoughts.DISLIKES_ALL_COMMENTS;
        else if (thoughts < 14)
            return SexualOrientationThoughts.NEUTRAL;
        else if(thoughts < 19)
            return SexualOrientationThoughts.HOMOPHOBIC;
        else
            return SexualOrientationThoughts.LIKES_ALL_COMMENTS;
    }
}
