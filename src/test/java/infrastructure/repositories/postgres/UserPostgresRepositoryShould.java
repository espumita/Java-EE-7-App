package infrastructure.repositories.postgres;

import org.junit.Test;
import utils.UserCredentials;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class UserPostgresRepositoryShould {

    private String SOME_PATIENT_DNI = "patient";
    private String SOME_DOCTOR_DNI = "doctor";


    @Test
    public void tell_us_if_a_patient_exists() throws Exception {
        UserCredentials patientCredentials = new UserCredentials(SOME_PATIENT_DNI);
        UserPostgresRepository userRepository = new UserPostgresRepository();

        boolean exist = userRepository.exist(patientCredentials);

        assertThat(exist, is(true));
    }

    @Test
    public void tell_us_if_a_doctor_exists() throws Exception {
        UserCredentials doctorCredentials = new UserCredentials(SOME_DOCTOR_DNI);
        UserPostgresRepository userRepository = new UserPostgresRepository();

        boolean exist = userRepository.exist(doctorCredentials);

        assertThat(exist, is(true));
    }
}
