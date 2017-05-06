package infrastructure.repositories.postgres;

import infrastructure.postgresEntyties.DoctorsEntity;
import infrastructure.postgresEntyties.PatientsEntity;
import infrastructure.repositories.UserRepository;
import utils.UserCredentials;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserPostgresRepository implements UserRepository {

    private EntityManagerFactory factory;

    public UserPostgresRepository() {
        this.factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    @Override
    public boolean exist(UserCredentials userCredentials) {
        try {
            EntityManager entityManager = factory.createEntityManager();

            PatientsEntity patientsEntity = entityManager.find(PatientsEntity.class, userCredentials.dni());
            if(patientsEntity != null) {
                entityManager.close();
                return true;
            };


            DoctorsEntity doctorsEntity = entityManager.find(DoctorsEntity.class, userCredentials.dni());
            if(doctorsEntity != null){
                entityManager.close();
                return true;
            }

            entityManager.close();
        }catch (Exception e){
            return false;
        }
        return false;
    }

    @Override
    public String role(UserCredentials userCredentials) throws Exception {
        try {
            EntityManager entityManager = factory.createEntityManager();

            PatientsEntity patientsEntity = entityManager.find(PatientsEntity.class, userCredentials.dni());
            if(patientsEntity != null){
                entityManager.close();
                return "PATIENT";
            }


            DoctorsEntity doctorsEntity = entityManager.find(DoctorsEntity.class, userCredentials.dni());
            if(doctorsEntity != null){
                entityManager.close();
                return "DOCTOR";
            }

            entityManager.close();
        }catch (Exception e){
            throw e;
        }
        throw new Exception("User do not exists");
    }
}
