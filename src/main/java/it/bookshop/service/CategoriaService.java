package it.bookshop.service;

import it.bookshop.model.Categoria;

public interface CategoriaService {

	Iterable<Categoria> getAll();
	Categoria getById( int id);
	void save( Categoria cat);
	void deleteById( int id );
	
}
