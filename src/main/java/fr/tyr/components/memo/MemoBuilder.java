package fr.tyr.components.memo;

import fr.tyr.components.character.personality.Personality;
import fr.tyr.components.character.personality.pastFacts.enums.CommonPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.GenderPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.OriginPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.SexualOrientationPastFacts;
import fr.tyr.components.character.personality.thoughts.enums.GenderThoughts;
import fr.tyr.components.character.personality.thoughts.enums.OriginThoughts;
import fr.tyr.components.character.personality.thoughts.enums.SexualOrientationThoughts;
import fr.tyr.components.classic.ImageComponent;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.memo.enums.Memos;
import fr.tyr.components.memo.enums.Questions;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MemoBuilder {
    private final static Random rand = new Random();
    private Memo memo = new Memo();
    public void resetMemo(){
        this.memo = new Memo();
    }
    public Memo getMemo(){
        return this.memo;
    }
    public void generateBackground(){
        this.memo.setBackground(new ImageComponent(Memos.valueOf(Arrays.stream(Memos.values()).toList().get(rand.nextInt(Memos.values().length)).name()).getImage(), new Vector2D()));
    }
    public void generateText(Personality personality){
        //
        // Obtention of every personality field
        //
        List<Questions> validQuestions = new ArrayList<>();

        // Past facts
        if(!personality.getPastFact().isCommonPastFactDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(CommonPastFacts.class));
        if(!personality.getPastFact().isGenderPastFactDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(GenderPastFacts.class));
        if(!personality.getPastFact().isOriginPastFactDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(OriginPastFacts.class));
        if(!personality.getPastFact().isSexualOrientationPastFactDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(SexualOrientationPastFacts.class));

        // Thoughts
        if(!personality.getThoughts().isGenderThoughtsDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(GenderThoughts.class));
        if(!personality.getThoughts().isOriginThoughtsDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(OriginThoughts.class));
        if(!personality.getThoughts().isSexualOrientationThoughtsDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(SexualOrientationThoughts.class));

        if(!validQuestions.isEmpty())
            this.memo.setText(new ArrayList<>(List.of(new TextComponent(Questions.valueOf(validQuestions.get(rand.nextInt(0, validQuestions.size())).name()).getDescription(), Color.BLACK, Memo.memoFont))));
        else
            this.memo.getText().getFirst().setText("Et si je passais à l'action ?");
    }
}
