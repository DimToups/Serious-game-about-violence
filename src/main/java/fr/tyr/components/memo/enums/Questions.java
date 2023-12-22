package fr.tyr.components.memo.enums;

import fr.tyr.components.character.personality.pastFacts.enums.CommonPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.GenderPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.OriginPastFacts;
import fr.tyr.components.character.personality.pastFacts.enums.SexualOrientationPastFacts;
import fr.tyr.components.character.personality.thoughts.enums.GenderThoughts;
import fr.tyr.components.character.personality.thoughts.enums.OriginThoughts;
import fr.tyr.components.character.personality.thoughts.enums.SexualOrientationThoughts;

import java.util.Arrays;
import java.util.List;

public enum Questions {
    PASTFACT_COMMON("Est-ce que tu as vécu des moments compliqués dans ta vie ?", CommonPastFacts.class),
    PASTFACT_GENDER("Lui demander si son avis sur les genres", GenderPastFacts.class),
    PASTFACT_ORIGIN("Est-ce que ton origine a influencée ta vie ?", OriginPastFacts.class),
    PASTFACT_SEXUALORIENTATION("Qu'est-ce que la personne pense des orientations sexuelles ?", SexualOrientationPastFacts.class),
    THOUGHTS_GENDER("Qu'est-ce que la personne pense sur l'égalité des genres ?", GenderThoughts.class),
    THOUGHTS_ORIGIN("Ca t'arrives de faire des blagues racistes ?", OriginThoughts.class),
    THOUGHTS_SEXUALORIENTATION("Comment tu réagirait si ton enfant était homosexuel ?", SexualOrientationThoughts.class),
    ;
    private final String description;
    private final Class<?> target;
    Questions(String description, Class<?> target){
        this.description = description;
        this.target = target;
    }
    public String getDescription() {
        return description;
    }
    public Class<?> getTarget(){
        return this.target;
    }
    public static List<Questions> getAllClassQuestions(Class<?> target){
        return Arrays.stream(Questions.values()).filter(question -> question.target == target).toList();
    }
}
