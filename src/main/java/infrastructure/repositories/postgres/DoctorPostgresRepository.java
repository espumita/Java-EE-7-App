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
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        try{
            EntityManager entityManager = factory.createEntityManager();

            DoctorsEntity doctorsEntity = entityManager.find(DoctorsEntity.class, doctorDni);
            if(doctorsEntity != null){
                Doctor doctor = new Doctor(doctorsEntity.getDni(), doctorsEntity.getName());

                List<Patient> patients = loadPatients(doctorDni, entityManager);
                patients.forEach(doctor::add);

                entityManager.close();
                return doctor;
            }
        } catch (Exception e){
            throw e;
        }
        return new Doctor.NotAssignedDoctor();
    }

    private List<Patient> loadPatients(String doctorDni, EntityManager entityManager) {
        TypedQuery<RelationsEntity> relationsQuery = entityManager.createQuery("SELECT relations FROM RelationsEntity relations WHERE relations.doctordni= '" + doctorDni+ "'", RelationsEntity.class);
        List<RelationsEntity> relationsEntities = relationsQuery.getResultList();

        TypedQuery<PatientsEntity> patientsQuery = entityManager.createQuery("SELECT patient FROM PatientsEntity patient " + whereClause(relationsEntities), PatientsEntity.class);
        List<PatientsEntity> patientsEntities = patientsQuery.getResultList();

        List<Patient> patients = patientsEntities.stream()
                .map(patient -> {
                    try {
                        return new PatientBuilder()
                                .withGender(patient.getGender())
                                .withName(patient.getName())
                                .withAddress(patient.getAddress())
                                .withAge(Integer.toString(patient.getAge()))
                                .withDNI(patient.getDni())
                                .withSamplesHistory(new ArrayList<>())
                                .build();
                    } catch (IncompletePatient incompletePatient) {
                        incompletePatient.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toList());

        return patients;
    }

    private String whereClause(List<RelationsEntity> relationsEntities) {
        String firstCondition = relationsEntities.get(0).getPatientdni();
        return "WHERE patient.dni = '" + firstCondition + "' " + othersConditions(relationsEntities);
    }

    private String othersConditions(List<RelationsEntity> relationsEntities) {
        return relationsEntities.subList(1, relationsEntities.size())
                .stream().map(relationsEntity -> "OR patient.dni = '" + relationsEntity.getPatientdni() + "'")
                .collect(Collectors.joining(" "));
    }

    @Override
    public void addPatient(Patient patient, String id) {

    }

    @Override
    public void removePatient(String dni, String id) {

    }
}
