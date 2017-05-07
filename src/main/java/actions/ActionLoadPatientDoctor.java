package actions;

import infrastructure.repositories.DoctorRepository;
import model.Doctor;

public class ActionLoadPatientDoctor implements Action {
    private final DoctorRepository doctorRepository;
    private final String dni;


    public ActionLoadPatientDoctor(DoctorRepository doctorRepository, String dni) {
        this.doctorRepository = doctorRepository;
        this.dni = dni;
    }

    public Doctor run() {
        return doctorRepository.simpleLoad(dni);
    }
}
