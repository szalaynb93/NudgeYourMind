package com.szalaynb.NudgeYourMind.model.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
