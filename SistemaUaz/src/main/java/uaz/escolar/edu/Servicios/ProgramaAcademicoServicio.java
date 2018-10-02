package uaz.escolar.edu.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uaz.escolar.edu.Entidades.ProgramaAcademico;
import uaz.escolar.edu.Repositorios.ProgramaAcademicoRepositorio;

import java.util.ArrayList;
import java.util.List;

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

    public void updatePrograma(ProgramaAcademico programa){
        programaRepositorio.save(programa);
    }
    public void deletePrograma(int id){
        programaRepositorio.deleteById(id);
    }
    public ProgramaAcademico getPrograma(int id){
       return  programaRepositorio.findById(id).get();
    }
}
