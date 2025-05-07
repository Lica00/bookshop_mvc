package it.bookshop.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.bookshop.dao.LibroDao;
import it.bookshop.model.Libro;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LibroServiceImp implements LibroService{

	@Autowired private LibroDao libroDao;
	
	@Override
	public Iterable<Libro> getAll() {
		return libroDao.findAll();
	}

	@Override
	public void save(Libro libro) {
		libroDao.save(libro);
	}

	@Override
	public Libro getById(int id) {
		Optional<Libro> libro = libroDao.findById(id);
		if( libro.isPresent() ) { return libro.get(); }
		else{ throw new EntityNotFoundException("Libro non trovato"); }
	}

	@Override
	public void deleteById(int id) {
		Optional<Libro> libro = libroDao.findById(id);
		if( libro.isPresent() ) { libroDao.deleteById(id); }
		else{ throw new EntityNotFoundException("Libro non trovato"); }
		
	}

}
