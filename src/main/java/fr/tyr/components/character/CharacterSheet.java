package fr.tyr.components.character;

import fr.tyr.Main;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharacterSheet extends ComposedComponent {

    public static final Font personalityFont = new Font("Roboto", Font.PLAIN, 25);
    public static final Font contentFont = new Font("Roboto", Font.PLAIN, 18);

    private static final ImageComponent sheetBackground = new ImageComponent(Images.CHARACTER_SHEET_BACKGROUND, new Vector2D(0, 0));
    // Personality infos
    private static final TextComponent firstName = new TextComponent("", Color.BLACK, personalityFont);
    private static final TextComponent lastName = new TextComponent("", Color.BLACK, personalityFont);
    private static final TextComponent age = new TextComponent("", Color.BLACK, personalityFont);
    // Past facts
    private static final TextComponent commonPastFacts = new TextComponent("", Color.BLACK, contentFont);
    private static final TextComponent genderPastFacts = new TextComponent("", Color.BLACK, contentFont);
    private static final TextComponent originPastFacts = new TextComponent("", Color.BLACK, contentFont);
    private static final TextComponent sexualOrientationPastFacts = new TextComponent("", Color.BLACK, contentFont);
    // Thoughts
    private static final TextComponent genderThoughts = new TextComponent("", Color.BLACK, contentFont);
    private static final TextComponent originThoughts = new TextComponent("", Color.BLACK, contentFont);
    private static final TextComponent sexualOrientationThoughts = new TextComponent("", Color.BLACK, contentFont);
    static {
        sheetBackground.resize(sheetBackground.getSize().getMultiplied(0.5D), false);
    }

    private Character character;
    private Vector2D baseCharacterPosition;
    private Vector2D baseCharacterSize;

    /**
     * Create a composed component
     *
     * @param position   The position of the component
     */
    public CharacterSheet(Vector2D position) {
        super(position);
        setFrame(new ArrayList<>(List.of(sheetBackground)));
        this.setVisible(false);
    }

    public void show(Character character){
        if(Objects.nonNull(this.character))
            hide();
        this.character = character;
        baseCharacterPosition = new Vector2D(character.getPosition());
        baseCharacterSize = new Vector2D(character.getSize());
        updateCharacter();
        updateTexts();
        setFrame(new ArrayList<>(List.of(sheetBackground, character, firstName, lastName, age, commonPastFacts, genderPastFacts, originPastFacts, sexualOrientationPastFacts, genderThoughts, originThoughts, sexualOrientationThoughts)));
        refreshSize();
        this.setVisible(true);
        Main.getLogger().info("Showing character sheet for %s %s".formatted(character.getIdentity().getFirstName(), character.getIdentity().getLastName()));
    }

    private void updateCharacter(){
        character.resize(0.6);
        character.move(getPosition().getAdded(new Vector2D(12, 105)));
        character.refreshSize();
    }

    private void updateTexts(){
        firstName.move(getPosition().getAdded(new Vector2D(110, 112)));
        lastName.move(getPosition().getAdded(new Vector2D(110, 155)));
        age.move(getPosition().getAdded(new Vector2D(110, 196)));
        commonPastFacts.move(getPosition().getAdded(new Vector2D(10, 238)));
        genderPastFacts.move(getPosition().getAdded(new Vector2D(10, 280)));
        originPastFacts.move(getPosition().getAdded(new Vector2D(10, 322)));
        sexualOrientationPastFacts.move(getPosition().getAdded(new Vector2D(10, 363)));
        genderThoughts.move(getPosition().getAdded(new Vector2D(10, 405)));
        originThoughts.move(getPosition().getAdded(new Vector2D(10, 447)));
        sexualOrientationThoughts.move(getPosition().getAdded(new Vector2D(10, 488)));
        firstName.setText(character.getIdentity().getFirstName().getFirstName());
        lastName.setText(character.getIdentity().getLastName().cleanName());
        age.setText("%d ans".formatted(character.getIdentity().getAge()));
        commonPastFacts.setText(character.getPersonality().getPastFact().getCommonPastFact().getTitle());
        genderPastFacts.setText(character.getPersonality().getPastFact().getGenderPastFact().getTitle());
        originPastFacts.setText(character.getPersonality().getPastFact().getOriginPastFact().getTitle());
        sexualOrientationPastFacts.setText(character.getPersonality().getPastFact().getSexualOrientationPastFact().getTitle());
        genderThoughts.setText(character.getPersonality().getThoughts().getGenderThoughts().getTitle());
        originThoughts.setText(character.getPersonality().getThoughts().getOriginThoughts().getTitle());
        sexualOrientationThoughts.setText(character.getPersonality().getThoughts().getSexualOrientationThoughts().getTitle());
    }

    public void hide(){
        if(Objects.isNull(character))
            throw new UnsupportedOperationException("Cannot hide a character sheet if it is not shown");
        // Log resize
        character.resize(baseCharacterSize);
        character.move(baseCharacterPosition);
        character.unframe();
        Main.getLogger().info("Hiding character sheet for %s %s".formatted(character.getIdentity().getFirstName(), character.getIdentity().getLastName()));
        character = null;
        setFrame(new ArrayList<>(List.of(sheetBackground)));
        this.setVisible(false);
    }

    @Override
    public void onClick(MouseButtons button) {
        hide();
    }
}
