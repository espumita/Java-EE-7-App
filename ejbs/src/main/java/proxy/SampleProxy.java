package proxy;

import java.util.Date;

public class SampleProxy {
    private final String glucoseLevel;
    private final Date date;

    public SampleProxy(String glucoseLevel, Date date) {
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
