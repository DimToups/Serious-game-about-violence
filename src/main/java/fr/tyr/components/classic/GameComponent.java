package fr.tyr.components.classic;

import fr.tyr.Main;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.Objects;

public abstract class GameComponent<T> {

    /**
     * The frame can be a unique object or a list of objects
     */
    private T frame;

    // Position and size part
    private Vector2D position;
    private Vector2D size;

    // Movement part
    private Vector2D target;
    private float duration;

    // Behavior part
    private boolean isHovered = false;
    private boolean isVisible = true;
    // Internal optimizations
    private boolean isRendered = true;

    /**
     * Create a component with a frame
     * @param frame The frame of the component
     */
    public GameComponent(T frame){
        this(frame, new Vector2D(0, 0));
    }

    /**
     * Create a component with a frame, a position
     * @param frame The frame of the component
     * @param position The position of the component
     */
    public GameComponent(T frame, Vector2D position){
        this(frame, position, new Vector2D(0, 0));
    }

    /**
     * Create a component with a frame, a position and a size
     * @param frame The frame of the component
     * @param position The position of the component
     * @param size The size of the component
     */
    public GameComponent(T frame, Vector2D position, Vector2D size){
        Main.getLogger().info("Initializing component %s at %s with size %s".formatted(Objects.isNull(frame) ? "unknown" : frame.getClass(), position, size));
        this.frame = frame;
        this.position = position;
        this.size = size;
    }

    /**
     * Move the component to a target position in a certain duration
     * @param target The target position
     * @param duration The duration of the movement
     */
    public void moveTo(Vector2D target, float duration){
        this.target = target;
        this.duration = duration;
    }

    /**
     * Execute a movement tick
     * @param tps The current number of ticks per second
     */
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

    public void move(Vector2D target){
        this.position = target;
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
    public boolean isVisible() {
        return isVisible;
    }
    public boolean isRendered() {
        return isRendered;
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
    public void setVisible(boolean visible) {
        isVisible = visible;
    }
    public void setRendered(boolean rendered) {
        isRendered = rendered;
    }

    /**
     * Render the component
     * @param g The graphics object
     */
    abstract public void render(Graphics g);
    /**
     * Execute a tick
     * @param aps The current number of ticks per second
     */
    abstract public void tick(int aps);
    /**
     * Execute an action when the component is clicked
     * @param button The button that was clicked
     */
    abstract public void onClick(MouseButtons button);
    /**
     * Execute an action when the mouse is hovering the component
     */
    abstract public void onHover();
    /**
     * Execute an action when the mouse is not hovering the component anymore
     */
    abstract public void onHoverLost();
    /**
     * Execute an action when the window is resized
     * @param size The new size of the window
     */
    abstract public void onWindowResized(Vector2D size);
}
