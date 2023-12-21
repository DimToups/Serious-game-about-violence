package fr.tyr.components.memo;

import fr.tyr.components.character.personality.Personality;

public class MemoDirector {
    private MemoBuilder builder;
    public MemoDirector(MemoBuilder builder){
        this.builder = builder;
    }

    public MemoBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(MemoBuilder builder) {
        this.builder = builder;
    }
    public void generateMemo(){
        builder.resetMemo();
        builder.generateBackground();
        builder.generateText(new Personality());
        builder.getMemo().assemble();
    }
}
