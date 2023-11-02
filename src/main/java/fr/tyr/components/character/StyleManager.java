package fr.tyr.components.character;

import fr.tyr.Main;
import fr.tyr.components.character.style.*;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.resources.images.Images;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

public abstract class StyleManager {
    public StyleManager(){

    }
    public static Skin generateSkin(){
        File dir = new File("./src/main/resources/assets/character/skins/");
        File[] files = dir.listFiles();

        if(files == null)
            return null;

        Random rand = new Random();
        int i = rand.nextInt(0, files.length);

        try {//Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            if (Arrays.stream(files).toList().get(i).getName().contains("."))
                return new Skin(Images.valueOf("SKIN_" + Arrays.stream(files).toList().get(i).getName().toUpperCase().substring(0, Arrays.stream(files).toList().get(i).getName().toUpperCase().indexOf("."))));
            else
                return new Skin(Images.valueOf("SKIN_" + Arrays.stream(files).toList().get(i).getName().toUpperCase()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une peau de base
            return null;
        }
    }
    public abstract Hair generateHair();
    public abstract Eyes generateEyes();
    public static Shirt generateShirt(){
        File dir = new File("./src/main/resources/assets/character/shirts/");
        File[] files = dir.listFiles();

        if(files == null)
            return null;

        Random rand = new Random();
        int i = rand.nextInt(0, files.length);

        try {//Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            if (Arrays.stream(files).toList().get(i).getName().contains("."))
                return new Shirt(Images.valueOf("SHIRT_" + Arrays.stream(files).toList().get(i).getName().toUpperCase().substring(0, Arrays.stream(files).toList().get(i).getName().toUpperCase().indexOf("."))));
            else
                return new Shirt(Images.valueOf("SHIRT_" + Arrays.stream(files).toList().get(i).getName().toUpperCase()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une peau de base
            return null;
        }
    }
    public static ImageComponent generateSpecial(){
        return null;
    }
}
