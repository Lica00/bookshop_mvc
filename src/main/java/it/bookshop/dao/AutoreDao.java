package it.bookshop.dao;
import org.springframework.data.repository.CrudRepository;
import it.bookshop.model.Autore;

public interface AutoreDao extends CrudRepository<Autore, Integer>{
	
}

