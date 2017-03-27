package Infrastructure;

import utils.UserCredentials;

public interface UserRepository {
    boolean exist(UserCredentials userCredentials);

}
