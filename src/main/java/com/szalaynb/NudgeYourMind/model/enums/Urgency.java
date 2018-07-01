package com.szalaynb.NudgeYourMind.model.enums;

public enum Urgency {

    NOTREALLY(1), AVERAGE(2), URGENT(3);

    private int value;

    Urgency(int value) {

        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
