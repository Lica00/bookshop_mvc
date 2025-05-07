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
import it.bookshop.model.Categoria;
import it.bookshop.model.Libro;
import it.bookshop.service.AutoreService;
import it.bookshop.service.CategoriaService;
import it.bookshop.service.LibroService;


@Controller
@RequestMapping("/libri")
public class LibriController {

	@Autowired private LibroService libroService;
	@Autowired private AutoreService autoreService;
	@Autowired private CategoriaService categoriaService;
	
	@GetMapping
	public String getLibri( Model model ){
		
		Iterable<Libro> libri = libroService.getAll();
		model.addAttribute("listaLibri", libri);
		
		Libro libro = new Libro();
		model.addAttribute("libro", libro);
		
		Iterable<Autore> autori = autoreService.getAll();
		Iterable<Categoria> cat = categoriaService.getAll();
		model.addAttribute("listaAutori", autori);
		model.addAttribute("listaCategorie", cat);
		
		return "libri";
	}
	
	@PostMapping("save")
	public String saveLibro( @ModelAttribute("libro") Libro lib){
		libroService.save(lib);
		return "redirect:/libri";
	}
	
	@GetMapping("delete")
	public String deleteLibro( @RequestParam( name = "id") int idLib){ 
		libroService.deleteById(idLib);
		return "redirect:/libri";
	}
	
	@GetMapping("update")
	public String updateLibro(  @RequestParam( name = "id") int idLib, Model model ) {
		Libro libro = libroService.getById(idLib);
		model.addAttribute("libro", libro);
		
		Iterable<Autore> autori = autoreService.getAll();
		Iterable<Categoria> cat = categoriaService.getAll();
		model.addAttribute("listaAutori", autori);
		model.addAttribute("listaCategorie", cat);
		
		return "modifica-libro";
	}
	
}

