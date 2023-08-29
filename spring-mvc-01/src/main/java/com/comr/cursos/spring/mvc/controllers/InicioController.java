package com.comr.cursos.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//para declarar controlador hay que poner notación @Controller
@Controller
public class InicioController {
	
	//@RequestMapping(value = {"/index","","/home"},method = RequestMethod.GET) forma 1
	@GetMapping({"/index","/home","/"}) //la forma mas simple para mapeo
	public String Index() {
		return "index";//el nombre de la vista
	}
}
