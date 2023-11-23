package fr.tyr.components.character.style.enums;

import fr.tyr.Main;
import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.identity.enums.Origin;
import fr.tyr.resources.images.Images;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public enum EyesEnum {
    //Male
    COMMON_MALE_BLUE("Blue", EyeColor.BLUE, Images.EYES_COMMON_MALE_BLUE, Gender.MALE, EyesEnum.getCommonEyesOrigins()),
    COMMON_MALE_LIGHT_BLUE("Light blue", EyeColor.LIGHT_BLUE, Images.EYES_COMMON_MALE_LIGHT_BLUE, Gender.MALE, EyesEnum.getCommonEyesOrigins()),
    COMMON_MALE_BROWN("brown", EyeColor.BROWN, Images.EYES_COMMON_MALE_BROWN, Gender.MALE, EyesEnum.getCommonEyesOrigins()),
    COMMON_MALE_GREEN("green", EyeColor.GREEN, Images.EYES_COMMON_MALE_GREEN, Gender.MALE, EyesEnum.getCommonEyesOrigins()),
    COMMON_MALE_YELLOW("yellow", EyeColor.YELLOW, Images.EYES_COMMON_MALE_YELLOW, Gender.MALE, EyesEnum.getCommonEyesOrigins()),
    //Female
    COMMON_FEMALE_DOUBLE_BRUSH_BLUE("female blue double brush blue", EyeColor.BLUE, Images.EYES_COMMON_FEMALE_DOUBLE_BRUSH_BLUE, Gender.FEMALE, EyesEnum.getCommonEyesOrigins()),
    COMMON_FEMALE_DOUBLE_BRUSH_LIGHT_BLUE("female blue double brush light blue", EyeColor.LIGHT_BLUE, Images.EYES_COMMON_FEMALE_DOUBLE_BRUSH_LIGHT_BLUE, Gender.FEMALE, EyesEnum.getCommonEyesOrigins()),
    COMMON_FEMALE_DOUBLE_BRUSH_BROWN("female blue double brush brown", EyeColor.BROWN, Images.EYES_COMMON_FEMALE_DOUBLE_BRUSH_BROWN, Gender.FEMALE, EyesEnum.getCommonEyesOrigins()),
    COMMON_FEMALE_DOUBLE_BRUSH_GREEN("female blue double brush green", EyeColor.GREEN, Images.EYES_COMMON_FEMALE_DOUBLE_BRUSH_GREEN, Gender.FEMALE, EyesEnum.getCommonEyesOrigins()),
    COMMON_FEMALE_DOUBLE_BRUSH_YELLOW("female blue double brush yellow", EyeColor.YELLOW, Images.EYES_COMMON_FEMALE_DOUBLE_BRUSH_YELLOW, Gender.FEMALE, EyesEnum.getCommonEyesOrigins());
    private final String name;
    private final EyeColor color;
    private final Images image;
    private final Gender gender;
    private final ArrayList<Origin> origins;

    /**
     * Create an EyesEnum instance
     * @param name The EyesEnum's name
     * @param color The EyesEnum's corresponding EyeColor instance
     * @param image The EyesEnum's corresponding Images instance
     * @param gender The EyesEnum's gender (true for male, false for female)
     * @param origins The EyesEnum's corresponding Origin instance
     */
    EyesEnum(String name, EyeColor color, Images image, Gender gender, ArrayList<Origin> origins){
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
        return Arrays.stream(values()).filter(eyes -> eyes.color == color).toList();
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the EyeColor param
     * @param color The chosen EyeColor instance
     * @param eyes The list of EyesEnum to process
     * @return The corresponding assets
     */
    public static List<EyesEnum> getAllColoredAssets(EyeColor color, List<EyesEnum> eyes){
        return new ArrayList<>(eyes).stream().filter(eyesEnum -> eyesEnum.color == color).toList();
    }

    /**
     * Send all the corresponding assets from the enum depending on the gender param
     * @param gender The chosen gender (true for male, false for female)
     * @return The corresponding assets
     */
    public static List<EyesEnum> getAllGenderAssets(Gender gender){
        return Arrays.stream(values()).filter(fn -> fn.gender == gender).toList();
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the gender param
     * @param gender The chosen gender (true for male, false for female)
     * @param eyes The list of EyesEnum to process
     * @return The corresponding assets
     */
    public static List<EyesEnum> getAllGenderAssets(Gender gender, List<EyesEnum> eyes){
        return new ArrayList<>(eyes).stream().filter(fn -> fn.getGender() == gender).toList();
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
        return new ArrayList<>(eyes).stream().filter(eyesEnum -> eyesEnum.origins.contains(origin)).toList();
    }

    /**
     * Send the EyesEnum's name
     * @return The EyesEnum's name
     */
    public String getName() {
        return name;
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
    public Gender getGender(){
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
        Optional<EyesEnum> eyesEnumOptional = Arrays.stream(values()).filter(fn -> image.toString().contains(fn.toString())).findFirst();
        if(eyesEnumOptional.isEmpty()){
            Main.getLogger().log(Level.SEVERE, "No eyes has been associated with \"" + image.name() + "\"");
            return null;
        }
        return eyesEnumOptional.get();
    }
}
