package fr.tyr.components.character.personality.thoughts;

import fr.tyr.components.character.personality.thoughts.enums.GenderThoughts;
import fr.tyr.components.character.personality.thoughts.enums.OriginThoughts;
import fr.tyr.components.character.personality.thoughts.enums.SexualOrientationThoughts;

public class Thoughts {
    private GenderThoughts genderThoughts;
    private OriginThoughts originThoughts;
    private SexualOrientationThoughts sexualOrientationThoughts;

    public GenderThoughts getGenderThoughts() {
        return genderThoughts;
    }

    public void setGenderThoughts(GenderThoughts genderThoughts) {
        this.genderThoughts = genderThoughts;
    }

    public OriginThoughts getOriginThoughts() {
        return originThoughts;
    }

    public void setOriginThoughts(OriginThoughts originThoughts) {
        this.originThoughts = originThoughts;
    }

    public SexualOrientationThoughts getSexualOrientationThoughts() {
        return sexualOrientationThoughts;
    }

    public void setSexualOrientationThoughts(SexualOrientationThoughts sexualOrientationThoughts) {
        this.sexualOrientationThoughts = sexualOrientationThoughts;
    }
}
