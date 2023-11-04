package fr.tyr.components.character;

import fr.tyr.components.character.identity.IdentityManager;
import fr.tyr.components.character.style.FemaleStyleManager;
import fr.tyr.components.character.style.MaleStyleManager;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class CharacterFactory {
    /**
     * Create CharacterFactory
     */
    public CharacterFactory(){}

    /**
     * Create a random Male Character
     * @param position The position of the component
     * @return
     */
    public Male generateMale(Vector2D position){
        MaleStyleManager msf = new MaleStyleManager();

        return new Male(position, msf.generateSkin(), msf.generateHair(), msf.generateEyes(), msf.generateBeard(), msf.generateShirt(), IdentityManager.generateMaleFirstName(), IdentityManager.generateLastName());
    }

    /**
     * Create a predeterminated Male Character
     * @param position The position of the component
     * @param components The components to add to the composed component
     * @return
     */
    public Male generateMale(Vector2D position, Images... components){
        //Traiter les images passées
        return null;
    }

    /**
     * Create a random Female Character
     * @param position The component position
     * @return
     */
    public Female generateFemale(Vector2D position){
        FemaleStyleManager fsm = new FemaleStyleManager();

        return new Female(position, fsm.generateSkin(), fsm.generateHair(), fsm.generateEyes(), fsm.generateShirt(), IdentityManager.generateFemaleFirstName(), IdentityManager.generateLastName());
    }

    /**
     * Create a predeterminated Female Character
     * @param position The component position
     * @param components The components to add to the composed component
     * @return
     */
    public Female generateFemale(Vector2D position, Images... components){
        //Traiter les images passées

        return null;
    }
}
