package fr.tyr.components.texts;

import java.util.ArrayList;
import java.util.List;

public class Text {

    private final List<TextPart> parts;

    public Text(TextPart... parts) {
        this.parts = new ArrayList<>(List.of(parts));
    }

    public void addPart(TextPart part) {
        parts.add(part);
    }

    public List<TextPart> getParts() {
        return parts;
    }
}
