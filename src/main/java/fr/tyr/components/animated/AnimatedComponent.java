package fr.tyr.components.animated;

import fr.tyr.components.classic.GameComponent;
import fr.tyr.tools.Vector2D;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public abstract class AnimatedComponent<T> extends GameComponent<List<T>> {

    private int currentFrame;
    private final List<Float> durationList;
    private float remainingTime;
    private boolean isRunning = true;

    /**
     * Create an animated component
     * @param position The position of the component
     * @param frames The frames of the component
     * @param timePerFrame The time in seconds between each frame
     */
    public AnimatedComponent(@NotNull final Vector2D position, @NotNull final List<T> frames, final float timePerFrame){
        super(frames, position);
        this.durationList = Collections.nCopies(frames.size(), timePerFrame);
    }

    /**
     * Create an animated component
     * @param position The position of the component
     * @param frames The frames of the component
     * @param durationList The duration of each frame
     */
    public AnimatedComponent(@NotNull final Vector2D position, @NotNull final List<T> frames, @NotNull final List<Float> durationList){
        super(frames, position);
        if(frames.size() != durationList.size())
            throw new IllegalArgumentException("Frames and durationList must have the same size");
        this.durationList = durationList;
    }

    /**
     * Go to the next frame
     */
    public void nextFrame(){
        currentFrame = ++currentFrame % getFrame().size();
    }

    @Override
    public void tick(int aps) {
        if(!isRunning)
            return;
        float dt = 1f / aps;
        remainingTime -= dt;
        if(remainingTime <= 0){
            remainingTime = durationList.get(currentFrame);
            nextFrame();
        }
    }

    public T getCurrentFrame(){
        return getFrame().get(currentFrame);
    }
    public boolean isRunning() {
        return isRunning;
    }

    public void pause(){
        isRunning = false;
    }
    public void resume(){
        isRunning = true;
    }
}
