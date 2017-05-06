package infrastructure.repositories;

import model.Patient;
import model.Sample;
import model.exceptions.IncompletePatient;

public interface PatientRepository {

    void addSample(Sample sample, String dni);

    Patient load(String dni) throws IncompletePatient;
}
