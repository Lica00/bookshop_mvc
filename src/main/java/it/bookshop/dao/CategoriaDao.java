package it.bookshop.dao;
import org.springframework.data.repository.CrudRepository;
import it.bookshop.model.Categoria;

public interface CategoriaDao extends CrudRepository<Categoria, Integer> {

}
