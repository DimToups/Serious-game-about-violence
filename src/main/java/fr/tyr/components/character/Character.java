package fr.tyr.components.character;

import fr.tyr.components.character.identity.Identity;
import fr.tyr.components.character.personality.Personality;
import fr.tyr.components.character.style.*;
import fr.tyr.components.character.style.enums.HairColor;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Character extends ComposedComponent{
    // Personality field
    private Personality personality = new Personality();

    //Identity field
    private Identity identity = new Identity();

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

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }


    /**
     * Send the Character's Skin
     * @return The Character's Skin
     */
    public CharacterStyle getCharacterStyle(){
        return this.characterStyle;
    }


    public void setCharacterStyle(CharacterStyle characterStyle){
        this.characterStyle = characterStyle;
        characterStyle.assemble(getPosition());
        List<GameComponent<?>> components = new ArrayList<>();
        components.add(characterStyle.getSkin());
        components.add(characterStyle.getShirt());
        components.add(characterStyle.getEyes());
        components.add(characterStyle.getHair());
        if(Objects.nonNull(characterStyle.getAdditionalComponent()))
            components.add(characterStyle.getAdditionalComponent());
        this.setFrame(components);
    }

    /**
     * Send the Character's HairColor
     * @return The Character's HairColor
     */
    public HairColor getHairColor(){
        return this.hairColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public void resize(Vector2D size) {
        super.resize(size);
    }
}
