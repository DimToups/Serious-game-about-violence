package fr.tyr.components.texts;

import java.util.ArrayList;
import java.util.List;

public class Text {

    private final List<TextPart> parts;

    /**
     * Create a text with the given parts
     * @param parts The parts of the text
     */
    public Text(TextPart... parts) {
        this.parts = new ArrayList<>(List.of(parts));
    }

    /**
     * Add a part to the text
     * @param part The part to add
     */
    public void addPart(TextPart part) {
        parts.add(part);
    }

    public List<TextPart> getParts() {
        return parts;
    }
}
