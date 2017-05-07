package beans;

import wrapper.DoctorProfileWrapper;

import javax.ejb.Local;

@Local
public interface DoctorProfileInterface {

    void wrapper(DoctorProfileWrapper doctorProfileWrapper);

    DoctorProfileWrapper wrapper();
}
