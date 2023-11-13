package fr.tyr.components.character.identity;

import java.util.Arrays;
import java.util.Random;

public class IdentityManager {
    static Random rand = new Random();
    /**
     * Create a IdentityManager
     */
    public IdentityManager(){}

    public static Origin generateOrigin(){
        return Origin.valueOf(Arrays.stream(Origin.values()).toList().get(rand.nextInt(0, Arrays.stream(Origin.values()).toList().size())).name());
    }
    /**
     * Create a random male firstname
     * @return A male firstname
     */
    public static FirstName generateMaleFirstName(Origin origin){
        return FirstName.valueOf(FirstName.getAllMaleFirstNames(FirstName.getAllOriginFirstNames(origin)).get(rand.nextInt(0, FirstName.getAllMaleFirstNames(FirstName.getAllOriginFirstNames(origin)).size())).name());
    }

    /**
     * Create a random female firstname
     * @return A female firstname
     */
    public static FirstName generateFemaleFirstName(Origin origin){
        return FirstName.valueOf(FirstName.getAllFemaleFirstNames(FirstName.getAllOriginFirstNames(origin)).get(rand.nextInt(0, FirstName.getAllFemaleFirstNames(FirstName.getAllOriginFirstNames(origin)).size())).name());
    }

    /**
     * Create a random lastname
     * @return A lastname
     */
    public static LastName generateLastName(Origin origin){
        return LastName.valueOf(LastName.getAllOriginLastNames(origin).get(rand.nextInt(0, LastName.getAllOriginLastNames(origin).size())).name());
    }

    /**
     * Generate a random adult age
     * @return An adult age
     */
    public static int generateAge(){
        return new Random().nextInt(18, 70);
    }
}
