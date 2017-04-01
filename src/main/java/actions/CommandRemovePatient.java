package actions;

public class CommandRemovePatient implements Command{
    private final String dni;
    private final DoctorRepository doctorRepository;
    private final String id;

    public CommandRemovePatient(String dni, DoctorRepository doctorRepository, String id) {

        this.dni = dni;
        this.doctorRepository = doctorRepository;
        this.id = id;
    }

    @Override
    public void run() {
        doctorRepository.removePatient(dni, id);
    }
}
