package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.Origin;

import java.util.ArrayList;
import java.util.Random;

public class MaleStyleManager extends StyleManager{
    /**
     * Generate a random Hair instance
     * @param color The character's HairColor
     * @return a Hair instance
     */
    @Override
    public Hair generateHair(HairColor color) {
        Random rand = new Random();
        try {
            ArrayList<HairEnum> validAssets = HairEnum.getAllColoredAssets(color ,HairEnum.getAllGenderAssets(true));

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
     * Create a random male Eye
     * @param origin The character's Origin
     * @return A male Eye
     */
    @Override
    public Eyes generateEyes(Origin origin) {
        Random rand = new Random();
        try {
            ArrayList<EyesEnum> validAssets = EyesEnum.getAllGenderAssets(true, EyesEnum.getAllOriginAssets(origin));

            return new Eyes(EyesEnum.valueOf(validAssets.get(rand.nextInt(0, validAssets.size())).name()));
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
        Random rand = new Random();
        try {
            ArrayList<BeardEnum> validAssets = BeardEnum.getAllColoredAssets(color);

            return new Beard(BeardEnum.valueOf(validAssets.get(rand.nextInt(0, validAssets.size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une barbe de base
            return new Beard(BeardEnum.NONE);
        }
    }
}