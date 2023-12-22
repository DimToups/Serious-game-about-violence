package fr.tyr.components.character.personality.thoughts.enums;


public enum SexualOrientationThoughts {
    DISLIKES_ALL_COMMENTS("Aime aucun commentaire", "La personne n'aime pas juger les orientations sexuelles"),
    NEUTRAL("Aucun avis", "La personne n'a pas avis sur les orientations sexuelles"),
    HOMOPHOBIC("Homophobe", "La personne est homophobe"),
    LIKES_ALL_COMMENTS("Aime tous les commentaires", "La personne aime les blagues homophobiques")
    ;
    private final String title;
    private final String description;
    SexualOrientationThoughts(String title, String description){
        this.title = title;
        this.description = description;
    }

    /**
     * Send the thought's title
     * @return The thought's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Send the thought's description
     * @return The thought's description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Returns a clean name of the instance
     * @return A clean name of the instance
     */
    public String cleanName(){
        String name = this.name();
        int i = 0;
        while(i < name.length() && name.contains("_")){
            //Recherche d'un '_'
            if(name.charAt(i) == '_')
                name = name.substring(0, i) + " " + name.substring(i + 1);
            i++;
        }
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}
