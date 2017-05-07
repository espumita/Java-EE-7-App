package wrapper;

import java.util.List;

public class DoctorProfileWrapper {

    private String dni;
    private final String name;

    public DoctorProfileWrapper(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public String dni() {
        return dni;
    }

    public String name() {
        return name;
    }

}
