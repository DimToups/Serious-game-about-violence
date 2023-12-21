package fr.tyr.components.violence;


import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.components.violence.enums.*;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.tools.Vector2D;

import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.chrono.JapaneseEra.values;

public class ViolenceCard extends ComposedComponent{
    private Types type;
    private ImageComponent background;
    private ImageComponent icon;
    private Acts acts;
    public static final Font cardFont = new Font("Roboto", Font.PLAIN,18);
    private List<TextComponent> description = new ArrayList<>();

    /**
     * Create a ViolenceCard
     */
    public ViolenceCard(){
        super(new Vector2D());
    }

    /**
     * Send the ImageComponent's Icon
     * @return The ImageComponent's Icon
     */
    public ImageComponent getIcon(){
        return this.icon;
    }
    /**
     * Defines the wanted Icon
     * @param icon The wanted Icon
     */
    public void setIcon(Icon icon){
        this.icon = new ImageComponent(icon.getImage());
    }
    /**
     * Send the ImageComponent's Background
     * @return The ImageComponent's Background
     */
    public ImageComponent getBackground(){
        return this.background;
    }
    /**
     * Defines the wanted Background
     * @param background The wanted Background
     */
    public void setBackground(Background background){
        this.background = new ImageComponent(background.getImage());
    }
    /**
     * Defines the wanted Acts
     * @param acts The wanted Acts
     */
    public void setActs(Acts acts){
        this.acts = acts;
    }
    /**
     * Send the Acts
     * @return The Acts
     */
    public Acts getActs() {
        return this.acts;
    }
    /**
     * Send the Type
     * @return The Type
     */
    public Types getType(){
        return this.type;
    }
    /**
     * Defines the wanted Types
     * @param type The wanted Types
     */
    public void setType(Types type){
        this.type = type;
    }
    /**
     * Defines the description of wanted Acts
     * @param act The wanted Acts
     */
    public void setDescription(Acts act) {
        this.description.getFirst().setText(act.getDescription());
    }

    /**
     * Resize component with the wanted Vector2D
     * @param size the wanted Vector2D
     */
    @Override
    public void resize(Vector2D size) {
        super.resize(size);
    }

    /**
     * Places all elements in the desired position
     * @param position desired position
     */
    public void finalize(Vector2D position){
        if(Objects.isNull(position))
            position = new Vector2D(0, 0);

        if(description.isEmpty())
            this.description.add(new TextComponent("", Color.BLACK, cardFont));
        this.description.getFirst().setText(this.acts.getDescription());

        this.icon.resize(new Vector2D(background.getSize().x/4,background.getSize().x/4));

        this.icon.move(Vector2D.add(background.getPosition(),
                new Vector2D(this.background.getSize().x /25,this.background.getSize().x /25 )));

        description = finalizeText(description.getFirst().getFrame().getParts().getFirst().getText());
        for(int i = 0; i < description.size(); i++) {
            description.get(i).move(Vector2D.add(background.getPosition(),
                    new Vector2D(icon.getPosition().x, (this.background.getSize().y - (this.icon.getPosition().y + this.icon.getSize().y + description.get(i).getSize().y)) / 10 + (this.icon.getPosition().y + this.icon.getSize().y + (description.get(i).getSize().y + cardFont.getSize() * 1.2) * i))));
        }

        // Addition of the components to the frame
        List<GameComponent<?>> components = new ArrayList<>(List.of(this.background, this.icon));
        components.addAll(description);
        setFrame(components);
    }

    /**
     * Line breaks when wanted text is too long
     * @param text the wanted text
     * @return a list containing all the text each element is a line
     */
    public List<TextComponent> finalizeText(String text){
        int size = 0;
        int textc = 0;
        List<TextComponent> finale = new ArrayList<>();
        finale.add(new TextComponent("", Color.BLACK, cardFont));
        int i = 0;
        String ligne = "";
        while (i < text.length()) {
            String tmp = "";
            while (i < text.length() && text.charAt(i) != ' ') {
                tmp = tmp + text.charAt(i);
                size += 18;
                i++;
            }
            if(size > this.background.getSize().x){
                finale.get(textc).setText(ligne);
                finale.add(new TextComponent("", Color.BLACK, cardFont));
                size -= 200;
                textc ++;
                ligne = "";
                ligne += tmp+" ";
            }
            else{
                ligne += tmp+" ";
            }
            i++;
        }
        finale.get(textc).setText(ligne);
        return finale;
    }
}