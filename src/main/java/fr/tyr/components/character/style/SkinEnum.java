package fr.tyr.components.character.style;

import fr.tyr.components.character.identity.Origin;
import fr.tyr.resources.images.Images;

import java.util.ArrayList;

public enum SkinEnum {
    WHITE("white", Images.SKIN_WHITE, Origin.FRENCH);
    private final String name;
    private final Images image;
    private final Origin origin;

    /**
     * Create an instance of SkinEnum
     * @param name The SkinEnum's name
     * @param image The SkinEnum's corresponding Images instance
     * @param origin The SkinEnum's Origin
     */
    SkinEnum(String name, Images image, Origin origin){
        this.name = name;
        this.image = image;
        this.origin = origin;
    }

    /**
     * Send the SkinEnum's name
     * @return The SkinEnum's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Send the SkinEnum's corresponding Images instance
     * @return The SkinEnum's Images
     */
    public Images getImage() {
        return image;
    }

    /**
     * Send the SkinEnum's Origin
     * @return The SkinEnum's Origin
     */
    public Origin getOrigin() {
        return origin;
    }

    /**
     * Send all the corresponding assets from the enum depending on the Origin param
     * @param origin The character's Origin
     * @return The corresponding assets
     */
    public static ArrayList<SkinEnum> getAllOriginAssets(Origin origin){
        ArrayList<SkinEnum> assets = new ArrayList<>();

        for(SkinEnum skin : SkinEnum.values()){
            if(skin.origin == origin)
                assets.add(skin);
        }

        return assets;
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the Origin param
     * @param origin The character's Origin
     * @param skin The List of SkinEnum to process
     * @return The corresponding assets
     */
    public static ArrayList<SkinEnum> getAllOriginAssets(Origin origin, ArrayList<SkinEnum> skin){
        ArrayList<SkinEnum> assets = new ArrayList<>();

        for(SkinEnum e : skin){
            if(e.origin == origin)
                assets.add(e);
        }

        return assets;
    }
}