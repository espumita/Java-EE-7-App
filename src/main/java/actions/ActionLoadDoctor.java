package actions;

import infrastructure.repositories.DoctorRepository;
import model.Doctor;
import model.exceptions.IncompletePatient;

public class ActionLoadDoctor implements Action {
    private final DoctorRepository doctorRepository;
    private final String doctorDni;

    public ActionLoadDoctor(DoctorRepository doctorRepository, String doctorDni) {
        this.doctorRepository = doctorRepository;
        this.doctorDni = doctorDni;
    }

    public Doctor run() throws IncompletePatient {
        return doctorRepository.fullLoad(doctorDni);
    }
}
