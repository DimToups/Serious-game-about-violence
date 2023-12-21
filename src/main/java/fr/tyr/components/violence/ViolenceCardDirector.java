package fr.tyr.components.violence;

import fr.tyr.components.violence.enums.Types;
import fr.tyr.tools.Vector2D;

public class ViolenceCardDirector {
    private ViolenceCardBuilder violenceCardBuilder;

    public ViolenceCardDirector(ViolenceCardBuilder violenceCardBuilder) {
        this.violenceCardBuilder = violenceCardBuilder;
    }
    public void generateViolenceCard(){
        // At the moment, no sexual violences are allowed
        Types type = Types.SEXUAL;
        while(type == Types.SEXUAL) {
            this.violenceCardBuilder.generateType();
            type = this.violenceCardBuilder.getViolenceCard().getType();
        }
        this.violenceCardBuilder.generateBackground(type);
        this.violenceCardBuilder.generateIcon(type);
        this.violenceCardBuilder.generateActs(type);
        this.violenceCardBuilder.getViolenceCard().finalize(new Vector2D());
    }
    public ViolenceCardBuilder getViolenceCardBuilder(){
        return this.violenceCardBuilder;
    }
    public void setViolenceCardBuilder(ViolenceCardBuilder violenceCardBuilder) {
        this.violenceCardBuilder = violenceCardBuilder;
    }
}