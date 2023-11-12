package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.resources.images.Images;

import java.util.logging.Level;

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

    /**
     * Return the corresponding Shirt depending on the Images param
     * @param image The Images to focus the search on
     * @return A ShirtEnum corresponding to the Images param
     */
    public static ShirtEnum getShirtEnum(Images image){
        for(ShirtEnum shirt : ShirtEnum.values()){
            if(image.toString().contains(shirt.toString()))
                return shirt;
        }
        Main.getLogger().log(Level.SEVERE, "No shirt has been associated with \"" + image.name() + "\"");
        return null;
    }
}
