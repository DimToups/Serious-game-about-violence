package fr.tyr.components.gauges;

import fr.tyr.components.classic.ImageComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.util.List;

public class TimeGauge extends Gauge{

    private final ImageComponent icon;

    public TimeGauge(Vector2D position) {
        super(position, false, new ImageComponent(Images.TIME_GAUGE_PROGRESS, new Vector2D(25, 23).getAdded(position)));
        ImageComponent background = new ImageComponent(Images.TIME_GAUGE_BACKGROUND, new Vector2D(25, 23).getAdded(position));
        icon = new ImageComponent(Images.TIME_GAUGE_ICON_EVENING, position);
        setFrame(List.of(icon, background, getProgressBar()));
    }

    @Override
    public void setCurrentProgress(int newProgress) {
        super.setCurrentProgress(newProgress);
        if(newProgress < 100/3D)
            icon.setImage(Images.TIME_GAUGE_ICON_MORNING);
        else if(newProgress < 200/3D)
            icon.setImage(Images.TIME_GAUGE_ICON_DAY);
        else
            icon.setImage(Images.TIME_GAUGE_ICON_EVENING);
    }
}
