package fr.tyr.components.character;

import fr.tyr.Main;
import fr.tyr.components.classic.GameComponent;
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
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

public class CharacterSheet extends ComposedComponent {

    // Fonts
    public static final Font personalityFont = new Font("Roboto", Font.PLAIN, 25);
    public static final Font contentFont = new Font("Roboto", Font.PLAIN, 12);

    private static ImageComponent sheetBackground = new ImageComponent(Images.CHARACTER_SHEET_BACKGROUND, new Vector2D(0, 0));
    // Personality infos
    private final TextComponent firstName = new TextComponent("", Color.BLACK, personalityFont);
    private final TextComponent lastName = new TextComponent("", Color.BLACK, personalityFont);
    private final TextComponent age = new TextComponent("", Color.BLACK, personalityFont);
    // Past facts
    private final TextComponent commonPastFacts = new TextComponent("", Color.BLACK, contentFont);
    private final TextComponent genderPastFacts = new TextComponent("", Color.BLACK, contentFont);
    private final TextComponent originPastFacts = new TextComponent("", Color.BLACK, contentFont);
    private final TextComponent sexualOrientationPastFacts = new TextComponent("", Color.BLACK, contentFont);
    // Thoughts
    private final TextComponent genderThoughts = new TextComponent("", Color.BLACK, contentFont);
    private final TextComponent originThoughts = new TextComponent("", Color.BLACK, contentFont);
    private final TextComponent sexualOrientationThoughts = new TextComponent("", Color.BLACK, contentFont);

    private final List<TextComponent> factsAndThoughts = new ArrayList<>(List.of(commonPastFacts, genderPastFacts, originPastFacts, sexualOrientationPastFacts, genderThoughts, originThoughts, sexualOrientationThoughts));

    private final Vector2D sheetPosition;
    private Character character;
    private Vector2D baseCharacterPosition;
    private Vector2D baseCharacterSize;
    private boolean isMoving = false;

    /**
     * Create a composed component
     *
     * @param position   The position of the component
     */
    public CharacterSheet(Vector2D position) {
        super(position);
        sheetBackground.resize(sheetBackground.getSize().getMultiplied(0.5D), false);
        sheetPosition = new Vector2D(position);
        setFrame(new ArrayList<>(List.of(sheetBackground)));
        this.setVisible(false);
    }

    public void show(Character character){
        if(isMoving)
            return;
        if(Objects.nonNull(this.character))
            hide(false);
        character.setFramed(true);
        this.character = character;
        baseCharacterPosition = new Vector2D(character.getPosition());
        baseCharacterSize = new Vector2D(character.getSize());
        Main.getGameEngine().safeListOperation(components -> components.remove(character));
        // Create sheet with all information
        setupCharacter();
        updateComponent();
        // Appearance animation
        move(new Vector2D(sheetPosition.x, 720));
        isMoving = true;
        moveTo(sheetPosition, 0.5F);
        new Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        isMoving = false;
                    }
                },
                600
        );
        this.setVisible(true);
        Main.getLogger().info("Showing character sheet for %s %s".formatted(character.getIdentity().getFirstName(), character.getIdentity().getLastName()));
    }

    private void setupCharacter(){
        character.resize(0.6);
        character.move(getPosition().getAdded(new Vector2D(12, 105)));
        character.refreshSize();
    }

    private List<TextComponent> getTextsToDisplay(){
        List<TextComponent> textComponents = new ArrayList<>();
        if(character.getPersonality().getPastFact().isCommonPastFactDiscovered())
            textComponents.add(commonPastFacts);
        if(character.getPersonality().getPastFact().isGenderPastFactDiscovered())
            textComponents.add(genderPastFacts);
        if(character.getPersonality().getPastFact().isOriginPastFactDiscovered())
            textComponents.add(originPastFacts);
        if(character.getPersonality().getPastFact().isSexualOrientationPastFactDiscovered())
            textComponents.add(sexualOrientationPastFacts);
        if(character.getPersonality().getThoughts().isGenderThoughtsDiscovered())
            textComponents.add(genderThoughts);
        if(character.getPersonality().getThoughts().isOriginThoughtsDiscovered())
            textComponents.add(originThoughts);
        if(character.getPersonality().getThoughts().isSexualOrientationThoughtsDiscovered())
            textComponents.add(sexualOrientationThoughts);
        return textComponents;
    }

    public void updateComponent(){
        setTexts();
        List<GameComponent<?>> componentsToDisplay = new ArrayList<>(List.of(sheetBackground, character, firstName, lastName, age));
        List<TextComponent> textsToDisplay = getTextsToDisplay();
        componentsToDisplay.addAll(textsToDisplay);
        setFrame(componentsToDisplay);
        refreshSize();
    }

    private void setTexts(){
        firstName.move(getPosition().getAdded(new Vector2D(110, 112)));
        lastName.move(getPosition().getAdded(new Vector2D(110, 155)));
        age.move(getPosition().getAdded(new Vector2D(110, 196)));

        // Move facts and thoughts
        AtomicInteger y = new AtomicInteger(238);
        factsAndThoughts.stream().filter(TextComponent::isVisible).forEach(textComponent -> {
            textComponent.move(getPosition().getAdded(new Vector2D(10, y.get())));
            y.addAndGet(42);
        });

        // Set facts and thoughts text content
        firstName.setText(character.getIdentity().getFirstName().getFirstName());
        lastName.setText(character.getIdentity().getLastName().cleanName());
        age.setText("%d ans".formatted(character.getIdentity().getAge()));
        commonPastFacts.setText(character.getPersonality().getPastFact().getCommonPastFact().getDescription());
        genderPastFacts.setText(character.getPersonality().getPastFact().getGenderPastFact().getDescription());
        originPastFacts.setText(character.getPersonality().getPastFact().getOriginPastFact().getDescription());
        sexualOrientationPastFacts.setText(character.getPersonality().getPastFact().getSexualOrientationPastFact().getDescription());
        genderThoughts.setText(character.getPersonality().getThoughts().getGenderThoughts().getDescription());
        originThoughts.setText(character.getPersonality().getThoughts().getOriginThoughts().getDescription());
        sexualOrientationThoughts.setText(character.getPersonality().getThoughts().getSexualOrientationThoughts().getDescription());
    }

    public void hide(boolean animate){
        if(isMoving)
            return;
        if(Objects.isNull(character))
            return;
        Main.getGameEngine().hideMemoDeck();
        Main.getGameEngine().hideViolenceDeck();
        if(animate){
            // Disappear animation
            isMoving = true;
            moveTo(new Vector2D(sheetPosition.x, 720), 0.5F);
            // Replace character on the screen after the animation
            new Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            resetSheet();
                            isMoving = false;
                        }
                    },
                    600
            );
            return;
        }
        resetSheet();
    }

    private void resetSheet(){
        resetCharacter();
        Main.getLogger().info("Hiding character sheet for %s %s".formatted(character.getIdentity().getFirstName(), character.getIdentity().getLastName()));
        character = null;
        setFrame(new ArrayList<>(List.of(sheetBackground)));
        setVisible(false);
    }

    private void resetCharacter(){
        character.resize(baseCharacterSize);
        character.move(baseCharacterPosition);
        character.setFramed(false);
        Main.getGameEngine().safeListOperation(components -> {
            components.add(character);
            components.remove(this);
            components.add(this);
        });
    }

    @Override
    public void onClick(MouseButtons button) {
        hide(true);
    }

    public Character getCharacter() {
        return character;
    }
}
