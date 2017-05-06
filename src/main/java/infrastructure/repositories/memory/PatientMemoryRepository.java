package infrastructure.repositories.memory;

import infrastructure.repositories.PatientRepository;
import model.Patient;
import model.PatientBuilder;
import model.Sample;
import model.exceptions.IncompletePatient;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Date;

/**
 * Now we use postgres repositories
 *
 * @deprecated use {@link PatientPostgresRepository} instead.
 */
@Deprecated
public class PatientMemoryRepository implements PatientRepository {

    private static PatientMemoryRepository instance = null;
    private ArrayList<Sample> sampleList = Lists.newArrayList(
            new Sample("100", new Date()),
            new Sample("80", new Date())
    );

    public static PatientMemoryRepository getInstance(){
        if (instance == null){
            instance = new PatientMemoryRepository();
        }
        return instance;
    }

    private PatientMemoryRepository() {

    }

    @Override
    public void addSample(Sample sample, String dni) {
        sampleList.add(sample);
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
                    .withSamplesHistory(sampleList)
                    .build();
            return patient;
        }
        return null;
    }
}
