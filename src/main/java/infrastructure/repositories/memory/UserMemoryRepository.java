package infrastructure.repositories.memory;

import infrastructure.repositories.UserRepository;
import infrastructure.repositories.postgres.UserPostgresRepository;
import utils.UserCredentials;

/**
 * Now we use postgres repositories
 *
 * @deprecated use {@link UserPostgresRepository} instead.
 */
@Deprecated
public class UserMemoryRepository implements UserRepository {

    private static final String PATIENT_DNI = "patient";
    private static final String DOCTOR_DNI = "doctor";

    @Override
    public boolean exist(UserCredentials userCredentials) {
        return userCredentials.dni().equals(PATIENT_DNI)
                || userCredentials.dni().equals(DOCTOR_DNI);
    }

    @Override
    public String role(UserCredentials userCredentials) throws Exception{
        return userCredentials.dni().equals(DOCTOR_DNI) ? "DOCTOR" : "PATIENT";
    }


}
