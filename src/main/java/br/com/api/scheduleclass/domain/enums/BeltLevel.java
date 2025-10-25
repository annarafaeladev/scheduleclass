package br.com.api.scheduleclass.domain.enums;

public enum BeltLevel {
    WHITE(30),
    BLUE(45),
    PURPLE(60),
    BROWN(90),
    BLACK(120),
    CORAL(0);

    private final int lessonsToNext;

    BeltLevel(int lessonsToNext) {
        this.lessonsToNext = lessonsToNext;
    }

    public int getLessonsToNext() {
        return lessonsToNext;
    }

    public static BeltLevel nextLevel(BeltLevel current) {
        return switch (current) {
            case WHITE -> BLUE;
            case BLUE -> PURPLE;
            case PURPLE -> BROWN;
            case BROWN -> BLACK;
            case BLACK -> CORAL;
            case CORAL -> null;
        };
    }
}
