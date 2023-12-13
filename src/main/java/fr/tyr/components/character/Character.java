package fr.tyr.components.character;

import fr.tyr.components.character.identity.enums.FirstName;
import fr.tyr.components.character.identity.enums.LastName;
import fr.tyr.components.character.identity.enums.Origin;
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
    private CommonPastFacts commonPastFact;
    private OriginPastFacts originPastFact;
    private GenderPastFacts genderPastFact;
    private SexualOrientationPastFacts sexualOrientationPastFacts;

    //Thoughts fields
    private OriginThoughts originThoughts;
    private GenderThoughts genderThoughts;
    private SexualOrientationThoughts sexualOrientationThoughts;

    //Personality fields
    private MentalStrength mentalStrength;
    private SexualOrientation sexualOrientation;

    //Identity fields
    private Origin origin;
    private FirstName firstName;
    private LastName lastName;
    private int age;

    //Style fields
    private CharacterStyle characterStyle;
    private HairColor hairColor;
    private Images special;

    /**
     * Create a Character
     * @param position The position of the component
     */
    public Character(Vector2D position) {
        super(position);
    }

    public Origin getOrigin() {
        return origin;
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
        return this.hairColor;
    }

    /**
     * Send the Character's Skin
     * @return The Character's Skin
     */
    public CharacterStyle getCharacterStyle(){
        return this.characterStyle;
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
    public SexualOrientationPastFacts getSexualOrientationPastFacts() {
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
    public void setCharacterStyle(CharacterStyle characterStyle){
        this.characterStyle = characterStyle;
        this.setFrame(characterStyle.getFrame());
    }
    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }
    public  void setFirstName(FirstName firstName){
        this.firstName = firstName;
    }
    public void setLastName(LastName lastName){
        this.lastName = lastName;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setOrigin(Origin origin){
        this.origin = origin;
    }
    public void setCommonPastFact(CommonPastFacts commonPastFact) {
        this.commonPastFact = commonPastFact;
    }
    public void setOriginPastFact(OriginPastFacts originPastFact) {
        this.originPastFact = originPastFact;
    }
    public void setGenderPastFact(GenderPastFacts genderPastFact) {
        this.genderPastFact = genderPastFact;
    }
    public void setSexualOrientationPastFacts(SexualOrientationPastFacts sexualOrientationPastFacts) {
        this.sexualOrientationPastFacts = sexualOrientationPastFacts;
    }
    public void setOriginThoughts(OriginThoughts originThoughts) {
        this.originThoughts = originThoughts;
    }
    public void setGenderThoughts(GenderThoughts genderThoughts) {
        this.genderThoughts = genderThoughts;
    }
    public void setSexualOrientationThoughts(SexualOrientationThoughts sexualOrientationThoughts) {
        this.sexualOrientationThoughts = sexualOrientationThoughts;
    }
    public void setSexualOrientation(SexualOrientation sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }
    public void setMentalStrength(MentalStrength mentalStrength) {
        this.mentalStrength = mentalStrength;
    }
}
