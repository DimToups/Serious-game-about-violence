package fr.tyr.components.character.identity;

public enum LastName {
    ;
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
