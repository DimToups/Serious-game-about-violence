package fr.tyr.components.character;

import fr.tyr.components.character.identity.enums.FirstName;
import fr.tyr.components.character.identity.enums.LastName;
import fr.tyr.components.character.personality.enums.thought.GenderThoughts;
import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.enums.thought.OriginThoughts;
import fr.tyr.components.character.personality.enums.thought.StyleThoughts;
import fr.tyr.components.character.personality.enums.pastFact.CommonPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.GenderPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.OriginPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.StylePastFacts;
import fr.tyr.components.character.style.*;
import fr.tyr.tools.Vector2D;

public class Male extends Character{
    private final Beard beard;
    /**
     * Create a Male Character
     * @param position The position of the component
     * @param skin The Character's Skin
     * @param hair The Character's Hair
     * @param eyes The Character's Eyes
     * @param beard The Character's Beard
     * @param shirt The Character's Shirt
     * @param firstName The Character's FirstName
     * @param lastName The Character's LastName
     * @param age The character's age
     */
    public Male(Vector2D position, Skin skin, Hair hair, Eyes eyes, Beard beard, Shirt shirt, FirstName firstName, LastName lastName, int age, CommonPastFacts commonPastFact, OriginPastFacts originPastFact, GenderPastFacts genderPastFact, StylePastFacts stylePastFact, MentalStrength mentalStrength, OriginThoughts originThoughts, GenderThoughts genderThoughts, StyleThoughts styleThoughts) {
        super(position, skin, hair, eyes, shirt, firstName, lastName, age, commonPastFact, originPastFact, genderPastFact, stylePastFact, mentalStrength, originThoughts, genderThoughts, styleThoughts);
        this.beard = beard;
    }

    /**
     * Send the Character's Beard
     * @return The Character's Beard
     */
    public Beard getBeard() {
        return beard;
    }
}
