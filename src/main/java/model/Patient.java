package model;

import java.util.ArrayList;
import java.util.List;

public class Patient implements User {

    private String name;
    private String gender;
    private String address;
    private String age;
    private String dni;
    private List<Sample> samples = new ArrayList();

    public Patient(String name, String gender, String address, String age, String dni) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.dni = dni;
    }

    public String dni(){
        return dni;
    }

    public void add(Sample sample) {
        samples.add(sample);
    }

    public List<Sample> samples() {
        return samples;
    }


}
