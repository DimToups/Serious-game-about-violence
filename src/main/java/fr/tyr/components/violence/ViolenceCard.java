package fr.tyr.components.violence;


import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.components.violence.enums.*;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.List;

public class ViolenceCard extends ComposedComponent{
    private Types type;
    private ImageComponent background;
    private ImageComponent icon;
    public static final Font cardFont = new Font("Roboto", Font.PLAIN,25);
    private static final TextComponent description = new TextComponent("",Color.BLACK, cardFont);
    public ViolenceCard(){
        super(new Vector2D());
    }


    public ImageComponent getIcon(){
        return this.icon;
    }
    public void setIcon(Icon icon){
        this.icon = new ImageComponent(icon.getImage());
        setFrame(List.of(this.icon));
    }
    public ImageComponent getBackground(){
        return this.background;
    }
    public void setBackground(Background background){
        this.background = new ImageComponent(background.getImage());
        setFrame(List.of(this.background));
    }
    public void setActs(Acts acts){
        description.setText(acts.getDescription());
        setFrame(List.of(background, icon, description));
    }

    public Types getType(){
        return this.type;
    }
    public void setType(Types type){
        this.type = type;
    }
    public void setDescription(Acts act) {
        this.description.setText(act.getDescription());
        setFrame(List.of(this.description));
    }
    @Override
    public void resize(Vector2D size) {
        super.resize(size);
    }
}