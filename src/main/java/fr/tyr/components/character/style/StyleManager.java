package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.Origin;
import fr.tyr.components.character.style.*;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.resources.images.Images;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public abstract class StyleManager {
    /**
     * Create a StyleManager
     */
    public StyleManager(){

    }
    public static HairColor generateHairColor(int age){
        //
        Random rand = new Random();

        //
        if(age < 55){
            //Décision entre une pilosité naturelle ou non
            if(rand.nextInt(0,30) != 0){
                //Choix d'une couleur naturelle
                switch (rand.nextInt(0,5)){
                    case 0 : return HairColor.BLACK;
                    case 1 : return HairColor.DARK_BROWN;
                    case 2 : return HairColor.BROWN;
                    case 3 : return HairColor.BLOND;
                    case 4 : return HairColor.GINGER;
                }
                return HairColor.BLACK;
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
                switch (rand.nextInt(0,4)){
                    case 0 : return HairColor.BLACK;
                    case 1 : return HairColor.DARK_BROWN;
                    case 2 : return HairColor.BROWN;
                    case 3 : return HairColor.BLOND;
                    case 4 : return HairColor.GINGER;
                }
                return HairColor.BLACK;
            }
            else
                return HairColor.WHITE;
        }
    }

    /**
     * Create a random skin
     * @return
     */
    public static Skin generateSkin(Origin origin){
        Random rand = new Random();

        try {//Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            return new Skin(SkinEnum.valueOf(SkinEnum.getAllOriginAssets(origin).get(rand.nextInt(0, SkinEnum.getAllOriginAssets(origin).size())).name()));
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
     * @return
     */
    public abstract Hair generateHair(HairColor color);

    /**
     * Create a random Eye
     * @return
     */
    public abstract Eyes generateEyes(Origin origin);

    /**
     * Create a random Shirt
     * @return
     */
    public static Shirt generateShirt(){
        Random rand = new Random();

        try {
            //Conversion de la chaîne de caractère choisie et retour de l'image correspondante
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
     * Create a random Special character component (may be removed)
     * @return
     */
    public static ImageComponent generateSpecial(){
        return null;
    }
}
