package fr.tyr.components.character.style;

import fr.tyr.components.character.identity.Origin;
import fr.tyr.resources.images.Images;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public enum SkinEnum {
    WHITE("white", Images.SKIN_WHITE, Origin.FRENCH, Origin.RUSSIAN, Origin.GERMAN, Origin.SPANISH),
    BLACK("black", Images.SKIN_BLACK, Origin.AFRICAN, Origin.ARABIC, Origin.AMERICAN),
    ASIAN("asian", Images.SKIN_ASIAN, Origin.ASIAN, Origin.RUSSIAN),
    TANNED("tanned", Images.SKIN_TANNED, Origin.ARABIC, Origin.SPANISH);
    private final String name;
    private final Images image;
    private final ArrayList<Origin> origins = new ArrayList<>();

    /**
     * Create an instance of SkinEnum
     * @param name The SkinEnum's name
     * @param image The SkinEnum's corresponding Images instance
     * @param origin All the possible SkinEnum's Origins
     */
    SkinEnum(String name, Images image, @NotNull Origin... origin){
        this.name = name;
        this.image = image;
        this.origins.addAll(Arrays.asList(origin));
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
    public ArrayList<Origin> getOrigin() {
        return origins;
    }

    /**
     * Send all the corresponding assets from the enum depending on the Origin param
     * @param origin The character's Origin
     * @return The corresponding assets
     */
    public static ArrayList<SkinEnum> getAllOriginAssets(Origin origin){
        ArrayList<SkinEnum> assets = new ArrayList<>();

        for(SkinEnum skin : SkinEnum.values()){
            for(Origin o : skin.origins) {
                if (o == origin)
                    assets.add(skin);
            }
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
            for(Origin o : e.origins) {
                if (o == origin)
                    assets.add(e);
            }
        }

        return assets;
    }
}