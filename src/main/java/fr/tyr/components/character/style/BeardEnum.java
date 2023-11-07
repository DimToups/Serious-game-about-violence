package fr.tyr.components.character.style;

import fr.tyr.resources.images.Images;

import java.util.ArrayList;

public enum BeardEnum {
    // ATTENTION!!! LE PARAMETRE "null" DE NONE DOIT ETRE CHANGE PAR UNE INSTANCE D'IMAGE VIDE
    NONE("none", HairColor.BLACK, Images.NONE);
    private final String name;
    private final HairColor color;
    private final Images image;
    BeardEnum(String name, HairColor color, Images image){
        this.name = name;
        this.color = color;
        this.image = image;
    }
    public static ArrayList<BeardEnum> getAllColoredAssets(HairColor color){
        ArrayList<BeardEnum> assets = new ArrayList<>();

        for(BeardEnum beard : BeardEnum.values()){
            if(beard.color == color)
                assets.add(beard);
        }

        return assets;
    }
    public static ArrayList<BeardEnum> getAllColoredAssets(HairColor color, ArrayList<BeardEnum> beards){
        ArrayList<BeardEnum> assets = new ArrayList<>();

        for(BeardEnum beard : beards){
            if(beard.color == color)
                assets.add(beard);
        }

        return assets;
    }
    public String getName() {
        return this.name;
    }
    public HairColor getColor() {
        return color;
    }
    public Images getImage() {
        return image;
    }
}
