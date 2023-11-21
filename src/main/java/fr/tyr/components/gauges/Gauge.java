package fr.tyr.components.gauges;

import fr.tyr.Main;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.util.List;
import java.util.Random;

public class Gauge extends ComposedComponent {

    private final boolean isVertical;
    private int currentProgress = 100;
    private final ImageComponent progressBar;

    public Gauge(Vector2D position, boolean isVertical, Images backgroundImage, Vector2D backgroundOffset, Images iconImages, Vector2D iconOffset, Images progressBarImage, Vector2D imageOffset) {
        super(position);
        this.isVertical = isVertical;
        ImageComponent background = new ImageComponent(backgroundImage, backgroundOffset.getAdded(position));
        ImageComponent icon = new ImageComponent(iconImages, iconOffset.getAdded(position));
        progressBar = new ImageComponent(progressBarImage, imageOffset.getAdded(position));
        setSize(background.getSize());
        setFrame(List.of(background, icon, progressBar));
    }

    public void setCurrentProgress(int currentProgress) {
        this.currentProgress = currentProgress;
        int gaugeSize = 100 - currentProgress;
        Main.getLogger().warning("Gauge size: " + gaugeSize);
        if(currentProgress == 0){
            Main.getLogger().warning("Gauge is empty");
            progressBar.setVisible(false);
            return;
        }else
            progressBar.setVisible(true);
        if(isVertical){
            int y = (int) (getSize().y * (gaugeSize / 100D));
            progressBar.crop(0, y, (int) getSize().x, (int) getSize().y - y);
            progressBar.move(getPosition().getAdded(new Vector2D(0, y)));
        }else{
            int x = (int) (getSize().y * (gaugeSize / 100D));
            progressBar.crop(x, 0, (int) getSize().x - x, (int) getSize().y);
            progressBar.move(getPosition().getAdded(new Vector2D(x, 0)));
        }
    }

    @Override
    public void onClick(MouseButtons button) {
        int random = new Random().nextInt(0, 101);
        Main.getLogger().warning("Random: " + random);
        setCurrentProgress(random);
    }
}
