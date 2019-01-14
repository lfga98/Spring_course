package uaz.ejemplo.edu.demouaz.ejemplo.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Cliente;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Factura;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Producto;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.service.IClienteService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/form/{clienteId}")
    public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
                        RedirectAttributes flash) {

        Cliente cliente = clienteService.findOne(clienteId);

        if (cliente == null) {
            flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
            return "redirect:/listar";
        }

        Factura factura = new Factura();
        factura.setCliente(cliente);

        model.put("factura", factura);
        model.put("titulo", "Crear Factura");

        return "factura/form";
    }

    @GetMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
    public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {
        return clienteService.findByNombre(term);
    }







}
