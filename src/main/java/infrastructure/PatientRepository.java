package infrastructure;

import model.Sample;

public interface PatientRepository {

    void addSample(Sample sample, String dni);
    void load(String dni);
}
