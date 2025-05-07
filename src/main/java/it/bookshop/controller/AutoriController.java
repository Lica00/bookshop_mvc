package it.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.bookshop.model.Autore;
import it.bookshop.service.AutoreService;


@Controller
@RequestMapping("/autori") 
public class AutoriController {

	@Autowired private AutoreService autoreService;
	
	@GetMapping
	public String getAutori( Model model ){ 
		
		Iterable<Autore> autori = autoreService.getAll(); 
		model.addAttribute("listaAutori", autori); 	      
		
		Autore autore = new Autore(); // istanza vuota ( serve a save )
		model.addAttribute("autore", autore); 
		
		return "autori"; 
	}
	

	@PostMapping("save") 
	public String saveAutore( @ModelAttribute("autore") Autore aut ){
		autoreService.save(aut);
		return "redirect:/autori";
	}
	
	
	@GetMapping("delete")
	public String deleteAutore( @RequestParam( name="id" ) int idAut ){
		autoreService.deleteById(idAut);
		return "redirect:/autori";
	}
	
	
	@GetMapping("update")
	public String updateAutore( @RequestParam( name="id" ) int idAut, Model model ){
		Autore aut = autoreService.getById(idAut);
		model.addAttribute("autore", aut);
		return "modifica-autore";
	}
	
	
}

