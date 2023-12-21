package fr.tyr.components.violence.enums;

import fr.tyr.components.character.style.enums.HairColor;
import fr.tyr.components.character.style.enums.HairEnum;

import java.util.Arrays;
import java.util.List;

public enum Acts {
    PHYSICAL_PUNCH(Types.PHYSICAL, "Coup de poing au visage lors d'un combat"),
    PHYSICAL_THROTTLING(Types.PHYSICAL, "Prise d'étranglement lors d'une soumission"),
    PHYSICAL_VIOLENT_PROJECTION(Types.PHYSICAL,"Projection violente sur le tatami pendant un entraînement"),
    PHYSICAL_KNEE_STRIKE(Types.PHYSICAL, "Coup de genou lors d'une démonstration de technique"),
    PHYSICAL_TRAINING_HARD(Types.PHYSICAL,"Pousser à la limite physique pendant l'entraînement"),
    ECONOMICAL_CREDIT_CARD_THEFT(Types.ECONOMICAL,"Voler sa carte de credit durant l'entrainement"),
    ECONOMICAL_LYING_ABOUT_PRICES(Types.ECONOMICAL,"Augmenter les prix pour l'adhérent"),
    ECONOMICAL_SPECULATING_ON_PRICES(Types.ECONOMICAL,"Faire croire a l'adherent que le prix vont augmenter"),
    ECONOMICAL_MOCK_SOCIAL_RANK(Types.ECONOMICAL,"Faire de blague sur le rang social de l'adhérent"),
    ECONOMICAL_LOOK_DOWN(Types.ECONOMICAL,"Regarder de haut l'adhérent"),
    PSYCHOLOGICAL_INTIMIDATION(Types.PSYCHOLOGICAL,"Menacer de frapper l'adhérent"),
    PSYCHOLOGICAL_HUMILIATION(Types.PSYCHOLOGICAL,"Faire remarquer a tous le monde que l'adhérent est mauvais"),
    PSYCHOLOGICAL_EXCESSIVE_PRESSURE(Types.PSYCHOLOGICAL,"Mettre la pression a l'adhérent par rapports a un match"),
    PSYCHOLOGICAL_SOCIAL_ISOLATION(Types.PSYCHOLOGICAL,"Ignorer complètement l'adhérent"),
    PSYCHOLOGICAL_GENDER_DISCRIMINATION(Types.PSYCHOLOGICAL,"Faire une blague misogyne"),
    PSYCHOLOGICAL_ETHNIC_DISCRIMINATION(Types.PSYCHOLOGICAL,"Faire une blague raciste"),
    PSYCHOLOGICAL_SEXUAL_ORIENTATION_DISCRIMINATION(Types.PSYCHOLOGICAL,"Faire une blague homophobe"),
    VERBAL_INSULTS(Types.VERBAL,"Insulter l'adhérent"),
    VERBAL_DENIGRATION(Types.VERBAL,"Dénigrer les competence de l'adhérent "),
    VERBAL_THREATS(Types.VERBAL,"Menacer d'exclure l'adhérent"),
    VERBAL_REMARK_MOVE(Types.VERBAL,"Faire une remarque déplacée le physique de l'adhérent"),
    ;

    private final Types type;
    private final String description;

    Acts(Types type, String description){
        this.type = type;
        this.description = description;
    }
    public static List<Acts> getAllActs(Types type){
        return Arrays.stream(values()).filter(acts -> acts.type == type).toList();
    }
    public String getDescription(){
        return this.description;
    }
}
