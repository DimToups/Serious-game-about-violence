package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.Origin;

import java.util.ArrayList;
import java.util.Random;

public class FemaleStyleManager extends StyleManager{
    /**
     * Generate a random Hair instance
     * @param color The character's HairColor
     * @return A random Hair instance
     */
    @Override
    public Hair generateHair(HairColor color) {
        Random rand = new Random();
        try {
            ArrayList<HairEnum> validAssets = HairEnum.getAllGenderAssets(true, HairEnum.getAllColoredAssets(color));

            return new Hair(HairEnum.valueOf(validAssets.get(rand.nextInt(0, validAssets.size())).name()));
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
        Random rand = new Random();
        try {
            ArrayList<EyesEnum> validAssets = EyesEnum.getAllGenderAssets(false, EyesEnum.getAllOriginAssets(origin));

            return new Eyes(EyesEnum.valueOf(validAssets.get(rand.nextInt(0, validAssets.size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour de yeux de base
            return new Eyes(EyesEnum.NORMAL_MALE_BLUE);
        }
    }
}