package fr.tyr.components.animated;

import fr.tyr.components.texts.AnimatedText;
import fr.tyr.components.texts.Text;
import fr.tyr.components.texts.TextPart;
import fr.tyr.tools.Vector2D;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public abstract class AnimatedTextComponent extends AnimatedComponent<Text> {

    /**
     * Create a new animated text component
     * @param position The position of the text
     * @param text The text to display
     * @param timePerFrame The time to display each frame
     */
    public AnimatedTextComponent(@NotNull Vector2D position, AnimatedText text, float timePerFrame) {
        super(position, text.getFrames(), timePerFrame);
    }

    /**
     * Create a new animated text component
     * @param position The position of the text
     * @param text The text to display
     * @param durationList The list of duration for each frame
     */
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
