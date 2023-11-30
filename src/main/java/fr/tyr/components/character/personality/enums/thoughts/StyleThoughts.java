package fr.tyr.components.character.personality.enums.thoughts;


public enum StyleThoughts {
    DISLIKES_ALL_COMMENTS,
    DISLIKES_COMMENTS_ON_ITS_STYLE,
    NEUTRAL,
    LIKES_ALL_COMMENTS;
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
