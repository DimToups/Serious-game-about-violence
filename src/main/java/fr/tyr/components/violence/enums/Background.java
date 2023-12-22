package fr.tyr.components.violence.enums;

import fr.tyr.resources.images.Images;

public enum Background {
    PHYSICAL(Types.PHYSICAL, Images.BACKGROUND_PHYSICAL),
    SEXUAL(Types.SEXUAL, Images.BACKGROUND_SEXUAL),
    ECONOMICAL(Types.ECONOMICAL, Images.BACKGROUND_ECONOMICAL),
    VERBAL(Types.VERBAL, Images.BACKGROUND_VERBAL),
    PSYCHOLOGICAL(Types.PSYCHOLOGICAL, Images.BACKGROUND_PSYCHOLOGICAL);

    private final Types type;
    private final Images background;

    /**
     * create an instance of background
     * @param type The Background's name
     * @param background The Background's corresponding Images instance
     */
    Background(Types type, Images background){
        this.type = type;
        this.background = background;
    }

    /**
     * Return the corresponding Images depending on the Background
     * @return The Images corresponding of the Background
     */
    public Images getImage(){
        return this.background;
    }
}
