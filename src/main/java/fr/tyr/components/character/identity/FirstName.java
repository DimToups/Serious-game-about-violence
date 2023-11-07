package fr.tyr.components.character.identity;

import java.util.ArrayList;

public enum FirstName {
    //Prénoms masculins
    LEO("Léo", true, Origin.FRENCH),
    LUDWIG("Ludwig", true, Origin.GERMAN),
    GABRIEL("Gabriel", true, Origin.FRENCH),
    RAPHAEL("Raphaël", true, Origin.FRENCH),
    ARTHUR("Arthur", true, Origin.FRENCH),
    LOUIS("Louis", true, Origin.FRENCH),
    JULES("Jules", true, Origin.FRENCH),
    HUGO("Hugo", true, Origin.FRENCH),
    LUCAS("Lucas", true, Origin.FRENCH),
    NOAH("Noah", true, Origin.FRENCH),
    GABIN("Gabin", true, Origin.FRENCH),
    PAUL("Paul", true, Origin.FRENCH),
    NATHAN("Nathan", true, Origin.FRENCH),
    ANTOINE("Antoine", true, Origin.FRENCH),
    SIMON("Simon", true, Origin.FRENCH),
    TOM("Tom", true, Origin.FRENCH),
    ANATOLE("Anatole", true, Origin.FRENCH),
    DIMITRI("Dimitri", true, Origin.RUSSIAN),
    LEON("Léon", true, Origin.FRENCH),
    VICTOR("Victor", true, Origin.FRENCH),
    MATHIS("Mathis", true, Origin.FRENCH),
    IBRAHIM("Ibrahim", true, Origin.ARABIC),
    LIAM("Liam", true, Origin.FRENCH),
    LENNY("Lenny", true, Origin.AMERICAN),
    PABLO("Pablo", true, Origin.SPANISH),
    JOSEPH("Joseph", true, Origin.AMERICAN),
    BASILE("Basile", true, Origin.FRENCH),
    LOGAN("Logan", true, Origin.AMERICAN),
    AYOUB("Ayoub", true, Origin.ARABIC),
    WASSIM("Wassim", true, Origin.ARABIC),
    ALAIN("Alain", true, Origin.FRENCH),
    CHARLES("Charles", true, Origin.FRENCH),
    ARNAUD("Arnaud", true, Origin.FRENCH),
    DAMIEN("Damien", true, Origin.FRENCH),
    GUILLAUME("Guillaume", true, Origin.FRENCH),
    KENZO("Kenzo", true, Origin.ARABIC),
    MOHAMMED("Mohammed ", true, Origin.ARABIC),
    ERIC("Eric", true, Origin.FRENCH),
    //Prénoms féminins
    JADE("Jade", false, Origin.FRENCH),
    LOUISE("Louise", false, Origin.FRENCH),
    EMMA("Emma", false, Origin.FRENCH),
    ALICE("Alice", false, Origin.FRENCH),
    CHLOE("Chloé", false, Origin.FRENCH),
    LEA("Léa", false, Origin.FRENCH),
    ANNA("Anna", false, Origin.FRENCH),
    INES("Inès", false, Origin.FRENCH),
    JULIETTE("Juliette", false, Origin.FRENCH),
    ZOE("Zoé", false, Origin.FRENCH),
    EVA("Éva", false, Origin.FRENCH),
    ROMANE("Romane", false, Origin.FRENCH),
    CAMILLE("Romane", false, Origin.FRENCH),
    OLIVIA("Olivia", false, Origin.FRENCH),
    ALYX("Alyx", false, Origin.AMERICAN),
    CHARLOTTE("Charlotte", false, Origin.FRENCH),
    LYNA("Lyna", false, Origin.FRENCH),
    ROXANE("Roxane", false, Origin.FRENCH),
    MAYA("Maya", false, Origin.FRENCH),
    CONSTANCE("Constance", false, Origin.FRENCH),
    GWENHAEL("Gwenhael", false, Origin.FRENCH),
    SARAH("Sarah", false, Origin.ARABIC),
    YASMINE("Yasmine", false, Origin.ARABIC),
    KHADIJA("Khadija", false, Origin.ARABIC),
    OLGA("Olga", false, Origin.RUSSIAN),
    NATACHA("Natacha", false, Origin.RUSSIAN),
    SASHA("Sasha", false, Origin.RUSSIAN),
    APRIL("April", false, Origin.AMERICAN),
    JING("JING", true, Origin.ASIAN),
    ZI_HAN("Zi Han", true, Origin.ASIAN);
    private final String firstName;
    /**
     * true for male, false for female
     */
    private final boolean gender;
    private final Origin origin;

    /**
     * Create a FirstName enum
     * @param firstName The firstName
     * @param gender The gender (true for male, false for female)
     */
    FirstName(String firstName, boolean gender, Origin origin){
        this.firstName = firstName;
        this.gender = gender;
        this.origin = origin;
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
     * Send the Origin of the FirstName
     * @return
     */
    public Origin getOrigin() {
        return this.origin;
    }

    /**
     * Send all the corresponding FirstName depending on the specified Origin
     * @param origin The character's origin
     * @return An array of FirstNames with all the corresponding origins
     */
    public static ArrayList<FirstName> getAllOriginFirstNames(Origin origin){
        ArrayList<FirstName> firstNames = new ArrayList<>();

        for(FirstName fn : FirstName.values()){
            if(fn.getOrigin() == origin)
                firstNames.add(fn);
        }

        return firstNames;
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
     * @param firstNames An array of firstname
     * @return All of the male firstnames of the parameter firstNames
     */
    public static ArrayList<FirstName> getAllMaleFirstNames(ArrayList<FirstName> firstNames){
        ArrayList<FirstName> amfn = new ArrayList<>();
        for(FirstName fn : firstNames){
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

    /**
     * Send all the instanciated male firstnames
     * @param firstNames An array of firstname
     * @return All of the female firstnames of the parameter firstNames
     */
    public static ArrayList<FirstName> getAllFemaleFirstNames(ArrayList<FirstName> firstNames){
        ArrayList<FirstName> affn = new ArrayList<>();
        for(FirstName fn : firstNames){
            if(!fn.getGender())
                affn.add(fn);
        }
        return affn;
    }
}
