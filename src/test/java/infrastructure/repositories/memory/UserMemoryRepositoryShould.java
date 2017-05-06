package infrastructure.repositories.memory;

import infrastructure.repositories.UserRepository;
import infrastructure.repositories.postgres.UserPostgresRepositoryShould;
import org.junit.Before;
import org.junit.Test;
import utils.UserCredentials;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Now we use postgres repositories
 *
 * @deprecated use {@link UserPostgresRepositoryShould} instead.
 */
@Deprecated
public class UserMemoryRepositoryShould {

    private UserRepository userRepository;
    private static final String SOME_DNI = "patient";

    @Before
    public void setUp(){
        userRepository = new UserMemoryRepository();
    }

    @Test
    public void tell_us_if_the_user_exists() throws Exception {
        UserCredentials userCredentials = new UserCredentials(SOME_DNI);

        boolean exist = userRepository.exist(userCredentials);

        assertThat(exist, is(true));
    }

    @Test
    public void tell_us_if_the_user_do_not_exist() throws Exception {
        UserCredentials userCredentials = new UserCredentials("otherDni");

        boolean exist = userRepository.exist(userCredentials);

        assertThat(exist, is(false));
    }

}
