package fr.tyr.components.violences;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.components.violences.enums.Acts;
import fr.tyr.tools.Vector2D;

public class ViolenceCard extends ComposedComponent {
    private final Acts act;
    private final ImageComponent background;
    private final TextComponent description;
    private final TextComponent violenceKind;
    private final TextComponent cardKind;
    public ViolenceCard(Vector2D position, ImageComponent background, TextComponent description, TextComponent violenceKind, TextComponent cardKind, Acts act){
        super(position, background, description, violenceKind, cardKind);
        this.act = act;
        this.background = background;
        this.description = description;
        this.violenceKind = violenceKind;
        this.cardKind = cardKind;
    }
    public Acts getAct() {
        return this.act;
    }
    public ImageComponent getBackground() {
        return background;
    }
    public TextComponent getDescription() {
        return description;
    }
    public TextComponent getViolenceKind() {
        return violenceKind;
    }
    public TextComponent getCardKind() {
        return cardKind;
    }
}
