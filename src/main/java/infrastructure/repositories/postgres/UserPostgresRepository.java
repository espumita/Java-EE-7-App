package infrastructure.repositories.postgres;

import infrastructure.postgresEntyties.PatientsEntity;
import infrastructure.repositories.UserRepository;
import utils.PostgresConnectionProvider;
import utils.UserCredentials;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

public class UserPostgresRepository implements UserRepository {

    @Override
    public boolean exist(UserCredentials userCredentials) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            EntityManager entityManager = factory.createEntityManager();
            PatientsEntity patientsEntity = entityManager.find(PatientsEntity.class, userCredentials.dni());
            if(patientsEntity != null) return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public String role(UserCredentials userCredentials) {
        return null;
    }
}
