package fr.tyr.components.violences.enums;

import fr.tyr.components.character.enums.CharacterComponents;

public enum Acts {
    ;
    private final String description;
    private final CharacterComponents violenceTarget;
    private final Violences violenceKind;
    private final CardsKind cardKind;
    Acts(String description, CharacterComponents violenceTarget, Violences violenceKind, CardsKind cardKind){
        this.description = description;
        this.violenceTarget = violenceTarget;
        this.violenceKind = violenceKind;
        this.cardKind = cardKind;
    }

    public String getDescription(){
        return this.description;
    }

    public CharacterComponents getViolenceTarget() {
        return violenceTarget;
    }

    public Violences getViolenceKind() {
        return violenceKind;
    }

    public CardsKind getCardKind() {
        return cardKind;
    }
}
