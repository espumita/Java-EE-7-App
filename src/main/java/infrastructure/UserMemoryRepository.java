package infrastructure;

import utils.UserCredentials;

public class UserMemoryRepository implements UserRepository {

    private static final String PATIENT_DNI = "patient";
    private static final String DOCTOR_DNI = "doctor";

    @Override
    public boolean exist(UserCredentials userCredentials) {
        return userCredentials.dni().equals(PATIENT_DNI)
                || userCredentials.dni().equals(DOCTOR_DNI);
    }

    @Override
    public String role(UserCredentials userCredentials) {
        return userCredentials.dni().equals(DOCTOR_DNI) ? "DOCTOR" : "PATIENT";
    }


}
