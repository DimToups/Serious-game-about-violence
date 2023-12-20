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
        this.female.getIdentity().setGender(Gender.FEMALE);
        this.female.getIdentity().setOrigin(IdentityManager.generateOrigin());
        this.female.getIdentity().setFirstName(IdentityManager.generateFemaleFirstName(this.female.getIdentity().getOrigin()));
        this.female.getIdentity().setLastName(IdentityManager.generateLastName(this.female.getIdentity().getOrigin()));
        int age = IdentityManager.generateAge();
        this.female.getIdentity().setAge(age);
        this.female.setHairColor(StyleManager.generateHairColor(age));
    }

    /**
     * Generate the Character's personality
     */
    @Override
    public void generatePersonality() {
        this.female.getPersonality().setMentalStrength(pm.generateMentalStrength(this.female.getPersonality().getPastFact().getCommonPastFact(), this.getFemale().getPersonality().getPastFact().getOriginPastFact(), this.getFemale().getPersonality().getPastFact().getGenderPastFact(), this.getFemale().getPersonality().getPastFact().getSexualOrientationPastFact()));
        this.female.getPersonality().setSexualOrientation(pm.generateSexualOrientation(this.getFemale().getPersonality().getPastFact().getSexualOrientationPastFact(), Gender.FEMALE));
    }

    /**
     * Generate the Character's past
     */
    @Override
    public void generatePast() {
        this.female.getPersonality().getPastFact().setCommonPastFact(pm.generateCommonPastFact());
        this.female.getPersonality().getPastFact().setOriginPastFact(pm.generateOriginPastFacts(this.female.getIdentity().getOrigin()));
        this.female.getPersonality().getPastFact().setGenderPastFact(pm.generateGenderPastFact(Gender.FEMALE));
        this.female.getPersonality().getPastFact().setSexualOrientationPastFact(pm.generateSexualOrientationPastFact());
    }

    /**
     * Generate the Character's thoughts
     */
    @Override
    public void generateThoughts() {
        this.female.getPersonality().getThoughts().setOriginThoughts(pm.generateOriginThoughts(this.female.getPersonality().getPastFact().getOriginPastFact()));
        this.female.getPersonality().getThoughts().setGenderThoughts(pm.generateGenderThoughts(this.female.getPersonality().getPastFact().getGenderPastFact(), Gender.FEMALE));
        this.female.getPersonality().getThoughts().setSexualOrientationThoughts(pm.generateSexualOrientationThoughts(this.female.getPersonality().getPastFact().getSexualOrientationPastFact()));
    }

    /**
     * Generate the Character's Style
     */
    @Override
    public void generateStyle() {
        this.female.setCharacterStyle(new CharacterStyle(fsm.generateEyes(this.female.getIdentity().getOrigin()), fsm.generateHair(this.female.getHairColor()), FemaleStyleManager.generateShirt(), FemaleStyleManager.generateSkin(this.female.getIdentity().getOrigin())));
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
