package infrastructure;

import model.Doctor;
import model.Patient;

public interface DoctorRepository {



    void addPatient(Patient patient, String id);

    void removePatient(String dni, String id);

    Doctor load(String dni);
}
