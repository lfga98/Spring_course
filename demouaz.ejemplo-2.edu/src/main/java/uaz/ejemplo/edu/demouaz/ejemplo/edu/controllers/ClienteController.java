package uaz.ejemplo.edu.demouaz.ejemplo.edu.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Cliente;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.service.IClienteService;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.service.UploadServiceImp;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.util.paginator.PageRender;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private UploadServiceImp uploadServiceImp;


	private final Logger log = LoggerFactory.getLogger(getClass());


	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id")Long id,Map<String, Object> model,RedirectAttributes flash ){
		Cliente cliente = clienteService.findOne(id);
		if (cliente==null){
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		model.put("cliente" , cliente);
		model.put("titulo", "Detalle cliente: " +cliente.getNombre());
		return "ver";
	}

	@RequestMapping(value = {"/listar","/"}, method = RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Cliente> clientes = clienteService.findAll(pageRequest);
		
		PageRender<Cliente> pageRender = new PageRender<Cliente>("/listar", clientes);
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
		return "listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Crear Cliente");
		return "form";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Cliente cliente = null;
		
		if(id > 0) {
			cliente = clienteService.findOne(id);
			if(cliente == null) {
				flash.addFlashAttribute("error", "El ID del cliente no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, @RequestParam("file")MultipartFile foto , RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}

		if(!foto.isEmpty()){

			if(cliente.getId()!=null && cliente.getId() > 0 && cliente.getFoto()!=null && cliente.getFoto().length()>0){
			uploadServiceImp.delete(cliente.getFoto());
			}
			String uniqueFilename= null;
			try {
				uniqueFilename = uploadServiceImp.copy(foto);
			} catch (IOException e) {
				e.printStackTrace();
			}

			flash.addFlashAttribute("info", "Has subido correctamente ' " + foto.getOriginalFilename() +" ' ");
			cliente.setFoto(uniqueFilename);

		}


		String mensajeFlash = (cliente.getId() != null)? "Cliente editado con éxito!" : "Cliente creado con éxito!";

		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			Cliente cliente = clienteService.findOne(id);

			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
			if (uploadServiceImp.delete(cliente.getFoto())){
				flash.addFlashAttribute("info", "Foto: " +cliente.getFoto() + " eliminada con exito");
			}


		}
		return "redirect:/listar";
	}
}
