package fr.tyr.components.character.personality.enums.thought;


public enum SexualOrientationThoughts {
    DISLIKES_ALL_COMMENTS("Aime aucun commentaire", "La personne n'aime pas qu'on se moque des orientations sexuelles des personnes."),
    NEUTRAL("Aucun avis", "La personne n'a aucun avis sur les orientations sexuelles des personnes."),
    HOMOPHOBIC("Homophobe", "La personne n'aime pas l'idée que des gens de même sexe puissent s'aimer."),
    LIKES_ALL_COMMENTS("Aime tous les commentaires", "La personne aime particulièrement qu'on se moque des orientations sexuelles des personnes.")
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
