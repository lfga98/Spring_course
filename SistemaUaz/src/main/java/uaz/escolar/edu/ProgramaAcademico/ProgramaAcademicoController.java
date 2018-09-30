package uaz.escolar.edu.ProgramaAcademico;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProgramaAcademicoController {

    @RequestMapping("/programa")
    public String helloWorld(Model model) {
        return "Programa/index";
    }

    @RequestMapping("/adios")
    public String byeWorld(Model model) {
        return "adios/adios";
    }

}
