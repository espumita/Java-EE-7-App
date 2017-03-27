package model;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String id;
    private List<Sample> samples = new ArrayList();

    public Patient(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    public void add(Sample sample) {
        samples.add(sample);
    }

    public List<Sample> samples() {
        return samples;
    }
}
