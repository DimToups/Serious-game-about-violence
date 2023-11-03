package fr.tyr.components.character;

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

        return new Male(position, msf.generateSkin(), msf.generateHair(), msf.generateEyes(), msf.generateShirt());
    }

    /**
     * Create a predeterminated Male Character
     * @param position The position of the component
     * @param components The components to add to the composed component
     * @return
     */
    public Male generateMale(Vector2D position, Images... components){
        //Traiter les images passées
        return new Male(position);
    }

    /**
     * Create a random Female Character
     * @param position The component position
     * @return
     */
    public Female generateFemale(Vector2D position){
        //Générer des assets aléatoires

        return new Female(position /* + les composants générés*/);
    }

    /**
     * Create a predeterminated Female Character
     * @param position The component position
     * @param components The components to add to the composed component
     * @return
     */
    public Female generateFemale(Vector2D position, Images... components){
        //Traiter les images passées

        return new Female(position /* + les composants traités*/);
    }
}
