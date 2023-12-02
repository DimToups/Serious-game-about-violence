package fr.tyr.components.character;

import fr.tyr.Main;
import fr.tyr.components.character.identity.IdentityManager;
import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.personality.PersonalityManager;
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
import fr.tyr.components.character.style.enums.HairColor;
import fr.tyr.tools.Vector2D;

public class CharacterFactory {
    /**
     * Create a random Male Character
     * @param position The position of the component
     * @return A male character
     */
    public Male generateMale(Vector2D position){
        Main.getLogger().info("Generating a male character...");
        MaleStyleManager msf = new MaleStyleManager();
        PersonalityManager pm = new PersonalityManager();

        //Generation of the character's identity
        Origin origin = IdentityManager.generateOrigin();
        int age = IdentityManager.generateAge();
        HairColor hairColor = StyleManager.generateHairColor(age);

        //Generation of the character's style
        MaleCharacterStyle maleCharacterStyle = new MaleCharacterStyle(MaleStyleManager.generateBeard(hairColor), msf.generateEyes(origin), msf.generateHair(hairColor), MaleStyleManager.generateShirt(), MaleStyleManager.generateSkin(origin));
        maleCharacterStyle.assemble();

        //Generation of the character's past
        CommonPastFacts cpf = pm.generateCommonPastFact();
        OriginPastFacts opf = pm.generateOriginPastFacts(origin);
        GenderPastFacts gpf = pm.generateGenderPastFact(Gender.MALE);
        SexualOrientationPastFacts spf = pm.generateSexualOrientationPastFact();

        //Generation of the character's personality
        MentalStrength mentalStrength = pm.generateMentalStrength(cpf, opf, gpf, spf);
        SexualOrientation sexualOrientation = pm.generateSexualOrientation(spf, Gender.MALE);

        //Generation of the character's thoughts
        OriginThoughts ot = pm.generateOriginThoughts(opf);
        GenderThoughts gt = pm.generateGenderThoughts(gpf, Gender.MALE);
        SexualOrientationThoughts sot = pm.generateSexualOrientationThoughts(spf);

        return new Male(position, maleCharacterStyle, IdentityManager.generateMaleFirstName(origin), IdentityManager.generateLastName(origin), age, cpf, opf, gpf, spf, mentalStrength, sexualOrientation, ot, gt, sot);
    }

    /**
     * Create a random Female Character
     * @param position The component position
     * @return A female character
     */
    public Female generateFemale(Vector2D position){
        Main.getLogger().info("Generating a female character...");
        FemaleStyleManager fsm = new FemaleStyleManager();
        PersonalityManager pm = new PersonalityManager();

        //Generation of the character's identity
        Origin origin = IdentityManager.generateOrigin();
        int age = IdentityManager.generateAge();
        HairColor hairColor = StyleManager.generateHairColor(age);

        //Generation of the character's style
        CharacterStyle characterStyle = new CharacterStyle(fsm.generateEyes(origin), fsm.generateHair(hairColor), FemaleStyleManager.generateShirt(), FemaleStyleManager.generateSkin(origin));
        characterStyle.assemble();

        //Generation of the character's past
        CommonPastFacts cpf = pm.generateCommonPastFact();
        OriginPastFacts opf = pm.generateOriginPastFacts(origin);
        GenderPastFacts gpf = pm.generateGenderPastFact(Gender.FEMALE);
        SexualOrientationPastFacts spf = pm.generateSexualOrientationPastFact();

        //Generation of the character's personality
        MentalStrength mentalStrength = pm.generateMentalStrength(cpf, opf, gpf, spf);
        SexualOrientation sexualOrientation = pm.generateSexualOrientation(spf, Gender.FEMALE);

        //Generation of the character's thoughts
        OriginThoughts ot = pm.generateOriginThoughts(opf);
        GenderThoughts gt = pm.generateGenderThoughts(gpf, Gender.FEMALE);
        SexualOrientationThoughts sot = pm.generateSexualOrientationThoughts(spf);

        return new Female(position, characterStyle, IdentityManager.generateFemaleFirstName(origin), IdentityManager.generateLastName(origin), age, cpf, opf, gpf, spf, mentalStrength, sexualOrientation, ot, gt, sot);
    }
}
