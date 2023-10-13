package fr.tyr.components.classic;

import fr.tyr.components.texts.Text;
import fr.tyr.components.texts.TextPart;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.Objects;

public abstract class TextComponent extends GameComponent<Text>{

    public TextComponent(Text frame) {
        super(frame);
    }

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
        setSize(new Vector2D(x - (int) getPosition().x, -maxY));
    }
}
