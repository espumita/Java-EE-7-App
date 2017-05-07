package wrapper;

import java.util.ArrayList;
import java.util.List;

public class PatientWrapper {
    private String name;
    private String gender;
    private String address;
    private String age;
    private String dni;
    private List<SampleWrapper> samplesHistory = new ArrayList<>();

    public PatientWrapper(String name, String gender, String address, String age, String dni, ArrayList samplesHistory) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.dni = dni;
        this.samplesHistory = samplesHistory;
    }

    public String dni(){
        return dni;
    }

    public String gender() {
        return gender;
    }

    public String name() {
        return name;
    }

    public String address() {
        return address;
    }

    public String age() {
        return age;
    }

    public void add(SampleWrapper sample) {
        samplesHistory.add(sample);
    }

    public ArrayList<SampleWrapper> sampleHistory() {
        return (ArrayList<SampleWrapper>) samplesHistory;
    }
}
