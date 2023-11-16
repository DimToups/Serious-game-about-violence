package fr.tyr.components.character.enums;

import fr.tyr.components.character.identity.enums.FirstName;
import fr.tyr.components.character.identity.enums.LastName;
import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.components.character.style.*;

public enum CharacterComponents {
    BEARD(Beard.class, CharacterComponentKind.STYLE),
    EYES(Eyes.class, CharacterComponentKind.STYLE),
    HAIR(Hair.class, CharacterComponentKind.STYLE),
    SHIRT(Shirt.class, CharacterComponentKind.STYLE),
    SKIN(Skin.class, CharacterComponentKind.STYLE),
    ORIGIN(Origin.class, CharacterComponentKind.IDENTITY),
    LASTNAME(LastName.class, CharacterComponentKind.IDENTITY),
    FIRSTANME(FirstName.class, CharacterComponentKind.IDENTITY),
    AGE(Integer.class, CharacterComponentKind.IDENTITY),
    ;
    private final Object component;
    private final CharacterComponentKind componentKind;
    CharacterComponents(Object component, CharacterComponentKind componentKind){
        this.component = component;
        this.componentKind = componentKind;
    }

    public Object getUsedClass(){
        return this.component;
    }
    public CharacterComponentKind getComponentKind(){
        return this.componentKind;
    }
}
