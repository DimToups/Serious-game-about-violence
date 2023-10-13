package fr.tyr.components.texts;

import java.util.ArrayList;
import java.util.List;

public class AnimatedText {

    private final List<Text> frames;

    public AnimatedText(Text... frames) {
        this.frames = new ArrayList<>(List.of(frames));
    }

    public List<Text> getFrames() {
        return frames;
    }

    public void addFrame(Text frame) {
        frames.add(frame);
    }

}
