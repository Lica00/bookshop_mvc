package it.bookshop.service;
import it.bookshop.model.Autore;


public interface AutoreService {
	
	Iterable<Autore> getAll();       
	Autore getById( int id );      
	void save( Autore autore );      
	void deleteById( int id );

}


