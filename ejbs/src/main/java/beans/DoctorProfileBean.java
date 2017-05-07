package beans;

import wrapper.DoctorProfileWrapper;

import javax.ejb.Stateless;

@Stateless(name = "DoctorProfileEJB")
public class DoctorProfileBean implements DoctorProfileInterface {
    private DoctorProfileWrapper doctorProfileWrapper;

    public DoctorProfileBean() {
    }

    @Override
    public void wrapper(DoctorProfileWrapper doctorProfileWrapper) {
        this.doctorProfileWrapper = doctorProfileWrapper;
    }

    @Override
    public DoctorProfileWrapper wrapper() {
        return doctorProfileWrapper;
    }
}
