package fr.tyr.components.end;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MembersSummary extends ComposedComponent {

    private static final Font membersFont = new Font("Roboto", Font.PLAIN, 25);

    private final ImageComponent membersIcon = new ImageComponent(Images.END_FIGURE_ICON, new Vector2D(0, 0));
    private final TextComponent membersText = new TextComponent("", Color.BLACK, membersFont, new Vector2D(80, 45));

    public MembersSummary(Vector2D position, int currentMemberCount, int maxMemberCount) {
        super(position);
        membersIcon.resize(0.15);
        membersText.setText("%d / %d membres restants".formatted(currentMemberCount, maxMemberCount));
        setFrame(new ArrayList<>(List.of(membersIcon, membersText)));
    }
}
