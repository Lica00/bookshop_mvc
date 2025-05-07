package it.bookshop.dao;
import org.springframework.data.repository.CrudRepository;
import it.bookshop.model.Libro;

public interface LibroDao extends CrudRepository<Libro, Integer> {

}

