package beans;

import proxy.PatientProxy;
import javax.ejb.Local;

@Local
public interface PatientBeanInterface{
    PatientProxy patient();
    void patient(PatientProxy patient);
}
