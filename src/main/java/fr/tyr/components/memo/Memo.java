package fr.tyr.components.memo;

import fr.tyr.Main;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.memo.enums.Questions;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Memo extends ComposedComponent {
    public static final Font memoFont = new Font("Roboto", Font.PLAIN, 12);
    private ImageComponent background;
    private List<TextComponent> text = new ArrayList<>();
    private Questions question;
    public Memo(){
        super(new Vector2D());
    }
    public Memo(Vector2D v){
        super(v);
    }

    public ImageComponent getBackground() {
        return background;
    }

    public void setBackground(ImageComponent background) {
        this.background = background;
    }

    public List<TextComponent> getText() {
        return text;
    }

    public void setText(List<TextComponent> texts) {
        this.text = texts;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public void assemble(){
        this.background.resize(0.35);
        this.text = TextComponent.adjustText(this.text.getFirst(), this.background.getSize().x * 0.9, memoFont);
        for(int i = 0; i < text.size(); i++)
            this.text.get(i).move(Vector2D.add(this.background.getPosition(),
                    new Vector2D(this.background.getSize().x * 0.05, this.background.getSize().y * 0.2 + (memoFont.getSize() + 2) * i)));

        List<GameComponent<?>> components = new ArrayList<>(List.of(this.background));
        components.addAll(this.text);
        setFrame(components);
    }

    @Override
    public void onClick(MouseButtons button) {
        if(button != MouseButtons.LEFT)
            return;
        if(isHovered())
            onHoverLost();
        Main.getLogger().info("Applying a memo...");
        Main.getGameEngine().applyMemo(this);
    }
}
