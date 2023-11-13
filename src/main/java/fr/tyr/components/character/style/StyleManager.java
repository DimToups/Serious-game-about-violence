package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.Origin;
import fr.tyr.components.classic.ImageComponent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class StyleManager {
    static Random rand = new Random();
    /**
     * Create a StyleManager
     */
    public StyleManager(){

    }

    /**
     * Generate a HairColor for a character depending on its age
     * @param age The character's age
     * @return A corresponding HairColor instance
     */
    public static HairColor generateHairColor(int age){
        if(age < 55){
            //Décision entre une pilosité naturelle ou non
            if(rand.nextInt(0,30) != 0){
                //Choix d'une couleur naturelle
                return switch (rand.nextInt(0, 5)) {
                    case 1 -> HairColor.DARK_BROWN;
                    case 2 -> HairColor.BROWN;
                    case 3 -> HairColor.BLOND;
                    case 4 -> HairColor.GINGER;
                    default -> HairColor.BLACK;
                };
            }
            else{
                //Choix d'une couleur non naturelle
                if(rand.nextInt(0,2) == 0)
                    return HairColor.PINK;
                else
                    return HairColor.BLUE;
            }
        }
        else{
            //Choix d'une couleur naturelle ou blanche
            if(rand.nextInt(0,10) == 0){
                //Choix d'une couleur naturelle
                return switch (rand.nextInt(0, 4)) {
                    case 1 -> HairColor.DARK_BROWN;
                    case 2 -> HairColor.BROWN;
                    case 3 -> HairColor.BLOND;
                    case 4 -> HairColor.GINGER;
                    default -> HairColor.BLACK;
                };
            }
            else
                return HairColor.WHITE;
        }
    }

    /**
     * Create a random skin
     * @param origin The character's Origin
     * @return A SkinEnum
     */
    public static Skin generateSkin(Origin origin){
        try {
            List<SkinEnum> validAssets = SkinEnum.getAllOriginAssets(origin);

            return new Skin(SkinEnum.valueOf(validAssets.get(rand.nextInt(0, validAssets.size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une peau de base
            return new Skin(SkinEnum.WHITE);
        }
    }

    /**
     * Create a random Hair
     * @param color The character's HairColor
     * @return A Hair instance
     */
    public abstract Hair generateHair(HairColor color);

    /**
     * Create random Eyes
     * @param origin The character's Origin
     * @return An Eyes instance
     */
    public abstract Eyes generateEyes(Origin origin);

    /**
     * Create a random Shirt
     * @return A Shirt instance
     */
    public static Shirt generateShirt(){
        try {
            return new Shirt(ShirtEnum.valueOf(Arrays.stream(ShirtEnum.values()).toList().get(rand.nextInt(0, ShirtEnum.values().length)).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une haut de base
            return new Shirt(ShirtEnum.RED);
        }
    }

    /**
     * Create a random Special character component (maybe removed)
     * @return A Special component
     */
    public static ImageComponent generateSpecial(){
        return null;
    }
}
