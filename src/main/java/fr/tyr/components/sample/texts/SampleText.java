package fr.tyr.components.sample.texts;

import fr.tyr.components.texts.Text;
import fr.tyr.components.texts.TextPart;

import java.awt.*;

public class SampleText extends Text {

    public SampleText() {
        addPart(new TextPart("Hello ", Color.WHITE, new Font("Roboto", Font.PLAIN, 23)));
        addPart(new TextPart("World", Color.CYAN, new Font("Roboto", Font.PLAIN, 16)));
        addPart(new TextPart("!", Color.ORANGE, new Font("Roboto", Font.PLAIN, 30)));
    }

}
