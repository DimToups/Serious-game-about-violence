package fr.tyr.components.character.personality.enums;

public enum GenderPersonality {
    MYSOGYNIST,
    MISANDRIST,
    NEUTRAL,
    DISLIKES_ALL_COMMENTS;
    public String cleanName(){
        String name = this.name();
        int i = 0;
        while(i < name.length() && !name.contains("_")){
            //Recherche d'un '_'
            if(name.charAt(i) == '_')
                name = name.substring(0, i) + " " + name.substring(i + 1, name.length());
        }
        return name;
    }
}
