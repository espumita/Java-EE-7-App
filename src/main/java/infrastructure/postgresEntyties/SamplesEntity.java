package infrastructure.postgresEntyties;

import javax.persistence.*;

@Entity
@Table(name = "samples", schema = "public", catalog = "GlucoseAppDB")
public class SamplesEntity {
    private long id;
    private String patientdni;
    private int glucoselevel;
    private String date;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "patientdni")
    public String getPatientdni() {
        return patientdni;
    }

    public void setPatientdni(String patientdni) {
        this.patientdni = patientdni;
    }

    @Basic
    @Column(name = "glucoselevel")
    public int getGlucoselevel() {
        return glucoselevel;
    }

    public void setGlucoselevel(int glucoselevel) {
        this.glucoselevel = glucoselevel;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SamplesEntity that = (SamplesEntity) o;

        if (id != that.id) return false;
        if (glucoselevel != that.glucoselevel) return false;
        if (patientdni != null ? !patientdni.equals(that.patientdni) : that.patientdni != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (patientdni != null ? patientdni.hashCode() : 0);
        result = 31 * result + glucoselevel;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
