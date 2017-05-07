package beans;

import wrapper.PatientWrapper;
import javax.ejb.Local;

@Local
public interface PatientBeanInterface{
    PatientWrapper wrapper();
    void wrapper(PatientWrapper wrapper);
}
