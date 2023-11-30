package fr.tyr.components.character;

import fr.tyr.Main;
import fr.tyr.components.character.identity.IdentityManager;
import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.personality.PersonalityManager;
import fr.tyr.components.character.personality.enums.thoughts.GenderThoughts;
import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.enums.thoughts.OriginThoughts;
import fr.tyr.components.character.personality.enums.thoughts.StyleThoughts;
import fr.tyr.components.character.personality.enums.pastFacts.CommonPastFacts;
import fr.tyr.components.character.personality.enums.pastFacts.GenderPastFacts;
import fr.tyr.components.character.personality.enums.pastFacts.OriginPastFacts;
import fr.tyr.components.character.personality.enums.pastFacts.StylePastFacts;
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

        //Generation of the character's past
        CommonPastFacts cpf = pm.generateCommonPastFact();
        OriginPastFacts opf = pm.generateOriginPastFacts(origin);
        GenderPastFacts gpf = pm.generateGenderPastFact(Gender.MALE);
        StylePastFacts spf = pm.generateStylePastFact();

        //Generation of the character's personality
        MentalStrength mentalStrength = pm.generateMentalStrength(cpf, opf, gpf, spf);
        OriginThoughts op = pm.generateOriginThoughts(opf, origin);
        GenderThoughts gp = pm.generateGenderThoughts(gpf, Gender.MALE);
        StyleThoughts sp = pm.generateStyleThoughts(spf);

        return new Male(position, MaleStyleManager.generateSkin(origin), msf.generateHair(hairColor), msf.generateEyes(origin), MaleStyleManager.generateBeard(hairColor), MaleStyleManager.generateShirt(), IdentityManager.generateMaleFirstName(origin), IdentityManager.generateLastName(origin), age, cpf, opf, gpf, spf, mentalStrength, op, gp, sp);
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

        Origin origin = IdentityManager.generateOrigin();
        int age = IdentityManager.generateAge();
        HairColor hairColor = StyleManager.generateHairColor(age);

        //Generation of the character's past
        CommonPastFacts cpf = pm.generateCommonPastFact();
        OriginPastFacts opf = pm.generateOriginPastFacts(origin);
        GenderPastFacts gpf = pm.generateGenderPastFact(Gender.FEMALE);
        StylePastFacts spf = pm.generateStylePastFact();

        //Generation of the character's personality
        MentalStrength mentalStrength = pm.generateMentalStrength(cpf, opf, gpf, spf);
        OriginThoughts op = pm.generateOriginThoughts(opf, origin);
        GenderThoughts gp = pm.generateGenderThoughts(gpf, Gender.FEMALE);
        StyleThoughts sp = pm.generateStyleThoughts(spf);

        return new Female(position, FemaleStyleManager.generateSkin(origin), fsm.generateHair(hairColor), fsm.generateEyes(origin), FemaleStyleManager.generateShirt(), IdentityManager.generateFemaleFirstName(origin), IdentityManager.generateLastName(origin), age, cpf, opf, gpf, spf, mentalStrength, op, gp, sp);
    }
}
