package infrastructure.postgresEntyties;

import javax.persistence.*;

@Entity
@Table(name = "doctors", schema = "public", catalog = "GlucoseAppDB")
public class DoctorsEntity {
    private String dni;
    private String name;

    @Id
    @Column(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorsEntity that = (DoctorsEntity) o;

        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dni != null ? dni.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
