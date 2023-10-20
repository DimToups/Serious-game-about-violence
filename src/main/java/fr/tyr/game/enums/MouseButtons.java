package fr.tyr.game.enums;

public enum MouseButtons {
    LEFT(1),
    MIDDLE(2),
    RIGHT(3);

    private final int value;

    MouseButtons(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Get the enum from the integer value
     * @param value The value of the enum
     * @return The enum
     */
    public static MouseButtons from(int value){
        return switch (value) {
            case 1 -> LEFT;
            case 2 -> MIDDLE;
            case 3 -> RIGHT;
            default -> throw new IllegalArgumentException("Unexpected value: %s".formatted(value));
        };
    }
}
