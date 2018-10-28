package uaz.escolar.edu.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uaz.escolar.edu.Entidades.ProgramaAcademico;
import uaz.escolar.edu.Servicios.ProgramaAcademicoServicio;

import java.util.List;

@RestController
public class ProgramaAcademicoController {

    @Autowired
    private ProgramaAcademicoServicio programaServicio;

    @RequestMapping("/progaca")
    public String helloWorld(Model model) {
        return "index";
    }

    @RequestMapping("/programas")
    public List<ProgramaAcademico> getAllProgramas() {
        return programaServicio.getAllPrograma();
    }

    @RequestMapping("/programas/{id}")
    public ModelAndView getPrograma(@PathVariable("id") int idPrograma){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("idProgramaAcademica",programaServicio.getPrograma(idPrograma).getIdProgramaAcademica());
        mav.addObject("nombre",programaServicio.getPrograma(idPrograma).getNombre());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/programas")
    public void addTopic(@RequestBody ProgramaAcademico programa){
        programaServicio.addProgramaAcademico(programa);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/programas/{id}")
    public void updateTopic(@RequestBody ProgramaAcademico programa, @PathVariable("id") int idPrograma){
        programaServicio.updatePrograma(idPrograma,programa);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/programas/{id}")
    public void deleteTopic(@PathVariable("id") int idPrograma){
        programaServicio.deletePrograma(idPrograma);
    }


}
