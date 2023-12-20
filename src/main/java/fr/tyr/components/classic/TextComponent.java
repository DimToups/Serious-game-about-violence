package fr.tyr.components.classic;

import fr.tyr.Main;
import fr.tyr.components.texts.Text;
import fr.tyr.components.texts.TextPart;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.Objects;

public class TextComponent extends GameComponent<Text>{

    /**
     * Create a new TextComponent
     * @param frame The frame of the component
     */
    public TextComponent(Text frame) {
        super(frame);
    }

    public TextComponent(String text, Color color, Font font) {
        this(new Text(text, color, font));
    }

    public TextComponent(String text, Color color, Font font, Vector2D position) {
        this(new Text(text, color, font), position);
    }

    /**
     * Create a new TextComponent
     * @param frame The frame of the component
     * @param position The position of the component
     */
    public TextComponent(Text frame, Vector2D position) {
        super(frame, position);
    }

    @Override
    public void render(Graphics g) {
        int x = (int) getPosition().x;
        int maxY = 0;
        if(Objects.nonNull(getFrame()))
            for(TextPart part : getFrame().getParts()){
                g.setColor(part.getColor());
                g.setFont(part.getFont());
                g.drawString(part.getText(), x, (int) getPosition().y);
                x += g.getFontMetrics().stringWidth(part.getText());
                if(g.getFontMetrics().getHeight() > maxY)
                    maxY = g.getFontMetrics().getHeight();
            }
        setSize(new Vector2D(x - (int) getPosition().x, maxY));
        if(Main.doesHitboxDisplay())
            displayHitbox(g);
    }

    public void setText(String text){
        if(getFrame().getParts().size() > 1)
            throw new UnsupportedOperationException("Cannot set text of a multi-part text");
        else if(getFrame().getParts().isEmpty())
            throw new UnsupportedOperationException("Cannot set text of an empty text");
        Color color = getFrame().getParts().getFirst().getColor();
        Font font = getFrame().getParts().getFirst().getFont();
        setFrame(new Text(text, color, font));
    }

    @Override
    public void tick(int aps) {

    }

    @Override
    public void onClick(MouseButtons button) {

    }

    @Override
    public void onHover() {

    }

    @Override
    public void onHoverLost() {

    }

    @Override
    public void onWindowResized(Vector2D size) {

    }
}
