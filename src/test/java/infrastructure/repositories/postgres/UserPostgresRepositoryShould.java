package infrastructure.repositories.postgres;

import org.junit.Before;
import org.junit.Test;
import utils.UserCredentials;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class UserPostgresRepositoryShould {

    private String SOME_DNI = "patient";


    @Test
    public void tell_us_if_the_user_exists() throws Exception {
        UserCredentials userCredentials = new UserCredentials(SOME_DNI);
        UserPostgresRepository userRepository = new UserPostgresRepository();

        boolean exist = userRepository.exist(userCredentials);

        assertThat(exist, is(true));
    }
}
