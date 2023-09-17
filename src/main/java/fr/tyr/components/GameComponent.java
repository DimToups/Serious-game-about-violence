package fr.tyr.components;

import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.Objects;

public abstract class GameComponent {

    private Vector2D position;
    private Vector2D size;

    private Vector2D target;
    private Vector2D basePosition;
    private float duration;

    private boolean isHovered = false;

    public GameComponent(){
        this.position = new Vector2D(0, 0);
    }

    public GameComponent(Vector2D position){
        this.position = position;
    }

    public void moveTo(Vector2D target){
        this.target = target;
        this.duration = 0;
    }

    public void moveTo(Vector2D target, float duration){
        this.basePosition = new Vector2D(position);
        this.target = Vector2D.subtract(target, this.position);
        this.duration = duration;
    }

    public void move(int tps){
        if(Objects.isNull(this.target))
            return;
        this.position.add(this.target.getDivided(tps * duration));
        if(this.position.distance(this.basePosition.getAdded(target)) <= new Vector2D(0, 0).distance(this.target.getDivided(tps * duration))){
            this.position = this.basePosition.getAdded(target);
            this.basePosition = null;
            this.target = null;
        }
    }

    public Vector2D getPosition() {
        return position;
    }
    public Vector2D getSize() {
        return size;
    }
    public boolean isHovered() {
        return isHovered;
    }

    protected void setSize(Vector2D size) {
        this.size = size;
    }
    public void setIsHovered(boolean isHovered) {
        this.isHovered = isHovered;
    }

    abstract public void render(Graphics g);
    abstract public void onClick();
    abstract public void onHover();
    abstract public void onHoverLost();
}
