package fr.tyr.components.animated;

import fr.tyr.components.classic.GameComponent;
import fr.tyr.tools.Vector2D;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public abstract class AnimatedComponent<T> extends GameComponent<T> {

    private int currentFrame;
    private final List<T> frames;
    private final List<Float> durationList;
    private float remainingTime;
    private boolean isRunning = true;

    public AnimatedComponent(@NotNull final Vector2D position, @NotNull final List<T> frames, final float timePerFrame){
        super(null, position);
        this.frames = frames;
        this.durationList = Collections.nCopies(frames.size(), timePerFrame);
    }

    public AnimatedComponent(@NotNull final Vector2D position, @NotNull final List<T> frames, @NotNull final List<Float> durationList){
        super(null, position);
        if(frames.size() != durationList.size())
            throw new IllegalArgumentException("Frames and durationList must have the same size");
        this.frames = frames;
        this.durationList = durationList;
    }

    public void nextFrame(){
        currentFrame = ++currentFrame % frames.size();
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
        return frames.get(currentFrame);
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
