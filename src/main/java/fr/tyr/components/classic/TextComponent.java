package fr.tyr.components.classic;

import fr.tyr.Main;
import fr.tyr.components.texts.Text;
import fr.tyr.components.texts.TextPart;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextComponent extends GameComponent<Text>{

    /**
     * Create a new TextComponent
     * @param frame The frame of the component
     */
    public TextComponent(Text frame) {
        super(frame);
    }

    public TextComponent(String text, Color color, Font font) {
        this(new Text(text, color, font));
    }

    public TextComponent(String text, Color color, Font font, Vector2D position) {
        this(new Text(text, color, font), position);
    }

    /**
     * Create a new TextComponent
     * @param frame The frame of the component
     * @param position The position of the component
     */
    public TextComponent(Text frame, Vector2D position) {
        super(frame, position);
    }

    @Override
    public void render(Graphics g) {
        int x = (int) getPosition().x;
        int maxY = 0;
        if(Objects.nonNull(getFrame()))
            for(TextPart part : getFrame().getParts()){
                g.setColor(part.getColor());
                g.setFont(part.getFont());
                g.drawString(part.getText(), x, (int) getPosition().y);
                x += g.getFontMetrics().stringWidth(part.getText());
                if(g.getFontMetrics().getHeight() > maxY)
                    maxY = g.getFontMetrics().getHeight();
            }
        setSize(new Vector2D(x - (int) getPosition().x, maxY));
        if(Main.doesHitboxDisplay())
            displayHitbox(g, Color.BLUE);
    }

    public void setText(String text){
        if(getFrame().getParts().size() > 1)
            throw new UnsupportedOperationException("Cannot set text of a multi-part text");
        else if(getFrame().getParts().isEmpty())
            throw new UnsupportedOperationException("Cannot set text of an empty text");
        Color color = getFrame().getParts().getFirst().getColor();
        Font font = getFrame().getParts().getFirst().getFont();
        setFrame(new Text(text, color, font));
    }

    public static List<TextComponent> adjustText(TextComponent baseText, double lineSize, Font font){
        double size = 0;
        int textc = 0;
        String text = baseText.getFrame().getParts().getFirst().getText();
        Color color = baseText.getFrame().getParts().getFirst().getColor();
        List<TextComponent> finalText = new ArrayList<>();
        finalText.add(new TextComponent("", color, font));
        int i = 0;
        String ligne = "";
        while (i < text.length()) {
            String tmp = "";
            while (i < text.length() && text.charAt(i) != ' ') {
                tmp += text.charAt(i);
                size += font.getSize();
                i++;
            }
            if(size > lineSize){
                finalText.get(textc).setText(ligne);
                finalText.add(new TextComponent("", color, font));
                size -= lineSize;
                textc ++;
                ligne = "";
                ligne += tmp+" ";
            }
            else
                ligne += tmp+" ";
            i++;
        }
        finalText.get(textc).setText(ligne);
        return finalText;
    }

    @Override
    public void tick(int aps) {

    }

    @Override
    public void onClick(MouseButtons button) {

    }

    @Override
    public void onHover() {

    }

    @Override
    public void onHoverLost() {

    }

    @Override
    public void onWindowResized(Vector2D size) {

    }

}
