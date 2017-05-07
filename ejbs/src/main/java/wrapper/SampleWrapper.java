package wrapper;

import java.util.Date;

public class SampleWrapper {
    private final String glucoseLevel;
    private final Date date;

    public SampleWrapper(String glucoseLevel, Date date) {
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
