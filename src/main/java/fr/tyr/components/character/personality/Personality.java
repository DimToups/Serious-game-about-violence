package fr.tyr.components.character.personality;

import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.enums.SexualOrientation;
import fr.tyr.components.character.personality.pastFacts.PastFacts;
import fr.tyr.components.character.personality.thoughts.Thoughts;
import fr.tyr.components.violence.enums.Types;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Personality {
    private PastFacts pastFact = new PastFacts();
    private Thoughts thoughts = new Thoughts();
    private MentalStrength mentalStrength;
    private SexualOrientation sexualOrientation;

    public PastFacts getPastFact() {
        return pastFact;
    }

    public void setPastFact(PastFacts pastFact) {
        this.pastFact = pastFact;
    }

    public Thoughts getThoughts() {
        return thoughts;
    }

    public void setThoughts(Thoughts thoughts) {
        this.thoughts = thoughts;
    }

    public MentalStrength getMentalStrength() {
        return mentalStrength;
    }

    public void setMentalStrength(MentalStrength mentalStrength) {
        this.mentalStrength = mentalStrength;
    }

    public SexualOrientation getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(SexualOrientation sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }
    public double Sensitivity(Types type){
            MentalStrength ment;
            double multiplier = 1;
            switch (type){
                case ECONOMICAL -> {
                    ment = pastFact.getOriginPastFact().getLeaningMentalStrength();
                    break;
                }
                case VERBAL -> {
                    ment = pastFact.getGenderPastFact().getLeaningMentalStrength();
                    break;
                }
                case PSYCHOLOGICAL -> {
                    ment = pastFact.getSexualOrientationPastFact().getLeaningMentalStrength();
                    break;
                }
                default ->  ment = pastFact.getCommonPastFact().getLeaningMentalStrength();
            }
            if (ment == MentalStrength.BOLD){
                multiplier = 0.5;
            } else if (ment == MentalStrength.WEAK) {
                multiplier = 1.5;
            }
            return multiplier;
    }
}
