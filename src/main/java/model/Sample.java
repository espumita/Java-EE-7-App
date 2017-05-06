package model;

public class Sample {
    private final String glucoseLevel;
    private final String date;

    public Sample(String glucoseLevel, String date) {
        this.glucoseLevel = glucoseLevel;
        this.date = date;
    }

    public String glucoseLevel() {
        return glucoseLevel;
    }

    public String date() {
        return date;
    }
}
