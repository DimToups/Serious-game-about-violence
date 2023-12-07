package fr.tyr.components.character;
import fr.tyr.components.character.identity.IdentityManager;
import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.personality.PersonalityManager;
import fr.tyr.components.character.style.MaleCharacterStyle;
import fr.tyr.components.character.style.MaleStyleManager;
import fr.tyr.components.character.style.StyleManager;
import fr.tyr.tools.Vector2D;

public class MaleBuilder implements CharacterBuilder{
    private static final PersonalityManager pm = new PersonalityManager();
    private static final MaleStyleManager msf = new MaleStyleManager();
    private Male male = new Male(new Vector2D());

    /**
     * Reset the current Character
     */
    @Override
    public void reset() {
        this.male = new Male(new Vector2D());
    }

    /**
     * Generate the Character's identity
     */
    @Override
    public void generateIdentity() {
        this.male.setOrigin(IdentityManager.generateOrigin());
        this.male.setFirstName(IdentityManager.generateMaleFirstName(this.male.getOrigin()));
        this.male.setLastName(IdentityManager.generateLastName(this.male.getOrigin()));
        int age = IdentityManager.generateAge();
        this.male.setAge(age);
        this.male.setHairColor(StyleManager.generateHairColor(age));
    }

    /**
     * Generate the Character's personality
     */
    @Override
    public void generatePersonality() {
        this.male.setMentalStrength(pm.generateMentalStrength(this.male.getCommonPastFact(), this.getMale().getOriginPastFact(), this.getMale().getGenderPastFact(), this.getMale().getSexualOrientationPastFacts()));
        this.male.setSexualOrientation(pm.generateSexualOrientation(this.getMale().getSexualOrientationPastFacts(), Gender.MALE));
    }

    /**
     * Generate the Character's past
     */
    @Override
    public void generatePast() {
        this.male.setCommonPastFact(pm.generateCommonPastFact());
        this.male.setOriginPastFact(pm.generateOriginPastFacts(this.male.getOrigin()));
        this.male.setGenderPastFact(pm.generateGenderPastFact(Gender.MALE));
        this.male.setSexualOrientationPastFacts(pm.generateSexualOrientationPastFact());
    }

    /**
     * Generate the Character's thoughts
     */
    @Override
    public void generateThoughts() {
        this.male.setOriginThoughts(pm.generateOriginThoughts(this.male.getOriginPastFact()));
        this.male.setGenderThoughts(pm.generateGenderThoughts(this.male.getGenderPastFact(), Gender.MALE));
        this.male.setSexualOrientationThoughts(pm.generateSexualOrientationThoughts(this.male.getSexualOrientationPastFacts()));
    }

    /**
     * Generate the Character's Style
     */
    @Override
    public void generateStyle() {
        this.male.setCharacterStyle(new MaleCharacterStyle(MaleStyleManager.generateBeard(this.male.getCharacterStyle().getHair().getColor()), msf.generateEyes(this.male.getOrigin()), msf.generateHair(this.male.getCharacterStyle().getHair().getColor()), MaleStyleManager.generateShirt(), MaleStyleManager.generateSkin(this.male.getOrigin())));
        this.male.getCharacterStyle().assemble();
    }

    /**
     * Send the current character
     * @return The current character
     */
    public Male getMale() {
        return male;
    }
}
