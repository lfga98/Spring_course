package uaz.escolar.edu.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProgramaAcademico {
    @Id
    private int idProgramaAcademica;
    private String nombre;

    public ProgramaAcademico(int idProgramaAcademica, String nombre) {
        this.idProgramaAcademica = idProgramaAcademica;
        this.nombre = nombre;
    }

    public int getIdProgramaAcademica() {
        return idProgramaAcademica;
    }

    public void setIdProgramaAcademica(int idProgramaAcademica) {
        this.idProgramaAcademica = idProgramaAcademica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
