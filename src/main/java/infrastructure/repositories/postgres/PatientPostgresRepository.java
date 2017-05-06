package infrastructure.repositories.postgres;

import infrastructure.postgresEntyties.PatientsEntity;
import infrastructure.postgresEntyties.SamplesEntity;
import infrastructure.repositories.PatientRepository;
import model.Patient;
import model.PatientBuilder;
import model.Sample;
import model.exceptions.IncompletePatient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PatientPostgresRepository implements PatientRepository{


    private final EntityManagerFactory factory;

    public PatientPostgresRepository() {
        this.factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    @Override
    public void addSample(Sample sample, String dni) {

    }

    @Override
    public Patient load(String dni) throws IncompletePatient {
        try{
            EntityManager entityManager = factory.createEntityManager();

            PatientsEntity patientsEntity = entityManager.find(PatientsEntity.class, dni);
            if(patientsEntity != null) {
                ArrayList<Sample> sampleHistory = loadSampleHistory(dni, entityManager);
                entityManager.close();

                Patient patient = new PatientBuilder()
                        .withGender(patientsEntity.getGender())
                        .withName(patientsEntity.getName())
                        .withAddress(patientsEntity.getAddress())
                        .withAge(Integer.toString(patientsEntity.getAge()))
                        .withDNI(dni)
                        .withSamplesHistory(sampleHistory)
                        .build();
                return patient;
            }

        } catch (IncompletePatient e){
            throw e;
        }catch (Exception e){
            throw e;
        }
        return null;
    }

    private ArrayList<Sample> loadSampleHistory(String dni, EntityManager entityManager) {
        TypedQuery<SamplesEntity> query = entityManager.createQuery("SELECT patient from SamplesEntity patient where patient.patientdni = '" + dni + "'", SamplesEntity.class);
        List<SamplesEntity> resultList = query.getResultList();
        ArrayList<Sample> samples = new ArrayList<>();
        resultList.forEach( sampleEntity -> {
            samples.add(new Sample(
                    Integer.toString(sampleEntity.getGlucoselevel()),
                    sampleEntity.getDate()
            ));
        });
        return samples;
    }
}
