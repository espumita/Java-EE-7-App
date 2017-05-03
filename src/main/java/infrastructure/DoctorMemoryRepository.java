package infrastructure;

import model.Doctor;
import model.Patient;
import model.PatientBuilder;
import model.Sample;
import model.exceptions.IncompletePatient;
import org.assertj.core.util.Lists;

import java.util.Date;

import static model.Doctor.*;

public class DoctorMemoryRepository implements DoctorRepository {
    @Override
    public void addPatient(Patient patient, String id) {

    }

    @Override
    public void removePatient(String dni, String id) {

    }

    @Override
    public Doctor simpleLoad(String patientDni) {
        return (patientDni.equals("patient")) ? new Doctor("45345345N", "Jhon Smith") :
                new NotAssignedDoctor();

    }

    @Override
    public Doctor fullLoad(String doctorDni) throws IncompletePatient {
        Doctor doctor = new Doctor(doctorDni, "Jhon Smith");
        doctor.add(aPatient());
        doctor.add(aPatient());
        doctor.add(aPatient());
        return doctor;
    }

    private Patient aPatient() throws IncompletePatient {
        return new PatientBuilder()
                .withGender("Male")
                .withName("David Jesus")
                .withAddress("Madrid")
                .withAge("30")
                .withDNI("someDni")
                .withSamplesHistory(Lists.newArrayList(
                        new Sample("100", new Date()),
                        new Sample("80", new Date())
                ))
                .build();
    }
}
