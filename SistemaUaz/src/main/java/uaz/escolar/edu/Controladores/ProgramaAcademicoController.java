package uaz.escolar.edu.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uaz.escolar.edu.Entidades.ProgramaAcademico;
import uaz.escolar.edu.Servicios.ProgramaAcademicoServicio;

import java.util.List;

@Controller
public class ProgramaAcademicoController {

    @Autowired
    private ProgramaAcademicoServicio programaServicio;

    @RequestMapping("/progaca")
    public String helloWorld(Model model) {
        return "Programa/index";
    }

    @RequestMapping("/programas")
    public List<ProgramaAcademico> getAllProgramas() {
        return programaServicio.getAllPrograma();
    }
    @RequestMapping("/programas/{id}")
    public ProgramaAcademico getTopic(@PathVariable("id") int idPrograma){
        return programaServicio.getPrograma(idPrograma);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/programas")
    public void addTopic(@RequestBody ProgramaAcademico programa){
        programaServicio.addProgramaAcademico(programa);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/programas/{id}")
    public void updateTopic(@RequestBody ProgramaAcademico programa, @PathVariable("id") int idPrograma){
        //programaServicio.updatePrograma(idPrograma,programa);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/programas/{id}")
    public void deleteTopic(@PathVariable("id") int idPrograma){
        programaServicio.deletePrograma(idPrograma);
    }


}
