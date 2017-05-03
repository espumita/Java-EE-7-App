package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Doctor implements User{

    private String dni;
    private final String name;
    private List<Patient> patients = new ArrayList<Patient>();

    public Doctor(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public String name() {
        return name;
    }

    public String dni() {
        return dni;
    }

    public List<Patient> patients() {
        return patients;
    }

    public void add(Patient patient) {
        patients.add(patient);
    }

    public void removePatientWithId(String patientDni) {
        patients = (ArrayList<Patient>) patients.stream()
                .filter(patient -> !patient.dni().equals(patientDni))
                .collect(Collectors.toList());
    }

    public static class NotAssignedDoctor extends Doctor{

        public NotAssignedDoctor() {
            super("Jhon Smith", "Not assigned");
        }
    }
}
