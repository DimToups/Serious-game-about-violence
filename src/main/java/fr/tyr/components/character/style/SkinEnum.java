package fr.tyr.components.character.style;

import fr.tyr.components.character.identity.Origin;
import fr.tyr.resources.images.Images;

import java.util.ArrayList;

public enum SkinEnum {
    WHITE("white", Images.SKIN_WHITE, Origin.FRENCH);
    private final String name;
    private final Images image;
    private final Origin origin;
    SkinEnum(String name, Images image, Origin origin){
        this.name = name;
        this.image = image;
        this.origin = origin;
    }
    public String getName() {
        return this.name;
    }
    public Images getImage() {
        return image;
    }
    public Origin getOrigin() {
        return origin;
    }

    public static ArrayList<SkinEnum> getAllOriginAssets(Origin origin){
        ArrayList<SkinEnum> assets = new ArrayList<>();

        for(SkinEnum skin : SkinEnum.values()){
            if(skin.origin == origin)
                assets.add(skin);
        }

        return assets;
    }
    public static ArrayList<SkinEnum> getAllOriginAssets(Origin origin, ArrayList<SkinEnum> skin){
        ArrayList<SkinEnum> assets = new ArrayList<>();

        for(SkinEnum e : skin){
            if(e.origin == origin)
                assets.add(e);
        }

        return assets;
    }
}