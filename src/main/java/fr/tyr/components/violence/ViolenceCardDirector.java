package fr.tyr.components.violence;

import fr.tyr.components.violence.enums.Types;
import fr.tyr.tools.Vector2D;

public class ViolenceCardDirector {
    private ViolenceCardBuilder violenceCardBuilder;
    /**
     * Create a ViolenceCardDirector
     */
    public ViolenceCardDirector(ViolenceCardBuilder violenceCardBuilder) {
        this.violenceCardBuilder = violenceCardBuilder;
    }
    /**
     * Generate the violenceCard
     */
    public void generateViolenceCard(){
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
    /**
     * Send the ViolenceCardBuilder
     * @return the ViolenceCardBuilder
     */
    public ViolenceCardBuilder getViolenceCardBuilder(){
        return this.violenceCardBuilder;
    }
}