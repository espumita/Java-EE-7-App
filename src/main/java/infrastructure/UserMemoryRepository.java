package infrastructure;

import model.Patient;
import model.PatientBuilder;
import model.User;
import model.exceptions.IncompletePatient;
import utils.UserCredentials;

public class UserMemoryRepository implements UserRepository {

    @Override
    public boolean exist(UserCredentials userCredentials) {
        return userCredentials.dni().equals("someDni")
                || userCredentials.dni().equals("patient");
    }

    @Override
    public User load(String dni) throws IncompletePatient {
        if (dni.equals("patient")){
            Patient patient = new PatientBuilder()
                    .withGender("Male")
                    .withName("someName")
                    .withAddress("someAddress")
                    .withAge("someAge")
                    .withDNI(dni)
                    .build();
            return patient;
        }
        return null;
    }

}
