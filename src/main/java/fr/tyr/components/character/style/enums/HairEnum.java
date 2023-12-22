package fr.tyr.components.character.style.enums;

import fr.tyr.Main;
import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.resources.images.Images;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public enum HairEnum {
    //without gender
    NONE("none", HairColor.BLACK, Images.NONE, Gender.UNKNOWN),

    //female
    MID_LENGHT_BLACK("female black mid-lenght", HairColor.BLACK, Images.HAIR_MID_LENGTH_BLACK, Gender.FEMALE),
    MID_LENGHT_DARK_BROWN("female dark brown mid-lenght", HairColor.DARK_BROWN, Images.HAIR_MID_LENGTH_DARK_BROWN, Gender.FEMALE),
    MID_LENGHT_BROWN("female brown mid-lenght", HairColor.BROWN, Images.HAIR_MID_LENGTH_BROWN, Gender.FEMALE),
    MID_LENGHT_BLOND("female blond mid-lenght", HairColor.BLOND, Images.HAIR_MID_LENGTH_BLOND, Gender.FEMALE),
    MID_LENGHT_WHITE("female white mid-lenght", HairColor.WHITE, Images.HAIR_MID_LENGTH_WHITE, Gender.FEMALE),
    MID_LENGHT_GINGER("female ginger mid-lenght", HairColor.GINGER, Images.HAIR_MID_LENGTH_GINGER, Gender.FEMALE),
    MID_LENGHT_BLUE("female blue mid-lenght", HairColor.BLUE, Images.HAIR_MID_LENGTH_BLUE, Gender.FEMALE),
    MID_LENGHT_PINK("female pink mid-lenght", HairColor.PINK, Images.HAIR_MID_LENGTH_PINK, Gender.FEMALE),
    //male
    BOWL_BLACK("male black bowl", HairColor.BLACK, Images.HAIR_BOWL_BLACK, Gender.MALE),
    BOWL_DARK_BROWN("male dark brown bowl", HairColor.DARK_BROWN, Images.HAIR_BOWL_DARK_BROWN, Gender.MALE),
    BOWL_BROWN("male black bowl", HairColor.BROWN, Images.HAIR_BOWL_BROWN, Gender.MALE),
    BOWL_BLOND("male blond bowl", HairColor.BLOND, Images.HAIR_BOWL_BLOND, Gender.MALE),
    BOWL_WHITE("male white bowl", HairColor.WHITE, Images.HAIR_BOWL_WHITE, Gender.MALE),
    BOWL_GINGER("male ginger bowl", HairColor.GINGER, Images.HAIR_BOWL_GINGER, Gender.MALE),
    BOWL_BLUE("male blue bowl", HairColor.BLUE, Images.HAIR_BOWL_BLUE, Gender.MALE),
    BOWL_PINK("male pink bowl", HairColor.PINK, Images.HAIR_BOWL_PINK, Gender.MALE),
    ;
    private final String name;
    private final HairColor color;
    private final Images image;
    private final Gender gender;

    /**
     * Create an instance of HairEnum
     * @param name The name of the haircut
     * @param color The HairEnum's hairColor
     * @param image The HairEnum's corresponding Images instance
     * @param gender THe HairEnum's preferred gender (true for male, false for female)
     */
    HairEnum(String name, HairColor color, Images image, Gender gender){
        this.name = name;
        this.color = color;
        this.image = image;
        this.gender = gender;
    }

    /**
     * Send all the corresponding assets from the enum depending on the HairColor param
     * @param color The chosen HairColor instance
     * @return The corresponding assets
     */
    public static List<HairEnum> getAllColoredAssets(HairColor color){
        return Arrays.stream(values()).filter(hair -> hair.color == color).toList();
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the HairColor param
     * @param color The chosen HairColor instance
     * @param hairs The list of HairEnum to process
     * @return The corresponding assets
     */
    public static List<HairEnum> getAllColoredAssets(HairColor color, List<HairEnum> hairs){
        return new ArrayList<>(hairs).stream().filter(hair -> hair.color == color).toList();
    }

    /**
     * Send all the corresponding assets from the enum depending on the gender param
     * @param gender The chosen gender (true for male, false for female)
     * @return The corresponding assets
     */
    public static List<HairEnum> getAllGenderAssets(Gender gender){
        return Arrays.stream(values()).filter(hair -> hair.gender == gender).toList();
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the gender param
     * @param gender The chosen gender (true for male, false for female)
     * @param hairs The list of HairEnum to process
     * @return The corresponding assets
     */
    public static List<HairEnum> getAllGenderAssets(Gender gender, List<HairEnum> hairs){
        return new ArrayList<>(hairs).stream().filter(hair -> hair.getGender() == gender).toList();
    }

    /**
     * Send the HairEnum's name
     * @return The HairEnum's name
     */
    public String getName() {
        return name;
    }

    /**
     * Send the HairEnum's HairColor
     * @return the HairEnum's HairColor
     */
    public HairColor getColor() {
        return color;
    }

    /**
     * Send the HairEnum's corresponding Images instance
     * @return the HairEnum's Images
     */
    public Images getImage() {
        return image;
    }

    /**
     * Send the HairEnum's gender
     * @return The HairEnum's gender
     */
    public Gender getGender(){
        return gender;
    }

    /**
     * Return the corresponding HairEnum depending on the Images param
     * @param image The Images to focus the search on
     * @return A HairEnum corresponding to the Images param
     */
    public static HairEnum getHairEnum(Images image){
        Optional<HairEnum> hairEnumOptional = Arrays.stream(values()).filter(hair -> image.toString().contains(hair.toString())).findFirst();
        if(hairEnumOptional.isEmpty()){
            Main.getLogger().log(Level.SEVERE, "No hair has been associated with \"" + image.name() + "\"");
            return null;
        }
        return hairEnumOptional.get();
    }
}
