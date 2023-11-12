package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.Origin;

import java.util.Arrays;
import java.util.Random;

public class FemaleStyleManager extends StyleManager{
    /**
     * Generate a random Hair instance
     * @param color The character's HairColor
     * @return A random Hair instance
     */
    @Override
    public Hair generateHair(HairColor color) {
        try {
            Random rand = new Random();

            return new Hair(HairEnum.valueOf(HairEnum.getAllGenderAssets(true, HairEnum.getAllColoredAssets(color)).get(rand.nextInt(0, HairEnum.getAllGenderAssets(true, HairEnum.getAllColoredAssets(color)).size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une coupe de base
            return new Hair(HairEnum.BLACK_DISHEVELLED);
        }
    }

    /**
     * Create a random female Eye
     * @param origin The caracter's origin
     * @return A random female Eye
     */
    @Override
    public Eyes generateEyes(Origin origin) {
        try {
            Random rand = new Random();

            return new Eyes(EyesEnum.valueOf(Arrays.stream(EyesEnum.values()).toList().get(rand.nextInt(0, EyesEnum.values().length)).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour de yeux de base
            return new Eyes(EyesEnum.WHITE_MALE_BLUE);
        }
    }
}