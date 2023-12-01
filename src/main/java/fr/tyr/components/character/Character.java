package fr.tyr.components.character;

import fr.tyr.components.character.identity.enums.FirstName;
import fr.tyr.components.character.identity.enums.LastName;
import fr.tyr.components.character.personality.enums.SexualOrientation;
import fr.tyr.components.character.personality.enums.thought.GenderThoughts;
import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.enums.thought.OriginThoughts;
import fr.tyr.components.character.personality.enums.thought.SexualOrientationThoughts;
import fr.tyr.components.character.personality.enums.pastFact.CommonPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.GenderPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.OriginPastFacts;
import fr.tyr.components.character.personality.enums.pastFact.SexualOrientationPastFacts;
import fr.tyr.components.character.style.*;
import fr.tyr.components.character.style.enums.HairColor;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public abstract class Character extends ComposedComponent{
    //Past facts fields
    private final CommonPastFacts commonPastFact;
    private final OriginPastFacts originPastFact;
    private final GenderPastFacts genderPastFact;
    private final SexualOrientationPastFacts sexualOrientationPastFacts;

    //Thoughts fields
    private final OriginThoughts originThoughts;
    private final GenderThoughts genderThoughts;
    private final SexualOrientationThoughts sexualOrientationThoughts;

    //Personality fields
    private final MentalStrength mentalStrength;
    private final SexualOrientation sexualOrientation;

    //Identity fields
    private final FirstName firstName;
    private final LastName lastName;
    private final int age;

    //Style fields
    private final Skin skin;
    private final Hair hair;
    private final Eyes eyes;
    private final Shirt shirt;
    private Images special;

    /**
     * Create a Character
     * @param position The position of the component
     * @param skin The character's skin
     * @param hair The character's hair
     * @param eyes The character's eyes
     * @param shirt The character's shirt
     * @param firstName The character's firstname
     * @param lastName The character's lastname
     * @param age The character's age
     * @param commonPastFact A common past fact on the character
     * @param originPastFact A origin based past fact on the character
     * @param genderPastFact A gender based past fact on the character
     * @param stylePastFact A style based past fact on the character
     * @param mentalStrength The character's mentalStrength
     * @param originThoughts The character's thoughts on origins
     * @param genderThoughts The character's thoughts on genders
     * @param sexualOrientationThoughts The character's thoughts on style
     */
    public Character(Vector2D position, Skin skin, Hair hair, Eyes eyes, Shirt shirt, FirstName firstName, LastName lastName, int age, CommonPastFacts commonPastFact, OriginPastFacts originPastFact, GenderPastFacts genderPastFact, SexualOrientationPastFacts stylePastFact, MentalStrength mentalStrength, SexualOrientation sexualOrientation, OriginThoughts originThoughts, GenderThoughts genderThoughts, SexualOrientationThoughts sexualOrientationThoughts) {
        super(position, skin, hair, eyes, shirt);

        //Attribution of the character's chosen style in its fields
        this.skin = skin;
        this.hair = hair;
        this.eyes = eyes;
        this.shirt = shirt;

        //Attribution of the character's identity
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        //Attribution of the character's past facts
        this.commonPastFact = commonPastFact;
        this.originPastFact = originPastFact;
        this.genderPastFact = genderPastFact;
        this.sexualOrientationPastFacts = stylePastFact;

        //Attribution of the character's personality
        this.mentalStrength = mentalStrength;
        this.sexualOrientation = sexualOrientation;

        //Attribution of the character's thoughts
        this.originThoughts = originThoughts;
        this.genderThoughts = genderThoughts;
        this.sexualOrientationThoughts = sexualOrientationThoughts;
    }

    /**
     * Send the Character's FirstName
     * @return The Character's FirstName
     */
    public FirstName getFirstName(){
        return this.firstName;
    }

    /**
     * Send the Character's LastName
     * @return The Character's LastName
     */
    public LastName getLastName() {
        return this.lastName;
    }

    /**
     * Send the Character's age
     * @return The Character's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Send the Character's HairColor
     * @return The Character's HairColor
     */
    public HairColor getHairColor(){
        return this.hair.getColor();
    }

    /**
     * Send the Character's Skin
     * @return The Character's Skin
     */
    public Skin getSkin() {
        return this.skin;
    }

    /**
     * Send the Character's Hair
     * @return The Character's Hair
     */
    public Hair getHair() {
        return this.hair;
    }

    /**
     * Send the Character's Eyes
     * @return The Character's Eyes
     */
    public Eyes getEyes() {
        return this.eyes;
    }

    /**
     * Send the Character's Shirt
     * @return The Character's Shirt
     */
    public Shirt getShirt() {
        return this.shirt;
    }

    /**
     * Send the character's common past fact
     * @return The character's common past fact
     */
    public CommonPastFacts getCommonPastFact() {
        return commonPastFact;
    }

    /**
     * Send the character's origin based past fact
     * @return The character's origin based past fact
     */
    public OriginPastFacts getOriginPastFact() {
        return originPastFact;
    }

    /**
     * Send the character's gender based past fact
     * @return The character's gender based past fact
     */
    public GenderPastFacts getGenderPastFact() {
        return genderPastFact;
    }

    /**
     * Send the character's style based past fact
     * @return The character's style based past fact
     */
    public SexualOrientationPastFacts getStylePastFacts() {
        return sexualOrientationPastFacts;
    }

    /**
     * Send the character's mental strength
     * @return The character's mental strength
     */
    public MentalStrength getMentalStrength() {
        return mentalStrength;
    }

    /**
     * Send the character's sexual orientation
     * @return The character's sexual orientation
     */
    public SexualOrientation getSexualOrientation() {
        return sexualOrientation;
    }

    /**
     * Send the Character's thoughts on origins
     * @return The Character's thoughts on origins
     */
    public OriginThoughts getOriginThoughts() {
        return originThoughts;
    }

    /**
     * Send the Character's thoughts on genders
     * @return The Character's thoughts on genders
     */
    public GenderThoughts getGenderThoughts() {
        return genderThoughts;
    }

    /**
     * Send the Character's thoughts on style
     * @return The Character's thoughts on style
     */
    public SexualOrientationThoughts getSexualOrientationThoughts() {
        return sexualOrientationThoughts;
    }
}
