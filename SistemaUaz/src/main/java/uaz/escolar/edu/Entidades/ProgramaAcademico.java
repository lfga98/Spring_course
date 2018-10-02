package uaz.escolar.edu.Entidades;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProgramaAcademico {
    @Id
    private int idProgramaAcademica;
    private String nombre;

    public ProgramaAcademico() {
    }

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
