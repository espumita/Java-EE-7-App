package actions;

import infrastructure.DoctorRepository;
import model.Doctor;

public class CommandLoadPatientDoctor implements Command {
    private final DoctorRepository doctorRepository;
    private final String dni;


    public CommandLoadPatientDoctor(DoctorRepository doctorRepository, String dni) {
        this.doctorRepository = doctorRepository;
        this.dni = dni;
    }

    public Doctor run() {
        return doctorRepository.load(dni);
    }
}
