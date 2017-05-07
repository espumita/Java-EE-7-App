package actions;

import infrastructure.repositories.DoctorRepository;

public class ActionRemovePatient implements Action {
    private final String dni;
    private final DoctorRepository doctorRepository;
    private final String id;

    public ActionRemovePatient(String dni, DoctorRepository doctorRepository, String id) {

        this.dni = dni;
        this.doctorRepository = doctorRepository;
        this.id = id;
    }

    public void run() {
        doctorRepository.removePatient(dni, id);
    }
}
