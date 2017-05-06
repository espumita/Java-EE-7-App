package infrastructure.repositories.postgres;

import infrastructure.postgresEntyties.DoctorsEntity;
import infrastructure.postgresEntyties.PatientsEntity;
import infrastructure.postgresEntyties.RelationsEntity;
import infrastructure.repositories.DoctorRepository;
import model.Doctor;
import model.Patient;
import model.PatientBuilder;
import model.Sample;
import model.exceptions.IncompletePatient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class DoctorPostgresRepository implements DoctorRepository {

    private final EntityManagerFactory factory;

    public DoctorPostgresRepository() {
        this.factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }




    @Override
    public Doctor simpleLoad(String patientDni) {
        try{
            EntityManager entityManager = factory.createEntityManager();

            RelationsEntity relationsEntity = entityManager.find(RelationsEntity.class, patientDni);
            if(relationsEntity != null) {
                relationsEntity.getDoctordni();
                DoctorsEntity doctorsEntity = entityManager.find(DoctorsEntity.class, relationsEntity.getDoctordni());
                if(doctorsEntity != null){
                    entityManager.close();
                    return new Doctor(doctorsEntity.getDni(), doctorsEntity.getName());
                }
            }
        } catch (Exception e){
            throw e;
        }
        return new Doctor.NotAssignedDoctor();
    }

    @Override
    public Doctor fullLoad(String doctorDni) throws IncompletePatient {
        return null;
    }

    @Override
    public void addPatient(Patient patient, String id) {

    }

    @Override
    public void removePatient(String dni, String id) {

    }
}
