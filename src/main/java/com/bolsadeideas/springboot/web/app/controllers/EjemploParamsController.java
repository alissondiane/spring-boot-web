package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
//http://localhost:8080/params/string?texto=hola%20que%20tal
public class EjemploParamsController {
	@GetMapping("/")
	public String index(@RequestParam(name="texto", required=false,defaultValue="Otro valor por defecto...") String texto, Model model) {
		model.addAttribute("resultado","El texto enviado es: "+texto);
		return "params/index";
	}
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required=false,defaultValue="Otro valor por defecto...") String texto, Model model) {
		model.addAttribute("resultado","El texto enviado es: "+texto);
		return "params/ver";
	}
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado","El saludo enviado es: '"+saludo+"'y el número es'"+numero+"'");
		return "params/ver";
	}
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		}catch(NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("resultado","El saludo enviado es: '"+saludo+"'y el número es'"+numero+"'");
		return "params/ver";
	}
	
}
