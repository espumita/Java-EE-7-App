package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Doctor implements User{

    private final String name;
    private List<Patient> patients = new ArrayList<Patient>();

    public Doctor(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public List<Patient> patients() {
        return patients;
    }

    public void add(Patient patient) {
        patients.add(patient);
    }

    public void removePatientWithId(String dni) {
        patients = (ArrayList<Patient>) patients.stream()
                .filter(patient -> !patient.dni().equals(dni))
                .collect(Collectors.toList());
    }

    public static class NotAssignedDoctor extends Doctor{

        public NotAssignedDoctor() {
            super("Not assigned");
        }
    }
}
