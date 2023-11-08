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

    /**
     * Create an EyesEnum instance
     * @param name The EyesEnum's name
     * @param color The EyesEnum's corresponding EyeColor instance
     * @param image The EyesEnum's corresponding Images instance
     * @param gender The EyesEnum's gender (true for male, false for female)
     * @param origin The EyesEnum's corresponding Origin instance
     */
    EyesEnum(String name, EyeColor color, Images image, boolean gender, Origin origin){
        this.name = name;
        this.color = color;
        this.image = image;
        this.gender = gender;
        this.origin = origin;
    }

    /**
     * Send all the corresponding assets from the enum depending on the EyeColor param
     * @param color The chosen EyeColor instance
     * @return The corresponding assets
     */
    public static ArrayList<EyesEnum> getAllColoredAssets(EyeColor color){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum eyes : EyesEnum.values()){
            if(eyes.color == color)
                assets.add(eyes);
        }

        return assets;
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the EyeColor param
     * @param color The chosen EyeColor instance
     * @param eyes The list of EyesEnum to process
     * @return The corresponding assets
     */
    public static ArrayList<EyesEnum> getAllColoredAssets(EyeColor color, ArrayList<EyesEnum> eyes){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum e : eyes){
            if(e.color == color)
                assets.add(e);
        }

        return assets;
    }

    /**
     * Send all the corresponding assets from the enum depending on the gender param
     * @param gender The chosen gender (true for male, false for female)
     * @return The corresponding assets
     */
    public static ArrayList<EyesEnum> getAllGenderAssets(boolean gender){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum eyes : EyesEnum.values()){
            if(eyes.gender == gender)
                assets.add(eyes);
        }

        return assets;
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the gender param
     * @param gender The chosen gender (true for male, false for female)
     * @param eyes The list of EyesEnum to process
     * @return The corresponding assets
     */
    public static ArrayList<EyesEnum> getAllGenderAssets(boolean gender, ArrayList<EyesEnum> eyes){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum e : eyes){
            if(e.gender == gender)
                assets.add(e);
        }

        return assets;
    }

    /**
     * Send all the corresponding assets from the enum depending on the Origin param
     * @param origin The chosen Origin
     * @return The corresponding assets
     */
    public static ArrayList<EyesEnum> getAllOriginAssets(Origin origin){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum eyes : EyesEnum.values()){
            if(eyes.origin == origin)
                assets.add(eyes);
        }

        return assets;
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the Origin param
     * @param origin The chosen Origin
     * @param eyes The list of EyesEnum to process
     * @return The corresponding assets
     */
    public static ArrayList<EyesEnum> getAllOriginAssets(Origin origin, ArrayList<EyesEnum> eyes){
        ArrayList<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum e : eyes){
            if(e.origin == origin)
                assets.add(e);
        }

        return assets;
    }

    /**
     * Send the EyesEnum's name
     * @return The EyesEnum's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Send the EyesEnum's color
     * @return The EyesEnum's color
     */
    public EyeColor getColor() {
        return color;
    }

    /**
     * Send the EyesEnum's Images instance
     * @return The EyesEnum's Images instance
     */
    public Images getImage() {
        return image;
    }

    /**
     * Send the EyesEnum's gender (true for male, false for female)
     * @return The EyesEnum's gender
     */
    public boolean getGender(){
        return gender;
    }

    /**
     * Send the EyesEnum's Origin
     * @return The EyesEnum's Origin
     */
    public Origin getOrigin(){
        return origin;
    }
}
