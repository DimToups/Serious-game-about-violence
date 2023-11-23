package fr.tyr.components.character.identity.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum FirstName {

    //                          //
    //           MALE           //
    //                          //

    //
    //FRENCH
    //
    LEO("Léo", Gender.MALE, Origin.FRENCH),
    GABRIEL("Gabriel", Gender.MALE, Origin.FRENCH),
    RAPHAEL("Raphaël", Gender.MALE, Origin.FRENCH),
    ARTHUR("Arthur", Gender.MALE, Origin.FRENCH),
    LOUIS("Louis", Gender.MALE, Origin.FRENCH),
    JULES("Jules", Gender.MALE, Origin.FRENCH),
    HUGO("Hugo", Gender.MALE, Origin.FRENCH),
    LUCAS("Lucas", Gender.MALE, Origin.FRENCH),
    NOAH("Noah", Gender.MALE, Origin.FRENCH),
    GABIN("Gabin", Gender.MALE, Origin.FRENCH),
    PAUL("Paul", Gender.MALE, Origin.FRENCH),
    NATHAN("Nathan", Gender.MALE, Origin.FRENCH),
    ANTOINE("Antoine", Gender.MALE, Origin.FRENCH),
    SIMON("Simon", Gender.MALE, Origin.FRENCH),
    TOM("Tom", Gender.MALE, Origin.FRENCH),
    ANATOLE("Anatole", Gender.MALE, Origin.FRENCH),
    LEON("Léon", Gender.MALE, Origin.FRENCH),
    VICTOR("Victor", Gender.MALE, Origin.FRENCH),
    MATHIS("Mathis", Gender.MALE, Origin.FRENCH),
    LIAM("Liam", Gender.MALE, Origin.FRENCH),
    BASILE("Basile", Gender.MALE, Origin.FRENCH),
    ALAIN("Alain", Gender.MALE, Origin.FRENCH),
    CHARLES("Charles", Gender.MALE, Origin.FRENCH),
    ARNAUD("Arnaud", Gender.MALE, Origin.FRENCH),
    DAMIEN("Damien", Gender.MALE, Origin.FRENCH),
    GUILLAUME("Guillaume", Gender.MALE, Origin.FRENCH),
    ERIC("Eric", Gender.MALE, Origin.FRENCH),

    //
    //GERMAN
    //
    LUDWIG("Ludwig", Gender.MALE, Origin.GERMAN),
    LEO_DE("Leo", Gender.MALE, Origin.GERMAN),
    FINN("Finn", Gender.MALE, Origin.GERMAN),
    FELIX("Felix", Gender.MALE, Origin.GERMAN),
    HENRY("Henry", Gender.MALE, Origin.GERMAN),
    SIEGBERT("Siegbert", Gender.MALE, Origin.GERMAN),
    CARL("Carl", Gender.MALE, Origin.GERMAN),
    FRANK("Frank", Gender.MALE, Origin.GERMAN),
    HANSEL("Hänsel", Gender.MALE, Origin.GERMAN),

    //
    //ARABIC
    //
    IBRAHIM("Ibrahim", Gender.MALE, Origin.ARABIC),
    AYOUB("Ayoub", Gender.MALE, Origin.ARABIC),
    WASSIM("Wassim", Gender.MALE, Origin.ARABIC),
    KENZO("Kenzo", Gender.MALE, Origin.ARABIC),
    MOHAMMED("Mohammed ", Gender.MALE, Origin.ARABIC),

    //
    //SPANISH
    //
    PABLO("Pablo", Gender.MALE, Origin.SPANISH),
    JOSE("José", Gender.MALE, Origin.SPANISH),
    CARLOS("Carlos", Gender.MALE, Origin.SPANISH),
    JUAN("Juan", Gender.MALE, Origin.SPANISH),
    PEDRO("Pedro", Gender.MALE, Origin.SPANISH),
    MATIAS("Matias", Gender.MALE, Origin.SPANISH),
    DIEGO("Diego", Gender.MALE, Origin.SPANISH),
    ALEJANDRO("Diego", Gender.MALE, Origin.SPANISH),
    DONATO("Donato", Gender.MALE, Origin.SPANISH),

    //
    //ASIAN
    //
    AKI("Aki", Gender.MALE, Origin.ASIAN),

    //
    //AMERICAN
    //
    LENNY("Lenny", Gender.MALE, Origin.AMERICAN),
    LOGAN("Logan", Gender.MALE, Origin.AMERICAN),
    JOSEPH("Joseph", Gender.MALE, Origin.AMERICAN),

    //
    //RUSSIAN
    //
    DIMITRI("Dimitri", Gender.MALE, Origin.RUSSIAN),

    //
    //AFRICAN
    //
    AADAN("Aadan", Gender.MALE, Origin.AFRICAN),
    ABIDEMI("Abidemi", Gender.MALE, Origin.AFRICAN),
    AMARI("Amari", Gender.MALE, Origin.AFRICAN),
    FARAJI("Faraji", Gender.MALE, Origin.AFRICAN),
    FEMI("Femi", Gender.MALE, Origin.AFRICAN),


    //                          //
    //          FEMALE          //
    //                          //

    //
    //FRENCH
    //
    JADE("Jade", Gender.FEMALE, Origin.FRENCH),
    LOUISE("Louise", Gender.FEMALE, Origin.FRENCH),
    EMMA("Emma", Gender.FEMALE, Origin.FRENCH),
    ALICE("Alice", Gender.FEMALE, Origin.FRENCH),
    CHLOE("Chloé", Gender.FEMALE, Origin.FRENCH),
    LEA("Léa", Gender.FEMALE, Origin.FRENCH),
    ANNA("Anna", Gender.FEMALE, Origin.FRENCH),
    INES("Inès", Gender.FEMALE, Origin.FRENCH),
    JULIETTE("Juliette", Gender.FEMALE, Origin.FRENCH),
    ZOE("Zoé", Gender.FEMALE, Origin.FRENCH),
    EVA("Éva", Gender.FEMALE, Origin.FRENCH),
    ROMANE("Romane", Gender.FEMALE, Origin.FRENCH),
    CAMILLE("Romane", Gender.FEMALE, Origin.FRENCH),
    OLIVIA("Olivia", Gender.FEMALE, Origin.FRENCH),
    CHARLOTTE("Charlotte", Gender.FEMALE, Origin.FRENCH),
    LYNA("Lyna", Gender.FEMALE, Origin.FRENCH),
    ROXANE("Roxane", Gender.FEMALE, Origin.FRENCH),
    MAYA("Maya", Gender.FEMALE, Origin.FRENCH),
    CONSTANCE("Constance", Gender.FEMALE, Origin.FRENCH),
    GWENHAEL("Gwenhael", Gender.FEMALE, Origin.FRENCH),

    //
    //GERMAN
    //
    ALMA("Alma", Gender.FEMALE, Origin.GERMAN),
    HANNA("Hanna", Gender.FEMALE, Origin.GERMAN),
    IRMA("Irma", Gender.FEMALE, Origin.GERMAN),
    JOHANNA("Johanna", Gender.FEMALE, Origin.GERMAN),
    LUISA("Luisa", Gender.FEMALE, Origin.GERMAN),
    MATHILDA("Mathilda", Gender.FEMALE, Origin.GERMAN),

    //
    //ARABIC
    //
    SARAH("Sarah", Gender.FEMALE, Origin.ARABIC),
    YASMINE("Yasmine", Gender.FEMALE, Origin.ARABIC),
    KHADIJA("Khadija", Gender.FEMALE, Origin.ARABIC),

    //
    //SPANISH
    //
    SOFIA("Sofia", Gender.FEMALE, Origin.SPANISH),
    ISABELLA("Isabella", Gender.FEMALE, Origin.SPANISH),
    CAMILA("Camila", Gender.FEMALE, Origin.SPANISH),
    MARIANA("Mariana", Gender.FEMALE, Origin.SPANISH),
    SARA("Sara", Gender.FEMALE, Origin.SPANISH),
    AURELIA("Aurelia", Gender.FEMALE, Origin.SPANISH),
    ANTONIA("Antonia", Gender.FEMALE, Origin.SPANISH),
    CARMEN("Carmen", Gender.FEMALE, Origin.SPANISH),
    LUCIA("Lucía", Gender.FEMALE, Origin.SPANISH),

    //
    //ASIAN
    //
    JING("JING", Gender.FEMALE, Origin.ASIAN),
    ZI_HAN("Zi Han", Gender.FEMALE, Origin.ASIAN),

    //
    //AMERICAN
    //
    APRIL("April", Gender.FEMALE, Origin.AMERICAN),
    ALYX("Alyx", Gender.FEMALE, Origin.AMERICAN),

    //
    //RUSSIAN
    //
    OLGA("Olga", Gender.FEMALE, Origin.RUSSIAN),
    NATACHA("Natacha", Gender.FEMALE, Origin.RUSSIAN),
    SASHA("Sasha", Gender.FEMALE, Origin.RUSSIAN),

    //
    //AFRICAN
    //
    ABEBA("Abeba", Gender.FEMALE, Origin.AFRICAN),
    ADA("Ada", Gender.FEMALE, Origin.AFRICAN),
    AMARA("Amara", Gender.FEMALE, Origin.AFRICAN),
    HIBO("Hibo", Gender.FEMALE, Origin.AFRICAN),
    IMANI("Imani", Gender.FEMALE, Origin.AFRICAN),
    ;
    private final String firstName;
    private final Gender gender;
    private final Origin origin;

    /**
     * Create a FirstName enum
     * @param firstName The firstName
     * @param gender The gender (true for male, false for female)
     */
    FirstName(String firstName, Gender gender, Origin origin){
        this.firstName = firstName;
        this.gender = gender;
        this.origin = origin;
    }

    /**
     * Send the firstname
     * @return The firstname
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Send the gender
     * @return The gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Send the Origin of the FirstName
     * @return The Origin of the FirstName
     */
    public Origin getOrigin() {
        return origin;
    }

    /**
     * Send all the corresponding FirstName depending on the specified Origin
     * @param origin The character's origin
     * @return An array of FirstNames with all the corresponding origins
     */
    public static List<FirstName> getAllOriginFirstNames(Origin origin){
        return Arrays.stream(FirstName.values()).filter(fn -> fn.getOrigin() == origin).toList();
    }
    /**
     * Send all the instanciated male firstnames
     * @return All the instanciated male firstnames
     */
    public static List<FirstName> getAllMaleFirstNames(){
        return Arrays.stream(FirstName.values()).filter(fn -> fn.getGender() == Gender.MALE).toList();
    }

    /**
     * Send all the instanciated male firstnames
     * @param firstNames An array of firstname
     * @return All the male firstnames of the parameter firstNames
     */
    public static List<FirstName> getAllMaleFirstNames(List<FirstName> firstNames){
        return new ArrayList<>(firstNames).stream().filter(fn -> fn.getGender() == Gender.MALE).toList();
    }

    /**
     * Send all the instanciated female firstnames
     * @return All the instanciated female firstnames
     */
    public static List<FirstName> getAllFemaleFirstNames(){
        return Arrays.stream(FirstName.values()).filter(fn -> fn.getGender() == Gender.FEMALE).toList();
    }

    /**
     * Send all the instanciated female firstnames
     * @param firstNames An array of firstname
     * @return All the female firstnames of the parameter firstNames
     */
    public static List<FirstName> getAllFemaleFirstNames(List<FirstName> firstNames){
        return new ArrayList<>(firstNames).stream().filter(fn -> fn.getGender() == Gender.FEMALE).toList();
    }
}
