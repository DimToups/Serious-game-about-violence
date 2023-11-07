package fr.tyr.components.character.style;

import fr.tyr.components.character.identity.Origin;
import fr.tyr.resources.images.Images;

import java.util.ArrayList;

public enum EyesEnum {
    WHITE_MALE_BLUE("Blue", EyeColor.BLUE, Images.EYES_MALE_BLUE, true, Origin.FRENCH);
    private final String name;
    private final EyeColor color;
    private final Images image;
    private final boolean gender;
    private final Origin origin;
    EyesEnum(String name, EyeColor color, Images image, boolean gender, Origin origin){
        this.name = name;
        this.color = color;
        this.image = image;
        this.gender = gender;
        this.origin = origin;
    }
    public static ArrayList<EyesEnum> getAllColoredAssets(EyeColor color){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum eyes : EyesEnum.values()){
            if(eyes.color == color)
                assets.add(eyes);
        }

        return assets;
    }
    public static ArrayList<EyesEnum> getAllColoredAssets(EyeColor color, ArrayList<EyesEnum> eyes){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum e : eyes){
            if(e.color == color)
                assets.add(e);
        }

        return assets;
    }
    public static ArrayList<EyesEnum> getAllGenderAssets(boolean gender){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum eyes : EyesEnum.values()){
            if(eyes.gender == gender)
                assets.add(eyes);
        }

        return assets;
    }
    public static ArrayList<EyesEnum> getAllGenderAssets(boolean gender, ArrayList<EyesEnum> eyes){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum e : eyes){
            if(e.gender == gender)
                assets.add(e);
        }

        return assets;
    }
    public static ArrayList<EyesEnum> getAllOriginAssets(Origin origin){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum eyes : EyesEnum.values()){
            if(eyes.origin == origin)
                assets.add(eyes);
        }

        return assets;
    }
    public static ArrayList<EyesEnum> getAllOriginAssets(Origin origin, ArrayList<EyesEnum> eyes){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum e : eyes){
            if(e.origin == origin)
                assets.add(e);
        }

        return assets;
    }
    public String getName() {
        return this.name;
    }
    public EyeColor getColor() {
        return color;
    }
    public Images getImage() {
        return image;
    }
    public boolean getGender(){
        return gender;
    }
    public Origin getOrigin(){
        return origin;
    }
}
