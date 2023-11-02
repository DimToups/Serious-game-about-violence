package fr.tyr.components.character;

import fr.tyr.Main;
import fr.tyr.components.character.style.*;
import fr.tyr.resources.images.Images;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

public class MaleStyleManager extends StyleManager{
    /**
     * Create a MaleStyleManager
     * @return
     */
    @Override
    public Hair generateHair() {
        File dir = new File("./src/main/resources/assets/character/hairs/male");
        File[] files = dir.listFiles();

        try {
            Random rand = new Random();
            int i = rand.nextInt(0, files.length);

            //Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            if (Arrays.stream(files).toList().get(i).getName().contains("."))
                return new Hair(Images.valueOf("HAIR_MALE_" + Arrays.stream(files).toList().get(i).getName().toUpperCase().substring(0, Arrays.stream(files).toList().get(i).getName().toUpperCase().indexOf("."))));
            else
                return new Hair(Images.valueOf("HAIR_MALE_" + Arrays.stream(files).toList().get(i).getName().toUpperCase()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une peau de base
            return null;
        }
    }

    /**
     * Create a random male Eye
     * @return
     */
    @Override
    public Eyes generateEyes() {
        File dir = new File("./src/main/resources/assets/character/eyes/male");
        File[] files = dir.listFiles();

        try {
            Random rand = new Random();
            int i = rand.nextInt(0, files.length);

            //Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            if (Arrays.stream(files).toList().get(i).getName().contains("."))
                return new Eyes(Images.valueOf("EYES_MALE_" + Arrays.stream(files).toList().get(i).getName().toUpperCase().substring(0, Arrays.stream(files).toList().get(i).getName().toUpperCase().indexOf("."))));
            else
                return new Eyes(Images.valueOf("EYES_MALE_" + Arrays.stream(files).toList().get(i).getName().toUpperCase()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une peau de base
            return null;
        }
    }

    /**
     * Create a random beard
     * @return
     */
    public static Beard generateBeard(){
        File dir = new File("./src/main/resources/assets/character/beards/");
        File[] files = dir.listFiles();

        try {
            Random rand = new Random();
            int i = rand.nextInt(0, files.length);

            //Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            if (Arrays.stream(files).toList().get(i).getName().contains("."))
                return new Beard(Images.valueOf("BEARD_" + Arrays.stream(files).toList().get(i).getName().toUpperCase().substring(0, Arrays.stream(files).toList().get(i).getName().toUpperCase().indexOf("."))));
            else
                return new Beard(Images.valueOf("BEARD_" + Arrays.stream(files).toList().get(i).getName().toUpperCase()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une peau de base
            return null;
        }
    }
}
