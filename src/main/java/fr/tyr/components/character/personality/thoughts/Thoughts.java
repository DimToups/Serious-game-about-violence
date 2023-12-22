package fr.tyr.components.character.personality.thoughts;

import fr.tyr.components.character.personality.thoughts.enums.GenderThoughts;
import fr.tyr.components.character.personality.thoughts.enums.OriginThoughts;
import fr.tyr.components.character.personality.thoughts.enums.SexualOrientationThoughts;

public class Thoughts {
    private GenderThoughts genderThoughts;
    private boolean isGenderThoughtsDiscovered = false;
    private OriginThoughts originThoughts;
    private boolean isOriginThoughtsDiscovered = false;
    private SexualOrientationThoughts sexualOrientationThoughts;
    private boolean isSexualOrientationThoughtsDiscovered = false;

    /**
     * Send the instance's genderThoughts
     * @return The instance's genderThoughts
     */
    public GenderThoughts getGenderThoughts() {
        return genderThoughts;
    }

    /**
     * Set the instance's genderThoughts value with a specified GenderThoughts value
     * @param genderThoughts The GenderThoughts instance replacing the current one
     */
    public void setGenderThoughts(GenderThoughts genderThoughts) {
        this.genderThoughts = genderThoughts;
    }

    /**
     * Send the state of the genderThoughts field
     * @return The state of the genderThoughts field
     */
    public boolean isGenderThoughtsDiscovered() {
        return isGenderThoughtsDiscovered;
    }

    /**
     * Set the state of the genderThoughts field
     * @param genderThoughtsDiscovered The wanted state of the genderThoughts field
     */
    public void setGenderThoughtsDiscovered(boolean genderThoughtsDiscovered) {
        isGenderThoughtsDiscovered = genderThoughtsDiscovered;
    }

    /**
     * Send the instance's originThoughts
     * @return The instance's originThoughts
     */
    public OriginThoughts getOriginThoughts() {
        return originThoughts;
    }
    /**
     * Set the instance's originThoughts value with a specified OriginThoughts value
     * @param originThoughts The GenderThoughts instance replacing the current one
     */
    public void setOriginThoughts(OriginThoughts originThoughts) {
        this.originThoughts = originThoughts;
    }

    /**
     * Send the state of the originThoughts field
     * @return The state of the originThoughts field
     */
    public boolean isOriginThoughtsDiscovered() {
        return isOriginThoughtsDiscovered;
    }

    /**
     * Set the state of the originThoughts field
     * @param originThoughtsDiscovered The wanted state of the originThoughts field
     */
    public void setOriginThoughtsDiscovered(boolean originThoughtsDiscovered) {
        isOriginThoughtsDiscovered = originThoughtsDiscovered;
    }

    /**
     * Send the instance's sexualOrientationThoughts
     * @return The instance's sexualOrientationThoughts
     */
    public SexualOrientationThoughts getSexualOrientationThoughts() {
        return sexualOrientationThoughts;
    }

    /**
     * Set the instance's sexualOrientationThoughts value with a specified SexualOrientationThoughts value
     * @param sexualOrientationThoughts The SexualOrientationThoughts instance replacing the current one
     */
    public void setSexualOrientationThoughts(SexualOrientationThoughts sexualOrientationThoughts) {
        this.sexualOrientationThoughts = sexualOrientationThoughts;
    }

    /**
     * Send the state of the sexualOrientationThoughts field
     * @return The state of the sexualOrientationThoughts field
     */
    public boolean isSexualOrientationThoughtsDiscovered() {
        return isSexualOrientationThoughtsDiscovered;
    }

    /**
     * Set the state of the sexualOrientationThoughts field
     * @param sexualOrientationThoughtsDiscovered The wanted state of the sexualOrientationThoughts field
     */
    public void setSexualOrientationThoughtsDiscovered(boolean sexualOrientationThoughtsDiscovered) {
        isSexualOrientationThoughtsDiscovered = sexualOrientationThoughtsDiscovered;
    }
}
