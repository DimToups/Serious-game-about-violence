package fr.tyr.components.character.personality.pastFacts;

import fr.tyr.components.character.personality.pastFacts.enums.CommonPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.GenderPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.OriginPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.SexualOrientationPastFacts;

public class PastFacts {
    private CommonPastFacts commonPastFact;
    private boolean isCommonPastFactDiscovered = false;
    private GenderPastFacts genderPastFact;
    private boolean isGenderPastFactDiscovered = false;
    private OriginPastFacts originPastFact;
    private boolean isOriginPastFactDiscovered = false;
    private SexualOrientationPastFacts sexualOrientationPastFact;
    private boolean isSexualOrientationPastFactDiscovered = false;

    public CommonPastFacts getCommonPastFact() {
        return commonPastFact;
    }

    public void setCommonPastFact(CommonPastFacts commonPastFact) {
        this.commonPastFact = commonPastFact;
    }

    public boolean isCommonPastFactDiscovered() {
        return isCommonPastFactDiscovered;
    }

    public void setCommonPastFactDiscovered(boolean commonPastFactDiscovered) {
        isCommonPastFactDiscovered = commonPastFactDiscovered;
    }

    public GenderPastFacts getGenderPastFact() {
        return genderPastFact;
    }

    public void setGenderPastFact(GenderPastFacts genderPastFact) {
        this.genderPastFact = genderPastFact;
    }

    public boolean isGenderPastFactDiscovered() {
        return isGenderPastFactDiscovered;
    }

    public void setGenderPastFactDiscovered(boolean genderPastFactDiscovered) {
        isGenderPastFactDiscovered = genderPastFactDiscovered;
    }

    public OriginPastFacts getOriginPastFact() {
        return originPastFact;
    }

    public void setOriginPastFact(OriginPastFacts originPastFact) {
        this.originPastFact = originPastFact;
    }

    public boolean isOriginPastFactDiscovered() {
        return isOriginPastFactDiscovered;
    }

    public void setOriginPastFactDiscovered(boolean originPastFactDiscovered) {
        isOriginPastFactDiscovered = originPastFactDiscovered;
    }

    public SexualOrientationPastFacts getSexualOrientationPastFact() {
        return sexualOrientationPastFact;
    }

    public void setSexualOrientationPastFact(SexualOrientationPastFacts sexualOrientationPastFact) {
        this.sexualOrientationPastFact = sexualOrientationPastFact;
    }

    public boolean isSexualOrientationPastFactDiscovered() {
        return isSexualOrientationPastFactDiscovered;
    }

    public void setSexualOrientationPastFactDiscovered(boolean sexualOrientationPastFactDiscovered) {
        isSexualOrientationPastFactDiscovered = sexualOrientationPastFactDiscovered;
    }
}
