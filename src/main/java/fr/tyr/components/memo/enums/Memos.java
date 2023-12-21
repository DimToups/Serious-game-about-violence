package fr.tyr.components.memo.enums;

import fr.tyr.resources.images.Images;

public enum Memos {
    GREEN(Images.MEMO_GREEN),
    YELLOW(Images.MEMO_YELLOW),
    PINK(Images.MEMO_PINK),
    ;
    private final Images image;
    Memos(Images image){
        this.image = image;
    }

    public Images getImage() {
        return image;
    }
}
