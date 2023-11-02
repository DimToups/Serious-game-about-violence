package fr.tyr.components.character;

import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public class CharacterFactory {
    public CharacterFactory(){}
    public Male generateMale(Vector2D position){
        MaleStyleManager msf = new MaleStyleManager();

        return new Male(position, msf.generateSkin(), msf.generateHair(), msf.generateEyes(), msf.generateShirt());
    }
    public Male generateMale(Vector2D position, Images... components){
        //Traiter les images passées
        return new Male(position);
    }
    public Female generateFemale(Vector2D position){
        //Générer des assets aléatoires

        return new Female(position /* + les composants générés*/);
    }
    public Female generateFemale(Vector2D position, Images... components){
        //Traiter les images passées

        return new Female(position /* + les composants traités*/);
    }
}
