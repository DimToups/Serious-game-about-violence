package fr.tyr.components.character.style;

import fr.tyr.Main;
import fr.tyr.resources.images.Images;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public enum HairEnum {
    //without gender
    NONE("none", HairColor.BLACK, Images.NONE, true),

    //female
    MID_LENGHT_BLACK("female black mid-lenght", HairColor.BLACK, Images.HAIR_MID_LENGTH_BLACK, false),
    MID_LENGHT_DARK_BROWN("female dark brown mid-lenght", HairColor.DARK_BROWN, Images.HAIR_MID_LENGTH_DARK_BROWN, false),
    MID_LENGHT_BROWN("female brown mid-lenght", HairColor.BROWN, Images.HAIR_MID_LENGTH_BROWN, false),
    MID_LENGHT_BLOND("female blond mid-lenght", HairColor.BLOND, Images.HAIR_MID_LENGTH_BLOND, false),
    MID_LENGHT_WHITE("female white mid-lenght", HairColor.WHITE, Images.HAIR_MID_LENGTH_WHITE, false),
    MID_LENGHT_GINGER("female ginger mid-lenght", HairColor.GINGER, Images.HAIR_MID_LENGTH_GINGER, false),
    MID_LENGHT_BLUE("female blue mid-lenght", HairColor.BLUE, Images.HAIR_MID_LENGTH_BLUE, false),
    MID_LENGHT_PINK("female pink mid-lenght", HairColor.PINK, Images.HAIR_MID_LENGTH_PINK, false),
    //male
    BLACK_DISHEVELLED("male black dishevelled", HairColor.BLACK, Images.HAIR_MALE_DISHEVELLED, true),
    BOWL_BLACK("male white dishevelled", HairColor.BLACK, Images.HAIR_BOWL_BLACK, true),
    BOWL_DARK_BROWN("male white dishevelled", HairColor.DARK_BROWN, Images.HAIR_BOWL_DARK_BROWN, true),
    BOWL_BROWN("male white dishevelled", HairColor.BROWN, Images.HAIR_BOWL_BROWN, true),
    BOWL_BLOND("male white dishevelled", HairColor.BLOND, Images.HAIR_BOWL_BLOND, true),
    BOWL_WHITE("male white dishevelled", HairColor.WHITE, Images.HAIR_BOWL_WHITE, true),
    BOWL_GINGER("male white dishevelled", HairColor.GINGER, Images.HAIR_BOWL_GINGER, true),
    BOWL_BLUE("male white dishevelled", HairColor.BLUE, Images.HAIR_BOWL_BLUE, true),
    BOWL_PINK("male white dishevelled", HairColor.PINK, Images.HAIR_BOWL_PINK, true);
    private final String name;
    private final HairColor color;
    private final Images image;
    private final boolean gender;

    /**
     * Create an instance of HairEnum
     * @param name The name of the haircut
     * @param color The HairEnum's hairColor
     * @param image The HairEnum's corresponding Images instance
     * @param gender THe HairEnum's preferred gender (true for male, false for female)
     */
    HairEnum(String name, HairColor color, Images image, boolean gender){
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
        List<HairEnum> assets = new ArrayList<>();

        for(HairEnum hair : HairEnum.values()){
            if(hair.color == color)
                assets.add(hair);
        }

        return assets;
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the HairColor param
     * @param color The chosen HairColor instance
     * @param hairs The list of HairEnum to process
     * @return The corresponding assets
     */
    public static List<HairEnum> getAllColoredAssets(HairColor color, List<HairEnum> hairs){
        List<HairEnum> assets = new ArrayList<>();

        for(HairEnum hair : hairs){
            if(hair.color == color)
                assets.add(hair);
        }

        return assets;
    }

    /**
     * Send all the corresponding assets from the enum depending on the gender param
     * @param gender The chosen gender (true for male, false for female)
     * @return The corresponding assets
     */
    public static List<HairEnum> getAllGenderAssets(boolean gender){
        List<HairEnum> assets = new ArrayList<>();

        for(HairEnum hair : HairEnum.values()){
            if(hair.getGender() == gender)
                assets.add(hair);
        }

        return assets;
    }

    /**
     * Send all the corresponding assets from the ArrayList param depending on the gender param
     * @param gender The chosen gender (true for male, false for female)
     * @param hairs The list of HairEnum to process
     * @return The corresponding assets
     */
    public static List<HairEnum> getAllGenderAssets(boolean gender, List<HairEnum> hairs){
        List<HairEnum> assets = new ArrayList<>();

        for(HairEnum hair : hairs){
            if(hair.getGender() == gender)
                assets.add(hair);
        }

        return assets;
    }

    /**
     * Send the HairEnum's name
     * @return The HairEnum's name
     */
    public String getName() {
        return this.name;
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
    public boolean getGender(){
        return gender;
    }

    /**
     * Return the corresponding HairEnum depending on the Images param
     * @param image The Images to focus the search on
     * @return A HairEnum corresponding to the Images param
     */
    public static HairEnum getHairEnum(Images image){
        for(HairEnum hair : HairEnum.values()){
            if(image.toString().contains(hair.toString()))
                return hair;
        }
        Main.getLogger().log(Level.SEVERE, "No hair has been associated with \"" + image.name() + "\"");
        return null;
    }
}
