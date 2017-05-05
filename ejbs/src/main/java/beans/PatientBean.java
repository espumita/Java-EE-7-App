package beans;

import proxy.PatientProxy;

import javax.ejb.Stateful;

@Stateful(name = "PatientEJB")
public class PatientBean implements PatientBeanInterface {
    private PatientProxy patient;

    public PatientBean() {
    }

    public PatientProxy patient() {
        return patient;
    }

    public void patient(PatientProxy patient) {
        this.patient = patient;
    }
}
