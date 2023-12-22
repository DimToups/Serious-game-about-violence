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

    /**
     * Send the instance's commonPastFact
     * @return The instance's commonPastFact
     */
    public CommonPastFacts getCommonPastFact() {
        return commonPastFact;
    }

    /**
     * Set the instance's commonPastFact value with a specified CommonPastFact instance
     * @param commonPastFact The CommonPastFact instance replacing the current one
     */
    public void setCommonPastFact(CommonPastFacts commonPastFact) {
        this.commonPastFact = commonPastFact;
    }

    /**
     * Send the state of the commonPastFact field
     * @return The state of the commonPastFact field
     */
    public boolean isCommonPastFactDiscovered() {
        return isCommonPastFactDiscovered;
    }

    /**
     * Set the state of the commonPastFact field
     * @param commonPastFactDiscovered The wanted state of the commonPastFact field
     */
    public void setCommonPastFactDiscovered(boolean commonPastFactDiscovered) {
        isCommonPastFactDiscovered = commonPastFactDiscovered;
    }

    /**
     * Send the instance's genderPastFact
     * @return The instance's genderPastFact
     */
    public GenderPastFacts getGenderPastFact() {
        return genderPastFact;
    }

    /**
     * Set the instance's genderPastFact value with a specified GenderPastFact instance
     * @param genderPastFact The GenderPastFact instance replacing the current one
     */
    public void setGenderPastFact(GenderPastFacts genderPastFact) {
        this.genderPastFact = genderPastFact;
    }
    /**
     * Send the state of the genderPastFact field
     * @return The state of the genderPastFact field
     */
    public boolean isGenderPastFactDiscovered() {
        return isGenderPastFactDiscovered;
    }
    /**
     * Set the state of the genderPastFact field
     * @param genderPastFactDiscovered The wanted state of the genderPastFact field
     */
    public void setGenderPastFactDiscovered(boolean genderPastFactDiscovered) {
        isGenderPastFactDiscovered = genderPastFactDiscovered;
    }

    /**
     * Send the instance's originPastFact
     * @return The instance's originPastFact
     */
    public OriginPastFacts getOriginPastFact() {
        return originPastFact;
    }

    /**
     * Set the instance's originPastFact value with a specified originPastFact instance
     * @param originPastFact The originPastFact instance replacing the current one
     */
    public void setOriginPastFact(OriginPastFacts originPastFact) {
        this.originPastFact = originPastFact;
    }
    /**
     * Send the state of the originPastFact field
     * @return The state of the originPastFact field
     */
    public boolean isOriginPastFactDiscovered() {
        return isOriginPastFactDiscovered;
    }
    /**
     * Set the state of the originPastFact field
     * @param originPastFactDiscovered The wanted state of the originPastFact field
     */
    public void setOriginPastFactDiscovered(boolean originPastFactDiscovered) {
        isOriginPastFactDiscovered = originPastFactDiscovered;
    }

    /**
     * Send the instance's sexualOrientationPastFact
     * @return The instance's sexualOrientationPastFact
     */
    public SexualOrientationPastFacts getSexualOrientationPastFact() {
        return sexualOrientationPastFact;
    }

    /**
     * Set the instance's sexualOrientationPastFact value with a specified SexualOrientationPastFact instance
     * @param sexualOrientationPastFact The SexualOrientation instance replacing the current one
     */
    public void setSexualOrientationPastFact(SexualOrientationPastFacts sexualOrientationPastFact) {
        this.sexualOrientationPastFact = sexualOrientationPastFact;
    }
    /**
     * Send the state of the sexualOrientationPastFact field
     * @return The state of the sexualOrientationPastFact field
     */
    public boolean isSexualOrientationPastFactDiscovered() {
        return isSexualOrientationPastFactDiscovered;
    }
    /**
     * Set the state of the sexualOrientation field
     * @param sexualOrientationPastFactDiscovered The wanted state of the sexualOrientation field
     */
    public void setSexualOrientationPastFactDiscovered(boolean sexualOrientationPastFactDiscovered) {
        isSexualOrientationPastFactDiscovered = sexualOrientationPastFactDiscovered;
    }
}
