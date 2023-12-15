package fr.tyr.components.character;
import fr.tyr.components.character.identity.IdentityManager;
import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.personality.PersonalityManager;
import fr.tyr.components.character.style.*;
import fr.tyr.tools.Vector2D;

public class FemaleBuilder implements CharacterBuilder{
    private static final PersonalityManager pm = new PersonalityManager();
    private static final FemaleStyleManager fsm = new FemaleStyleManager();
    private Character female = new Character(new Vector2D());

    /**
     * Reset the current Character
     */
    @Override
    public void reset() {
        this.female = new Character(new Vector2D());
    }

    /**
     * Generate the Character's identity
     */
    @Override
    public void generateIdentity() {
        this.female.setOrigin(IdentityManager.generateOrigin());
        this.female.setFirstName(IdentityManager.generateFemaleFirstName(this.female.getOrigin()));
        this.female.setLastName(IdentityManager.generateLastName(this.female.getOrigin()));
        int age = IdentityManager.generateAge();
        this.female.setAge(age);
        this.female.setHairColor(StyleManager.generateHairColor(age));
    }

    /**
     * Generate the Character's personality
     */
    @Override
    public void generatePersonality() {
        this.female.setMentalStrength(pm.generateMentalStrength(this.female.getCommonPastFact(), this.getFemale().getOriginPastFact(), this.getFemale().getGenderPastFact(), this.getFemale().getSexualOrientationPastFacts()));
        this.female.setSexualOrientation(pm.generateSexualOrientation(this.getFemale().getSexualOrientationPastFacts(), Gender.FEMALE));
    }

    /**
     * Generate the Character's past
     */
    @Override
    public void generatePast() {
        this.female.setCommonPastFact(pm.generateCommonPastFact());
        this.female.setOriginPastFact(pm.generateOriginPastFacts(this.female.getOrigin()));
        this.female.setGenderPastFact(pm.generateGenderPastFact(Gender.FEMALE));
        this.female.setSexualOrientationPastFacts(pm.generateSexualOrientationPastFact());
    }

    /**
     * Generate the Character's thoughts
     */
    @Override
    public void generateThoughts() {
        this.female.setOriginThoughts(pm.generateOriginThoughts(this.female.getOriginPastFact()));
        this.female.setGenderThoughts(pm.generateGenderThoughts(this.female.getGenderPastFact(), Gender.FEMALE));
        this.female.setSexualOrientationThoughts(pm.generateSexualOrientationThoughts(this.female.getSexualOrientationPastFacts()));
    }

    /**
     * Generate the Character's Style
     */
    @Override
    public void generateStyle() {
        this.female.setCharacterStyle(new CharacterStyle(fsm.generateEyes(this.female.getOrigin()), fsm.generateHair(this.female.getHairColor()), FemaleStyleManager.generateShirt(), FemaleStyleManager.generateSkin(this.female.getOrigin())));
        this.female.getCharacterStyle().assemble();
    }

    /**
     * Send the current character
     * @return The current character
     */
    public Character getFemale() {
        return female;
    }
}
