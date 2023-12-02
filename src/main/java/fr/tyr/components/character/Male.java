package fr.tyr.components.character;

import fr.tyr.components.character.identity.enums.FirstName;
import fr.tyr.components.character.identity.enums.LastName;
import fr.tyr.components.character.personality.enums.SexualOrientation;
import fr.tyr.components.character.personality.enums.thought.GenderThoughts;
import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.enums.thought.OriginThoughts;
import fr.tyr.components.character.personality.enums.thought.SexualOrientationThoughts;
import fr.tyr.components.character.personality.enums.pastFact.CommonPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.GenderPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.OriginPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.SexualOrientationPastFacts;
import fr.tyr.components.character.style.*;
import fr.tyr.tools.Vector2D;

public class Male extends Character{
    /**
     * Create a Male Character
     * @param position The position of the component
     * @param maleCharacterStyle The Character's style
     * @param firstName The Character's FirstName
     * @param lastName The Character's LastName
     * @param age The character's age
     */
    public Male(Vector2D position, MaleCharacterStyle maleCharacterStyle, FirstName firstName, LastName lastName, int age, CommonPastFacts commonPastFact, OriginPastFacts originPastFact, GenderPastFacts genderPastFact, SexualOrientationPastFacts stylePastFact, MentalStrength mentalStrength, SexualOrientation sexualOrientation, OriginThoughts originThoughts, GenderThoughts genderThoughts, SexualOrientationThoughts sexualOrientationThoughts) {
        super(position, maleCharacterStyle, firstName, lastName, age, commonPastFact, originPastFact, genderPastFact, stylePastFact, mentalStrength, sexualOrientation, originThoughts, genderThoughts, sexualOrientationThoughts);
    }
}
