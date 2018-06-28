package com.szalaynb.NudgeYourMind.model.enums;


public enum Priority {

    P0(0), P1(1), P2(2);

    private int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
