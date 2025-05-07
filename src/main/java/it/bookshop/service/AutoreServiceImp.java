package it.bookshop.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.bookshop.dao.AutoreDao;
import it.bookshop.model.Autore;
import jakarta.persistence.EntityNotFoundException;


@Service 
public class AutoreServiceImp implements AutoreService {
	
	@Autowired private AutoreDao autoreDao;

	@Override
	public Iterable<Autore> getAll() {
		return autoreDao.findAll();
	}

	@Override
	public void save( Autore autore ) {
		autoreDao.save(autore);
	}
	
	@Override
	public Autore getById(int id) {
		Optional<Autore> autore = autoreDao.findById(id);
		
		// Verifica esistenza - return autore o lancia eccezione
		if( autore.isPresent() ) { return autore.get(); }
		else{ throw new EntityNotFoundException("Autore non trovato"); }
		
	}
	
	@Override
	public void deleteById(int id) {
		Optional<Autore> autore = autoreDao.findById(id);
		
		// Verifica esistenza - elimina autore o lancia eccezione
		if( autore.isPresent() ) { autoreDao.deleteById(id); }
		else{ throw new EntityNotFoundException("Autore non trovato"); }
	}


}
