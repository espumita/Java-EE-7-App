package actions;

import model.Patient;

interface DoctorRepository {
    void addPatient(Patient patient, String id);

    void removePatient(String dni, String id);
}
