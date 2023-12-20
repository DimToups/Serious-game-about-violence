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

    public GenderThoughts getGenderThoughts() {
        return genderThoughts;
    }

    public void setGenderThoughts(GenderThoughts genderThoughts) {
        this.genderThoughts = genderThoughts;
    }

    public boolean isGenderThoughtsDiscovered() {
        return isGenderThoughtsDiscovered;
    }

    public void setGenderThoughtsDiscovered(boolean genderThoughtsDiscovered) {
        isGenderThoughtsDiscovered = genderThoughtsDiscovered;
    }

    public OriginThoughts getOriginThoughts() {
        return originThoughts;
    }

    public void setOriginThoughts(OriginThoughts originThoughts) {
        this.originThoughts = originThoughts;
    }

    public boolean isOriginThoughtsDiscovered() {
        return isOriginThoughtsDiscovered;
    }

    public void setOriginThoughtsDiscovered(boolean originThoughtsDiscovered) {
        isOriginThoughtsDiscovered = originThoughtsDiscovered;
    }

    public SexualOrientationThoughts getSexualOrientationThoughts() {
        return sexualOrientationThoughts;
    }

    public void setSexualOrientationThoughts(SexualOrientationThoughts sexualOrientationThoughts) {
        this.sexualOrientationThoughts = sexualOrientationThoughts;
    }

    public boolean isSexualOrientationThoughtsDiscovered() {
        return isSexualOrientationThoughtsDiscovered;
    }

    public void setSexualOrientationThoughtsDiscovered(boolean sexualOrientationThoughtsDiscovered) {
        isSexualOrientationThoughtsDiscovered = sexualOrientationThoughtsDiscovered;
    }
}
