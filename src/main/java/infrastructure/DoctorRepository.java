package infrastructure;

import model.Patient;

public interface DoctorRepository {
    void addPatient(Patient patient, String id);

    void removePatient(String dni, String id);
}
