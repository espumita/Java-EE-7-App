package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Doctor {

    private ArrayList<Patient> patients = new ArrayList<Patient>();

    public List<Patient> patients() {
        return patients;
    }

    public void add(Patient patient) {

        patients.add(patient);
    }

    public void removePatientWithId(String id) {
        patients = (ArrayList<Patient>) patients.stream()
                .filter(patient -> patient.id().equals(id))
                .collect(Collectors.toList());
    }

    public String example(){
        return "Some Doctor Name";
    }
}
