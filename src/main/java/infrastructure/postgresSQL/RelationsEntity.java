package infrastructure.postgresSQL;

import javax.persistence.*;

@Entity
@Table(name = "relations", schema = "public", catalog = "GlucoseAppDB")
public class RelationsEntity {
    private String patientdni;
    private String doctordni;

    @Id
    @Column(name = "patientdni")
    public String getPatientdni() {
        return patientdni;
    }

    public void setPatientdni(String patientdni) {
        this.patientdni = patientdni;
    }

    @Basic
    @Column(name = "doctordni")
    public String getDoctordni() {
        return doctordni;
    }

    public void setDoctordni(String doctordni) {
        this.doctordni = doctordni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelationsEntity that = (RelationsEntity) o;

        if (patientdni != null ? !patientdni.equals(that.patientdni) : that.patientdni != null) return false;
        if (doctordni != null ? !doctordni.equals(that.doctordni) : that.doctordni != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = patientdni != null ? patientdni.hashCode() : 0;
        result = 31 * result + (doctordni != null ? doctordni.hashCode() : 0);
        return result;
    }
}
