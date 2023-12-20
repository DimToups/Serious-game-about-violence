package fr.tyr.components.character.personality.thoughts.enums;

public enum GenderThoughts {
    MISOGYNIST("Misogyne", "La personne n'aime pas les femmes."),
    MISANDRE("Misandre", "La personne n'aime pas les hommes."),
    NEUTRAL("Neutre", "La personne n'a pas d'avis sur les genres."),
    DISLIKES_ALL_COMMENTS("Aime aucun commentaire", "La personne n'aime pas la discrimination envers les genres.")
    ;
    private final String title;
    private final String description;
    GenderThoughts(String title, String description){
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
