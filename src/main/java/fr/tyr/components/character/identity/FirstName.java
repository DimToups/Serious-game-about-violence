package fr.tyr.components.character.identity;

import java.util.ArrayList;
import java.util.List;

public enum FirstName {

    //                          //
    //           MALE           //
    //                          //

    //
    //FRENCH
    //
    LEO("Léo", true, Origin.FRENCH),
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
    LEON("Léon", true, Origin.FRENCH),
    VICTOR("Victor", true, Origin.FRENCH),
    MATHIS("Mathis", true, Origin.FRENCH),
    LIAM("Liam", true, Origin.FRENCH),
    BASILE("Basile", true, Origin.FRENCH),
    ALAIN("Alain", true, Origin.FRENCH),
    CHARLES("Charles", true, Origin.FRENCH),
    ARNAUD("Arnaud", true, Origin.FRENCH),
    DAMIEN("Damien", true, Origin.FRENCH),
    GUILLAUME("Guillaume", true, Origin.FRENCH),
    ERIC("Eric", true, Origin.FRENCH),

    //
    //GERMAN
    //
    LUDWIG("Ludwig", true, Origin.GERMAN),
    LEO_DE("Leo", true, Origin.GERMAN),
    FINN("Finn", true, Origin.GERMAN),
    FELIX("Felix", true, Origin.GERMAN),
    HENRY("Henry", true, Origin.GERMAN),
    SIEGBERT("Siegbert", true, Origin.GERMAN),
    CARL("Carl", true, Origin.GERMAN),
    FRANK("Frank", true, Origin.GERMAN),
    HANSEL("Hänsel", true, Origin.GERMAN),

    //
    //ARABIC
    //
    IBRAHIM("Ibrahim", true, Origin.ARABIC),
    AYOUB("Ayoub", true, Origin.ARABIC),
    WASSIM("Wassim", true, Origin.ARABIC),
    KENZO("Kenzo", true, Origin.ARABIC),
    MOHAMMED("Mohammed ", true, Origin.ARABIC),

    //
    //SPANISH
    //
    PABLO("Pablo", true, Origin.SPANISH),
    JOSE("José", true, Origin.SPANISH),
    CARLOS("Carlos", true, Origin.SPANISH),
    JUAN("Juan", true, Origin.SPANISH),
    PEDRO("Pedro", true, Origin.SPANISH),
    MATIAS("Matias", true, Origin.SPANISH),
    DIEGO("Diego", true, Origin.SPANISH),
    ALEJANDRO("Diego", true, Origin.SPANISH),
    DONATO("Donato", true, Origin.SPANISH),

    //
    //ASIAN
    //
    AKI("Aki", true, Origin.ASIAN),

    //
    //AMERICAN
    //
    LENNY("Lenny", true, Origin.AMERICAN),
    LOGAN("Logan", true, Origin.AMERICAN),
    JOSEPH("Joseph", true, Origin.AMERICAN),

    //
    //RUSSIAN
    //
    DIMITRI("Dimitri", true, Origin.RUSSIAN),

    //
    //AFRICAN
    //
    AADAN("Aadan", true, Origin.AFRICAN),
    ABIDEMI("Abidemi", true, Origin.AFRICAN),
    AMARI("Amari", true, Origin.AFRICAN),
    FARAJI("Faraji", true, Origin.AFRICAN),
    FEMI("Femi", true, Origin.AFRICAN),


    //                          //
    //          FEMALE          //
    //                          //

    //
    //FRENCH
    //
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
    CHARLOTTE("Charlotte", false, Origin.FRENCH),
    LYNA("Lyna", false, Origin.FRENCH),
    ROXANE("Roxane", false, Origin.FRENCH),
    MAYA("Maya", false, Origin.FRENCH),
    CONSTANCE("Constance", false, Origin.FRENCH),
    GWENHAEL("Gwenhael", false, Origin.FRENCH),

    //
    //GERMAN
    //
    ALMA("Alma", false, Origin.GERMAN),
    HANNA("Hanna", false, Origin.GERMAN),
    IRMA("Irma", false, Origin.GERMAN),
    JOHANNA("Johanna", false, Origin.GERMAN),
    LUISA("Luisa", false, Origin.GERMAN),
    MATHILDA("Mathilda", false, Origin.GERMAN),

    //
    //ARABIC
    //
    SARAH("Sarah", false, Origin.ARABIC),
    YASMINE("Yasmine", false, Origin.ARABIC),
    KHADIJA("Khadija", false, Origin.ARABIC),

    //
    //SPANISH
    //
    SOFIA("Sofia", false, Origin.SPANISH),
    ISABELLA("Isabella", false, Origin.SPANISH),
    CAMILA("Camila", false, Origin.SPANISH),
    MARIANA("Mariana", false, Origin.SPANISH),
    SARA("Sara", false, Origin.SPANISH),
    AURELIA("Aurelia", false, Origin.SPANISH),
    ANTONIA("Antonia", false, Origin.SPANISH),
    CARMEN("Carmen", false, Origin.SPANISH),
    LUCIA("Lucía", false, Origin.SPANISH),

    //
    //ASIAN
    //
    JING("JING", false, Origin.ASIAN),
    ZI_HAN("Zi Han", false, Origin.ASIAN),

    //
    //AMERICAN
    //
    APRIL("April", false, Origin.AMERICAN),
    ALYX("Alyx", false, Origin.AMERICAN),

    //
    //RUSSIAN
    //
    OLGA("Olga", false, Origin.RUSSIAN),
    NATACHA("Natacha", false, Origin.RUSSIAN),
    SASHA("Sasha", false, Origin.RUSSIAN),

    //
    //AFRICAN
    //
    ABEBA("Abeba", false, Origin.AFRICAN),
    ADA("Ada", false, Origin.AFRICAN),
    AMARA("Amara", false, Origin.AFRICAN),
    HIBO("Hibo", false, Origin.AFRICAN),
    IMANI("Imani", false, Origin.AFRICAN),
    ;
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
     * @return The firstname
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Send the gender
     * @return The gender
     */
    public boolean getGender() {
        return gender;
    }

    /**
     * Send the Origin of the FirstName
     * @return The Origin of the FirstName
     */
    public Origin getOrigin() {
        return this.origin;
    }

    /**
     * Send all the corresponding FirstName depending on the specified Origin
     * @param origin The character's origin
     * @return An array of FirstNames with all the corresponding origins
     */
    public static List<FirstName> getAllOriginFirstNames(Origin origin){
        List<FirstName> firstNames = new ArrayList<>();

        for(FirstName fn : FirstName.values()){
            if(fn.getOrigin() == origin)
                firstNames.add(fn);
        }

        return firstNames;
    }
    /**
     * Send all the instanciated male firstnames
     * @return All the instanciated male firstnames
     */
    public static List<FirstName> getAllMaleFirstNames(){
        List<FirstName> amfn = new ArrayList<>();
        for(FirstName fn : FirstName.values()){
            if(fn.getGender())
                amfn.add(fn);
        }
        return amfn;
    }

    /**
     * Send all the instanciated male firstnames
     * @param firstNames An array of firstname
     * @return All the male firstnames of the parameter firstNames
     */
    public static List<FirstName> getAllMaleFirstNames(List<FirstName> firstNames){
        List<FirstName> amfn = new ArrayList<>();
        for(FirstName fn : firstNames){
            if(fn.getGender())
                amfn.add(fn);
        }
        return amfn;
    }

    /**
     * Send all the instanciated female firstnames
     * @return All the instanciated female firstnames
     */
    public static List<FirstName> getAllFemaleFirstNames(){
        List<FirstName> affn = new ArrayList<>();
        for(FirstName fn : FirstName.values()){
            if(!fn.getGender())
                affn.add(fn);
        }
        return affn;
    }

    /**
     * Send all the instanciated female firstnames
     * @param firstNames An array of firstname
     * @return All the female firstnames of the parameter firstNames
     */
    public static List<FirstName> getAllFemaleFirstNames(List<FirstName> firstNames){
        List<FirstName> affn = new ArrayList<>();
        for(FirstName fn : firstNames){
            if(!fn.getGender())
                affn.add(fn);
        }
        return affn;
    }
}
