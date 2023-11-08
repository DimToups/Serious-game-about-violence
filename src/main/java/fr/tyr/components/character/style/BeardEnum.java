package fr.tyr.components.character.style;

import fr.tyr.resources.images.Images;

import java.util.ArrayList;

public enum BeardEnum {
    NONE("none", HairColor.BLACK, Images.NONE);
    private final String name;
    private final HairColor color;
    private final Images image;

    /**
     * Create an instance of BeardEnum
     * @param name The name of the beard cut
     * @param color The corresponding Haircolor of the beard
     * @param image The corresponding Images instance
     */
    BeardEnum(String name, HairColor color, Images image){
        this.name = name;
        this.color = color;
        this.image = image;
    }

    /**
     * Return all the assets from the enum corresponding to the sent HairColor param
     * @param color The corresponding Haircolor of the beard
     * @return All the corresponding assets
     */
    public static ArrayList<BeardEnum> getAllColoredAssets(HairColor color){
        ArrayList<BeardEnum> assets = new ArrayList<>();

        for(BeardEnum beard : BeardEnum.values()){
            if(beard.color == color)
                assets.add(beard);
        }

        return assets;
    }

    /**
     * Return all the assets from the beard param corresponding to the sent HairColor param
     * @param color The corresponding Haircolor of the beard
     * @param beards An Array of Beard
     * @return All the corresponding assets
     */
    public static ArrayList<BeardEnum> getAllColoredAssets(HairColor color, ArrayList<BeardEnum> beards){
        ArrayList<BeardEnum> assets = new ArrayList<>();

        for(BeardEnum beard : beards){
            if(beard.color == color)
                assets.add(beard);
        }

        return assets;
    }

    /**
     * Send the Beard name
     * @return The Beard name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Send the Beard's HairColor
     * @return The Beard's HairColor
     */
    public HairColor getColor() {
        return color;
    }

    /**
     * Send the Beard's Images
     * @return The Beard's Images
     */
    public Images getImage() {
        return image;
    }
}
