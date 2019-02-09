package uaz.prueba.db.demo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "programa_academico", schema = "sistema_escolar", catalog = "")
public class ProgramaAcademico {
    private int idProgramaAcademica;
    private String nombre;

    @Id
    @Column(name = "id_programa_academica")
    public int getIdProgramaAcademica() {
        return idProgramaAcademica;
    }

    public void setIdProgramaAcademica(int idProgramaAcademica) {
        this.idProgramaAcademica = idProgramaAcademica;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgramaAcademico that = (ProgramaAcademico) o;

        if (idProgramaAcademica != that.idProgramaAcademica) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProgramaAcademica;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
