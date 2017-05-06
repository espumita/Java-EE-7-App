package infrastructure.repositories;

import model.Patient;
import model.Sample;
import model.exceptions.IncompletePatient;

public interface PatientRepository {

    void addSample(Sample sample, String dni) throws Exception;

    Patient load(String dni) throws IncompletePatient;
}
