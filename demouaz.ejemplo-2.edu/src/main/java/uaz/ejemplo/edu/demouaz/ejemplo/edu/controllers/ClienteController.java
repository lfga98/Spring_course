package uaz.ejemplo.edu.demouaz.ejemplo.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.dao.ClienteDaoImpl;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Cliente;

import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class ClienteController {

    @Autowired
    private ClienteDaoImpl clienteDao;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteDao.findAll());
        return "listar";
    }

   
    @RequestMapping(value="/form")
    public String crear(Map<String, Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo","Formulario Cliente");
        return "form";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult results, Model model){
        if(results.hasErrors()){
            model.addAttribute("titulo","Formulario Cliente");
            return "form";
        }
        clienteDao.save(cliente);
        return "redirect:listar";
    }
}
