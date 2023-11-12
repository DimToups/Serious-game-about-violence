package fr.tyr.components.character.style;

import fr.tyr.resources.images.Images;

import java.util.ArrayList;

public enum HairEnum {
    //without gender
    NONE("none", HairColor.BLACK, Images.NONE, true),

    //female

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
     * @param gender THe HairEnum's prefered gender (true for male, false for female)
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
    public static ArrayList<HairEnum> getAllColoredAssets(HairColor color){
        ArrayList<HairEnum> assets = new ArrayList<>();

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
    public static ArrayList<HairEnum> getAllColoredAssets(HairColor color, ArrayList<HairEnum> hairs){
        ArrayList<HairEnum> assets = new ArrayList<>();

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
    public static ArrayList<HairEnum> getAllGenderAssets(boolean gender){
        ArrayList<HairEnum> assets = new ArrayList<>();

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
    public static ArrayList<HairEnum> getAllGenderAssets(boolean gender, ArrayList<HairEnum> hairs){
        ArrayList<HairEnum> assets = new ArrayList<>();

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
}
