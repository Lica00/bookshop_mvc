package it.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.bookshop.model.Categoria;
import it.bookshop.service.CategoriaService;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
	
	@Autowired private CategoriaService categoriaService;
	
	@GetMapping
	public String getCategorie( Model model ){
		Iterable<Categoria> categorie = categoriaService.getAll();
		model.addAttribute("listaCategorie", categorie);
		
		Categoria cat = new Categoria();
		model.addAttribute("categoria", cat); 
		return "categorie";
	}
	
	@PostMapping("save")
	public String saveCategoria( @ModelAttribute("categoria") Categoria cat){ 
		categoriaService.save(cat);
		return "redirect:/categorie"; 
	}
	
	@GetMapping("delete")
	public String deleteCategoria( @RequestParam( name = "id") int idCat){
		categoriaService.deleteById(idCat);
		return "redirect:/categorie";
	}
	
	@GetMapping("update")
	public String updateCategoria( @RequestParam( name = "id") int idCat, Model model  ){ 
		Categoria cat = categoriaService.getById(idCat);
		model.addAttribute(cat);
		return "modifica-categoria";
	}

}
