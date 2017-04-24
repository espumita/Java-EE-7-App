package model;

import java.util.Date;

public class Sample {
    private final String glucoseLevel;
    private final Date date;

    public Sample(String glucoseLevel, Date date) {
        this.glucoseLevel = glucoseLevel;
        this.date = date;
    }

    public String glucoseLevel() {
        return glucoseLevel;
    }

    public Date date() {
        return date;
    }
}
