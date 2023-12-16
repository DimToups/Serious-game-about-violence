package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.style.enums.*;

import java.util.List;

public class FemaleStyleManager extends StyleManager{
    public CharacterStyle generateCommonCharacter(){
        return new CharacterStyle(EyesEnum.COMMON_FEMALE_DOUBLE_BRUSH_BLUE, HairEnum.MID_LENGHT_BLACK, ShirtEnum.RED, SkinEnum.WHITE);
    }
    /**
     * Generate a random Hair instance
     * @param color The character's HairColor
     * @return A random Hair instance
     */
    @Override
    public HairEnum generateHair(HairColor color) {
        try {
            List<HairEnum> validAssets = HairEnum.getAllGenderAssets(Gender.FEMALE, HairEnum.getAllColoredAssets(color));

            return HairEnum.valueOf(validAssets.get(rand.nextInt(0, validAssets.size())).name());
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une coupe de base
            return HairEnum.BOWL_BLACK;
        }
    }

    /**
     * Create a random female Eye
     * @param origin The character's origin
     * @return A random female Eye
     */
    @Override
    public EyesEnum generateEyes(Origin origin) {
        try {
            List<EyesEnum> validAssets = EyesEnum.getAllGenderAssets(Gender.FEMALE, EyesEnum.getAllOriginAssets(origin));

            return EyesEnum.valueOf(validAssets.get(rand.nextInt(0, validAssets.size())).name());
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour de yeux de base
            return EyesEnum.COMMON_MALE_BLUE;
        }
    }
}
