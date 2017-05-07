package beans;

import wrapper.PatientWrapper;
import javax.ejb.Local;

@Local
public interface PatientBeanInterface{

    void wrapper(PatientWrapper wrapper);

    PatientWrapper wrapper();
}
