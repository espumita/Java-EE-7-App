package infrastructure.repositories;

import model.Doctor;
import model.Patient;
import model.exceptions.IncompletePatient;

public interface DoctorRepository {



    void addPatient(Patient patient, String id);

    void removePatient(String dni, String id);

    Doctor simpleLoad(String patientDni);

    Doctor fullLoad(String doctorDni) throws IncompletePatient;
}
