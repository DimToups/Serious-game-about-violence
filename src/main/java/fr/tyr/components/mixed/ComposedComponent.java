package fr.tyr.components.mixed;

import fr.tyr.components.classic.GameComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ComposedComponent extends GameComponent<List<GameComponent<?>>> {

    /**
     * Create a composed component
     * @param position The position of the component
     * @param components The components to add to the composed component
     */
    public ComposedComponent(Vector2D position, GameComponent<?>... components) {
        super(new ArrayList<>(List.of(components)), position);
    }

    @Override
    public void setFrame(List<GameComponent<?>> frame) {
        super.setFrame(frame);
//        for(GameComponent<?> component: frame){
//            if(component.getPosition().x < getPosition().x){
//                for(GameComponent<?> component1: frame){
//                    component1.move(component1.getPosition().getAdded(new Vector2D(getPosition().x - component.getPosition().x, 0)));
//                }
//            }
//            if(component.getPosition().y < getPosition().y){
//                for(GameComponent<?> component1: frame){
//                    component1.move(component1.getPosition().getAdded(new Vector2D(0, getPosition().y - component.getPosition().y)));
//                }
//            }
//        }
        for(GameComponent<?> component: frame){
            if(component.getPosition().x < getPosition().x){
                Vector2D relativePosition = new Vector2D(getPosition().x - component.getPosition().x, 0);
                for(GameComponent<?> component1: frame)
                    component1.move(component1.getPosition().getAdded(relativePosition));
            }
            if(component.getPosition().y < getPosition().y){
                Vector2D relativePosition = new Vector2D(0, getPosition().y - component.getPosition().y);
                for(GameComponent<?> component1: frame)
                    component1.move(component1.getPosition().getAdded(relativePosition));
            }
        }
        int sizeX = 0, sizeY = 0;
        for(GameComponent<?> component: getFrame()){
            if(component.getPosition().x + component.getSize().x > sizeX)
                sizeX = (int) (component.getPosition().x + component.getSize().x);
            if(component.getPosition().y + component.getSize().y > sizeY)
                sizeY = (int) (component.getPosition().y + component.getSize().y);
        }
        setSize(new Vector2D(sizeX, sizeY).getRemoved(getPosition()));
    }

    @Override
    public void move(int tps){
        getFrame().forEach(component -> component.move(tps));
    }

    @Override
    public void render(Graphics g) {
        getFrame().stream().filter(fn -> fn.isVisible() && fn.isRendered()).forEach(component -> component.render(g));
//        g.setColor(Color.RED);
//        g.drawRect((int) getPosition().x, (int) getPosition().y, (int) getSize().x, (int) getSize().y);
    }

    @Override
    public void tick(int aps) {
        getFrame().forEach(component -> component.tick(aps));
    }

    @Override
    public void onClick(MouseButtons button) {
        getFrame().forEach(component -> component.onClick(button));
    }

    @Override
    public void onHover() {
        getFrame().forEach(GameComponent::onHover);
    }

    @Override
    public void onHoverLost() {
        getFrame().forEach(GameComponent::onHoverLost);
    }

    @Override
    public void onWindowResized(Vector2D size) {
        getFrame().forEach(component -> component.onWindowResized(size));
    }
}
