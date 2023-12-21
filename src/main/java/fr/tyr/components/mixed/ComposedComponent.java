package fr.tyr.components.mixed;

import fr.tyr.Main;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.classic.ImageComponent;
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
        updateComponentPosition();
    }

    public void updateComponentPosition(){
        for(GameComponent<?> component: getFrame()){
            if(component.getPosition().x < getPosition().x){
                Vector2D relativePosition = new Vector2D(getPosition().x - component.getPosition().x, 0);
                for(GameComponent<?> component1: getFrame())
                    component1.move(component1.getPosition().getAdded(relativePosition));
            }
            if(component.getPosition().y < getPosition().y){
                Vector2D relativePosition = new Vector2D(0, getPosition().y - component.getPosition().y);
                for(GameComponent<?> component1: getFrame())
                    component1.move(component1.getPosition().getAdded(relativePosition));
            }
        }
//        for(GameComponent<?> component: getFrame()){
//            Vector2D relativeX = new Vector2D(getPosition().x - component.getPosition().x, 0);
//            for(GameComponent<?> component1: getFrame())
//                component1.move(component1.getPosition().getAdded(relativeX));
//            Vector2D relativeY = new Vector2D(0, getPosition().y - component.getPosition().y);
//            for(GameComponent<?> component1: getFrame())
//                component1.move(component1.getPosition().getAdded(relativeY));
//        }
        refreshSize();
    }

    public void refreshSize(){
        int sizeX = 0, sizeY = 0;
        for(GameComponent<?> component: getFrame()){
            if(component.getPosition().x + component.getSize().x > sizeX)
                sizeX = (int) (component.getPosition().x + component.getSize().x);
            if(component.getPosition().y + component.getSize().y > sizeY)
                sizeY = (int) (component.getPosition().y + component.getSize().y);
        }
        setSize(new Vector2D(sizeX, sizeY).getRemoved(getPosition()));
    }

    public void resize(Vector2D size){
        Vector2D ratio = size.getDivided(getSize());
        for(GameComponent<?> component: getFrame()){
            Vector2D relativePosition = component.getPosition().getRemoved(getPosition());
            component.move(getPosition().getAdded(relativePosition.getMultiplied(ratio)));
            if(component instanceof ImageComponent imageComponent){
                imageComponent.resize(component.getSize().getMultiplied(ratio));
            }else if(component instanceof ComposedComponent composedComponent){
                composedComponent.resize(component.getSize().getMultiplied(ratio));
            }
        }
        setSize(size);
    }

    public void resize(double ratio){
        resize(getSize().getMultiplied(ratio));
    }

    @Override
    public void move(int tps){
        super.move(tps);
        getFrame().forEach(component -> component.move(tps));
    }

    @Override
    public void move(Vector2D target) {
        Vector2D difference = target.getRemoved(getPosition());
        super.move(target);
        getFrame().forEach(component -> component.move(component.getPosition().getAdded(difference)));
    }

    @Override
    public void moveTo(Vector2D target, float duration) {
        Vector2D difference = target.getRemoved(getPosition());
        super.moveTo(target, duration);
        getFrame().forEach(component -> component.moveTo(component.getPosition().getAdded(difference), duration));
    }

    @Override
    public void render(Graphics g) {
        getFrame().stream().filter(fn -> fn.isVisible() && fn.isRendered()).forEach(component -> component.render(g));
        if(Main.doesHitboxDisplay())
            displayHitbox(g, Color.GREEN);
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
