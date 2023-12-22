package fr.tyr.components.character.identity;

import fr.tyr.components.character.identity.enums.FirstName;
import fr.tyr.components.character.identity.enums.LastName;
import fr.tyr.components.character.identity.enums.Origin;

import java.util.Arrays;
import java.util.Random;

public class IdentityManager {
    static Random rand = new Random();

    public static Origin generateOrigin(){
        return Origin.valueOf(Arrays.stream(Origin.values()).toList().get(rand.nextInt(0, Arrays.stream(Origin.values()).toList().size())).name());
    }
    /**
     * Create a random male firstname
     * @return A male firstname
     */
    public static FirstName generateMaleFirstName(Origin origin){
        int r = rand.nextInt(0, 10);
        if(r < 6)
            return FirstName.valueOf(FirstName.getAllMaleFirstNames(FirstName.getAllOriginFirstNames(origin)).get(rand.nextInt(0, FirstName.getAllMaleFirstNames(FirstName.getAllOriginFirstNames(origin)).size())).name());
        else if (r < 8)
            return FirstName.valueOf(FirstName.getAllMaleFirstNames(FirstName.getAllOriginFirstNames(Origin.FRENCH)).get(rand.nextInt(0, FirstName.getAllMaleFirstNames(FirstName.getAllOriginFirstNames(Origin.FRENCH)).size())).name());
        else
            return FirstName.valueOf(FirstName.getAllMaleFirstNames(FirstName.getAllOriginFirstNames(Origin.GERMAN)).get(rand.nextInt(0, FirstName.getAllMaleFirstNames(FirstName.getAllOriginFirstNames(Origin.GERMAN)).size())).name());
    }

    /**
     * Create a random female firstname
     * @return A female firstname
     */
    public static FirstName generateFemaleFirstName(Origin origin){
        int r = rand.nextInt(0, 10);
        if(r < 6)
            return FirstName.valueOf(FirstName.getAllFemaleFirstNames(FirstName.getAllOriginFirstNames(origin)).get(rand.nextInt(0, FirstName.getAllFemaleFirstNames(FirstName.getAllOriginFirstNames(origin)).size())).name());
        else if(r < 8)
            return FirstName.valueOf(FirstName.getAllFemaleFirstNames(FirstName.getAllOriginFirstNames(Origin.FRENCH)).get(rand.nextInt(0, FirstName.getAllFemaleFirstNames(FirstName.getAllOriginFirstNames(Origin.FRENCH)).size())).name());
        else
            return FirstName.valueOf(FirstName.getAllFemaleFirstNames(FirstName.getAllOriginFirstNames(Origin.GERMAN)).get(rand.nextInt(0, FirstName.getAllFemaleFirstNames(FirstName.getAllOriginFirstNames(Origin.GERMAN)).size())).name());
    }

    /**
     * Create a random lastname
     * @return A lastname
     */
    public static LastName generateLastName(Origin origin){
        int r = rand.nextInt(0, 10);
        if(r < 7)
            return LastName.valueOf(LastName.getAllOriginLastNames(origin).get(rand.nextInt(0, LastName.getAllOriginLastNames(origin).size())).name());
        else if (r < 8)
            return LastName.valueOf(LastName.getAllOriginLastNames(Origin.FRENCH).get(rand.nextInt(0, LastName.getAllOriginLastNames(Origin.FRENCH).size())).name());
        else
            return LastName.valueOf(LastName.getAllOriginLastNames(Origin.GERMAN).get(rand.nextInt(0, LastName.getAllOriginLastNames(Origin.GERMAN).size())).name());
    }

    /**
     * Generate a random adult age
     * @return An adult age
     */
    public static int generateAge(){
        return new Random().nextInt(18, 70);
    }
}
