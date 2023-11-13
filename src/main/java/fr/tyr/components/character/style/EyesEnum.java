package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.components.character.identity.Origin;
import fr.tyr.resources.images.Images;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public enum EyesEnum {
    //Male
    COMMON_MALE_BLUE("Blue", EyeColor.BLUE, Images.EYES_COMMON_MALE_BLUE, true, EyesEnum.getCommonEyesOrigins()),
    COMMON_MALE_LIGHT_BLUE("Light blue", EyeColor.LIGHT_BLUE, Images.EYES_COMMON_MALE_LIGHT_BLUE, true, EyesEnum.getCommonEyesOrigins()),
    COMMON_MALE_BROWN("brown", EyeColor.BROWN, Images.EYES_COMMON_MALE_BROWN, true, EyesEnum.getCommonEyesOrigins()),
    COMMON_MALE_GREEN("green", EyeColor.GREEN, Images.EYES_COMMON_MALE_GREEN, true, EyesEnum.getCommonEyesOrigins()),
    COMMON_MALE_YELLOW("yellow", EyeColor.YELLOW, Images.EYES_COMMON_MALE_YELLOW, true, EyesEnum.getCommonEyesOrigins()),
    //Female
    COMMON_FEMALE_DOUBLE_BRUSH_BLUE("female blue double brush blue", EyeColor.BLUE, Images.EYES_COMMON_FEMALE_DOUBLE_BRUSH_BLUE, false, EyesEnum.getCommonEyesOrigins()),
    COMMON_FEMALE_DOUBLE_BRUSH_LIGHT_BLUE("female blue double brush light blue", EyeColor.LIGHT_BLUE, Images.EYES_COMMON_FEMALE_DOUBLE_BRUSH_LIGHT_BLUE, false, EyesEnum.getCommonEyesOrigins()),
    COMMON_FEMALE_DOUBLE_BRUSH_BROWN("female blue double brush brown", EyeColor.BROWN, Images.EYES_COMMON_FEMALE_DOUBLE_BRUSH_BROWN, false, EyesEnum.getCommonEyesOrigins()),
    COMMON_FEMALE_DOUBLE_BRUSH_GREEN("female blue double brush green", EyeColor.GREEN, Images.EYES_COMMON_FEMALE_DOUBLE_BRUSH_GREEN, false, EyesEnum.getCommonEyesOrigins()),
    COMMON_FEMALE_DOUBLE_BRUSH_YELLOW("female blue double brush yellow", EyeColor.YELLOW, Images.EYES_COMMON_FEMALE_DOUBLE_BRUSH_YELLOW, false, EyesEnum.getCommonEyesOrigins());
    private final String name;
    private final EyeColor color;
    private final Images image;
    private final boolean gender;
    private final ArrayList<Origin> origins;

    /**
     * Create an EyesEnum instance
     * @param name The EyesEnum's name
     * @param color The EyesEnum's corresponding EyeColor instance
     * @param image The EyesEnum's corresponding Images instance
     * @param gender The EyesEnum's gender (true for male, false for female)
     * @param origins The EyesEnum's corresponding Origin instance
     */
    EyesEnum(String name, EyeColor color, Images image, boolean gender, ArrayList<Origin> origins){
        this.name = name;
        this.color = color;
        this.image = image;
        this.gender = gender;
        this.origins = origins;
    }

    /**
     * Send all the corresponding assets from the enum depending on the EyeColor param
     * @param color The chosen EyeColor instance
     * @return The corresponding assets
     */
    public static List<EyesEnum> getAllColoredAssets(EyeColor color){
        List<EyesEnum> assets = new ArrayList<>();

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
    public static List<EyesEnum> getAllColoredAssets(EyeColor color, List<EyesEnum> eyes){
        List<EyesEnum> assets = new ArrayList<>();

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
    public static List<EyesEnum> getAllGenderAssets(boolean gender){
        List<EyesEnum> assets = new ArrayList<>();

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
    public static List<EyesEnum> getAllGenderAssets(boolean gender, List<EyesEnum> eyes){
        List<EyesEnum> assets = new ArrayList<>();

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
    public static List<EyesEnum> getAllOriginAssets(Origin origin){
        List<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum eyes : EyesEnum.values()){
            for(Origin o : eyes.origins) {
                if (o == origin)
                    assets.add(eyes);
            }
        }

        return assets;
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the Origin param
     * @param origin The chosen Origin
     * @param eyes The list of EyesEnum to process
     * @return The corresponding assets
     */
    public static List<EyesEnum> getAllOriginAssets(Origin origin, List<EyesEnum> eyes){
        List<EyesEnum> assets = new ArrayList<>();

        for(EyesEnum e : eyes){
            for(Origin o : e.origins) {
                if (o == origin)
                    assets.add(e);
            }
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
    public ArrayList<Origin> getOrigins(){
        return origins;
    }

    /**
     * Send all the possible origins for common eyes
     * @return All the origins for common eyes
     */
    public static ArrayList<Origin> getCommonEyesOrigins(){
        return new ArrayList<>(Arrays.asList(Origin.AMERICAN, Origin.FRENCH, Origin.ARABIC, Origin.SPANISH, Origin.RUSSIAN, Origin.AFRICAN));
    }

    /**
     * Send all the possible origins for slant eyes
     * @return All the origins for slant eyes
     */
    public static List<Origin> getAsianEyesOrigins(){
        return new ArrayList<>(Arrays.asList(Origin.RUSSIAN, Origin.ASIAN));
    }
    /**
     * Return the corresponding EyesEnum depending on the Images param
     * @param image The Images to focus the search on
     * @return A EyesEnum corresponding to the Images param
     */
    public static EyesEnum getEyesEnum(Images image){
        for(EyesEnum eyes : EyesEnum.values()){
            if(image.toString().contains(eyes.toString()))
                return eyes;
        }
        Main.getLogger().log(Level.SEVERE, "No eyes has been associated with \"" + image.name() + "\"");
        return null;
    }
}
