package fr.tyr.components.character.style;

import fr.tyr.resources.images.Images;

public enum ShirtEnum {
    RED("red", Images.SHIRT_RED),
    PURPLE("purple", Images.SHIRT_PURPLE),
    LIGHT_BLUE("light blue", Images.SHIRT_LIGHT_BLUE),
    GREEN("green", Images.SHIRT_GREEN);
    private final String name;
    private final Images image;

    /**
     * Create a ShirtEnum instance
     * @param name The Shirt's name
     * @param image The Shirt's corresponding Images instance
     */
    ShirtEnum(String name, Images image){
        this.name = name;
        this.image = image;
    }

    /**
     * Send the Shirt's name
     * @return The Shirt's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Send the Shirt's corresponding Images instance
     * @return The Shirt's Images
     */
    public Images getImage() {
        return image;
    }
}
