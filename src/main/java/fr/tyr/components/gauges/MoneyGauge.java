package fr.tyr.components.gauges;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoneyGauge extends ComposedComponent {

    private static final Font moneyFont = new Font("Roboto", Font.PLAIN, 25);

    private int moneyCount;

    private final ImageComponent moneyLogo = new ImageComponent(Images.MONEY_GAUGE_ICON, new Vector2D(0, 0));
    private final TextComponent moneyText = new TextComponent("%d".formatted(moneyCount), Color.WHITE, moneyFont, new Vector2D(125, 35));

    public MoneyGauge(Vector2D position) {
        super(position);
        moneyLogo.resize(0.25);
        setFrame(new ArrayList<>(List.of(moneyLogo, moneyText)));
    }

    public void addMoney(int money){
        moneyCount += money;
        moneyText.setText("%d".formatted(moneyCount));
    }

    public void removeMoney(int money){
        moneyCount -= money;
        moneyText.setText("%d".formatted(moneyCount));
    }

    public int getMoneyCount(){
        return moneyCount;
    }

    public void setMoney(int money) {
        moneyCount = money;
        moneyText.setText("%d".formatted(moneyCount));
    }
}
