package fr.tyr.components.end;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TimeSummary extends ComposedComponent {

    private static final Font timeFont = new Font("Roboto", Font.PLAIN, 25);

    private final ImageComponent timeIcon = new ImageComponent(Images.END_TIME_ICON, new Vector2D(0, 0));
    private final TextComponent timeText = new TextComponent("", Color.BLACK, timeFont, new Vector2D(80, 40));

    public TimeSummary(Vector2D position, int currentDayCount) {
        super(position);
        timeIcon.resize(0.15);
        timeText.setText("%d jours".formatted(currentDayCount));
        setFrame(new ArrayList<>(List.of(timeIcon, timeText)));
    }
}
