package it.bookshop.service;

import it.bookshop.model.Libro;

public interface LibroService {

	Iterable<Libro> getAll();
	Libro getById( int id );
	void save( Libro lib);
	void deleteById( int id );

	
}
