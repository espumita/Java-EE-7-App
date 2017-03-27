package Infrastructure;

import model.User;
import utils.UserCredentials;

public class UserMemoryRepository implements UserRepository {

    @Override
    public boolean exist(UserCredentials userCredentials) {
        return userCredentials.name().equals("someUserName");
    }

}
