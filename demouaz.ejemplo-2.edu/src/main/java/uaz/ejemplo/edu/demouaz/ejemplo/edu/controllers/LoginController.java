package uaz.ejemplo.edu.demouaz.ejemplo.edu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "error", required = false) String logout,
            Model model,
            Principal principal, RedirectAttributes flash){
        if (principal != null){
            flash.addFlashAttribute("info","Ya se tiene una sesion iniciada");
            return "redirect:/";
        }
        if(error!=null){
            model.addAttribute("error","Error al ingresar, el usuario o contraseña incorrectos");
        }
        if(logout!=null){
            model.addAttribute("success","Se ha cerrado sesion con exito");
        }


        return "/login";
    }
}
