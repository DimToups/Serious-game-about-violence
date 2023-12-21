package fr.tyr.components.violence;


import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.components.violence.enums.*;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ViolenceCard extends ComposedComponent{
    private Types type;
    private ImageComponent background;
    private ImageComponent icon;
    private Acts acts;
    public static final Font cardFont = new Font("Roboto", Font.PLAIN,18);
    private List<TextComponent> description = new ArrayList<>();
    public ViolenceCard(){
        super(new Vector2D());
    }
    public ImageComponent getIcon(){
        return this.icon;
    }
    public void setIcon(Icon icon){
        this.icon = new ImageComponent(icon.getImage());
    }
    public ImageComponent getBackground(){
        return this.background;
    }
    public void setBackground(Background background){
        this.background = new ImageComponent(background.getImage());
    }
    public void setActs(Acts acts){
        this.acts = acts;
    }
    public Acts getActs() {
        return this.acts;
    }
    public Types getType(){
        return this.type;
    }
    public void setType(Types type){
        this.type = type;
    }
    public void setDescription(Acts act) {
        this.description.getFirst().setText(act.getDescription());
    }
    @Override
    public void resize(Vector2D size) {
        super.resize(size);
    }
    public void finalize(Vector2D position){
        if(Objects.isNull(position))
            position = new Vector2D(0, 0);

        if(description.isEmpty())
            this.description.add(new TextComponent("", Color.BLACK, cardFont));
        this.description.getFirst().setText(this.acts.getDescription());


        this.icon.resize(new Vector2D(background.getSize().x/4,background.getSize().x/4));
        this.icon.move(Vector2D.add(background.getPosition(),
                new Vector2D(this.background.getSize().x /25,this.background.getSize().x /25 )));

        description = TextComponent.adjustText(description.getFirst(), this.background.getSize().x, cardFont);
        for(int i = 0; i < description.size(); i++) {
            description.get(i).move(Vector2D.add(background.getPosition(),
                    new Vector2D(icon.getPosition().x, (this.background.getSize().y - (this.icon.getPosition().y + this.icon.getSize().y + description.get(i).getSize().y)) / 10 + (this.icon.getPosition().y + this.icon.getSize().y + (description.get(i).getSize().y + cardFont.getSize() * 1.2) * i))));
        }

        // Addition of the components to the frame
        List<GameComponent<?>> components = new ArrayList<>(List.of(this.background, this.icon));
        components.addAll(description);
        setFrame(components);
    }
}