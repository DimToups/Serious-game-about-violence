package fr.tyr.components.memo;

import fr.tyr.components.character.personality.Personality;
import fr.tyr.components.character.personality.PersonalityTraits;
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
            validQuestions.addAll(Questions.getAllClassQuestions(PersonalityTraits.COMMON_PAST_FACTS));
        if(!personality.getPastFact().isGenderPastFactDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(PersonalityTraits.GENDER_PAST_FACTS));
        if(!personality.getPastFact().isOriginPastFactDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(PersonalityTraits.ORIGIN_PAST_FACTS));
        if(!personality.getPastFact().isSexualOrientationPastFactDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(PersonalityTraits.SEXUAL_ORIENTATION_PAST_FACTS));

        // Thoughts
        if(!personality.getThoughts().isGenderThoughtsDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(PersonalityTraits.GENDER_THOUGHTS));
        if(!personality.getThoughts().isOriginThoughtsDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(PersonalityTraits.ORIGIN_THOUGHTS));
        if(!personality.getThoughts().isSexualOrientationThoughtsDiscovered())
            validQuestions.addAll(Questions.getAllClassQuestions(PersonalityTraits.SEXUAL_ORIENTATION_THOUGHTS));

        if(!validQuestions.isEmpty()) {
            Questions question = validQuestions.get(rand.nextInt(0, validQuestions.size()));
            this.memo.setQuestion(question);
            this.memo.setText(new ArrayList<>(List.of(new TextComponent(Questions.valueOf(question.name()).getDescription(), Color.BLACK, Memo.memoFont))));
        }
        else
            this.memo.getText().getFirst().setText("Et si je passais à l'action ?");
    }
}
