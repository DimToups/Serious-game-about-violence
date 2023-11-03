package fr.tyr.components.character.identity;

public enum LastName {
    MARTIN("Marthin"),
    PETIT("Petit"),
    GIRAUD("Giraud"),
    MEYER("Meyer"),
    MULLER("Muller"),
    SCHMITT("Schmitt"),
    SCHNEIDER("Schneider"),
    JUNG("Jung"),
    ROTH("Roth"),
    PETER("Peter"),
    HEINRICH("Heinrich"),
    KUHN("Kuhn"),
    OTT("Ott"),
    HARTMANN("HARTMANN"),
    LANG("Lang"),
    FISCHER("Fischer"),
    AZIZ("Aziz"),
    AL_BAKIR("Al Bakir"),
    FAROUK("Farouk"),
    SMITH("Smith"),
    BROWN("Brown"),
    LOPEZ("Lopez"),
    MARTINEZ("Martinez"),
    LIN("Lin"),
    ZHANG("Zhang"),
    WU("Wu"),
    CHEN("Chen");
    private final String lastName;

    /**
     * Create a LastName enum
     * @param lastName The lastname
     */
    LastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Send the lastname
     * @return
     */
    public String getLastName(){
        return this.lastName;
    }
}
