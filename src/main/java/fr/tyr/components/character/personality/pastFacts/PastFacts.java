package fr.tyr.components.character.personality.pastFacts;

import fr.tyr.components.character.personality.pastFacts.enums.CommonPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.GenderPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.OriginPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.SexualOrientationPastFacts;

public class PastFacts {
    private CommonPastFacts commonPastFact;
    private GenderPastFacts genderPastFact;
    private OriginPastFacts originPastFact;
    private SexualOrientationPastFacts sexualOrientationPastFact;

    public CommonPastFacts getCommonPastFact() {
        return commonPastFact;
    }

    public void setCommonPastFact(CommonPastFacts commonPastFact) {
        this.commonPastFact = commonPastFact;
    }

    public GenderPastFacts getGenderPastFact() {
        return genderPastFact;
    }

    public void setGenderPastFact(GenderPastFacts genderPastFact) {
        this.genderPastFact = genderPastFact;
    }

    public OriginPastFacts getOriginPastFact() {
        return originPastFact;
    }

    public void setOriginPastFact(OriginPastFacts originPastFact) {
        this.originPastFact = originPastFact;
    }

    public SexualOrientationPastFacts getSexualOrientationPastFact() {
        return sexualOrientationPastFact;
    }

    public void setSexualOrientationPastFact(SexualOrientationPastFacts sexualOrientationPastFact) {
        this.sexualOrientationPastFact = sexualOrientationPastFact;
    }
}
