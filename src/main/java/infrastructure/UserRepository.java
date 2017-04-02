package infrastructure;

import model.User;
import model.exceptions.IncompletePatient;
import utils.UserCredentials;

public interface UserRepository {

    boolean exist(UserCredentials userCredentials);
    User load(String dni) throws IncompletePatient;

}
