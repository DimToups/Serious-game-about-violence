package fr.tyr.components.violence.enums;

import fr.tyr.resources.images.Images;

public enum Icon {
    PHYSICAL(Types.PHYSICAL, Images.ICON_PHYSICAL),
    SEXUAL(Types.SEXUAL, Images.ICON_SEXUAL),
    ECONOMICAL(Types.ECONOMICAL, Images.ICON_ECONOMICAL),
    VERBAL(Types.VERBAL, Images.ICON_VERBAL),
    PSYCHOLOGICAL(Types.PSYCHOLOGICAL, Images.ICON_PSYCHOLOGICAL);

    private final Types type;
    private final Images icon;

    /**
     * create an instance of Icon
     * @param type The Icon's name
     * @param icon The Icon's corresponding Images instance
     */
    Icon(Types type, Images icon){
        this.type = type;
        this.icon = icon;
    }
    /**
     * Return the corresponding Images depending on the Icon
     * @return The Images corresponding of the Icon
     */
    public Images getImage(){
        return this.icon;
    }
}

