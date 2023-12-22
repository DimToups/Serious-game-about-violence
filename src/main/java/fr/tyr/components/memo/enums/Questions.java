package fr.tyr.components.memo.enums;

import fr.tyr.components.character.personality.PersonalityTraits;

import java.util.Arrays;
import java.util.List;

public enum Questions {
    PASTFACT_COMMON("Est-ce que tu as vécu des moments compliqués dans ta vie ?", PersonalityTraits.COMMON_PAST_FACTS),
    PASTFACT_GENDER("Lui demander si son avis sur les genres", PersonalityTraits.GENDER_PAST_FACTS),
    PASTFACT_ORIGIN("Est-ce que ton origine a influencée ta vie ?", PersonalityTraits.ORIGIN_PAST_FACTS),
    PASTFACT_SEXUALORIENTATION("Qu'est-ce que la personne pense des orientations sexuelles ?", PersonalityTraits.SEXUAL_ORIENTATION_PAST_FACTS),
    THOUGHTS_GENDER("Qu'est-ce que la personne pense sur l'égalité des genres ?", PersonalityTraits.GENDER_THOUGHTS),
    THOUGHTS_ORIGIN("Ca t'arrives de faire des blagues racistes ?", PersonalityTraits.ORIGIN_THOUGHTS),
    THOUGHTS_SEXUALORIENTATION("Comment tu réagirait si ton enfant était homosexuel ?", PersonalityTraits.SEXUAL_ORIENTATION_THOUGHTS),
    ;
    private final String description;
    private final PersonalityTraits target;
    Questions(String description, PersonalityTraits target){
        this.description = description;
        this.target = target;
    }
    public String getDescription() {
        return description;
    }
    public PersonalityTraits getTarget(){
        return this.target;
    }
    public static List<Questions> getAllClassQuestions(PersonalityTraits trait){
        return Arrays.stream(Questions.values()).filter(question -> question.target == trait).toList();
    }
}
