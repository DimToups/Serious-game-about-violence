package fr.tyr.components.character.identity;

import java.util.Arrays;
import java.util.Random;

public class IdentityManager {
    /**
     * Create a IdentityManager
     */
    public IdentityManager(){}

    /**
     * Create a random male firstname
     * @return
     */
    public static FirstName generateMaleFirstName(){
        Random rand = new Random();
        return FirstName.valueOf(FirstName.getAllMaleFirstNames().get(rand.nextInt(0, FirstName.getAllMaleFirstNames().size())).name());
    }

    /**
     * Create a random female firstname
     * @return
     */
    public static FirstName generateFemaleFirstName(){
        Random rand = new Random();
        return FirstName.valueOf(FirstName.getAllFemaleFirstNames().get(rand.nextInt(0, FirstName.getAllFemaleFirstNames().size())).name());
    }

    /**
     * Create a random lastname
     * @return
     */
    public static LastName generateLastName(){
        Random rand = new Random();
        return LastName.valueOf(Arrays.stream(LastName.values()).toList().get(rand.nextInt(0, LastName.values().length)).name());
    }
}
