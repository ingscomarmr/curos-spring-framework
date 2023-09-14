package com.comr.cursos.spring.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comr.cursos.spring.mvc.models.Usuario;


//para declarar controlador hay que poner notación @Controller
@Controller
public class InicioController {
	
	//@RequestMapping(value = {"/index","","/home"},method = RequestMethod.GET) forma 1
	@GetMapping({"/index","/home","/"}) //la forma mas simple para mapeo
	public String index(Model model) { //model es para pasar atributos
		model.addAttribute("title", "Esto es una app de Spring FrameWork"); //se agrega el atriburo
		return "index";//el nombre de la vista
	}
	
	@RequestMapping("/perfil") //por default es metodo Get
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Omar");
		usuario.setApellido("Munguia Rivera");
		usuario.setEmail("micorre@correo.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Datos ".concat(usuario.getNombre())); //se agrega el atriburo
		
		return "perfil";
	}
	
	
	@RequestMapping("/listarusuarios") //por default es metodo Get
	public String listarUsuarios(Model model) {
				
		//SE PASAN DE MANERA GLOBAL @ModelAttribute("usuarios")
		/*List<Usuario> lista = new ArrayList<>();
		lista.add(new Usuario("Eder", "Neri", "Eder@correo.com"));
		lista.add(new Usuario("Jon", "Sepa", "Jon.com"));
		lista.add(new Usuario("Richi", "Richon", "Richi@correo.com"));
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Omar");
		usuario.setApellido("Munguia Rivera");
		usuario.setEmail("micorre@correo.com");
		lista.add(usuario);*/
		
		//atributos
		model.addAttribute("titulo", "LISTA USUARIOS"); //se agrega el atriburo
		//model.addAttribute("usuarios", lista); ya no se manda el objeto porque desde el ModelAttribute se esta enviando
				
		return "listarusuarios";
	}
	
	//Este metodo esta accesible para todo el controlador, si hace referencia alguna vista a usuarios este metodo sera el que responda
	@ModelAttribute("usuarios")
	public List<Usuario> getUsuarios(){ //retorna el objeto
		List<Usuario> lista = new ArrayList<>();
		lista.add(new Usuario("Eder", "Neri", "Eder@correo.com"));
		lista.add(new Usuario("Jon", "Sepa", "Jon.com"));
		lista.add(new Usuario("Richi", "Richon", "Richi@correo.com"));
		
		return lista;
	}
}
