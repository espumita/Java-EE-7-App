package beans;

import wrapper.PatientWrapper;

import javax.ejb.Stateful;

@Stateful(name = "PatientEJB")
public class PatientBean implements PatientBeanInterface {
    private PatientWrapper wrapper;

    public PatientBean() {
    }

    @Override
    public void wrapper(PatientWrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public PatientWrapper wrapper() {
        return wrapper;
    }
}
