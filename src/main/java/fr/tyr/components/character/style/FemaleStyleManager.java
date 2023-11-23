package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.style.enums.EyesEnum;
import fr.tyr.components.character.style.enums.HairColor;
import fr.tyr.components.character.style.enums.HairEnum;

import java.util.List;

public class FemaleStyleManager extends StyleManager{
    /**
     * Generate a random Hair instance
     * @param color The character's HairColor
     * @return A random Hair instance
     */
    @Override
    public Hair generateHair(HairColor color) {
        try {
            List<HairEnum> validAssets = HairEnum.getAllGenderAssets(Gender.MALE, HairEnum.getAllColoredAssets(color));

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
     * @param origin The character's origin
     * @return A random female Eye
     */
    @Override
    public Eyes generateEyes(Origin origin) {
        try {
            List<EyesEnum> validAssets = EyesEnum.getAllGenderAssets(Gender.FEMALE, EyesEnum.getAllOriginAssets(origin));

            return new Eyes(EyesEnum.valueOf(validAssets.get(rand.nextInt(0, validAssets.size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour de yeux de base
            return new Eyes(EyesEnum.COMMON_MALE_BLUE);
        }
    }
}
