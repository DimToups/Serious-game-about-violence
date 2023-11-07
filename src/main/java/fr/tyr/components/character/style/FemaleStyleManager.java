package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.Origin;
import fr.tyr.resources.images.Images;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

public class FemaleStyleManager extends StyleManager{
    /**
     * Create a FemaleStyleManager
     * @return
     */
    @Override
    public Hair generateHair() {
        File dir = new File("./src/main/resources/assets/character/hairs/");
        File[] files = dir.listFiles();

        try {
            Random rand = new Random();
            int i = rand.nextInt(0, files.length);

            //Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            if (Arrays.stream(files).toList().get(i).getName().contains("."))
                return new Hair(Images.valueOf("HAIRS_FEMALE" + Arrays.stream(files).toList().get(i).getName().toUpperCase().substring(0, Arrays.stream(files).toList().get(i).getName().toUpperCase().indexOf("."))));
            else
                return new Hair(Images.valueOf("HAIRS_FEMALE" + Arrays.stream(files).toList().get(i).getName().toUpperCase()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une peau de base
            return null;
        }
    }

    /**
     * Create a random female Eye
     * @return
     */
    @Override
    public Eyes generateEyes(Origin origin) {
        File dir = new File("./src/main/resources/assets/character/eyes/");
        File[] files = dir.listFiles();

        try {
            Random rand = new Random();
            int i = rand.nextInt(0, files.length);

            //Conversion de la chaîne de caractère choisie et retour de l'image correspondante
            if (Arrays.stream(files).toList().get(i).getName().contains("."))
                return new Eyes(Images.valueOf("EYES_FEMALE" + Arrays.stream(files).toList().get(i).getName().toUpperCase().substring(0, Arrays.stream(files).toList().get(i).getName().toUpperCase().indexOf("."))));
            else
                return new Eyes(Images.valueOf("EYES_FEMALE" + Arrays.stream(files).toList().get(i).getName().toUpperCase()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une peau de base
            return null;
        }
    }
}