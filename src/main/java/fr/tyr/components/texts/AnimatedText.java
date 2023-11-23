package fr.tyr.components.texts;

import java.util.ArrayList;
import java.util.List;

public class AnimatedText {

    private final List<Text> frames;

    /**
     * Create an animated text
     * @param frames The frames of the animation
     */
    public AnimatedText(Text... frames) {
        this.frames = new ArrayList<>(List.of(frames));
    }

    public List<Text> getFrames() {
        return frames;
    }

    /**
     * Add a frame to the animation
     * @param frame The frame to add
     */
    public void addFrame(Text frame) {
        frames.add(frame);
    }

}
