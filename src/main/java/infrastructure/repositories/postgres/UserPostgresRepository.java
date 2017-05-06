package infrastructure.repositories.postgres;

import infrastructure.postgresEntyties.DoctorsEntity;
import infrastructure.postgresEntyties.PatientsEntity;
import infrastructure.repositories.UserRepository;
import utils.UserCredentials;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserPostgresRepository implements UserRepository {

    @Override
    public boolean exist(UserCredentials userCredentials) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            EntityManager entityManager = factory.createEntityManager();

            PatientsEntity patientsEntity = entityManager.find(PatientsEntity.class, userCredentials.dni());
            if(patientsEntity != null) return true;


            DoctorsEntity doctorsEntity = entityManager.find(DoctorsEntity.class, userCredentials.dni());
            if(doctorsEntity != null) return true;

            entityManager.close();
        }catch (Exception e){
            return false;
        }
        return false;
    }

    @Override
    public String role(UserCredentials userCredentials) {
        return null;
    }
}
