package infrastructure;

import model.Patient;
import model.PatientBuilder;
import model.Sample;
import model.exceptions.IncompletePatient;

public class PatientMemoryRepository implements PatientRepository{

    public void addSample(Sample sample, String dni) {

    }

    @Override
    public Patient load(String dni) throws IncompletePatient {
        if (dni.equals("patient")) {
            Patient patient = new PatientBuilder()
                    .withGender("Male")
                    .withName("David Jesus")
                    .withAddress("Madrid")
                    .withAge("30")
                    .withDNI(dni)
                    .build();
            return patient;
        }
        return null;
    }
}
