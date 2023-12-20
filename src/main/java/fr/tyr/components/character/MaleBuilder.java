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
    private Character male = new Character(new Vector2D());

    /**
     * Reset the current Character
     */
    @Override
    public void reset() {
        this.male = new Character(new Vector2D());
    }

    /**
     * Generate the Character's identity
     */
    @Override
    public void generateIdentity() {
        this.male.getIdentity().setGender(Gender.MALE);
        this.male.getIdentity().setOrigin(IdentityManager.generateOrigin());
        this.male.getIdentity().setFirstName(IdentityManager.generateMaleFirstName(this.male.getIdentity().getOrigin()));
        this.male.getIdentity().setLastName(IdentityManager.generateLastName(this.male.getIdentity().getOrigin()));
        int age = IdentityManager.generateAge();
        this.male.getIdentity().setAge(age);
        this.male.setHairColor(StyleManager.generateHairColor(age));
    }

    /**
     * Generate the Character's personality
     */
    @Override
    public void generatePersonality() {
        this.male.getPersonality().setMentalStrength(pm.generateMentalStrength(this.male.getPersonality().getPastFact().getCommonPastFact(), this.getMale().getPersonality().getPastFact().getOriginPastFact(), this.getMale().getPersonality().getPastFact().getGenderPastFact(), this.getMale().getPersonality().getPastFact().getSexualOrientationPastFact()));
        this.male.getPersonality().setSexualOrientation(pm.generateSexualOrientation(this.getMale().getPersonality().getPastFact().getSexualOrientationPastFact(), Gender.MALE));
    }

    /**
     * Generate the Character's past
     */
    @Override
    public void generatePast() {
        this.male.getPersonality().getPastFact().setCommonPastFact(pm.generateCommonPastFact());
        this.male.getPersonality().getPastFact().setOriginPastFact(pm.generateOriginPastFacts(this.male.getIdentity().getOrigin()));
        this.male.getPersonality().getPastFact().setGenderPastFact(pm.generateGenderPastFact(Gender.MALE));
        this.male.getPersonality().getPastFact().setSexualOrientationPastFact(pm.generateSexualOrientationPastFact());
    }

    /**
     * Generate the Character's thoughts
     */
    @Override
    public void generateThoughts() {
        this.male.getPersonality().getThoughts().setOriginThoughts(pm.generateOriginThoughts(this.male.getPersonality().getPastFact().getOriginPastFact()));
        this.male.getPersonality().getThoughts().setGenderThoughts(pm.generateGenderThoughts(this.male.getPersonality().getPastFact().getGenderPastFact(), Gender.MALE));
        this.male.getPersonality().getThoughts().setSexualOrientationThoughts(pm.generateSexualOrientationThoughts(this.male.getPersonality().getPastFact().getSexualOrientationPastFact()));
    }

    /**
     * Generate the Character's Style
     */
    @Override
    public void generateStyle() {
        this.male.setCharacterStyle(new MaleCharacterStyle(MaleStyleManager.generateBeard(this.male.getHairColor()), msf.generateEyes(this.male.getIdentity().getOrigin()), msf.generateHair(this.male.getHairColor()), MaleStyleManager.generateShirt(), MaleStyleManager.generateSkin(this.male.getIdentity().getOrigin())));
//        this.male.getCharacterStyle().assemble();
    }

    /**
     * Send the current character
     * @return The current character
     */
    public Character getMale() {
        return male;
    }
}
