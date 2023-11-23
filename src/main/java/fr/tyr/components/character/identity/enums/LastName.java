package fr.tyr.components.character.identity.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LastName {

    //
    //FRENCH
    //
    MARTIN(Origin.FRENCH),
    PETIT(Origin.FRENCH),
    GIRAUD(Origin.FRENCH),

    //
    //GERMAN
    //
    MEYER(Origin.GERMAN),
    MULLER(Origin.GERMAN),
    SCHMITT(Origin.GERMAN),
    SCHNEIDER(Origin.GERMAN),
    JUNG(Origin.GERMAN),
    ROTH(Origin.GERMAN),
    PETER(Origin.GERMAN),
    HEINRICH(Origin.GERMAN),
    KUHN(Origin.GERMAN),
    OTT(Origin.GERMAN),
    HARTMANN(Origin.GERMAN),
    LANG(Origin.GERMAN),
    FISCHER(Origin.GERMAN),

    //
    //ARABIC
    //
    AZIZ(Origin.ARABIC),
    AL_BAKIR(Origin.ARABIC),
    FAROUK(Origin.ARABIC),

    //
    //SPANISH
    //
    GACIA(Origin.SPANISH),
    PAZ(Origin.SPANISH),
    HERNANDEZ(Origin.SPANISH),
    CARRERA(Origin.SPANISH),

    //
    //ASIAN
    //
    LIN(Origin.ASIAN),
    ZHANG(Origin.ASIAN),
    WU(Origin.ASIAN),
    CHEN(Origin.ASIAN),

    //
    //AMERICAN
    //
    SMITH(Origin.AMERICAN),
    BROWN(Origin.AMERICAN),
    LOPEZ(Origin.AMERICAN),
    MARTINEZ(Origin.AMERICAN),

    //
    //RUSSIAN
    //
    BELINSKI(Origin.RUSSIAN),
    ANDREEV(Origin.RUSSIAN),
    BOLKONSKI(Origin.RUSSIAN),
    OZEROVA(Origin.RUSSIAN),
    ZALESSKAIA(Origin.RUSSIAN),
    IGNATIEV(Origin.RUSSIAN),
    KILOSOVSKAIA(Origin.RUSSIAN),
    ROUMIANTSEV(Origin.RUSSIAN),

    //
    //AFRICAN
    //
    ABARA(Origin.AFRICAN),
    ABIMBOLA(Origin.AFRICAN),
    ADEBISI(Origin.AFRICAN),
    ADEKUNLE(Origin.AFRICAN),
    KANUMBA(Origin.AFRICAN),
    KEITA(Origin.AFRICAN),
    KIMATHI(Origin.AFRICAN),
    GBEHO(Origin.AFRICAN),

    ;
    private final Origin origin;

    /**
     * Create a LastName enum
     * @param origin The lastname's origin
     */
    LastName(Origin origin){
        this.origin = origin;
    }

    /**
     * Send the lastname's origin
     * @return The lastname's origin
     */
    public Origin getOrigin(){
        return this.origin;
    }

    /**
     * Send back all of the lastnames corresponding to the specified origin
     * @param origin An specified origin
     * @return The remaining LastNames
     */
    public static List<LastName> getAllOriginLastNames(Origin origin){
        return Arrays.stream(LastName.values()).filter(lastName -> lastName.getOrigin() == origin).toList();
    }

    /**
     * Convert the LastName into an clean String
     * @return The converted LastName
     */
    public String cleanName(){
        String name = this.name().toLowerCase();

        name = name.substring(0,1).toUpperCase() + name.substring(1);

        for(int i = 0 ; i < name.length(); i++){
            if(name.charAt(i) == '_')
                name = name.substring(0, i-1) + " " + name.substring(0, i+1).toUpperCase() + name.substring(0, i+2);
        }

        return name;
    }
}
