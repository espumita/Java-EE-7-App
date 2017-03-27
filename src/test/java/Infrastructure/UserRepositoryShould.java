package Infrastructure;

import model.Doctor;
import org.junit.Before;
import org.junit.Test;
import utils.UserCredentials;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserRepositoryShould {

    private UserRepository userRepository;
    private static final String SOME_USER_NAME = "SomeUserName";

    @Before
    public void setUp(){
        userRepository = new UserMemoryRepository();
    }

    @Test
    public void tell_us_if_the_user_exists() throws Exception {
        UserCredentials userCredentials = new UserCredentials(SOME_USER_NAME);

        boolean exist = userRepository.exist(userCredentials);

        assertThat(exist, is(true));
    }

    @Test
    public void tell_us_if_the_user_do_not_exist() throws Exception {
        UserCredentials userCredentials = new UserCredentials("otherName");

        boolean exist = userRepository.exist(userCredentials);

        assertThat(exist, is(false));
    }
}
