package uaz.escolar.edu.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import uaz.escolar.edu.Entidades.ProgramaAcademico;
import uaz.escolar.edu.Repositorios.ProgramaAcademicoRepositorio;

import java.util.ArrayList;
import java.util.List;


@EnableJpaRepositories(basePackages="uaz.escolar.edu.Repositorios")
@Service
public class ProgramaAcademicoServicio {

    @Autowired
    private ProgramaAcademicoRepositorio programaRepositorio;

    public List<ProgramaAcademico> getAllPrograma(){
        List<ProgramaAcademico> programas = new ArrayList<>();
        programaRepositorio.findAll().forEach(programas::add);
        return programas;
    }

    public void addProgramaAcademico(ProgramaAcademico programa){
        programaRepositorio.save(programa);
    }

    public void updatePrograma(int idProgramaAcademico,ProgramaAcademico programa){
        programaRepositorio.save(programa);
    }

    public void deletePrograma(int id){
        programaRepositorio.deleteById(id);
    }
    public ProgramaAcademico getPrograma(int id){
       return programaRepositorio.findById(id).get();
    }
}
