package it.bookshop.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.*;


@Entity                   
@Table( name = "author" )  
public class Autore {
	
	@Id                          
	private int id;
	
	@Column( name = "name" )
	private String name;
	
	@Column( name = "lastname" )
	private String lastname;

	@OneToMany( cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "autore", orphanRemoval = true )
	private List <Libro> books = new ArrayList<>();

	public int getId() { return id;}
	public void setId(int id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getLastname() { return lastname; }
	public void setLastname(String lastname) { this.lastname = lastname;}
	
}



