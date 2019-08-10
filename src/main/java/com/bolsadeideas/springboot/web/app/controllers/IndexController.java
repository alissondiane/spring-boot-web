package com.bolsadeideas.springboot.web.app.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
//ruta de primer nivel del controlador
public class IndexController {
	//rutas de segundo nivel del controlador
	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo","Hola Spring Framework");
		return "index";
	}
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Guzmán");
		usuario.setEmail("andres@correo.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo","Perfil de usuario:".concat(usuario.getNombre()));
		return "perfil";
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de  usuarios");
		return "listar";
	}
	//Atributo declarado: si queremos asignar  un atributo a todos los metodos del controlador
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Andrés","Guzmán","Andres@correo.com"));
		usuarios.add(new Usuario("Lucia","Campos","Lucia@correo.com"));
		usuarios.add(new Usuario("Ricardo","Gutierrez","Ricardo@correo.com"));
		return usuarios;
	}
	
}
