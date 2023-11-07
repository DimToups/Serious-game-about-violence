package fr.tyr.components.character.style;

import fr.tyr.resources.images.Images;

import java.util.ArrayList;

public enum ShirtEnum {
    RED("red", Images.SHIRT_RED);
    private final String name;
    private final Images image;
    ShirtEnum(String name, Images image){
        this.name = name;
        this.image = image;
    }
    public String getName() {
        return this.name;
    }
    public Images getImage() {
        return image;
    }
}
