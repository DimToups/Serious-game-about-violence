package fr.tyr.components.character;

import fr.tyr.components.character.identity.enums.FirstName;
import fr.tyr.components.character.identity.enums.LastName;
import fr.tyr.components.character.style.*;
import fr.tyr.components.character.style.enums.HairColor;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

public abstract class Character extends ComposedComponent{
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
     */
    public Character(Vector2D position, Skin skin, Hair hair, Eyes eyes, Shirt shirt, FirstName firstName, LastName lastName, int age) {
        super(position, skin, hair, eyes, shirt);

        //Attribution of the character's chosen skin in its fields
        this.skin = skin;
        this.hair = hair;
        this.eyes = eyes;
        this.shirt = shirt;

        //Attribution of the character's identity
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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
}
