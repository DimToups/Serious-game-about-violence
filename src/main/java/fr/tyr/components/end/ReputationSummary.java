package fr.tyr.components.end;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ReputationSummary extends ComposedComponent {

    private static final Font reputationFont = new Font("Roboto", Font.PLAIN, 25);

    private final ImageComponent reputationIcon = new ImageComponent(Images.END_STAR_ICON, new Vector2D(0, 0));
    private final TextComponent reputationText = new TextComponent("", Color.BLACK, reputationFont, new Vector2D(80, 45));

    public ReputationSummary(Vector2D position, int currentReputation) {
        super(position);
        reputationIcon.resize(0.15);
        reputationText.setText("%d / %d".formatted(currentReputation, 100));
        setFrame(new ArrayList<>(List.of(reputationIcon, reputationText)));
    }
}
