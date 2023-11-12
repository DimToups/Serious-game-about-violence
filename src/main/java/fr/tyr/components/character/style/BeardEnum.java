package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.resources.images.Images;

import java.util.ArrayList;
import java.util.logging.Level;

public enum BeardEnum {
    NONE("none", HairColor.BLACK, Images.NONE),
    SHORT_BLACK("short black", HairColor.BLACK, Images.BEARD_SHORT_BLACK),
    SHORT_DARK_BROWN("short dark brown", HairColor.DARK_BROWN, Images.BEARD_SHORT_DARK_BROWN),
    SHORT_BROWN("short brown", HairColor.BROWN, Images.BEARD_SHORT_BROWN),
    SHORT_BLOND("short blond", HairColor.BLOND, Images.BEARD_SHORT_BLOND),
    SHORT_WHITE("short white", HairColor.WHITE, Images.BEARD_SHORT_WHITE),
    SHORT_GINGER("short ginger", HairColor.GINGER, Images.BEARD_SHORT_GINGER),
    SHORT_BLUE("short blue", HairColor.BLUE, Images.BEARD_SHORT_BLUE),
    SHORT_PINK("short pink", HairColor.PINK, Images.BEARD_SHORT_PINK);
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

    /**
     * Return the corresponding BeardEnum depending on the Images param
     * @param image The Images to focus the search on
     * @return A BeardEnum corresponding to the Images param
     */
    public static BeardEnum getBeardEnum(Images image){
        for(BeardEnum beard : BeardEnum.values()){
            if(image.toString().contains(beard.toString()))
                return beard;
        }
        Main.getLogger().log(Level.SEVERE, "No beard has been associated with \"" + image.name() + "\"");
        return null;
    }
}
