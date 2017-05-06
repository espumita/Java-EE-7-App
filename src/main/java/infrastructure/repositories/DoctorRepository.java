package infrastructure.repositories;

import model.Doctor;
import model.Patient;
import model.exceptions.IncompletePatient;

public interface DoctorRepository {


    Doctor simpleLoad(String patientDni);

    Doctor fullLoad(String doctorDni) throws IncompletePatient;

    void addPatient(Patient patient, String id);

    void removePatient(String dni, String id);
}
