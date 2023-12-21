package fr.tyr.components.violence;

import fr.tyr.components.violence.enums.Types;

public class ViolenceCardDirector {
    private ViolenceCardBuilder violenceCardBuilder;

    public ViolenceCardDirector(ViolenceCardBuilder violenceCardBuilder) {
        this.violenceCardBuilder = violenceCardBuilder;
    }
    public void generateViolenceCard(){
        this.violenceCardBuilder.generateType();
        Types type = this.violenceCardBuilder.getViolenceCard().getType();
        this.violenceCardBuilder.generateActs(type);
        this.violenceCardBuilder.generateBackground(type);
        this.violenceCardBuilder.generateIcon(type);
    }
    public ViolenceCardBuilder getViolenceCardBuilder(){
        return this.violenceCardBuilder;
    }
}