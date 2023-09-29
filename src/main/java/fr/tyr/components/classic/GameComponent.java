package fr.tyr.components.classic;

import fr.tyr.Main;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.Objects;

public abstract class GameComponent<T> {

    private T frame;
    private Vector2D position;
    private Vector2D size;

    // Movement part
    private Vector2D target;
    private float duration;

    // Behavior part
    private boolean isHovered = false;

    public GameComponent(T frame){
        this(frame, new Vector2D(0, 0));
    }

    public GameComponent(T frame, Vector2D position){
        this(frame, position, new Vector2D(0, 0));
    }

    public GameComponent(T frame, Vector2D position, Vector2D size){
        Main.getLogger().info("Initializing component %s at %s with size %s".formatted(Objects.isNull(frame) ? "unknown" : frame.getClass(), position, size));
        this.frame = frame;
        this.position = position;
        this.size = size;
    }

    public void moveTo(Vector2D target, float duration){
        this.target = target;
        this.duration = duration;
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
        }
        duration -= 1f / tps;
    }

    public T getFrame() {
        return frame;
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

    public void setFrame(T frame) {
        this.frame = frame;
    }
    protected void setSize(Vector2D size) {
        this.size = size;
    }
    public void setIsHovered(boolean isHovered) {
        this.isHovered = isHovered;
    }
    public boolean isMoving(){
        return Objects.nonNull(target);
    }
    public float getRemainingDuration(){
        return duration;
    }
    public Vector2D getTarget() {
        return target;
    }

    abstract public void render(Graphics g);
    abstract public void tick(int aps);
    abstract public void onClick(MouseButtons button);
    abstract public void onHover();
    abstract public void onHoverLost();
    abstract public void onWindowResized(Vector2D size);
}
