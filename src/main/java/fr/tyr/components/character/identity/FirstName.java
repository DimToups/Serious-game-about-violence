package fr.tyr.components.character.identity;

import java.util.ArrayList;

public enum FirstName {
    //Prénoms masculins
    LEO("Léo", true),
    GABRIEL("Gabriel", true),
    RAPHAEL("Raphaël", true),
    ARTHUR("Arthur", true),
    LOUIS("Louis", true),
    JULES("Jules", true),
    HUGO("Hugo", true),
    LUCAS("Lucas", true),
    NOAH("Noah", true),
    GABIN("Gabin", true),
    PAUL("Paul", true),
    NATHAN("Nathan", true),
    ANTOINE("Antoine", true),
    SIMON("Simon", true),
    TOM("Tom", true),
    ANATOLE("Anatole", true),
    DIMITRI("Dimitri", true),
    LEON("Léon", true),
    VICTOR("Victor", true),
    MATHIS("Mathis", true),
    IBRAHIM("Ibrahim", true),
    LIAM("Liam", true),
    LENNY("Lenny", true),
    PABLO("Pablo", true),
    JOSEPH("Joseph", true),
    BASILE("Basile", true),
    LOGAN("Logan", true),
    AYOUB("Ayoub", true),
    WASSIM("Wassim", true),
    ALAIN("Alain", true),
    CHARLES("Charles", true),
    ARNAUD("Arnaud", true),
    DAMIEN("Damien", true),
    GUILLAUME("Guillaume", true),
    KENZO("Kenzo", true),
    MOHAMMED("Mohammed ", true),
    ERIC("Eric", true),
    //Prénoms féminins
    JADE("Jade", false),
    LOUISE("Louise", false),
    EMMA("Emma", false),
    ALICE("Alice", false),
    CHLOE("Chloé", false),
    LEA("Léa", false),
    ANNA("Anna", false),
    INES("Inès", false),
    JULIETTE("Juliette", false),
    ZOE("Zoé", false),
    EVA("Éva", false),
    ROMANE("Romane", false),
    CAMILLE("Romane", false),
    OLIVIA("Olivia", false),
    ALYX("Alyx", false),
    CHARLOTTE("Charlotte", false),
    LYNA("Lyna", false),
    ROXANE("Roxane", false),
    MAYA("Maya", false),
    CONSTANCE("Constance", false),
    GWENHAEL("Gwenhael", false),
    SARAH("Sarah", false),
    YASMINE("Yasmine", false),
    KHADIJA("Khadija", false),
    OLGA("Olga", false),
    NATACHA("Natacha", false),
    SASHA("Sasha", false),
    APRIL("April", false);
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
