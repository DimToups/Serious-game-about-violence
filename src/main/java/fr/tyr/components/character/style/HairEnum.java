package fr.tyr.components.character.style;

import fr.tyr.resources.images.Images;

import java.util.ArrayList;

public enum HairEnum {
    MALE_BLACK_DISHEVELLED("male white dishevelled", HairColor.BLACK, Images.HAIR_MALE_DISHEVELLED, true);
    private final String name;
    private final HairColor color;
    private final Images image;
    private final boolean gender;
    HairEnum(String name, HairColor color, Images image, boolean gender){
        this.name = name;
        this.color = color;
        this.image = image;
        this.gender = gender;
    }
    public static ArrayList<HairEnum> getAllColoredAssets(HairColor color){
        ArrayList<HairEnum> assets = new ArrayList<>();

        for(HairEnum hair : HairEnum.values()){
            if(hair.color == color)
                assets.add(hair);
        }

        return assets;
    }
    public static ArrayList<HairEnum> getAllColoredAssets(HairColor color, ArrayList<HairEnum> hairs){
        ArrayList<HairEnum> assets = new ArrayList<>();

        for(HairEnum hair : hairs){
            if(hair.color == color)
                assets.add(hair);
        }

        return assets;
    }
    public static ArrayList<HairEnum> getAllGenderAssets(boolean gender){
        ArrayList<HairEnum> assets = new ArrayList<>();

        for(HairEnum hair : HairEnum.values()){
            if(hair.getGender() == gender)
                assets.add(hair);
        }

        return assets;
    }
    public static ArrayList<HairEnum> getAllGenderAssets(boolean gender, ArrayList<HairEnum> hairs){
        ArrayList<HairEnum> assets = new ArrayList<>();

        for(HairEnum hair : hairs){
            if(hair.getGender() == gender)
                assets.add(hair);
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
    public boolean getGender(){
        return gender;
    }
}
