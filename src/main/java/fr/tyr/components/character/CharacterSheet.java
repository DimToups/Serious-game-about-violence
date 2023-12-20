package fr.tyr.components.character;

import fr.tyr.Main;
import fr.tyr.components.character.style.CharacterStyle;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.util.List;
import java.util.Objects;

public class CharacterSheet extends ComposedComponent {

    private static final ImageComponent sheetBackground = new ImageComponent(Images.CHARACTER_SHEET_BACKGROUND, new Vector2D(0, 0));
    private CharacterStyle style;

    /**
     * Create a composed component
     *
     * @param position   The position of the component
     */
    public CharacterSheet(Vector2D position) {
        super(position);
        setFrame(List.of(sheetBackground));
        this.setVisible(false);
    }

    public void show(Character character){
        Main.getLogger().warning("Sheet position : %s".formatted(getPosition().toString()));
        character.resize(new Vector2D(50, 50));
        character.move(getPosition().getAdded(new Vector2D(50, 50)));
        Main.getLogger().warning("Character position : %s".formatted(character.getPosition().toString()));
        if(Objects.nonNull(style))
            getFrame().remove(style);
        setFrame(List.of(sheetBackground, character));
        this.setVisible(true);
    }

    public void hide(){
        if(Objects.nonNull(style))
            getFrame().remove(style);
        style = null;
        this.setVisible(false);
    }
}
