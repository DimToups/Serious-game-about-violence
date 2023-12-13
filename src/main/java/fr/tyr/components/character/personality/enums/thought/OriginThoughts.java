package fr.tyr.components.character.personality.enums.thought;

public enum OriginThoughts {
    DISLIKES_ALL_COMMENTS("Aime aucun commentaire", "La personne ne tolère pas les commentaires racistes."),
    DISLIKES_COMMENTS_ON_ITS_ORIGIN("N'aime pas les commentaires sur son origine", "La personne n'aime pas qu'on se moque de son origine."),
    NEUTRAL("Aucun avis", "La personne n'a pas vraiment d'avis sur les origines."),
    LIKES_ALL_COMMENTS("Aime tous les commentaires", "La personne est apprécie les commentaires racistes.")
    ;
    private final String title;
    private final String description;
    OriginThoughts(String title, String description){
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
