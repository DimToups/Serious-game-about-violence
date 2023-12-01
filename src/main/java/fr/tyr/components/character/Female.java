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

public class Female extends Character{
    /**
     * Create a Female Character
     * @param position The position of the component
     * @param skin The character's skin
     * @param hair The character's hair
     * @param eyes The character's eyes
     * @param shirt The character's shirt
     * @param firstName The character's firstname
     * @param lastName The character's lastname
     * @param age The character's age
     */
    public Female(Vector2D position, Skin skin, Hair hair, Eyes eyes, Shirt shirt, FirstName firstName, LastName lastName, int age, CommonPastFacts commonPastFact, OriginPastFacts originPastFact, GenderPastFacts genderPastFact, SexualOrientationPastFacts stylePastFact, MentalStrength mentalStrength, SexualOrientation sexualOrientation, OriginThoughts originThoughts, GenderThoughts genderThoughts, SexualOrientationThoughts sexualOrientationThoughts) {
        super(position, skin, hair, eyes, shirt, firstName, lastName, age, commonPastFact, originPastFact, genderPastFact, stylePastFact, mentalStrength, sexualOrientation, originThoughts, genderThoughts, sexualOrientationThoughts);
    }
}
