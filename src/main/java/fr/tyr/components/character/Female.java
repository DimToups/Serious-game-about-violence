package fr.tyr.components.character;

import fr.tyr.components.character.identity.enums.FirstName;
import fr.tyr.components.character.identity.enums.LastName;
import fr.tyr.components.character.personality.enums.GenderPersonality;
import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.enums.OriginPersonality;
import fr.tyr.components.character.personality.enums.StylePersonality;
import fr.tyr.components.character.personality.pastFacts.CommonPastFacts;
import fr.tyr.components.character.personality.pastFacts.GenderPastFacts;
import fr.tyr.components.character.personality.pastFacts.OriginPastFacts;
import fr.tyr.components.character.personality.pastFacts.StylePastFacts;
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
    public Female(Vector2D position, Skin skin, Hair hair, Eyes eyes, Shirt shirt, FirstName firstName, LastName lastName, int age, CommonPastFacts commonPastFact, OriginPastFacts originPastFact, GenderPastFacts genderPastFact, StylePastFacts stylePastFact, MentalStrength mentalStrength, OriginPersonality originPersonality, GenderPersonality genderPersonality, StylePersonality stylePersonality) {
        super(position, skin, hair, eyes, shirt, firstName, lastName, age, commonPastFact, originPastFact, genderPastFact, stylePastFact, mentalStrength, originPersonality, genderPersonality, stylePersonality);
    }
}
