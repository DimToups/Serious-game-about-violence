package fr.tyr.components.violence.enums;

public enum Acts {
    PHYSICAL_PUNCH(Types.PHYSICAL, "Coup de poing au visage lors d'un combat"),
    PHYSICAL_THROTTLING(Types.PHYSICAL, "Prise d'étranglement lors d'une soumission"),
    PHYSICAL_VIOLENT_PROJECTION(Types.PHYSICAL,"Projection violente sur le tatami pendant un entraînement"),
    PHYSICAL_KNEE_STRIKE(Types.PHYSICAL, "Coup de genou lors d'une démonstration de technique"),
    PHYSICAL_TRAINING_HARD(Types.PHYSICAL,"poussés à la limites physiques pendant l'entraînement"),
    ECONOMICAL_CREDIT_CARD_THEFT(Types.ECONOMICAL,"voler sa carte de credit durant l'entrainement"),
    ECONOMICAL_LYING_ABOUT_PRICES(Types.ECONOMICAL,"augmenter les prix pour l'adherent"),
    ECONOMICAL_SPECULATING_ON_PRICES(Types.ECONOMICAL,"faire croire a l'adherent que le prix vont augmenter"),
    ECONOMICAL_MOCK_SOCIAL_RANK(Types.ECONOMICAL,"faire de blague sur le rang social de l'adherent"),
    ECONOMICAL_LOOK_DOWN(Types.ECONOMICAL,"regarder de haut l'adherent"),
    PSYCHOLOGICAL_INTIMIDATION(Types.PSYCHOLOGICAL,"menacer de frapper l'adherent"),
    PSYCHOLOGICAL_HUMILIATION(Types.PSYCHOLOGICAL,"faire remarquer a tous le monde que l'adherent est mauvais"),
    PSYCHOLOGICAL_EXCESSIVE_PRESSURE(Types.PSYCHOLOGICAL,"mettre la pression a l'adherent par rapports a un match"),
    PSYCHOLOGICAL_SOCIAL_ISOLATION(Types.PSYCHOLOGICAL,"ignorer complètement l'adherent"),
    PSYCHOLOGICAL_GENDER_DISCRIMINATION(Types.PSYCHOLOGICAL,"faire une blague misogyne"),
    PSYCHOLOGICAL_ETHNIC_DISCRIMINATION(Types.PSYCHOLOGICAL,"faire un blague raciste"),
    PSYCHOLOGICAL_SEXUAL_ORIENTATION_DISCRIMINATION(Types.PSYCHOLOGICAL,"faire une blague homophobe"),
    VERBAL_INSULTS(Types.VERBAL,"insulter l'adherent"),
    VERBAL_DENIGRATION(Types.VERBAL,"dénigrer le competence de l'adherent "),
    VERBAL_THREATS(Types.VERBAL,"menacer d'exclure l'adherent"),
    VERBAL_REMARK_MOVE(Types.VERBAL,"faire une remarque déplacer le physique de l'adherent"),

    ;

    private final Types type;
    private final String description;

    Acts(Types type, String description){
        this.type = type;
        this.description = description;
    }
}
