package model;

import java.util.ArrayList;
import java.util.List;

public class Doctor {

    private ArrayList<Patient> patients = new ArrayList<Patient>();

    public List<Patient> patients() {
        return patients;
    }

    public void add(Patient patient) {

        patients.add(patient);
    }
}
