package fr.tyr.components.animated;

import fr.tyr.components.texts.AnimatedText;
import fr.tyr.components.texts.Text;
import fr.tyr.components.texts.TextPart;
import fr.tyr.tools.Vector2D;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public abstract class AnimatedTextComponent extends AnimatedComponent<Text> {

    public AnimatedTextComponent(@NotNull Vector2D position, AnimatedText text, float timePerFrame) {
        super(position, text.getFrames(), timePerFrame);
    }

    public AnimatedTextComponent(@NotNull Vector2D position, AnimatedText text, @NotNull List<Float> durationList) {
        super(position, text.getFrames(), durationList);
    }

    @Override
    public void render(Graphics g) {
        int x = (int) getPosition().x;
        int maxY = 0;
        for(TextPart part : getCurrentFrame().getParts()){
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
