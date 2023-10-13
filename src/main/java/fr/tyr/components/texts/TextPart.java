package fr.tyr.components.texts;

import java.awt.*;

public class TextPart {

    private String text;
    private Color color;
    private Font font;

    public TextPart(String text, Color color, Font font){
        this.text = text;
        this.color = color;
        this.font = font;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }
}
