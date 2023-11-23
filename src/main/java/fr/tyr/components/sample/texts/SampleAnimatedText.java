package fr.tyr.components.sample.texts;

import fr.tyr.components.texts.AnimatedText;
import fr.tyr.components.texts.Text;
import fr.tyr.components.texts.TextPart;

import java.awt.*;

public class SampleAnimatedText extends AnimatedText {

    public SampleAnimatedText(){
        Font font = new Font("Roboto", Font.PLAIN, 18);
        Text frame = new Text();
        frame.addPart(new TextPart("H", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("He", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hel", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hell", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hello", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hello", Color.ORANGE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hello", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hello", Color.ORANGE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hello", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hello", Color.ORANGE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hello", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hell", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("Hel", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("He", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("H", Color.WHITE, font));
        addFrame(frame);
        frame = new Text();
        frame.addPart(new TextPart("", Color.WHITE, font));
        addFrame(frame);
    }

}
