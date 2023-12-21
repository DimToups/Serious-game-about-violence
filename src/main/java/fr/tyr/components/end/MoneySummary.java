package fr.tyr.components.end;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoneySummary extends ComposedComponent {

    private static final Font moneyFont = new Font("Roboto", Font.PLAIN, 25);

    private final ImageComponent moneyIcon = new ImageComponent(Images.MONEY_GAUGE_ICON, new Vector2D(0, 0));
    private final TextComponent moneyText = new TextComponent("", Color.BLACK, moneyFont, new Vector2D(80, 25));

    public MoneySummary(Vector2D position, int currentMoneyCount) {
        super(position);
        moneyIcon.resize(0.15);
        moneyText.setText("%d".formatted(currentMoneyCount));
        setFrame(new ArrayList<>(List.of(moneyIcon, moneyText)));
    }
}
