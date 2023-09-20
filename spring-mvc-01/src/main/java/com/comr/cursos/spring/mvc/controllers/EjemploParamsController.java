package com.comr.cursos.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params") //ruta base que se le da al controlador
public class EjemploParamsController {

	@GetMapping("/")
	public String index(Model model) {
		
		return "paramsview/index";
	}
	
	@GetMapping("/string")
	public String methodParam(@RequestParam(name = "str", required = false, defaultValue = "No hay valor.") String txtParam, Model model) {
		//@RequestParam agrega un parametro al metodo para que sea llenado en la peticion
		model.addAttribute("resultado", "Texto enviado es: " + txtParam);
		return "paramsview/print_string";
	}
}
