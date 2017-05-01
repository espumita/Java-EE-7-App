package model;

import model.exceptions.IncompletePatient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PatientBuilder {
    private String gender;
    private String name;
    private String address;
    private String age;
    private String dni;
    private ArrayList<Sample> samplesHistory;

    public PatientBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PatientBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PatientBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public PatientBuilder withAge(String age) {
        this.age = age;
        return this;
    }

    public PatientBuilder withDNI(String dni) {
        this.dni = dni;
        return this;
    }

    public PatientBuilder withSamplesHistory(ArrayList<Sample> sampleList) {
        this.samplesHistory = sampleList;
        return this;
    }

    public Patient build() throws IncompletePatient {
        if(name == null || Objects.equals(name, "") ||
           gender == null || Objects.equals(gender, "") ||
           address == null || Objects.equals(address, "") ||
           age == null || Objects.equals(age, "") ||
           dni == null || Objects.equals(dni, "") ||
           samplesHistory == null
           ) throw new IncompletePatient() ;
        return new Patient(name, gender, address, age, dni, samplesHistory);
    }
}
