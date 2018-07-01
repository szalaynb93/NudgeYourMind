package com.szalaynb.NudgeYourMind.model.enums;

public enum Color {

    // TODO Change priority to (Importance * Urgency)

    BROWN(5), RED(4), YELLOW(2), ORANGE(3), WHITE(1),
    BLUE, GREEN, GREY, VIOLET, BLACK;

    private int value;

    Color(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    Color() {
    }
}
