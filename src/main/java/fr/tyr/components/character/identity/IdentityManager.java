package fr.tyr.components.character.identity;

import java.util.Arrays;
import java.util.Random;

public class IdentityManager {
    /**
     * Create a IdentityManager
     */
    public IdentityManager(){}

    public static Origin generateOrigin(){
        Random rand = new Random();
        return Origin.valueOf(Arrays.stream(Origin.values()).toList().get(rand.nextInt(0, Arrays.stream(Origin.values()).toList().size())).name());
    }
    /**
     * Create a random male firstname
     * @return
     */
    public static FirstName generateMaleFirstName(Origin origin){
        Random rand = new Random();
        return FirstName.valueOf(FirstName.getAllMaleFirstNames(FirstName.getAllOriginFirstNames(origin)).get(rand.nextInt(0, FirstName.getAllMaleFirstNames(FirstName.getAllOriginFirstNames(origin)).size())).name());
    }

    /**
     * Create a random female firstname
     * @return
     */
    public static FirstName generateFemaleFirstName(Origin origin){
        Random rand = new Random();
        return FirstName.valueOf(FirstName.getAllFemaleFirstNames(FirstName.getAllOriginFirstNames(origin)).get(rand.nextInt(0, FirstName.getAllFemaleFirstNames(FirstName.getAllOriginFirstNames(origin)).size())).name());
    }

    /**
     * Create a random lastname
     * @return
     */
    public static LastName generateLastName(Origin origin){
        Random rand = new Random();
        return LastName.valueOf(LastName.getAllOriginLastNames(origin).get(rand.nextInt(0, LastName.getAllOriginLastNames(origin).size())).name());
    }

    /**
     * Generate a random adult age
     * @return
     */
    public static int generateAge(){
        return new Random().nextInt(18, 70);
    }
}
