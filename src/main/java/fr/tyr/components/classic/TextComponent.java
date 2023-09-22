package fr.tyr.components.classic;

import fr.tyr.tools.Vector2D;

import java.awt.*;

public abstract class TextComponent extends GameComponent<String>{

    private Font font;
    private Color color;

    public TextComponent(String frame, Font font, Color color) {
        super(frame);
        this.font = font;
        this.color = color;
        setSize(new Vector2D(getFrame().length() * font.getSize() / 1.5D, -font.getSize()));
    }

    public TextComponent(String frame, Vector2D position, Font font, Color color) {
        super(frame, position);
        this.font = font;
        this.color = color;
        setSize(new Vector2D(getFrame().length() * font.getSize() / 1.5D, -font.getSize()));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.setFont(font);
        g.drawString(getFrame(), (int) getPosition().x, (int) getPosition().y);
    }

    public Font getFont() {
        return font;
    }
    public void setFont(Font font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}
