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
        position = new Vector2D(0, 0);
    }

    public GameComponent(Vector2D position){
        this.position = position;
    }

    public void moveTo(Vector2D target){
        moveTo(target, 0);
    }

    public void moveTo(Vector2D target, float duration){
        this.target = target;
        this.duration = duration;
        System.out.println(target);
    }

    public void move(int tps){
        if(Objects.isNull(target))
            return;
        Vector2D distance = Vector2D.subtract(target, position);
        Vector2D speed = distance.getDivided(tps * duration);
        position.add(speed);
        if(position.distance(target) <= 1){
            position = target;
            target = null;
            System.out.println(position);
            System.out.println("Done");
        }else{
            System.out.println(position);
        }
        duration -= 1f / tps;
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
