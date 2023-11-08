package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.Origin;

import java.util.Random;

public class MaleStyleManager extends StyleManager{
    /**
     * Generate a random Hair instance
     * @param color The character's HairColor
     * @return a Hair instance
     */
    @Override
    public Hair generateHair(HairColor color) {
        try {
            Random rand = new Random();

            //Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            return new Hair(HairEnum.valueOf(HairEnum.getAllColoredAssets(color ,HairEnum.getAllGenderAssets(true)).get(rand.nextInt(0, HairEnum.getAllColoredAssets(color ,HairEnum.getAllGenderAssets(true)).size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une coupe de base
            return new Hair(HairEnum.MALE_BLACK_DISHEVELLED);
        }
    }

    /**
     * Create a random male Eye
     * @param origin The character's Origin
     * @return A male Eye
     */
    @Override
    public Eyes generateEyes(Origin origin) {
        try {
            Random rand = new Random();

            //Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            return new Eyes(EyesEnum.valueOf(EyesEnum.getAllGenderAssets(true, EyesEnum.getAllOriginAssets(origin)).get(rand.nextInt(0, EyesEnum.getAllGenderAssets(true, EyesEnum.getAllOriginAssets(origin)).size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour de yeux de base
            return new Eyes(EyesEnum.WHITE_MALE_BLUE);
        }
    }

    /**
     * Create a random beard
     * @param color The character's HairColor
     * @return A Beard
     */
    public static Beard generateBeard(HairColor color){
        try {
            Random rand = new Random();

            //Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            return new Beard(BeardEnum.valueOf(BeardEnum.getAllColoredAssets(color).get(rand.nextInt(0, BeardEnum.getAllColoredAssets(color).size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une barbe de base
            return new Beard(BeardEnum.NONE);
        }
    }
}
