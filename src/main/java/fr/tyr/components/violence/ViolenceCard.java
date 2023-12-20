package fr.tyr.components.violence;

import fr.tyr.components.violence.enums.*;

public class ViolenceCard {
    private Types type;
    private Background background;
    private Icon icon;
    private Acts acts;

    public Icon getIcon(){
        return this.icon;
    }
    public void setIcon(Icon icon){
        this.icon = icon;
    }
    public Background getBackground(){
        return this.background;
    }
    public void setBackground(Background background){
        this.background = background;
    }
    public Acts getActs(){
        return this.acts;
    }
    public void setActs(Acts acts){
        this.acts = acts;
    }
    public Types getType(){
        return this.type;
    }
    public void setType(Types type){
        this.type = type;
    }
}
