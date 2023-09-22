package fr.tyr.components.animated;

import fr.tyr.tools.Vector2D;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public abstract class AnimatedTextComponent extends AnimatedComponent<String> {

    private final Font font;
    private final Color color;

    public AnimatedTextComponent(@NotNull Vector2D position, @NotNull List<String> frames, float timePerFrame, Font font, Color color) {
        super(position, frames, timePerFrame);
        this.font = font;
        this.color = color;
    }

    public AnimatedTextComponent(@NotNull Vector2D position, @NotNull List<String> frames, @NotNull List<Float> durationList, Font font, Color color) {
        super(position, frames, durationList);
        this.font = font;
        this.color = color;
    }

    @Override
    public void nextFrame() {
        super.nextFrame();
        setSize(new Vector2D(getCurrentFrame().length() * font.getSize() / 1.5D, -font.getSize()));
    }

    @Override
    public void render(Graphics g) {
        g.setFont(font);
        g.setColor(color);
        g.drawString(getCurrentFrame(), (int) getPosition().x, (int) getPosition().y);
    }
}
