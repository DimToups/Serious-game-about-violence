package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.style.enums.*;

import java.util.List;

public class MaleStyleManager extends StyleManager{
    public MaleCharacterStyle generateCommonCharacter(){
        return new MaleCharacterStyle(new Beard(BeardEnum.SHORT_BLACK) ,new Eyes(EyesEnum.COMMON_MALE_BLUE), new Hair(HairEnum.BOWL_BLACK), new Shirt(ShirtEnum.RED), new Skin(SkinEnum.WHITE));
    }
    /**
     * Generate a random Hair instance
     * @param color The character's HairColor
     * @return a Hair instance
     */
    @Override
    public Hair generateHair(HairColor color) {
        try {
            List<HairEnum> validAssets = HairEnum.getAllColoredAssets(color ,HairEnum.getAllGenderAssets(Gender.MALE));

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
        try {
            List<EyesEnum> validAssets = EyesEnum.getAllGenderAssets(Gender.MALE, EyesEnum.getAllOriginAssets(origin));

            return new Eyes(EyesEnum.valueOf(validAssets.get(rand.nextInt(0, validAssets.size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour de yeux de base
            return new Eyes(EyesEnum.COMMON_MALE_BLUE);
        }
    }

    /**
     * Create a random beard
     * @param color The character's HairColor
     * @return A Beard
     */
    public static Beard generateBeard(HairColor color){
        try {
            List<BeardEnum> validAssets = BeardEnum.getAllColoredAssets(color);

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
