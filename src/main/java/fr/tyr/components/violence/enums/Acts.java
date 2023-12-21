package fr.tyr.components.violence.enums;

import java.util.Arrays;
import java.util.List;

public enum Acts {
    PHYSICAL_PUNCH(Types.PHYSICAL, "Coup de poing au visage lors d'un combat"),
    PHYSICAL_THROTTLING(Types.PHYSICAL, "Ne pas arrêter l'étranglement lors d'une soumission"),
    PHYSICAL_VIOLENT_PROJECTION(Types.PHYSICAL,"Projeter inutilement violemment sur le tatami pendant un entraînement"),
    PHYSICAL_KNEE_STRIKE(Types.PHYSICAL, "Coup de genou \"Accidentel\" lors d'une démonstration de technique"),
    PHYSICAL_TRAINING_HARD(Types.PHYSICAL,"Le mener à sa limite physique pendant l'entraînement"),
    ECONOMICAL_CREDIT_CARD_THEFT(Types.ECONOMICAL,"Voler sa carte de credit durant l'entrainement"),
    ECONOMICAL_LYING_ABOUT_PRICES(Types.ECONOMICAL,"Augmenter les prix pour l'adhérent"),
    ECONOMICAL_SPECULATING_ON_PRICES(Types.ECONOMICAL,"Faire croire à l'adhérent que les prix vont augmenter"),
    ECONOMICAL_MOCK_SOCIAL_RANK(Types.ECONOMICAL,"Faire une blague sur le rang social de l'adhérent"),
    ECONOMICAL_LOOK_DOWN(Types.ECONOMICAL,"Prendre de haut l'adhérent"),
    PSYCHOLOGICAL_INTIMIDATION(Types.PSYCHOLOGICAL,"Menacer de frapper l'adhérent"),
    PSYCHOLOGICAL_HUMILIATION(Types.PSYCHOLOGICAL,"Faire remarquer à tout le monde que l'adhérent est mauvais"),
    PSYCHOLOGICAL_EXCESSIVE_PRESSURE(Types.PSYCHOLOGICAL,"Mettre la pression a l'adhérent par rapport a un combat"),
    PSYCHOLOGICAL_SOCIAL_ISOLATION(Types.PSYCHOLOGICAL,"Ignorer complètement l'adhérent"),
    PSYCHOLOGICAL_GENDER_DISCRIMINATION(Types.PSYCHOLOGICAL,"Faire une blague misogyne"),
    PSYCHOLOGICAL_ETHNIC_DISCRIMINATION(Types.PSYCHOLOGICAL,"Faire une blague raciste"),
    PSYCHOLOGICAL_SEXUAL_ORIENTATION_DISCRIMINATION(Types.PSYCHOLOGICAL,"Faire une blague homophobe"),
    VERBAL_INSULTS(Types.VERBAL,"Insulter l'adhérent"),
    VERBAL_DENIGRATION(Types.VERBAL,"Dénigrer les competences de l'adhérent"),
    VERBAL_THREATS(Types.VERBAL,"Menacer d'exclure l'adhérent"),
    VERBAL_REMARK_MOVE(Types.VERBAL,"Faire une remarque déplacée sur le physique de l'adhérent"),
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
