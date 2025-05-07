package it.bookshop.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.bookshop.dao.CategoriaDao;
import it.bookshop.model.Categoria;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaServiceImp implements CategoriaService{

	@Autowired private CategoriaDao categoriaDao;
	
	@Override
	public Iterable<Categoria> getAll() {			
		return categoriaDao.findAll();
	}
	
	@Override
	public void save( Categoria cat ){ 
		categoriaDao.save(cat); 
	}

	@Override
	public Categoria getById(int id) {	
		Optional<Categoria> cat = categoriaDao.findById(id);
		if( cat.isPresent() ) { return cat.get(); }
		else{ throw new EntityNotFoundException("Categoria non trovata"); }
	}

	@Override
	public void deleteById(int varId) {
		Optional<Categoria> cat = categoriaDao.findById(varId);
		if( cat.isPresent() ) { categoriaDao.deleteById(varId);}
		else{ throw new EntityNotFoundException("Categoria non trovata"); }
	}

}
