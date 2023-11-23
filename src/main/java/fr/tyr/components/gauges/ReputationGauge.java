package fr.tyr.components.gauges;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.util.List;

public class ReputationGauge extends Gauge{
    public ReputationGauge(Vector2D position){
        super(position, true, new ImageComponent(Images.REPUTATION_GAUGE_PROGRESS, position));
        ImageComponent background = new ImageComponent(Images.REPUTATION_GAUGE_BACKGROUND, position);
        ImageComponent icon = new ImageComponent(Images.REPUTATION_GAUGE_ICON, new Vector2D(-25, 350).getAdded(position));
        setFrame(List.of(background, icon, getProgressBar()));
    }
}
