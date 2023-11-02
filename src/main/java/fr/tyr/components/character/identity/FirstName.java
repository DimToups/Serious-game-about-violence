package fr.tyr.components.character.identity;

import java.util.ArrayList;

public enum FirstName {
    ;
    private final String firstName;
    /**
     * true for male, false for female
     */
    private final boolean gender;

    /**
     * Create an FirstName enum
     * @param firstName The firstName
     * @param gender The gender (true for male, false for female)
     */
    FirstName(String firstName, boolean gender){
        this.firstName = firstName;
        this.gender = gender;
    }

    /**
     * Send the firstname
     * @return
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Send the gender
     * @return
     */
    public boolean getGender() {
        return gender;
    }

    /**
     * Send all the instanciated male firstnames
     * @return
     */
    public static ArrayList<FirstName> getAllMaleFirstNames(){
        ArrayList<FirstName> amfn = new ArrayList<>();
        for(FirstName fn : FirstName.values()){
            if(fn.getGender())
                amfn.add(fn);
        }
        return amfn;
    }

    /**
     * Send all the instanciated male firstnames
     * @return
     */
    public static ArrayList<FirstName> getAllFemaleFirstNames(){
        ArrayList<FirstName> affn = new ArrayList<>();
        for(FirstName fn : FirstName.values()){
            if(!fn.getGender())
                affn.add(fn);
        }
        return affn;
    }
}
